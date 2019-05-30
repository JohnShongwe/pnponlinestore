package main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.model.User;
import main.service.UserService;

@Controller  //Marks the class as a controller
public class LoginController {
	
	
	//@Autowired  marks the field as Autowired, meaning you don't need the setter method
	@Autowired
	private UserService userService; //(e.g private UserService userService = new UserServiceImpl())

	//@RequestMapping maps the URL with the method underneath it, and Request Method specifies what type of method it is.
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		
		//registerAdmin
		
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/Admin/registerAdmin", method = RequestMethod.GET)
	public ModelAndView registerAdmin(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("Admin/registerAdmin");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/Admin/registerAdmin", method = RequestMethod.POST)
	public ModelAndView createNewAdmin(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("Admin/registerAdmin");
		} else {
			userService.saveAdmin(user);
			modelAndView.addObject("successMessage", "Admin has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("Admin/registerAdmin");
			
		}
	
		return modelAndView;
	}
	
	
	//Register Driver
	@RequestMapping(value="/Admin/registerDriver", method = RequestMethod.GET)
	public ModelAndView driverRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("Admin/DriverRegistration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/Admin/registerDriver", method = RequestMethod.POST)
	public ModelAndView createNewDriver(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("Admin/DriverRegistration");
		} else {
			userService.saveDriver(user);
			modelAndView.addObject("successMessage", "Driver has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("Admin/DriverRegistration");
			
		}
	
		return modelAndView;
	}
	
	//Register Supplier
	@RequestMapping(value="/Admin/registerSupplier", method = RequestMethod.GET)
	public ModelAndView supplierRegistration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("Admin/SupplierRegistration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/Admin/registerSupplier", method = RequestMethod.POST)
	public ModelAndView createNewSupplier(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("Admin/SupplierRegistration");
		} else {
			userService.saveSupplier(user);
			modelAndView.addObject("successMessage", "Supplier has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("Admin/SupplierRegistration");
			
		}
		
	
		
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/customer/home", method = RequestMethod.GET)
	public ModelAndView Customerhome(){  //Authentication verifies the identity of a user 
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
		modelAndView.setViewName("customer/home");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/Admin/home", method = RequestMethod.GET)
	public ModelAndView Adminhome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
		modelAndView.setViewName("Admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value="/Driver/home", method = RequestMethod.GET)
	public ModelAndView Driverhome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
		modelAndView.setViewName("Driver/home");
		return modelAndView;
	}
	
	@RequestMapping(value="/Supplier/home", method = RequestMethod.GET)
	public ModelAndView SupplierHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
		modelAndView.setViewName("Supplier/home");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/Supplier/requestedProduts", method = RequestMethod.GET)
	public ModelAndView requestedProduts(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Hello! " + user.getLastName() + " " + user.getName());
		modelAndView.setViewName("Supplier/RequestedProducts");
		return modelAndView;
	}


	@RequestMapping(value="/home")
	 protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
	        // Get the role of logged in user
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String role = auth.getAuthorities().toString();

	        String targetUrl = "";
	        if(role.contains("customer")) {
	            targetUrl = "redirect:/customer/home";
	        } else if(role.contains("Admin")) {
	            targetUrl = "redirect:/Admin/home";
	        }
	        else if(role.contains("Driver")) {
         targetUrl = "redirect:/Driver/home";
     }
	        
	        else if(role.contains("Supplier")) {
	            targetUrl = "redirect:/Supplier/home";
	        }
	        return targetUrl;
	    }
	
	


}
