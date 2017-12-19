package edu.utn.frro.ds.jpql.libros.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;
@Data @ToString(includeFieldNames=true, exclude="libros")
@Entity
public class Editorial {
	@Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String direccion;
    @OneToMany(mappedBy="editorial")
    private List<Libro> libros;
    
    public Editorial() {}
    public Editorial(String nombre) {
		this.nombre=nombre;
		libros=new ArrayList<Libro>();
		
	}
 
}