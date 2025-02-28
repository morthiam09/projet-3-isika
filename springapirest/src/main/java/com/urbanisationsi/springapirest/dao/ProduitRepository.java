package com.urbanisationsi.springapirest.dao;

import org.springframework.data.repository.CrudRepository;
import com.urbanisationsi.springapirest.modele.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

    
}
