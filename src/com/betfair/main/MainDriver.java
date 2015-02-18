package com.betfair.main;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.betfair.api.IMarketDataSource;
import com.betfair.api.MarketDataWrapper;
import com.betfair.entities.MarketBook;
import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.Runner;
import com.betfair.exceptions.APINGException;
import com.betfair.strategies.RaglanRoad;

public class MainDriver {
	private static RaglanRoad rg = null;
	private List<MarketCatalogue> list = null;

	public MainDriver() throws APINGException{
		IMarketDataSource marketDS = new MarketDataWrapper();
		rg = new RaglanRoad(marketDS);
		list = rg.getListMarketCatalogue();

//		printMarketCatalogue(list);
//		List<MarketBook> list2 = rg.getMarketPrices();
//		printMarketBook(list2);
//		rg.strategyCalculation();
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

	static class RunStrategyTimerTask extends TimerTask {
		@Override
		public void run(){
			System.out.println(new Date());
			try {
				rg.strategyCalculation();
			} catch (APINGException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws APINGException, InterruptedException{
		new MainDriver();
		TimerTask timerTask = new RunStrategyTimerTask();
		Timer timer = new Timer();
		Date date = new Date();
		date.setHours(13);
		date.setMinutes(18);
	    timer.scheduleAtFixedRate(timerTask, date, 5000);
	}

}
