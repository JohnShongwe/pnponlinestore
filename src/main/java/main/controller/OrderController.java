



package main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.model.User;
import main.service.UserService;

@Controller //Marks the class as a controller
public class OrderController {
	
	

	//@Autowired  marks the field as Autowired, meaning you don't need the setter method
	@Autowired 
	private UserService userService; //(e.g private UserService userService = new UserServiceImpl())

	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(value="/customer/shop", method = RequestMethod.GET)
	public ModelAndView shop(){  //Authentication verifies the identity of a user 
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
		modelAndView.setViewName("customer/shop");
		return modelAndView;
		
	}
		@RequestMapping(value="/customer/browse", method = RequestMethod.GET)
		public ModelAndView browse(){
			ModelAndView modelAndView = new ModelAndView();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
			modelAndView.setViewName("customer/browse");
			return modelAndView;
	}
		
		
	
		@RequestMapping(value="/customer/basket", method = RequestMethod.GET)
		public ModelAndView ProductCategory(){
			ModelAndView modelAndView = new ModelAndView();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
			modelAndView.setViewName("customer/basket");
			return modelAndView;
	}
		
		@RequestMapping(value="/customer/checkout", method = RequestMethod.GET)
		public ModelAndView checkout(){
			ModelAndView modelAndView = new ModelAndView();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
			modelAndView.setViewName("customer/checkout");
			return modelAndView;
	}
	
		

		@RequestMapping(value="/customer/CustomerInfo", method = RequestMethod.GET)
		public ModelAndView CustomerInfo(){
			ModelAndView modelAndView = new ModelAndView();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findUserByEmail(auth.getName());
			modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
			modelAndView.setViewName("customer/CustomerInfo");
			return modelAndView;
	}
	

}
