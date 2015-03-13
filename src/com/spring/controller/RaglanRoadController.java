package com.spring.controller;

import static com.googlecode.charts4j.Color.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.collection.PersistentBag;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.Order;
import com.betfair.entities.Result;
import com.betfair.entities.Runner;
import com.betfair.entities.RunnerCatalogue;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.DataUtil;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.Line;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.LineStyle;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Plot;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Slice;
import com.spring.model.Strategy;
import com.spring.model.User;
import com.spring.service.AccountService;
import com.spring.service.MarketCatalogueService;
import com.spring.service.OrderService;
import com.spring.service.ResultsService;
import com.spring.service.RunnerService;
import com.spring.service.StrategyService;
import com.spring.service.UserService;
import com.spring.test.RaglanRoadObject;

@Controller
@SessionAttributes({"strategy", "order", "runners"})
public class RaglanRoadController {

	@Autowired
	private RunnerService runnerService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private StrategyService strategyService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private MarketCatalogueService marketCatalogueService;
	@Autowired
	private ResultsService resultsService;
	@Autowired
	private UserService userService;

	@RequestMapping(value="raglanroad", method = RequestMethod.GET)
	public ModelAndView showRagalanRoad(ModelMap model) throws ParseException {
		LineChart chart = createLineChart();
		PieChart pieChart = createPieChart();
		Strategy raglanRoad = strategyService.getStrategy(1);
		List<MarketCatalogue> markets = marketCatalogueService.getMarketCatalogueList();
		List<RaglanRoadObject> list = getDataForRunnerTable();
		model.put("list", list);
//		List<Runner> runners = runnerService.getRunnerList();
//		model.put("runners", runners);
		//HashMap<String, List<PersistentBag>> markets = getMarkets();
		//model.put("markets", markets);
		//HashMap<Long, PersistentBag> runners = getRunnerOrders();
//		List<Order> orders = orderService.getOrderList();
//		List<Double> prices = new ArrayList<Double>();
//		List<Double> expReturns = new ArrayList<Double>();
//		for(Order order: orders){
//			prices.add(order.getPrice());
//			expReturns.add(order.getExp_winnigs());
//		}
//		model.put("prices", prices); 
//		model.put("expWinnings", expReturns);
		//		Runner runner = runnerService.getRunner((long) 9281231);
		//System.out.println(raglanRoad);
		//		model.addAttribute("marketTimes", markets);
		model.put("strategy", raglanRoad);
		model.addAttribute("pieChart", pieChart.toURLString());
		model.addAttribute("lineChart", chart.toURLString());
		return new ModelAndView("raglanroad");
	}
	
	@RequestMapping(value = "/addCash", method = RequestMethod.POST)
	public ModelAndView addCashToPool(@RequestParam("amount") Double amount){
		User user = (User) RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);
		Strategy raglanRoad = strategyService.getStrategy(1);
		raglanRoad.addToPool(amount);
		strategyService.addAccountToStrategy(raglanRoad);
		user.getAccount().addToRaglanroad(amount);
		user.getAccount().setBalance(user.getAccount().getBalance() - amount);
		userService.updateBalance(user);
		
		return new ModelAndView("raglanroad");
	}
	
	private List<RaglanRoadObject> getDataForRunnerTable(){
		List<RaglanRoadObject> list = new ArrayList<RaglanRoadObject>();
		List<Order> orders = orderService.getOrderList();
		List<MarketCatalogue> markets = marketCatalogueService.getMarketCatalogueList();
		int index = 0;
		
		for(MarketCatalogue mc: markets){
			RaglanRoadObject runner = new RaglanRoadObject();
			runner.setDate(mc.getMarketTime());
			runner.setRaceName(mc.getMarketName());
			runner.setPrice(orders.get(index).getPrice());
			runner.setExpWinnings(orders.get(index).getExp_winnigs());
			runner.setHorseName(mc.getRunners().get(index).getRunnerName());
			list.add(runner);
			index++;
		}
		return list;
	}

	private PieChart createPieChart() {
		Slice s1 = Slice.newSlice(15, Color.newColor("CACACA"), "Mac", "Mac");
		Slice s2 = Slice.newSlice(50, Color.newColor("DF7417"), "Window",
				"Window");
		Slice s3 = Slice.newSlice(25, Color.newColor("951800"), "Linux",
				"Linux");
		Slice s4 = Slice.newSlice(10, Color.newColor("01A1DB"), "Others",
				"Others");

		PieChart pieChart = GCharts.newPieChart(s1, s2, s3, s4);
		pieChart.setTitle("Google Pie Chart", Color.BLACK, 15);
		pieChart.setSize(720, 360);
		pieChart.setThreeD(true);
		return pieChart;
	}

	private LineChart createLineChart() throws ParseException {
		List<Result> results =  resultsService.getResults();
		Map<Date, Double> dailyReturns = getDailyReturns(results);
		Map<Date, Double> orderedReturns = new TreeMap<Date, Double>(dailyReturns);
		List<String> dates = new ArrayList<String>();
		List<Double> returns = new ArrayList<Double>();
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		for (Map.Entry<Date, Double> entry : orderedReturns.entrySet())
		{
		    String date = fmt.format(entry.getKey());
		    dates.add(date);
		    if(entry.getValue() > 100){
		    	Double val = entry.getValue()-100;
		    	returns.add(val);
		    }else{
		    	returns.add(entry.getValue());
		    }
		}
		
		Data data = DataUtil.scale(returns);
		List<Plot> plots = new LinkedList<Plot>();
		plots.add(Plots.newPlot(data));
		
		
		final Line line = Plots.newLine(Data.newData(returns));
		line.setColor(BLACK);
		final LineChart chart = GCharts.newLineChart(line);
		chart.setSize(650, 450);
		chart.setGrid(200, 5, 5, 0);
		chart.setTitle("Returns|(per €100)", BLACK, 14);
		chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(dates));
		chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("February"));
		chart.addYAxisLabels(AxisLabelsFactory.newAxisLabels("0", "25", "50", "75", "100"));
		
		return chart;
	}

	private Map<Date, Double> getDailyReturns(List<Result> results) {
		Map<Date, Double> pairs = new HashMap<Date, Double>();
		for(Result r: results){
			Double winning = pairs.get(r.getDate());
			if(winning == null)winning=0.0;
			pairs.put(r.getDate(), r.getAmount() + winning);
		}
		return pairs;
	}

}
