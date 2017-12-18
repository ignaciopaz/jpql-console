package edu.utn.frro.ds.jpql;

import java.util.Collection;

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
import edu.utn.frro.ds.jpql.libros.dao.EditorialDao;
import edu.utn.frro.ds.jpql.libros.dao.LibroDao;
import edu.utn.frro.ds.jpql.libros.domain.Autor;
import edu.utn.frro.ds.jpql.libros.domain.Editorial;
import edu.utn.frro.ds.jpql.libros.domain.Libro;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	@Autowired private LibroDao libroDao;
	@Autowired private EditorialDao editorialDao;
	@Autowired private AutorDao autorDao;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
	public CommandLineRunner cargarDatos() { 
		return (args) -> {
			Autor martin = new Autor("Martin", "Fowler");
			Autor kentBeck = new Autor("Kent", "Beck");
			Autor bob = new Autor("Robert", "Martin");
			Editorial addisonWesley = new Editorial("Addison Wesley");
			Editorial prenticeHall = new Editorial("Prentice Hall");
			
			Libro refactoring = new Libro("978-0201485677" , "Refactoring: Improving the Design of Existing Code", 20.0, addisonWesley, martin, kentBeck);
			Libro eaaPatterns = new Libro("978-0321127426", "Patterns of Enterprise Application Architecture", 12.0, addisonWesley, martin);
			Libro tdd = new Libro("978-0321146533", "Test Driven Development: By Example", 12.0, addisonWesley, kentBeck);
			Libro agile1 = new Libro("978-0135974445", "Agile Software Development, Principles, Patterns, and Practices", 15.0, prenticeHall, bob);
			Libro cleanCode = new Libro("978-0132350884", "Clean Code: A Handbook of Agile Software Craftsmanship", 25.0, prenticeHall, bob);
			Libro cleanArch = new Libro("978-0132350884", "Clean Architecture: A Craftsman's Guide to Software Structure and Design", 22.0, prenticeHall, bob);
			
			autorDao.save(martin);
			autorDao.save(kentBeck);
			autorDao.save(bob);
			editorialDao.save(addisonWesley);
			editorialDao.save(prenticeHall);
			
			libroDao.save(refactoring);
			libroDao.save(eaaPatterns);
			libroDao.save(agile1);
			libroDao.save(cleanCode);
			
			autorDao.flush();
			editorialDao.flush();
			
		};
	}

}