package com.betfair.strategies;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.betfair.api.IMarketDataSource;
import com.betfair.dao.MarketDataPersister;
import com.betfair.entities.MarketBook;
import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.MarketFilter;
import com.betfair.entities.TimeRange;
import com.betfair.enums.MarketProjection;
import com.betfair.exceptions.APINGException;

public class Lucayan implements IStrategy {
	
	private Set<String> eventTypeIds = new HashSet<String>();
	private MarketFilter marketFilter = new MarketFilter();
	private Set<String> countries = new HashSet<String>();
	private Set<String> typesCode = new HashSet<String>();
	private TimeRange time = new TimeRange();
	private Set<MarketProjection> marketProjection = new HashSet<MarketProjection>();
	private IMarketDataSource dataSource;
	private MarketDataPersister persister;
	private Double pool = 100.0;
	
	public  Lucayan(IMarketDataSource marketData) {
		dataSource = marketData;
		persister = new MarketDataPersister();
	}

	@Override
	public void execute() throws ParseException, APINGException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<MarketCatalogue> getListMarketCatalogue() throws APINGException, ParseException{
		Date dt = new Date();
		dt.setHours(17);
		eventTypeIds.add("7");
		countries.add("GB");
		countries.add("IE");
		typesCode.add("WIN");
		time.setFrom(new Date());
		time.setTo(dt);
		marketFilter.setMarketCountries(countries);
		marketFilter.setMarketTypeCodes(typesCode);
		marketFilter.setEventTypeIds(eventTypeIds);
		marketFilter.setMarketStartTime(time);
		marketProjection.add(MarketProjection.MARKET_START_TIME);
		marketProjection.add(MarketProjection.RUNNER_DESCRIPTION);
		String maxResults = "50";
		List<MarketCatalogue> listMarketCatalogue = dataSource.listMarketCatalogue(marketFilter, marketProjection, maxResults);
		List<MarketCatalogue> result = new ArrayList<MarketCatalogue>();
	
		for(MarketCatalogue marketCatalogue: listMarketCatalogue){
			if(marketCatalogue.getMarketName().contains("Mdn") && marketCatalogue.getMarketName().contains("Hrd")){
				result.add(marketCatalogue);
				persister.persistRunnerCatalogue(marketCatalogue.getRunners().get(0));
				persister.persistRunnerCatalogue(marketCatalogue.getRunners().get(1));
				persister.persistRunnerCatalogue(marketCatalogue.getRunners().get(2));
				persister.persistMarketCatalogue(marketCatalogue, 3);
			}
		}
		return result;
	}
	
	public Double getPool() {
		return pool;
	}

	public void addToPool(Double pool) {
		this.pool = this.pool + pool;
	}

	@Override
	public void strategyCalculation() throws APINGException, ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MarketBook> getMarketPrices() throws APINGException,
			ParseException {
		// TODO Auto-generated method stub
		return null;
	}

}
