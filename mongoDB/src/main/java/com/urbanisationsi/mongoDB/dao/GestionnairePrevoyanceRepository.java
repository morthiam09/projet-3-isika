package com.urbanisationsi.mongoDB.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.urbanisationsi.mongoDB.modele.GestionnairePrevoyance;

public interface GestionnairePrevoyanceRepository extends MongoRepository<GestionnairePrevoyance, String> {

     List<GestionnairePrevoyance> findByMail(String mail);
}
