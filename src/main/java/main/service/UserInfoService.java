package main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.model.User;
import main.model.orderCart;
import main.repository.UserInfoRepository;

@Service //Marks the class as a Service
public class UserInfoService {

	
	@Autowired  //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	private UserInfoRepository userInfoRepository;  //(e.g private  CustomerInfoRepository customerInfoRepository = new CustomerInfoRepositoryImpl())
	
	
	//Display User info of the logged in user
public ArrayList<User> viewUserInfo(String email)
	{
		return userInfoRepository.viewByUserId(email);
	}

	
}
