package com.betfair.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.betfair.entities.MarketCatalogue;
import com.betfair.entities.RunnerCatalogue;

public class Persister {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public Persister(){
	    emf = Persistence.createEntityManagerFactory("CatchTheMonkey");
		em = emf.createEntityManager();
	}
	
	public void persistMarketCatalogue(MarketCatalogue mk){
		em.getTransaction().begin();
		em.persist(mk);
		em.getTransaction().commit();
	    System.out.println("Market Catalogue saved!!!");
	}
	
	public void persistRunnerCatalogue(RunnerCatalogue rc){
		em.getTransaction().begin();
		em.persist(rc);
		em.getTransaction().commit();
	    System.out.println("Runner Catalogue saved!!!");
	}
	
	@SuppressWarnings("unchecked")
	public List<MarketCatalogue> getAllUsers() {
		em.getTransaction().begin();
		List<MarketCatalogue> list = this.em.createNamedQuery("Market.findAll").getResultList();
		em.getTransaction().commit();
		return list;
	}
	
	public void closeResources(){
		em.close();
		emf.close();
	}

}
