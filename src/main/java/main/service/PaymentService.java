package main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Payment;
import main.repository.CustomerInfoRepository;
import main.repository.PaymentRepository;


@Service //Marks the class as a Service
public class PaymentService {

	@Autowired //@Autowired  marks the field as Autowired, meaning you don't need the setter method
	private  PaymentRepository paymentRepository;  //(e.g CustomerInfoRepository customerInfoRepository = new CustomerInfoRepositoryImpl())
	 
	
//Process Payment
	public void ProcessPayment(Payment payment) {
		
		
		paymentRepository.save(payment);
		
	}

	
	
}
