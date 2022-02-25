package com.bolsadeideas.springboot.web.app.implement;

import java.util.List;
import java.util.Scanner;

import com.bolsadeideas.springboot.web.app.entities.Alumno;
import com.bolsadeideas.springboot.web.app.entities.Curso;
import com.bolsadeideas.springboot.web.app.entities.CursoHabilitados;
import com.bolsadeideas.springboot.web.app.entities.Inscripciones;
import com.bolsadeideas.springboot.web.app.entities.Materia;
import com.bolsadeideas.springboot.web.app.entities.Profesor;
import com.bolsadeideas.springboot.web.app.repository.CourseManager;
import com.bolsadeideas.springboot.web.app.repository.CursoHabilitadosManager;
import com.bolsadeideas.springboot.web.app.repository.InscripcionesManager;
import com.bolsadeideas.springboot.web.app.repository.MateriaManager;
import com.bolsadeideas.springboot.web.app.repository.ProfessorManager;
import com.bolsadeideas.springboot.web.app.repository.StudentManager;

public class Service {

	public void seleccionClase(String OpcionClase, String OpcionMetodo) {
		Service service = new Service();
		switch (OpcionClase) {
		case "1":
			service.seleccionMetodoAlumno(OpcionMetodo);
			break;
		case "2":
			service.seleccionMetodoCurso(OpcionMetodo);
			break;
		case "3":
			service.seleccionMetodoMateria(OpcionMetodo);
			break;
		case "4":
			service.seleccionMetodoProfesor(OpcionMetodo);
			break;
		case "5":
			service.seleccionMetodoInscripcion(OpcionMetodo);
			break;
		case "6":
			service.seleccionMetodoCursoHabilitado(OpcionMetodo);
			break;
		}
	}

	public void seleccionMetodoAlumno(String OpcionMetodo) {
		StudentManager studentManager = new StudentManager();
		Scanner lectura2 = new Scanner(System.in);
		switch (OpcionMetodo) {
		case "1": // all listar Alumno
			List<Alumno> allStudents = studentManager.getAllStudents();
			System.out.println(allStudents.toString());
			break;

		case "2": // Add Alumno
			System.out.println("Ingrese el:\nNombre: \n");
			String nombreA = lectura2.next();
			System.out.println("Apellido: \n");
			String apellidoA = lectura2.next();
			studentManager.add(nombreA, apellidoA);
			break;
		case "3": // Eliminar Alumno
			System.out.println("Ingrese el ID a eliminar: \n");
			int idEliminar = lectura2.nextInt();
			studentManager.delete(idEliminar);
			break;
		case "4":
			System.out.println("Ingrese el ID a modificar: \n");
			int idModify = lectura2.nextInt();
			System.out.println("Nombre: \n");
			String nombreA4 = lectura2.next();
			System.out.println("Apellido: \n");
			String apellidoA4 = lectura2.next();
			studentManager.modify(idModify, nombreA4, apellidoA4);
			break;
		case "5":
			System.out.println("Ingrese el ID a buscar: \n");
			int idbuscar = lectura2.nextInt();
			Alumno alu = new Alumno();
			alu = studentManager.getByid(idbuscar);
			System.out.println(alu.toString());
			break;
		}
	}

