package domain;

public class Book {
	private int isbn;
	private String name;
	private double price;
	private String author;

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}
}
