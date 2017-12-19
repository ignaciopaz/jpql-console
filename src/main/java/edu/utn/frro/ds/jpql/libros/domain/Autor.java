package edu.utn.frro.ds.jpql.libros.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;
@Data @ToString(includeFieldNames=true, exclude="libros")
@Entity
public class Autor {
	@Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;
    
    public Autor() {}
    public Autor(String nombre, String apellido) {
		this.apellido=apellido;
		this.nombre=nombre;
		libros = new ArrayList<Libro>();
	}
}
