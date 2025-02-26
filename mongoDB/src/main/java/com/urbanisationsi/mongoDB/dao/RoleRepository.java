package com.urbanisationsi.mongoDB.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.urbanisationsi.mongoDB.modele.Role;

public interface RoleRepository extends MongoRepository<Role, String> { 
 
    Role findByRole(String role); 

}
