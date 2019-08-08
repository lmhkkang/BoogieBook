package com.boogie.review.dto;

import java.util.Date;

public class ReviewDto {
	private String review_id;
	private int rate;
	private String content;
	private int member_num;
	private int book_id;
	private Date review_date;
	private String member_id;
	
	public ReviewDto() {
	}

	public ReviewDto(String review_id, int rate, String content, int member_num, int book_id, Date review_date,
			String member_id) {
		this.review_id = review_id;
		this.rate = rate;
		this.content = content;
		this.member_num = member_num;
		this.book_id = book_id;
		this.review_date = review_date;
		this.member_id = member_id;
	}

	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
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

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "ReviewDto [review_id=" + review_id + ", rate=" + rate + ", content=" + content + ", member_num="
				+ member_num + ", book_id=" + book_id + ", review_date=" + review_date + ", member_id=" + member_id
				+ "]";
	}
	
	

}
