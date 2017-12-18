package edu.utn.frro.ds.jpql.libros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utn.frro.ds.jpql.libros.domain.Autor;
@Repository
public interface AutorDao extends JpaRepository<Autor, Integer> {

}
