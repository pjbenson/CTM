package com.betfair.main;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.betfair.api.IMarketDataSource;
import com.betfair.api.MarketDataWrapper;
import com.betfair.entities.MarketBook;
import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.MarketFilter;
import com.betfair.entities.Runner;
import com.betfair.entities.TimeRange;
import com.betfair.enums.MarketProjection;
import com.betfair.exceptions.APINGException;
import com.betfair.strategies.RaglanRoad;

public class BetfairAPI {
	private Set<String> eventTypeIds = new HashSet<String>();
	private MarketFilter marketFilter = new MarketFilter();
	private Set<String> countries = new HashSet<String>();
	private Set<String> typesCode = new HashSet<String>();
	private TimeRange time = new TimeRange();
	private Set<MarketProjection> marketProjection = new HashSet<MarketProjection>();
	
	public BetfairAPI() throws APINGException{
		eventTypeIds.add("7");
		marketFilter.setEventTypeIds(eventTypeIds);
		time.setFrom(new Date());
		marketFilter.setMarketStartTime(time);
		marketProjection.add(MarketProjection.MARKET_START_TIME);
		String maxResults = "100";
		
		IMarketDataSource marketDS = new MarketDataWrapper();
		RaglanRoad rg = new RaglanRoad(marketDS);
//    	List<MarketCatalogue> list = rg.getListMarketCatalogue();
//    	printMarketCatalogue(list);
//    	List<MarketBook> list2 = rg.getMarketPrices();
//    	printMarketBook(list2);
		rg.strategyCalculation();
	}
	
	private void printMarketCatalogue(List<MarketCatalogue> mk){
		for(MarketCatalogue mc: mk){
			System.out.println("Market Name: "+mc.getMarketName() + "; Id: "+mc.getMarketId()+"Time: "+mc.getMarketTime().toString());
		}
        
    }
	
	private void printMarketBook(List<MarketBook> mb){
		for(MarketBook market: mb){
			System.out.println("Market id: "+ market.getMarketId());
			for(Runner runner: market.getRunners()){
				System.out.println("Selection id: "+ runner.getSelectionId() + ", Price: "+ runner.getLastPriceTraded());
			}
		}
	}
	
	public static void main(String[] args) throws APINGException{
    	new BetfairAPI();
	}

}
