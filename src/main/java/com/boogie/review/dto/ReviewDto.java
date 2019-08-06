package com.boogie.review.dto;

import java.util.Date;

public class ReviewDto {
	private int review_id;
	private int rate;
	private String content;
	private int member_num;
	private int book_id;
	private Date review_date;
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	@Override
	public String toString() {
		return "ReviewDto [review_id=" + review_id + ", rate=" + rate + ", content=" + content + ", member_num="
				+ member_num + ", book_id=" + book_id + ", review_date=" + review_date + "]";
	}
	
	
}
