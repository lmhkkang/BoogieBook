package com.boogie.recommend.dto;

import java.util.Date;

/**
 * @Author	: 나다윤
 * @Date	: 2019. 8. 2.
 * @Description :
 */

public class RecommendMarkDto 
{
	private String type01;
	private String type02;
	private String type03;
	
	private String img_path;
	private String book_name;
	private String author;
	private String publisher;
	
	private Date publish_date;
	
	private int price;
	
	private String book_id;
	private String story;
	
	private int sales_volume;
	
	private Date enrolled_date;
	
	public RecommendMarkDto() {}

	public RecommendMarkDto(String type01, String type02, String type03, String img_path, String book_name,
			String author, String publisher, Date publish_date, int price, String book_id, String story,
			int sales_volume, Date enrolled_date) {
		super();
		this.type01 = type01;
		this.type02 = type02;
		this.type03 = type03;
		this.img_path = img_path;
		this.book_name = book_name;
		this.author = author;
		this.publisher = publisher;
		this.publish_date = publish_date;
		this.price = price;
		this.book_id = book_id;
		this.story = story;
		this.sales_volume = sales_volume;
		this.enrolled_date = enrolled_date;
	}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getSales_volume() {
		return sales_volume;
	}

	public void setSales_volume(int sales_volume) {
		this.sales_volume = sales_volume;
	}

	public Date getEnrolled_date() {
		return enrolled_date;
	}

	public void setEnrolled_date(Date enrolled_date) {
		this.enrolled_date = enrolled_date;
	}

	@Override
	public String toString() {
		return "RecommendDto [type01=" + type01 + ", type02=" + type02 + ", type03=" + type03 + ", img_path=" + img_path
				+ ", book_name=" + book_name + ", author=" + author + ", publisher=" + publisher + ", publish_date="
				+ publish_date + ", price=" + price + ", book_id=" + book_id + ", story=" + story + ", sales_volume="
				+ sales_volume + ", enrolled_date=" + enrolled_date + "]";
	}
	

}
