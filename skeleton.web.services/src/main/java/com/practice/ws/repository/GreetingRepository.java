package com.practice.ws.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.ws.model.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long > {

}
