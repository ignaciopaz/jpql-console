package edu.utn.frro.ds.jpql.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ignacio.paz
 */
@Controller
public class ControllerJpqlConsole {
	@Autowired private EntityManager em;
	
	@RequestMapping("/jpql/console")
	public String console(@RequestParam(value="jpql", required=false, defaultValue="") String jpql, Model model) {
		model.addAttribute("results", null);
		if (jpql != null && !jpql.isEmpty() && jpql.toUpperCase().startsWith("SELECT")) {
			try {
				List queryResults = em.createQuery(jpql).getResultList();
				List<String> headers = new ArrayList<String>();
				List results = new ArrayList();
				extractFields(queryResults, headers, results);
				model.addAttribute("headers", headers);
				model.addAttribute("results", results);
				model.addAttribute("queryResults", queryResults);
			} catch (Exception e) {
				model.addAttribute("exception", e);
				System.out.println("aaaaa"+e.getLocalizedMessage());
				
			}
		}
		model.addAttribute("jpql", jpql);
		
		return "jpql/console";		
	}

	private void extractFields(List queryResults, List<String> headers, List results) throws IllegalAccessException {
		boolean headerRow = true;
		for(Object x : queryResults) {
		    Class<?> clazz = x.getClass();
		    List<String> values = new ArrayList<String>();
		    for (Field f : clazz.getDeclaredFields()) {
		    	f.setAccessible(true);
		    	String fieldValue = null;
		    	Object fieldValueObj = f.get(x);
		    	if (fieldValueObj != null) {
		    		fieldValue = fieldValueObj.toString();
		    	}
		    	if (headerRow) {
		    		headers.add(f.getName());
		    	}
		    	values.add(fieldValue);				    	
		    }
		    headerRow = false;
		    results.add(values);
		}
	}

}
