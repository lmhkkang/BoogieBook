package com.boogie.member.dto;


import java.util.Date;

/**
 * @작성자 : 신종명
 * @날짜 : 2019.08.01
 * @설명 : 멤버 DTO 
 */

public class MemberDto {
	int member_num;
	String member_id;
	String password;
	String email;
	String name;
	Date birth_date;
	int gender;
	String phone;
	String zipcode;
	String addr1;
	String addr2;
	String job;
	String interest;
	
	int non_member;
	int sns_num;
	Date register_date;
	
	public MemberDto() {}
	
	public MemberDto(int member_num, String member_id, String name, String password, int gender, Date birth_date,
			String phone, String email, String interest, String job, String addr1, String addr2, String zipcode,
			int non_member, int sns_num, Date register_date) {
		super();
		this.member_num = member_num;
		this.member_id = member_id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.birth_date = birth_date;
		this.phone = phone;
		this.email = email;
		this.interest = interest;
		this.job = job;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.non_member = non_member;
		this.sns_num = sns_num;
		this.register_date = register_date;
	}
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
		return "MemberDto [member_num=" + member_num + ", member_id=" + member_id + ", name=" + name + ", password="
				+ password + ", gender=" + gender + ", birth_date=" + birth_date + ", phone=" + phone + ", email="
				+ email + ", interest=" + interest + ", job=" + job + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", zipcode=" + zipcode + ", non_member=" + non_member + ", sns_num=" + sns_num + ", register_date="
				+ register_date + "]";
	}
		
}
