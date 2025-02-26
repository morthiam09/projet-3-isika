package com.urbanisationsi.mongodb.coursmongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.urbanisationsi.mongodb.coursmongodb.modele.GestionnairePrevoyance;

public interface GestionnairePrevoyanceRepository extends MongoRepository<GestionnairePrevoyance, String> {

    List<GestionnairePrevoyance> findByMail(String mail);

}
