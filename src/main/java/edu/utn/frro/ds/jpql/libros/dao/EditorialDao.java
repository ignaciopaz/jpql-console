package edu.utn.frro.ds.jpql.libros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utn.frro.ds.jpql.libros.domain.Editorial;

@Repository
public interface EditorialDao extends JpaRepository<Editorial, Integer> {

}
