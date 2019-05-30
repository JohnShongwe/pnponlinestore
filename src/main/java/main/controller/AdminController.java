package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.model.User;
import main.service.UserService;

@Controller //Marks the class as a controller
public class AdminController {

	
	//@Autowired  marks the field as Autowired, meaning you don't need the setter method
	
	@Autowired 
	private UserService userService; //(e.g private UserService userService = new UserServiceImpl())
	
//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of request is that
@RequestMapping(value="/Admin/products", method = RequestMethod.GET) 
public ModelAndView products(){
	ModelAndView modelAndView = new ModelAndView(); 
	Authentication auth = SecurityContextHolder.getContext().getAuthentication(); //Authentication verifies the identity of a user 
	User user = userService.findUserByEmail(auth.getName());
	modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
	modelAndView.setViewName("Admin/products");
	return modelAndView;
}





@RequestMapping(value="/Admin/ProductCategory", method = RequestMethod.GET)
public ModelAndView Category(){
	ModelAndView modelAndView = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
	modelAndView.setViewName("Admin/ProductCategory");
	return modelAndView;
}



@RequestMapping(value="/Admin/Driver", method = RequestMethod.GET)
public ModelAndView Driver(){
	ModelAndView modelAndView = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
	modelAndView.setViewName("Admin/Driver");
	return modelAndView;
}

@RequestMapping(value="/Driver/DriverInfo", method = RequestMethod.GET)
public ModelAndView driverINfo(){
	ModelAndView modelAndView = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
	modelAndView.setViewName("Driver/DriverInfo");
	return modelAndView;
}

@RequestMapping(value="/Driver/delivery", method = RequestMethod.GET)
public ModelAndView Delivery(){
	ModelAndView modelAndView = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
	modelAndView.setViewName("Driver/delivery");
	return modelAndView;
}

@RequestMapping(value="/Admin/RequestProducts", method = RequestMethod.GET)
public ModelAndView RequestProducts(){
	ModelAndView modelAndView = new ModelAndView();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	User user = userService.findUserByEmail(auth.getName());
	modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
	modelAndView.setViewName("Admin/RequestProducts");
	return modelAndView;
}


}



