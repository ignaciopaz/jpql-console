package edu.utn.frro.ds.jpql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import edu.utn.frro.ds.jpql.libros.dao.AutorDao;
import edu.utn.frro.ds.jpql.libros.dao.CategoriaDao;
import edu.utn.frro.ds.jpql.libros.dao.EditorialDao;
import edu.utn.frro.ds.jpql.libros.dao.LibroDao;
import edu.utn.frro.ds.jpql.libros.domain.Autor;
import edu.utn.frro.ds.jpql.libros.domain.Categoria;
import edu.utn.frro.ds.jpql.libros.domain.Editorial;
import edu.utn.frro.ds.jpql.libros.domain.Libro;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired private LibroDao libroDao;
	@Autowired private EditorialDao editorialDao;
	@Autowired private AutorDao autorDao;
	@Autowired private CategoriaDao categoriaDao;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
	public CommandLineRunner cargarDatos() { 
		return (args) -> {
			Autor martin = new Autor("Martin", "Fowler", "Martin Fowler (Walsall, 1963) es un ingeniero de software británico, autor y orador internacional sobre desarrollo de software, especializado en análisis y diseño orientado a objetos, UML, patrones de diseño, y metodologías de desarrollo ágil, incluyendo programación extrema.");
			Autor kentBeck = new Autor("Kent", "Beck", "Kent Beck (n. 1961) es ingeniero de software estadounidense, uno de los creadores de las metodologías de desarrollo de software de programación extrema (eXtreme Programming o XP) y el desarrollo guiado por pruebas (Test-Driven Development o TDD), también llamados metodología ágil. Beck fue uno de los 17 firmantes originales del Manifiesto Ágil en 2001.");
			Autor bob = new Autor("Robert C", "Martin", "Robert Cecil Martin (n. 1952) Robert Cecil Martin (coloquialmente conocido como Uncle Bob) es un ingeniero de software y autor estadounidense. Es coautor del Manifiesto Ágil. Ahora dirige una empresa de consultoría llamada Uncle Bob Consulting LLC y Clean Coders, que aloja videos basados en sus experiencias y libros.");
			Autor tolkien = new Autor("J. R. R.", "Tolkien", "J. R. R. Tolkien o JRRT, fue un escritor, poeta, filólogo, lingüista y profesor universitario británico, conocido principalmente por ser el autor de las novelas clásicas de fantasía heroica El hobbit y El Señor de los Anillos.");
			Editorial addisonWesley = new Editorial("Addison Wesley");
			Editorial prenticeHall = new Editorial("Prentice Hall");
			Editorial pearson = new Editorial("Pearson");
			Editorial booklet = new Editorial("Booklet");
			Editorial minotauro = new Editorial("Minotauro");
			
			Categoria computer = new Categoria("Computers Science");
			Categoria professionals = new Categoria("Professionals", computer);
			Categoria designPatterns = new Categoria("Design Patterns", computer);
			Categoria design = new Categoria("Software Design & Development", computer);
			Categoria architecture = new Categoria("Software Architecture", computer);
			Categoria agileDev = new Categoria("Agile Development", computer);
			
			Categoria fiction = new Categoria("Fiction");
			Categoria fantasy = new Categoria("Fantasy", fiction);
			Categoria epic = new Categoria("Epic", fiction);
			
			categoriaDao.save(computer);
			categoriaDao.save(professionals);
			categoriaDao.save(designPatterns);
			categoriaDao.save(design);
			categoriaDao.save(architecture);
			categoriaDao.save(agileDev);
			categoriaDao.save(fiction);
			categoriaDao.save(fantasy);
			categoriaDao.save(epic);			
			
			autorDao.save(martin);
			autorDao.save(kentBeck);
			autorDao.save(bob);
			autorDao.save(tolkien);
			editorialDao.save(addisonWesley);
			editorialDao.save(prenticeHall);
			editorialDao.save(pearson);
			editorialDao.save(booklet);
			editorialDao.save(minotauro);
			
			Libro refactoring = new Libro("978-0201485677" , "Refactoring: Improving the Design of Existing Code", 20.0, addisonWesley, professionals, design, designPatterns);
			Libro eaaPatterns = new Libro("978-0321127426", "Patterns of Enterprise Application Architecture", 12.0, addisonWesley, designPatterns, architecture);
			Libro tdd = new Libro("978-0321146533", "Test Driven Development: By Example", 12.0, addisonWesley, professionals, design);
			Libro agile1 = new Libro("978-0135974445", "Agile Software Development, Principles, Patterns, and Practices", 15.0, pearson, professionals, agileDev, design);
			Libro cleanCode = new Libro("978-0132350884", "Clean Code: A Handbook of Agile Software Craftsmanship", 25.0, prenticeHall, professionals, agileDev, design);
			Libro cleanArch = new Libro("978-0132350884", "Clean Architecture: A Craftsman's Guide to Software Structure and Design", 22.0, prenticeHall, architecture);			
			Libro comunidad = new Libro("978-8445000663", "1: El Señor de los Anillos I. La Comunidad del Anillo", 40.0, booklet, fantasy, epic);
			Libro torres = new Libro("978-6070712739", "2: El Senor de los Anillos: Las dos Torres ", 41.0, minotauro, fantasy, epic);
			Libro rey = new Libro("978-6070712746", "3: El Senor de los Anillos: El Retorno del Rey", 45.0, booklet, fantasy, epic);
			
			refactoring.agregarAutor(martin);
			refactoring.agregarAutor(kentBeck);
			eaaPatterns.agregarAutor(martin);
			
			tdd.agregarAutor(kentBeck);
			agile1.agregarAutor(bob);
			cleanCode.agregarAutor(bob);
			cleanArch.agregarAutor(bob);
			
			comunidad.agregarAutor(tolkien);
			torres.agregarAutor(tolkien);
			rey.agregarAutor(tolkien);
			
			libroDao.save(refactoring);
			libroDao.save(eaaPatterns);
			libroDao.save(agile1);
			libroDao.save(cleanCode);
			libroDao.save(cleanArch);
			libroDao.save(tdd);
			libroDao.save(comunidad);
			libroDao.save(torres);
			libroDao.save(rey);
			
		};
	}

}