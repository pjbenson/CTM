package com.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Account")
public class Account implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer id;
	
	@Column(name = "BALANCE")
	private Double balance;
	
	@OneToOne
    @PrimaryKeyJoinColumn
	private User user;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "accounts_strategies", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "strategy_id"))
	private List<Strategy> strategies;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Strategy> getStrategies() {
		return strategies;
	}
	public void addStrategy(Strategy strategy) {
		if (strategies==null) {
			strategies = new ArrayList<Strategy>();
		}
		if (!strategies.contains(strategy)) {
			strategies.add(strategy);
		}
	}
}
