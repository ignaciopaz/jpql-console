package edu.utn.frro.ds.jpql.libros.domain;

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
	public Autor() {}
    public Autor(String nombre, String apellido) {
		this.apellido=apellido;
		this.nombre=nombre;
	}

	@Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellido;

    @ManyToMany @JoinTable(name="autores_libros")
    private List<Libro> libros;
}
