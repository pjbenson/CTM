package com.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="Strategy")
public class Strategy implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "STRATEGY_ID")
	private Integer id;
	
	@Column(name = "STRATEGY_NAME")
	private String name;
	
	@Column(name = "STRATEGY_POOL")
	private Double pool;
	
	@OneToMany
	@JoinTable(name = "strategy_accounts", joinColumns = @JoinColumn(name = "strategy_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
	private List<Account> accounts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public Double getPool() {
		return pool;
	}
	public void setPool(Double pool) {
		this.pool = pool;
	}

}
