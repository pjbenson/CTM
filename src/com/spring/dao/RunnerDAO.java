package com.spring.dao;

import java.util.List;

import com.betfair.entities.Runner;

public interface RunnerDAO {
	
	public Runner getRunner(Long selectionID);
	
	public List<Runner> getRunnersList();
}
