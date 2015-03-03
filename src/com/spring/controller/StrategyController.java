package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Account;
import com.spring.model.Strategy;
import com.spring.model.User;
import com.spring.service.AccountService;
import com.spring.service.StrategyService;
import com.spring.service.UserService;

@Controller
@SessionAttributes("strategy")
public class StrategyController {

	@Autowired
	private StrategyService strategyService;

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@RequestMapping(value="strategyChoice", method = RequestMethod.GET)
	public ModelAndView showStrategy(ModelMap model) {
		Strategy strategy = new Strategy();
		model.addAttribute("strategy", strategy);
		return new ModelAndView("strategyChoice");
	}

	@RequestMapping(value = "/strategy1", method = RequestMethod.POST)
	public ModelAndView chooseStrategy1(@ModelAttribute("strategy") Strategy strategy, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);
		Account acc = accountService.getAccount(user.getAccount().getId());
		Strategy strat = strategyService.getStrategy(1);
		acc.addStrategy(strat);
		strat.addAccount(acc);
		accountService.addStrategyToAccount(acc);
		strategyService.addAccountToStrategy(strat);
		modelAndView.addObject("strategy", strat);
		return new ModelAndView("redirect:/index.html");

	}

	@RequestMapping(value = "/strategy2", method = RequestMethod.POST)
	public ModelAndView chooseStrategy2(@ModelAttribute("strategy") Strategy strategy, BindingResult result) {
		User user = (User) RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);
		Account acc = accountService.getAccount(user.getAccount().getId());
		Strategy strat = strategyService.getStrategy(2);
		acc.addStrategy(strat);
		strat.addAccount(acc);
		accountService.addStrategyToAccount(acc);
		strategyService.addAccountToStrategy(strat);
		return new ModelAndView("redirect:/index.html");
	}

	@RequestMapping(value = "/strategy3", method = RequestMethod.POST)
	public ModelAndView chooseStrategy3(@ModelAttribute("strategy") Strategy strategy, BindingResult result) {
		User user = (User) RequestContextHolder.currentRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);
		Account acc = accountService.getAccount(user.getAccount().getId());
		Strategy strat = strategyService.getStrategy(3);
		acc.addStrategy(strat);
		strat.addAccount(acc);
		accountService.addStrategyToAccount(acc);
		strategyService.addAccountToStrategy(strat);
		return new ModelAndView("redirect:/index.html");
	}

}
