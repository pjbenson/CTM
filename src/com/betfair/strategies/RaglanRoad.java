package com.betfair.strategies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import com.betfair.api.IMarketDataSource;
import com.betfair.entities.LimitOrder;
import com.betfair.entities.MarketBook;
import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.MarketFilter;
import com.betfair.entities.PlaceExecutionReport;
import com.betfair.entities.PlaceInstruction;
import com.betfair.entities.Runner;
import com.betfair.entities.TimeRange;
import com.betfair.enums.MarketProjection;
import com.betfair.enums.OrderProjection;
import com.betfair.enums.Side;
import com.betfair.exceptions.APINGException;

public class RaglanRoad {
	private IMarketDataSource dataSource;
	private Set<String> eventTypeIds = new HashSet<String>();
	private MarketFilter marketFilter = new MarketFilter();
	private Set<String> countries = new HashSet<String>();
	private Set<String> typesCode = new HashSet<String>();
	private TimeRange time = new TimeRange();
	private Set<MarketProjection> marketProjection = new HashSet<MarketProjection>();
	private Timer timer = new Timer(true);

	public RaglanRoad(IMarketDataSource marketData){
		dataSource = marketData;
	}

	public void strategyCalculation() throws APINGException{
		List<MarketBook> marketBooks = getMarketPrices();
		List<PlaceInstruction> instructions = new ArrayList<PlaceInstruction>();
		PlaceInstruction instruction1 = new PlaceInstruction();
		PlaceInstruction instruction2 = new PlaceInstruction();
		PlaceInstruction instruction3 = new PlaceInstruction();
		
		double price1;
		double price2;
		double price3;
		double a;
		double b;
		double c;
		double total;
		double ratio1;
		double ratio2;
		double ratio3;
		double exp1;
		double exp2;
		double exp3;
		
		for(MarketBook mb: marketBooks){
			price1 = mb.getRunners().get(0).getLastPriceTraded();
			price2 = mb.getRunners().get(1).getLastPriceTraded();
			price3 = mb.getRunners().get(2).getLastPriceTraded();
			a = price2*price3;
			b = price1*price3;
			c = price1*price2;
			total = a+b+c;
			ratio1 = Math.round((a/total)*100);
			ratio2 = Math.round((b/total)*100);
			ratio3 = Math.round((c/total)*100);
			exp1 = Math.round(ratio1*price1);
			exp2 = Math.round(ratio2*price2);
			exp3 = Math.round(ratio3*price3);
			System.out.print(price1+" "+price2+" "+price3+"\n");
			System.out.print(ratio1+" "+ratio2+" "+ratio3+"\n");
			System.out.print(exp1+" "+exp2+" "+exp3+"\n");
			
			instruction1.setSelectionId(mb.getRunners().get(0).getSelectionId());
			instruction1.setSide(Side.BACK);
			LimitOrder limitOrder = new LimitOrder();
			limitOrder.setPrice(price1);
			instruction1.setLimitOrder(limitOrder);
			instructions.add(instruction1);
			
			instruction2.setSelectionId(mb.getRunners().get(1).getSelectionId());
			instruction2.setSide(Side.BACK);
			limitOrder.setPrice(price2);
			instruction2.setLimitOrder(limitOrder);
			instructions.add(instruction2);
			//TODO: need to create two other instruction variables and add them to instructions collection
			
			PlaceExecutionReport placeBetResult = dataSource.placeOrders(mb.getMarketId(), instructions, "1");
		}

//		for (Map.Entry<Long, Double> entry: getFavourites().entrySet()) {
//			if(count == 0)
//				price1 = entry.getValue();
//			if(count == 1)
//				price2 = entry.getValue();
//			if(count == 2)
//				price3 = entry.getValue();
//
//			count++;
//		}
	}

	public Map<Long, Double> getFavourites() throws APINGException{
		Map<Long, Double> bets = new HashMap<Long, Double>();

		int count = 0;
		int max = 3;
		for (Map.Entry<Long, Double> entry: getSortedRunners().entrySet()) {
			if (count >= max) break;
			bets.put(entry.getKey(), entry.getValue());
			count++;
		}

		return bets;
	}

	public Map<Long, Double> getSortedRunners() throws APINGException{
		Map<Long, Double> horsesAndPrices = new TreeMap<Long, Double>();
		List<MarketBook> list = getMarketPrices();

		for(MarketBook mb: list){
			for(Runner runner: mb.getRunners()){
				horsesAndPrices.put(runner.getSelectionId(), runner.getLastPriceTraded());
			}
		}
		ValueComparator bvc =  new ValueComparator(horsesAndPrices);
		TreeMap<Long, Double> sorted_map = new TreeMap<Long, Double>(bvc);
		sorted_map.putAll(horsesAndPrices);

		return sorted_map;
	}

	public List<MarketBook> getMarketPrices() throws APINGException{
		List<MarketCatalogue> markets = getListMarketCatalogue();
		List<String> marketIds = new ArrayList<String>();
		marketIds.add(markets.get(1).getMarketId());
		//		TimerTask task = new RunStrategyTimerTask();
		//		timer.schedule(task, markets.get(0).getMarketTime());
		//TODO: create a timer than runs for 2 mins before each market start time
//		for(MarketCatalogue market: markets){
//			marketIds.add(market.getMarketId());
//		}

		return dataSource.listMarketBook(marketIds, OrderProjection.EXECUTABLE);
	}

	public List<MarketCatalogue> getListMarketCatalogue() throws APINGException{
		Date dt = new Date();
		dt.setHours(17);
		eventTypeIds.add("7");
		countries.add("GB");
		countries.add("IE");
		typesCode.add("WIN");
		time.setFrom(new Date());
		//time.setTo(dt);
		marketFilter.setMarketCountries(countries);
		marketFilter.setMarketTypeCodes(typesCode);
		marketFilter.setEventTypeIds(eventTypeIds);
		marketFilter.setMarketStartTime(time);
		marketProjection.add(MarketProjection.MARKET_START_TIME);
		String maxResults = "100";
		List<MarketCatalogue> listMarketCatalogue = dataSource.listMarketCatalogue(marketFilter, marketProjection, maxResults);
		List<MarketCatalogue> result = new ArrayList<MarketCatalogue>();
		for(MarketCatalogue m: listMarketCatalogue){
			if(m.getMarketName().contains("Mdn")){
				result.add(m);
			}
		}
		return result;
	}

	class ValueComparator implements Comparator {

		Map map;
		public ValueComparator(Map map){
			this.map = map;
		}
		public int compare(Object keyA, Object keyB){
			Comparable valueA = (Comparable) map.get(keyA);
			Comparable valueB = (Comparable) map.get(keyB);
			
			return valueA == null?(valueB==null ? 0 : Integer.MAX_VALUE) : (valueB==null ? Integer.MIN_VALUE : valueA.compareTo(valueB));

		}
	}

	class RunStrategyTimerTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("Start time:" );
		}

	}

}
