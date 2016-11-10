package com.practice.ws.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.ws.model.Greeting;
import com.practice.ws.repository.GreetingRepository;

@Service
public class GreetingServiceBean implements GreetingService {

	/*
	//*Helper Methods---START
	private static Long nextId;
	//map-> to hold the objects of greeting objects.
	private static Map<BigInteger, Greeting> greetingMap;
	
	//saves-> saves greeting object into the map.
	private static Greeting save(Greeting greeting){
		if(greetingMap == null){
			greetingMap = new HashMap<BigInteger, Greeting>();
			nextId = BigInteger.ONE;
		}
		greeting.setId(nextId);
		nextId = nextId.add(BigInteger.ONE);
		greetingMap.put(greeting.getId(), greeting);
		return greeting;
	}
	
	//static code block to initialize map if greeting with 2 objects
	static {
		Greeting g1 = new Greeting();
		g1.setText("Hello World!");
		save(g1);
		
		Greeting g2 = new Greeting();
		g2.setText("Hola Mundo!");
		save(g2);
	}

	private static boolean remove(Long id){
		Greeting deletedGreeting = greetingMap.remove(id);
		if(deletedGreeting == null) {
			return false;
		}
		return true;
	}
	//*Helper Methods---END
	*/


	@Autowired
	private GreetingRepository greetingRepository;	
	
	@Override
	public Collection<Greeting> findAll() {
		Collection<Greeting> greetings = greetingRepository.findAll();
		return greetings;
	}

	@Override
	public Greeting findOne(Long id) {
		
		Greeting greeting = greetingRepository.findOne(id);
		return greeting;
	}

	@Override
	public Greeting create(Greeting greeting) {
		if(greeting.getId() != null ){
			return null;
		}
		Greeting savedGreeting = greetingRepository.save(greeting);
		System.out.println("GreetingServiceBean.java--create()");
		return savedGreeting;
	}

	@Override
	public Greeting update(Greeting greeting) {
		Greeting greetingPersisted = findOne(greeting.getId());
		if(greetingPersisted == null){
			return null;
		}
		Greeting updateGreeting = greetingRepository.save(greeting);
		System.out.println("GreetingServiceBean.java--update()");
		return updateGreeting;
	}

	@Override
	public void delete(Long id) {
		greetingRepository.delete(id);
	}

}
