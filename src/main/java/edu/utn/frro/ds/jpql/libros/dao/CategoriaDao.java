package edu.utn.frro.ds.jpql.libros.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utn.frro.ds.jpql.libros.domain.Autor;
import edu.utn.frro.ds.jpql.libros.domain.Categoria;
@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Integer> {

}
