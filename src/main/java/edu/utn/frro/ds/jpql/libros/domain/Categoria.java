package edu.utn.frro.ds.jpql.libros.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;
@ToString(includeFieldNames=true, exclude="libros")
@Entity
public class Categoria {
	@Id @GeneratedValue
    private Integer id;
    private String descripcion;

    @ManyToMany(mappedBy="categorias")
    private List<Libro> libros;
    
    @ManyToOne
	private Categoria parentCategoria;
    
    public Categoria() {}
    public Categoria(String descripcion) {
		this.descripcion=descripcion;
		libros = new ArrayList<Libro>();
	}
	public Categoria(String string, Categoria parentCategoria) {
		this.parentCategoria=parentCategoria;
	}
}
