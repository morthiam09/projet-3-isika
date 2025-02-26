package com.urbanisationsi.mongodb.coursmongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.urbanisationsi.mongodb.coursmongodb.modele.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}
