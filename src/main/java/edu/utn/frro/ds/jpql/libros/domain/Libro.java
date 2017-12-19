package edu.utn.frro.ds.jpql.libros.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;
@Data @ToString(includeFieldNames=true)
@Entity
public class Libro {
	

	@Id @GeneratedValue
	private Integer id;
	private String titulo;
    private String isbn;
 
    @ManyToOne
    private Editorial editorial;
    
    @ManyToMany @JoinTable(name="libro_autor")
    private List<Autor> autores;
	private Double precio;
    
	public Libro() {}
	public Libro(String isbn, String titulo, Double precio, Editorial editorial) {
		this.isbn=isbn;
		this.titulo=titulo;
		this.precio=precio;
		this.editorial=editorial;
		this.autores= new ArrayList<Autor>();
	}
    public void agregarAutor(Autor autor) {
    	autores.add(autor);
    }
 
   
}