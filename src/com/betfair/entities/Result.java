package com.betfair.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Results")
public class Result implements Comparable{
	
	@Id
	@Column(name="RESULT_ID")
	private int resultId;
	@Column(name="AMOUNT")
	private Double amount;
	@Column(name="DATE")
	private Date date;
	@Column(name="HORSE_NAME")
	private String horseName;
	
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHorseName() {
		return horseName;
	}
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	@Override
	public int compareTo(Object arg0) {
		Date date = ((Result)arg0).getDate();
		// TODO Auto-generated method stub
		return this.date.getDate()-date.getDate();
	}

}