	public void seleccionMetodoProfesor(String OpcionMetodo) {
		ProfessorManager professorManager = new ProfessorManager();
		Scanner lectura2 = new Scanner(System.in);
		switch (OpcionMetodo) {
		case "1": // all lista Professor
			List<Profesor> allProfessor = professorManager.getAllProfessor();
			System.out.println(allProfessor.toString());
			break;

		case "2": // Add Professor
			System.out.println("Ingrese el:\nNombre: \n");
			String nombreA = lectura2.next();
			System.out.println("Apellido: \n");
			String apellidoA = lectura2.next();
			professorManager.add(nombreA, apellidoA);
			break;
		case "3": // Eliminar Profesor
			System.out.println("Ingrese el ID a eliminar: \n");
			int idEliminar = lectura2.nextInt();
			professorManager.delete(idEliminar);
			break;
		case "4": // Modificar
			System.out.println("Ingrese el ID a modificar: \n");
			int idModify = lectura2.nextInt();
			System.out.println("Nombre: \n");
			String nombreA4 = lectura2.next();
			System.out.println("Apellido: \n");
			String apellidoA4 = lectura2.next();
			professorManager.modify(idModify, nombreA4, apellidoA4);
			break;
		case "5": // buscar
			System.out.println("Ingrese el ID a buscar: \n");
			int idbuscar = lectura2.nextInt();
			Profesor profe = new Profesor();
			profe = professorManager.getByid(idbuscar);
			System.out.println(profe.toString());
			break;
		}
	}

	public void seleccionMetodoMateria(String OpcionMetodo) {
		MateriaManager materiaManager = new MateriaManager();
		Scanner lectura2 = new Scanner(System.in);
		switch (OpcionMetodo) {
		case "1": // all lista Materia
			List<Materia> allmateria = materiaManager.getAllMateria();
			System.out.println(allmateria.toString());
			break;

		case "2": // Add Materia
			System.out.println("Ingrese la descripcion de la materia: \n");
			String descricpcion = lectura2.next();
			materiaManager.add(OpcionMetodo);
			break;
		case "3": // Eliminar Materia
			System.out.println("Ingrese el ID a eliminar: \n");
			int idEliminar = lectura2.nextInt();
			materiaManager.delete(idEliminar);
			break;
		case "4": // Modificar
			System.out.println("Ingrese el ID a modificar: \n");
			int idModify = lectura2.nextInt();
			System.out.println("Descripcion: \n");
			String descripcion = lectura2.next();
			materiaManager.modify(idModify, descripcion);
			break;
		case "5": // Buscar
			System.out.println("Ingrese el ID a buscar: \n");
			int idbuscar = lectura2.nextInt();
			Materia materia = new Materia();
			materia = materiaManager.getByid(idbuscar);
			System.out.println(materia.toString());
			break;
		}
	}

	public void seleccionMetodoCurso(String OpcionMetodo) {
		CourseManager courseManager = new CourseManager();
		Scanner lectura2 = new Scanner(System.in);
		switch (OpcionMetodo) {
		case "1": // all lista Curso
			List<Curso> allcurso = courseManager.getAllCurso();
			System.out.println(allcurso.toString());
			break;

		case "2": // Add Curso
			System.out.println("Ingrese la descripcion de la curso: \n");
			String descricpcion = lectura2.next();
			courseManager.add(descricpcion);
			break;
		case "3": // Eliminar Curso
			System.out.println("Ingrese el ID a eliminar: \n");
			int idEliminar = lectura2.nextInt();
			courseManager.delete(idEliminar);
			break;
		case "4": // Modificar
			System.out.println("Ingrese el ID a modificar: \n");
			int idModify = lectura2.nextInt();
			System.out.println("Descripcion: \n");
			String descripcion = lectura2.next();
			courseManager.modify(idModify, descripcion);
			break;
		case "5": // Buscar
			System.out.println("Ingrese el ID a buscar: \n");
			int idbuscar = lectura2.nextInt();
			Curso curso = new Curso();
			curso = courseManager.getByid(idbuscar);
			System.out.println(curso.toString());
			break;
		}
	}

