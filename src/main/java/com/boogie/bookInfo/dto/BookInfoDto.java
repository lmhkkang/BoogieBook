package com.boogie.bookInfo.dto;

import java.util.Date;

public class BookInfoDto {

	private String type01;
	private String type02;
	private String type03;
	
	private String img_path;
	private String book_name;
	private int book_id;
	
	private String author;
	private String publisher;
	private Date publish_date;
	private Date enrolled_date;
	
	private int price;
	private int stock;
	private int sales_volume;
	
	private String story;
//----------------------여기까지 book table DB-----------------------------------------------

	public String getType01() {
		return type01;
	}

	public void setType01(String type01) {
		this.type01 = type01;
	}

	public String getType02() {
		return type02;
	}

	public void setType02(String type02) {
		this.type02 = type02;
	}

	public String getType03() {
		return type03;
	}

	public void setType03(String type03) {
		this.type03 = type03;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public Date getEnrolled_date() {
		return enrolled_date;
	}

	public void setEnrolled_date(Date enrolled_date) {
		this.enrolled_date = enrolled_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSales_volume() {
		return sales_volume;
	}

	public void setSales_volume(int sales_volume) {
		this.sales_volume = sales_volume;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "BookInfoDto [type01=" + type01 + ", type02=" + type02 + ", type03=" + type03 + ", img_path=" + img_path
				+ ", book_name=" + book_name + ", book_id=" + book_id + ", author=" + author + ", publisher="
				+ publisher + ", publish_date=" + publish_date + ", enrolled_date=" + enrolled_date + ", price=" + price
				+ ", stock=" + stock + ", sales_volume=" + sales_volume + ", story=" + story + "]";
	}

}
