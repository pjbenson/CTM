package com.betfair.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.betfair.entities.MarketBook;
import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.Order;
import com.betfair.entities.PlaceInstruction;
import com.betfair.entities.Runner;
import com.betfair.entities.RunnerCatalogue;

public class Persister {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public Persister(){
	    emf = Persistence.createEntityManagerFactory("CatchTheMonkey");
		em = emf.createEntityManager();
	}
	
	public void persistMarketBook(MarketBook mktBook){
		em.getTransaction().begin();
		em.persist(mktBook);
		em.getTransaction().commit();
	    System.out.println("Market Book saved!!!");
	}
	
	public void persistMarketCatalogue(MarketCatalogue mk){
		em.getTransaction().begin();
		em.persist(mk);
		em.getTransaction().commit();
	    System.out.println("Market Catalogue saved!!!");
	}
	
	public void persistRunner(Runner runner){
		em.getTransaction().begin();
		em.persist(runner);
		em.getTransaction().commit();
	    System.out.println("Runner saved!!!");
	}
	
	public void persistRunnerCatalogue(RunnerCatalogue rc){
		em.getTransaction().begin();
		em.persist(rc);
		em.getTransaction().commit();
	    System.out.println("Runner Catalogue saved!!!");
	}
	
	public void persistOrders(List<PlaceInstruction> instructions, List<Double> prices, List<Double> sizes){
		Order order = new Order();
		int index = 0;
		em.getTransaction().begin();
		for(PlaceInstruction instruction: instructions){
			order.setOrderType(instruction.getOrderType().toString());
			order.setPrice(prices.get(0));
			order.setSide("BACK");
			order.setSize(sizes.get(index));
			index++;
			em.persist(order);
			em.getTransaction().commit();
			System.out.println("Order saved!!!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MarketCatalogue> getAllMarkets() {
		em.getTransaction().begin();
		List<MarketCatalogue> list = this.em.createNamedQuery("Market.findAll").getResultList();
		em.getTransaction().commit();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<RunnerCatalogue> getAllRunners() {
		em.getTransaction().begin();
		List<RunnerCatalogue> list = this.em.createNamedQuery("Runners.findAll").getResultList();
		em.getTransaction().commit();
		return list;
	}
	
	public void closeResources(){
		em.close();
		emf.close();
	}

}
