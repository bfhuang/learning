package com.bookshelf;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAccess {
	private ServletContext servletContext;
	private Statement statement ;

	public MySQLAccess(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public MySQLAccess() {}

	public void insert(Book book) {
		Connection connect = getConnectionThroughDriverManager();
		System.out.println(connect);
		try {
			statement = connect.createStatement();
			String sql = "insert into book values(" + book.getIsbn() + ",'" +
					book.getName() + "'," +
					book.getPrice() + ",'" +
					book.getAuthor() + "');";
			 statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			}
		}
	}

	public List<Book> query() {
		Connection connect = getConnectionThroughApplicationContext();
		List<Book> books = new ArrayList<Book>();
		try {
			statement =  connect.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from book;");
			Book book;
			while(resultSet.next()){
				book = new Book();
				book.setIsbn(resultSet.getInt("isbn"));
				book.setName(resultSet.getString("name"));
				book.setPrice(resultSet.getDouble("price"));
				book.setAuthor(resultSet.getString("author"));
				books.add(book);
			}

		}catch (Exception e){
			System.out.println("Query the data failed");
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
	}

	private Connection getConnectionThroughApplicationContext() {
		ClassPathXmlApplicationContext applicationContextOfSpring =
				(ClassPathXmlApplicationContext) servletContext.getAttribute("applicationContextOfSpring");
		BasicDataSource basicDataSource = (BasicDataSource) applicationContextOfSpring.getBean("basicDataSource");
		try {
			return basicDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		return null;
	}

	private Connection getConnectionThroughDriverManager() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/bookShelf", "root", "");

		}catch (Exception e) {
			System.out.println("Connect to database failed" + e.getMessage());
		}
		return connection;
	}


	private Connection getConnectionThroughBasicDataSource() {
		Connection connection = null;
		BasicDataSource bdSource = new BasicDataSource();

		bdSource.setDriverClassName("com.mysql.jdbc.Driver");
		bdSource.setUrl("jdbc:mysql://localhost:3306/bookShelf");
		bdSource.setUsername("root");
		bdSource.setPassword("");

		try {
			connection = bdSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}


	public static void main(String[] args) {
		MySQLAccess mySQLAccess = new MySQLAccess();


		List<Book> books = mySQLAccess.query();
		System.out.println(books.size());
		System.out.println(books.get(0).getName());
	}
}