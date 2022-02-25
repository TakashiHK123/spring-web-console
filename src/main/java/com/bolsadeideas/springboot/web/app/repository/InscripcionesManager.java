package com.bolsadeideas.springboot.web.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.bolsadeideas.springboot.web.app.entities.Inscripciones;
import com.bolsadeideas.springboot.web.utils.ConnectionManager;

public class InscripcionesManager {

	private static final String SQL_INSERT = "INSERT INTO inscripciones (idinscripcion, id_cursohabilitado, id_alumno) VALUES (?, ?, ?)";
    private static final String SQL = "SELECT * FROM inscripciones";
    private static final String SQL_DELETE = "DELETE FROM inscripciones WHERE idinscripcion=?";
    private static final String SQL_MODIFY = "UPDATE inscripciones SET id_cursohabilitado=?, id_alumno=? WHERE idinscripcion=?";
    
    
    public List<Inscripciones> getAllinscripciones() {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            List<Inscripciones> inscriptos = new ArrayList();
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                Inscripciones inscripcion = new Inscripciones();
                inscripcion.setIdInscripciones(resultSet.getInt("idinscripcion"));
                inscripcion.setIdCursoHabilitado(resultSet.getInt("id_cursohabilitado"));
                inscripcion.setIdAlumno(resultSet.getInt("id_alumno"));
                inscriptos.add(inscripcion);
            }
            resultSet.close();
            return inscriptos;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        return Collections.EMPTY_LIST; 
    }
    
    public void add(int idcursohabilitado, int idalumno) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_INSERT)) {
        	InscripcionesManager inscripciones = new InscripcionesManager(); 
        	preparestatement.setInt(1, inscripciones.generarCodigo());
            preparestatement.setInt(2, idcursohabilitado);
            preparestatement.setInt(3, idalumno);
           
            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void delete(int idinscripcion) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_DELETE)) {

            preparestatement.setInt(1, idinscripcion);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void modify(int idinscripcion, int idcursohabilitado, int idalumno){
        try(Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_MODIFY)){
            
            preparestatement.setInt(1, idalumno);
            preparestatement.setInt(2, idcursohabilitado);
            preparestatement.setInt(3, idinscripcion);
            
            preparestatement.executeUpdate(); 
            
            
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
    
    public Inscripciones getByid(int idinscripcion) {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                              
                if (resultSet.getInt("idinscripcion")==idinscripcion){
                    Inscripciones inscripcion = new Inscripciones();
                    inscripcion.setIdInscripciones(resultSet.getInt("idinscripcion"));
                    inscripcion.setIdCursoHabilitado(resultSet.getInt("id_cursohabilitado"));
                    inscripcion.setIdAlumno(resultSet.getInt("id_alumno"));
                    
                    resultSet.close(); 
                    return inscripcion; 
                }
           
            }
            

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null; 
    }
    
    public int generarCodigo(){
        UUID uuid = UUID.randomUUID();
        int codigo = uuid.hashCode();
        return codigo; 
    }
}
