package com.betfair.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Bet_Order")
public class Order {
	@Id
	@Column(name="ORDER_ID")
	private int orderId;
	@Transient
	private String betId;
	@Column(name="ORDER_TYPE")
	private String orderType;
	@Transient
	private String status;
	@Transient
	private String persistenceType;
	@Column(name="ORDER_SIDE")
	private String side;
	@Column(name="ORDER_PRICE")
	private Double price;
	@Column(name="ORDER_SIZE")
	private Double size;
	@Transient
	private Double bspLiability;
	private Date placedDate;
	@Transient
	private Double avgPriceMatched;
	@Transient
	private Double sizeMatched;
	@Transient
	private Double sizeRemaining;
	@Transient
	private Double sizeLapsed;
	@Transient
	private Double sizeCancelled;
	@Transient
	private Double sizeVoided;

	public String getBetId() {
		return betId;
	}

	public void setBetId(String betId) {
		this.betId = betId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPersistenceType() {
		return persistenceType;
	}

	public void setPersistenceType(String persistenceType) {
		this.persistenceType = persistenceType;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Double getBspLiability() {
		return bspLiability;
	}

	public void setBspLiability(Double bspLiability) {
		this.bspLiability = bspLiability;
	}

	public Date getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}

	public Double getAvgPriceMatched() {
		return avgPriceMatched;
	}

	public void setAvgPriceMatched(Double avgPriceMatched) {
		this.avgPriceMatched = avgPriceMatched;
	}

	public Double getSizeMatched() {
		return sizeMatched;
	}

	public void setSizeMatched(Double sizeMatched) {
		this.sizeMatched = sizeMatched;
	}

	public Double getSizeRemaining() {
		return sizeRemaining;
	}

	public void setSizeRemaining(Double sizeRemaining) {
		this.sizeRemaining = sizeRemaining;
	}

	public Double getSizeLapsed() {
		return sizeLapsed;
	}

	public void setSizeLapsed(Double sizeLapsed) {
		this.sizeLapsed = sizeLapsed;
	}

	public Double getSizeCancelled() {
		return sizeCancelled;
	}

	public void setSizeCancelled(Double sizeCancelled) {
		this.sizeCancelled = sizeCancelled;
	}

	public Double getSizeVoided() {
		return sizeVoided;
	}

	public void setSizeVoided(Double sizeVoided) {
		this.sizeVoided = sizeVoided;
	}

	public String toString() {
		return "{" + "" + "betId=" + getBetId() + "," + "orderType="
				+ getOrderType() + "," + "status=" + getStatus() + ","
				+ "persistenceType=" + getPersistenceType() + "," + "side="
				+ getSide() + "," + "price=" + getPrice() + "," + "size="
				+ getSize() + "," + "bspLiability=" + getBspLiability() + ","
				+ "placedDate=" + getPlacedDate() + "," + "avgPriceMatched="
				+ getAvgPriceMatched() + "," + "sizeMatched="
				+ getSizeMatched() + "," + "sizeRemaining="
				+ getSizeRemaining() + "," + "sizeLapsed=" + getSizeLapsed()
				+ "," + "sizeCancelled=" + getSizeCancelled() + ","
				+ "sizeVoided=" + getSizeVoided() + "," + "}";
	}

}