	public void seleccionMetodoCursoHabilitado(String OpcionMetodo) {
		CursoHabilitadosManager obj = new CursoHabilitadosManager();
		Scanner lectura2 = new Scanner(System.in);
		switch (OpcionMetodo) {
		case "1": // all lista Cursohabilitado
			List<CursoHabilitados> allcursohabilitado = obj.getAllcursoHabilitado();
			System.out.println(allcursohabilitado.toString());
			break;

		case "2": // Add Cursohabilitado
			System.out.println("Ingrese los id del curso :\n");
			int idcurso = lectura2.nextInt();
			System.out.println("id de la materia :\n");
			int idmateria = lectura2.nextInt();
			System.out.println("id del profesor :\n");
			int idprofesor = lectura2.nextInt();
			obj.add(idcurso, idmateria, idprofesor);
			break;
		case "3": // Eliminar CursoHabilitado
			System.out.println("Ingrese el ID a eliminar: \n");
			int idEliminar = lectura2.nextInt();
			obj.delete(idEliminar);
			break;
		case "4": // Modificar
			System.out.println("Ingrese el ID a modificar: \n");
			int idModify = lectura2.nextInt();
			System.out.println("ID curso: \n");
			int idcurso2 = lectura2.nextInt();
			System.out.println("ID materia: \n");
			int idmateria2 = lectura2.nextInt();
			System.out.println("ID profesor: \n");
			int idprofesor2 = lectura2.nextInt();
			obj.modify(idModify, idcurso2, idmateria2, idprofesor2);
			break;
		case "5": // Buscar
			System.out.println("Ingrese el ID a buscar del curso habilitado: \n");
			int idbuscar = lectura2.nextInt();
			CursoHabilitados cursohabilitado = new CursoHabilitados();
			cursohabilitado = obj.getByid(idbuscar);
			System.out.println(cursohabilitado.toString());
			break;
		}
	}

	public void seleccionMetodoInscripcion(String OpcionMetodo) {
		InscripcionesManager obj = new InscripcionesManager();
		Scanner lectura2 = new Scanner(System.in);
		switch (OpcionMetodo) {
		case "1": // all lista Inscripcion
			List<Inscripciones> allinscripciones = obj.getAllinscripciones();
			System.out.println(allinscripciones.toString());
			break;

		case "2": // Add Inscripcion
			System.out.println("Ingrese el id del cursohabilitado :\n");
			int idcursohabilitado = lectura2.nextInt();
			System.out.println("id de la alumno :\n");
			int idalumno = lectura2.nextInt();
			obj.add(idcursohabilitado, idalumno);
			break;
		case "3": // Eliminar Inscripcion
			System.out.println("Ingrese el ID a eliminar: \n");
			int idEliminar = lectura2.nextInt();
			obj.delete(idEliminar);
			break;
		case "4": // Modificar
			System.out.println("Ingrese el ID a modificar: \n");
			int idModify = lectura2.nextInt();
			System.out.println("ID cursohabilitado: \n");
			int idcurso2 = lectura2.nextInt();
			System.out.println("ID alumno: \n");
			int idmateria2 = lectura2.nextInt();
			obj.modify(idModify, idcurso2, idmateria2);
			break;
		case "5": // Buscar
			System.out.println("Ingrese el ID a buscar de la inscripcion: \n");
			int idbuscar = lectura2.nextInt();
			Inscripciones inscripcion = new Inscripciones();
			inscripcion = obj.getByid(idbuscar);
			System.out.println(inscripcion.toString());
			break;
		}
	}

	public static void main(String[] args) {
		Scanner lectura = new Scanner(System.in);
		int bucle = 1;
		while (0 != bucle) {
			System.out.println(
					"Ingrese la clase por teclado el numero correspondiente: \n1. Alumno\n2. Curso\n3. Materia\n4. Profesor\n5. Inscripcion\n6. CursosHabilitados");
			String opcionClase = lectura.next();
			System.out.println("A elegido la opcion: " + opcionClase
					+ "\nIngrese el metodo a utilizar: \n1. Ver lista\n2. Agregar\n3. Eliminar\n4. Modificar\n5. Buscar por id");
			String opcionmetodo = lectura.next();
			Service servicio = new Service();
			servicio.seleccionClase(opcionClase, opcionmetodo);
			System.out.println("Si desea terminar ingrese 0 y si desea continuar cualquier numero distinto de 0");
			bucle = lectura.nextInt();
			
		}

	}

}
