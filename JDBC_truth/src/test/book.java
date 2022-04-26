package test;

public class book {

	private int id;
	private String isbn;
	private String title;
	private String auther;
	private String publisher;
	private double unitPrice;
	private int num;
	
	@Override
	public String toString() {
		return "book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", auther=" + auther + ", publisher="
				+ publisher + ", unitPrice=" + unitPrice + ", num=" + num + "]";
	}

	public book() {}
	
	public book(String isbn, String title, String auther, String publisher, double unitPrice, int num) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.auther = auther;
		this.publisher = publisher;
		this.unitPrice = unitPrice;
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
