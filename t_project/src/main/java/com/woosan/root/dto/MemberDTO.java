package com.woosan.root.dto;

import java.sql.Date;

public class MemberDTO {
	private String id, pwd, addr, name, phNum, email, gender, prf_addr, auto_cookie;
	private Date limit_time;
	private int age, rpt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPrf_addr() {
		return prf_addr;
	}
	public void setPrf_addr(String prf_addr) {
		this.prf_addr = prf_addr;
	}
	public String getAuto_cookie() {
		return auto_cookie;
	}
	public void setAuto_cookie(String auto_cookie) {
		this.auto_cookie = auto_cookie;
	}
	public Date getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(Date limit_time) {
		this.limit_time = limit_time;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRpt() {
		return rpt;
	}
	public void setRpt(int rpt) {
		this.rpt = rpt;
	}
	
}
