package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.web.app.entities.Alumno;
import com.bolsadeideas.springboot.web.app.repository.StudentManager;

import org.springframework.ui.Model;

//@RestController
@RequestMapping("/api")
public class IndexController {
	
	//private static final String template = "Hello, %s!"; 
	//private final AtomicLong counter = new AtomicLong(); 
	
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;

	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping({ "/index", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@GetMapping("/alumnos")
	public String mostrarAlumnos(Model model) {

		StudentManager student = new StudentManager(); 
        List<Alumno> alumnos = student.getAllStudents();
		model.addAttribute("titulo", alumnos);
		
		return "listar"; 
	}
	
	

	@GetMapping("/listar")
	public String listar(Model model) {


		StudentManager student = new StudentManager(); 
        List<Alumno> alumnos = student.getAllStudents();
		
		model.addAttribute("titulo", textoListar);
		return "listar";
	}

	/*@ModelAttribute("alumnos")
	public List<Alumno> poblarUsuarios() {
		StudentManager student = new StudentManager(); 
        List<Alumno> allStudents = student.getAllStudents();	
		return allStudents;
	}*/
}