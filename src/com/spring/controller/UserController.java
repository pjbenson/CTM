package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bean.AccountBean;
import com.spring.bean.UserBean;
import com.spring.model.Account;
import com.spring.model.User;
import com.spring.service.UserService;

@SessionAttributes("user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("command") UserBean userBean, BindingResult result) {
		User user = prepareModel(userBean);
		userService.addUser(user);
		return new ModelAndView("redirect:/loginform.html");
	}
	
	@RequestMapping(value = "/updateBalance", method = RequestMethod.POST)
	public ModelAndView updateBalance(@ModelAttribute("command") UserBean userBean, BindingResult result, HttpSession sessionObj) {
		//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user = (User) sessionObj.getAttribute("user");
		User user1 = userService.getUser(user.getUserId());
		user1.getAccount().setBalance(100.0);

		//if (principal instanceof User) {
			//user1 = userService.getUser(((User) principal).getUserId());
			//user.getAccount().setBalance(amount);
		//}
		userService.updateBalance(user1);
		return new ModelAndView("redirect:/index.html");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showUpdateBalance() {
		return new ModelAndView("updateBalance");
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users",  prepareListofBean(userService.userList()));
		return new ModelAndView("userList", model);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("command")  UserBean userBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users",  prepareListofBean(userService.userList()));
		return new ModelAndView("register", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(@ModelAttribute("command")  UserBean userBean, BindingResult result) {
		userService.deleteUser(prepareModel(userBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", null);
		model.put("users",  prepareListofBean(userService.userList()));
		return new ModelAndView("index", model);
	}
	
	private Account prepareAccount(AccountBean accBean){
		Account acc = new Account();
		acc.setBalance(accBean.getBalance());
		return acc;
	}
	
	private User prepareModel(UserBean userBean){
		Account acc = new Account();
		acc.setBalance(0.0);
		User user = new User();
		user.setFirstName(userBean.getFirstName());
		user.setLastName(userBean.getLastName());
		user.setUserAge(userBean.getAge());
		user.setUserPassword(userBean.getPassword());
		user.setUserId(userBean.getId());
		user.setUserEmail(userBean.getEmail());
		user.setAccount(acc);
		userBean.setId(null);
		return user;
	}
	
	private List<UserBean> prepareListofBean(List<User> users){
		List<UserBean> beans = null;
		if(users != null && !users.isEmpty()){
			beans = new ArrayList<UserBean>();
			UserBean bean = null;
			for(User user : users){
				bean = new UserBean();
				bean.setPassword(user.getUserPassword());
				bean.setId(user.getUserId());
				bean.setEmail(user.getUserEmail());
				bean.setAge(user.getUserAge());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private UserBean prepareUserBean(User user){
		UserBean bean = new UserBean();
		bean.setId(user.getUserId());
		bean.setPassword(user.getUserPassword());
		bean.setAge(user.getUserAge());
		bean.setEmail(user.getUserEmail());
		
		return bean;
	}
}
