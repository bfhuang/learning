package com.bookshelf;


import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
	private DataSource dataSource;

	public BookService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public BookService() {
	}

	public void insert(Book book) {
		Connection connect = null;
		try {
			connect = dataSource.getConnection();
			Statement statement = connect.createStatement();
			String sql = String.format("insert into book values(%d,'%s',%s,'%s');", book.getIsbn(), book.getName(), book.getPrice(), book.getAuthor());
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				assert connect != null;
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Book> query() {
		List<Book> books = new ArrayList<Book>();
		Connection connect = null;
		try {
			connect = dataSource.getConnection();
			Statement statement = connect.createStatement();
			String s = "select * from book;";
			ResultSet resultSet = statement.executeQuery(s);
			Book book;
			while (resultSet.next()) {
				book = new Book();
				book.setIsbn(resultSet.getInt("isbn"));
				book.setName(resultSet.getString("name"));
				book.setPrice(resultSet.getDouble("price"));
				book.setAuthor(resultSet.getString("author"));
				books.add(book);
			}

		} catch (Exception e) {
			System.out.println("Query the data failed");
		} finally {
			try {
				assert connect != null;
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
	}

	private Connection getConnectionThroughDriverManager() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/bookShelf", "root", "");

		} catch (Exception e) {
			System.out.println("Connect to database failed" + e.getMessage());
		}
		return connection;
	}


	private Connection getConnectionThroughBasicDataSource() {
		Connection connection = null;
		BasicDataSource bdSource = new BasicDataSource();

		bdSource.setDriverClassName("com.mysql.jdbc.Driver");
		bdSource.setUrl("jdbc:mysql://localhost:3306/test");
		bdSource.setUsername("root");
		bdSource.setPassword("");

		try {
			connection = bdSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private void insertTest() {
		Connection connect = getConnectionThroughBasicDataSource();
		System.out.println(connect);
		try {
			Statement statement = connect.createStatement();
			for (int i = 50000; i < 1000000; i++) {
				String sql = "insert into school values('name'," + i + ");";
				statement.executeUpdate(sql);


			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}