package kr.books.web.model;

public class BookDto {
	private int idx; // 목록번호
	private String book; // 책제목
	private String bookisbn; // 책 고유번호
	private String writer; // 저자
	private String publishing; // 출판사
	private int price; // 가격 
	private String image; // 파일 이름
	private String content; //내용
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getBookisbn() {
		return bookisbn;
	}
	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BookDto(int idx, String book, String bookisbn, String writer, String publishing, int price, String image,
			String content) {
		this.idx = idx;
		this.book = book;
		this.bookisbn = bookisbn;
		this.writer = writer;
		this.publishing = publishing;
		this.price = price;
		this.image = image;
		this.content = content;
	}
	public BookDto( String book, String bookisbn, String writer, String publishing, int price, String image,
			String content) {
		this.book = book;
		this.bookisbn = bookisbn;
		this.writer = writer;
		this.publishing = publishing;
		this.price = price;
		this.image = image;
		this.content = content;
	}
	public BookDto() {
		super();
	}
}
