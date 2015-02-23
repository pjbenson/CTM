package com.betfair.strategies;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;

import com.betfair.api.IMarketDataSource;
import com.betfair.dao.Persister;
import com.betfair.entities.LimitOrder;
import com.betfair.entities.MarketBook;
import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.MarketFilter;
import com.betfair.entities.PlaceExecutionReport;
import com.betfair.entities.PlaceInstruction;
import com.betfair.entities.RunnerCatalogue;
import com.betfair.entities.TimeRange;
import com.betfair.enums.ExecutionReportStatus;
import com.betfair.enums.MarketProjection;
import com.betfair.enums.OrderProjection;
import com.betfair.enums.OrderType;
import com.betfair.enums.PersistenceType;
import com.betfair.enums.Side;
import com.betfair.exceptions.APINGException;

public class RaglanRoad {
	private static Double AMOUNT = 100.0;
	private IMarketDataSource dataSource;
	private Set<String> eventTypeIds = new HashSet<String>();
	private MarketFilter marketFilter = new MarketFilter();
	private Set<String> countries = new HashSet<String>();
	private Set<String> typesCode = new HashSet<String>();
	private TimeRange time = new TimeRange();
	private Set<MarketProjection> marketProjection = new HashSet<MarketProjection>();
	private Timer timer = new Timer(true);
	private Persister persister;

	public RaglanRoad(IMarketDataSource marketData){
		dataSource = marketData;
		persister = new Persister();
	}

	public void strategyCalculation() throws APINGException, ParseException{
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
			ratio1 = Math.round((a/total)*AMOUNT);
			ratio2 = Math.round((b/total)*AMOUNT);
			ratio3 = Math.round((c/total)*AMOUNT);
			exp1 = Math.round(ratio1*price1);
			exp2 = Math.round(ratio2*price2);
			exp3 = Math.round(ratio3*price3);
			System.out.print(price1+" "+price2+" "+price3+"\n");
			System.out.print(ratio1+" "+ratio2+" "+ratio3+"\n");
			System.out.print(exp1+" "+exp2+" "+exp3+"\n");
			
			//TODO: create for loop to create instructions 1, 2 and 3
			instruction1.setSelectionId(mb.getRunners().get(0).getSelectionId());
			instruction1.setSide(Side.BACK);
			instruction1.setHandicap(0);
			instruction1.setOrderType(OrderType.LIMIT);
			LimitOrder limitOrder = new LimitOrder();
			limitOrder.setPrice(price1);
			limitOrder.setSize(ratio1);
			limitOrder.setPersistenceType(PersistenceType.LAPSE);
			instruction1.setLimitOrder(limitOrder);
			instructions.add(instruction1);

			instruction2.setSelectionId(mb.getRunners().get(1).getSelectionId());
			instruction2.setSide(Side.BACK);
			instruction2.setHandicap(0);
			instruction2.setOrderType(OrderType.LIMIT);
			LimitOrder limitOrder2 = new LimitOrder();
			limitOrder2.setPrice(price2);
			limitOrder2.setSize(ratio2);
			limitOrder2.setPersistenceType(PersistenceType.LAPSE);
			instruction2.setLimitOrder(limitOrder2);
			instructions.add(instruction2);
			
			instruction3.setSelectionId(mb.getRunners().get(2).getSelectionId());
			instruction3.setSide(Side.BACK);
			instruction3.setHandicap(0);
			instruction3.setOrderType(OrderType.LIMIT);
			LimitOrder limitOrder3 = new LimitOrder();
			limitOrder3.setPrice(price3);
			limitOrder3.setSize(ratio3);
			limitOrder3.setPersistenceType(PersistenceType.LAPSE);
			instruction3.setLimitOrder(limitOrder3);
			instructions.add(instruction3);

			PlaceExecutionReport placeBetResult = dataSource.placeOrders(mb.getMarketId(), instructions);
			
			if (placeBetResult.getStatus() == ExecutionReportStatus.SUCCESS) {
                System.out.println("Your bet has been placed!!");
                System.out.println(placeBetResult.getInstructionReports());
            } else if (placeBetResult.getStatus() == ExecutionReportStatus.FAILURE) {
                System.out.println("Your bet has NOT been placed :*( ");
                System.out.println("The error is: " + placeBetResult.getErrorCode() + ": " + placeBetResult.getErrorCode().getMessage());
            }
		}
	}
	
	public List<MarketBook> getMarketPrices() throws APINGException, ParseException{
		List<MarketCatalogue> markets = getListMarketCatalogue();
		List<String> marketIds = new ArrayList<String>();
		//marketIds.add(markets.get(0).getMarketId());
		//TODO: create a timer than runs for 2 mins before each market start time
		for(MarketCatalogue market: markets){
			marketIds.add(market.getMarketId());
		}

		return dataSource.listMarketBook(marketIds, OrderProjection.EXECUTABLE);
	}

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
		//marketFilter.setMarketStartTime(time);
		marketProjection.add(MarketProjection.MARKET_START_TIME);
		marketProjection.add(MarketProjection.RUNNER_DESCRIPTION);
		String maxResults = "100";
		List<MarketCatalogue> listMarketCatalogue = dataSource.listMarketCatalogue(marketFilter, marketProjection, maxResults);
		List<MarketCatalogue> result = new ArrayList<MarketCatalogue>();
	
		for(MarketCatalogue marketCatalogue: listMarketCatalogue){
			if(marketCatalogue.getMarketName().contains("Mdn") && marketCatalogue.getMarketName().contains("Hrd")){
				result.add(marketCatalogue);
				for(RunnerCatalogue rc: marketCatalogue.getRunners()){
					persister.persistRunnerCatalogue(rc);
				}
				persister.persistMarketCatalogue(marketCatalogue);
			}
		}
		//persister.closeResources();
		return result;
	}

	public void setAMOUNT(Double amount) {
		AMOUNT += amount;
	}

}
