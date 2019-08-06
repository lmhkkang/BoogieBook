package com.boogie.order.dto;

import java.util.Date;

public class OrderDto {
	private String member_id;
	private int book_id;
	private int quantity;
	private Date input_date;	//여기까지 cart table
	
	private String img_path;
	private String book_name;
	
	private int stock;
	
	private int order_id;
	private int order_status;
	private String status;
	private int price;			
	private Date order_date;
	
	private String name;
	private String addr1;
	private String addr2;  //결제완료페이지에 필요.
	private int total_price;
	
	public OrderDto() {}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getInput_date() {
		return input_date;
	}

	public void setInput_date(Date input_date) {
		this.input_date = input_date;
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

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	
	
	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "OrderDto [member_id=" + member_id + ", book_id=" + book_id + ", quantity=" + quantity + ", input_date="
				+ input_date + ", img_path=" + img_path + ", book_name=" + book_name + ", stock=" + stock
				+ ", order_id=" + order_id + ", order_status=" + order_status + ", status=" + status + ", price="
				+ price + ", order_date=" + order_date + ", name=" + name + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", total_price=" + total_price + "]";
	}

}
