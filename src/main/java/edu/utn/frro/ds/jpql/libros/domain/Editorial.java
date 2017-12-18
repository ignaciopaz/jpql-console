package edu.utn.frro.ds.jpql.libros.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;
@Data @ToString(includeFieldNames=true)
@Entity
public class Editorial {
	public Editorial() {}
    public Editorial(String nombre) {
		this.nombre=nombre;
	}

	@Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String direccion;
 
}