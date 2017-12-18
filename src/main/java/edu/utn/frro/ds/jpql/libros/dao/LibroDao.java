package edu.utn.frro.ds.jpql.libros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utn.frro.ds.jpql.libros.domain.Libro;

@Repository
public interface LibroDao extends JpaRepository<Libro, Integer> {

}
