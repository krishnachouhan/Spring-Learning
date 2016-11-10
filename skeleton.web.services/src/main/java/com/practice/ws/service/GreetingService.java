package com.practice.ws.service;

import java.math.BigInteger;
import java.util.Collection;

import com.practice.ws.model.Greeting;

public interface GreetingService {
	
	Collection<Greeting> findAll();
	
	Greeting findOne(Long id);
	
	Greeting create(Greeting greeting);
	
	Greeting update(Greeting greeting);
	
	void delete(Long id);
}
