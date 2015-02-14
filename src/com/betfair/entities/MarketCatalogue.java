package com.betfair.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MarketCatalogue {

	private String marketId;
	private String marketName;
	private List<RunnerCatalogue> runners = null;
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

	public void setMarketTime(String marketTime) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
		Date date = formatter.parse(marketTime);
		this.marketStartTime = date;
	}

	public String toString() {
		return getMarketName();
	}

}
