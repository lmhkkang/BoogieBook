package com.boogie.member.dto;

import java.util.Date;

/**
 * @작성자 : 신종명
 * @날짜 : 2019.08.01
 * @설명 : 멤버 DTO 
 */

public class MemberDto {
	private int member_num;
	private String member_id;
	private String password;
	private String email;
	private String name;
	private Date birth_date;
	private int gender;
	private String phone;
	private String zipcode;
	private String addr1;
	private String addr2;
	private String job;
	private String interest;
	
	private int non_member;
	private int sns_num;
	private Date register_date;
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public int getNon_member() {
		return non_member;
	}
	public void setNon_member(int non_member) {
		this.non_member = non_member;
	}
	public int getSns_num() {
		return sns_num;
	}
	public void setSns_num(int sns_num) {
		this.sns_num = sns_num;
	}
	public Date getRegister_date() {
		return register_date;
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "MemberDto [member_num=" + member_num + ", member_id=" + member_id + ", password=" + password
				+ ", email=" + email + ", name=" + name + ", birth_date=" + birth_date + ", gender=" + gender
				+ ", phone=" + phone + ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2 + ", job=" + job
				+ ", interest=" + interest + ", non_member=" + non_member + ", sns_num=" + sns_num + ", register_date="
				+ register_date + "]";
	}

	
	
	
}
