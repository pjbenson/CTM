package com.spring.test;

import java.util.Date;

public class RaglanRoadObject {
	
	private String raceName;
	private String horseName;
	private Date date;
	private Double price;
	private Double expWinnings;
	
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public String getHorseName() {
		return horseName;
	}
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getExpWinnings() {
		return expWinnings;
	}
	public void setExpWinnings(Double expWinnings) {
		this.expWinnings = expWinnings;
	}

}
