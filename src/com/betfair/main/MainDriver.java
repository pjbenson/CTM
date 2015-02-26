package com.betfair.main;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.betfair.api.IMarketDataSource;
import com.betfair.api.MarketDataWrapper;
import com.betfair.dao.Persister;
import com.betfair.entities.MarketBook;
import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.Runner;
import com.betfair.entities.RunnerCatalogue;
import com.betfair.exceptions.APINGException;
import com.betfair.strategies.Context;
import com.betfair.strategies.RaglanRoad;

public class MainDriver {
	private static RaglanRoad rg = null;
	private List<MarketCatalogue> list = null;
	private Persister persister = new Persister();
	private static Context context;

	public MainDriver() throws APINGException, ParseException{
		IMarketDataSource marketDS = new MarketDataWrapper();
		context = new Context(new RaglanRoad(marketDS));
		rg = new RaglanRoad(marketDS);
//		list = rg.getListMarketCatalogue();
//
//		printMarketCatalogue(list);
//		List<MarketBook> list2 = rg.getMarketPrices();
//		printMarketBook(list2);
		context.executeStrategy();
//		rg.strategyCalculation();
//		list = persister.getAllMarkets();
//		printMarketCatalogue(list);
	}

	private void printMarketCatalogue(List<MarketCatalogue> mk){
		for(MarketCatalogue mc: mk){
			System.out.println("Market Name: "+mc.getMarketName() + "; Id: "+mc.getMarketId()+"Time: "+mc.getMarketTime().toString());
			for(RunnerCatalogue rc: mc.getRunners()){
				System.out.println("Runner Name: " + rc.getRunnerName() + "; Id: " + rc.getSelectionId());
			}
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

	static class RunStrategyTimerTask extends TimerTask {
		@Override
		public void run(){
			try {
				context.executeStrategy();
			} catch (APINGException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws APINGException, InterruptedException, ParseException{
		new MainDriver();
//		TimerTask timerTask = new RunStrategyTimerTask();
//		Timer timer = new Timer();
//		Date date = new Date();
//		date.setHours(13);
//		date.setMinutes(00);
//		timer.schedule(timerTask, date);
//	    timer.scheduleAtFixedRate(timerTask, date, 5000);
	}

}
