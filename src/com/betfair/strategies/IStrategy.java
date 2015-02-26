package com.betfair.strategies;

import java.text.ParseException;

import com.betfair.exceptions.APINGException;

public interface IStrategy {
	public void execute() throws ParseException, APINGException;
}
