package com.bookshelf;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;

	public int add(Book book) throws SQLException {
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/bookShelf", "root", "");

			statement = connect.createStatement();
			String sql = "insert into book values(" + book.getIsbn() + ",'" +
					book.getName() + "'," +
					book.getPrice() + ",'" +
					book.getAuthor() + "');";
			 result = statement.executeUpdate(sql);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connect.close();
		}
		return result;
	}

}