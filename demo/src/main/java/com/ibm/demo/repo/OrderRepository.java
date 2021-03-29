package com.ibm.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.demo.entity.Order;

public interface OrderRepository extends MongoRepository<Order, String> {//String represents the object id in mongodb

}
