package com.betfair.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@NamedQueries({		
	@NamedQuery(name = "Market.findById", query = "select o from MarketCatalogue o where o.marketId=:a"),
	@NamedQuery(name = "Market.findAll", query = "select o from MarketCatalogue o")
})
@Entity
@Table(name="Market_Catalogue")
public class MarketCatalogue implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="MARKET_ID")
	private String marketId;
	@Column(name="MARKET_NAME")
	private String marketName;
	@OneToMany//(mappedBy="marketCatalogue")
	@JoinTable(name = "market_runner", joinColumns = @JoinColumn(name = "market_catalogue_market_id"), inverseJoinColumns = @JoinColumn(name = "runner_catalogue_selection_id"))
	private List<RunnerCatalogue> runners = new ArrayList<RunnerCatalogue>();
	@Column(name="MARKET_START_NAME")
	private Date marketStartTime;
	
	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public List<RunnerCatalogue> getRunners() {
		return runners;
	}

	public void setRunners(List<RunnerCatalogue> runners) {
		this.runners = runners;
	}
	
	public Date getMarketTime() {
		return marketStartTime;
	}
	
	public void addRunnner(RunnerCatalogue runner){
		runners.add(runner);
	}

	public void setMarketTime(Date marketTime) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
		String m = formatter.format(marketTime);
		Date date = formatter.parse(m);
		this.marketStartTime = date;
	}

	public String toString() {
		return getMarketName();
	}

}
