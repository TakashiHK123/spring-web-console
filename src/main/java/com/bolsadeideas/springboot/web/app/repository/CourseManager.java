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

import com.bolsadeideas.springboot.web.app.entities.Curso;
import com.bolsadeideas.springboot.web.utils.ConnectionManager;


public class CourseManager {
	
	private static final String SQL_INSERT = "INSERT INTO curso (idcurso, descripcion) VALUES (?, ?)";
    private static final String SQL = "SELECT * FROM curso";
    private static final String SQL_DELETE = "DELETE FROM curso WHERE idcurso=?";
    private static final String SQL_MODIFY = "UPDATE curso SET descripcion=? WHERE idcurso=?";
    
    
    public List<Curso> getAllCurso() {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            List<Curso> listaCursos = new ArrayList();
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(resultSet.getInt("idcurso"));
                curso.setDescripcion(resultSet.getString("descripcion"));
                
                listaCursos.add(curso);
            }
            resultSet.close();
            return listaCursos;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        return Collections.EMPTY_LIST; 
    }
    
    public void add(String descripcion) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_INSERT)) {
        	CourseManager courseC = new CourseManager(); 
            preparestatement.setInt(1, courseC.generarCodigo());
            preparestatement.setString(2, descripcion);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void delete(int idCurso) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_DELETE)) {

            preparestatement.setInt(1, idCurso);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void modify(int idCurso, String descripcion){
        try(Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_MODIFY)){
            
            preparestatement.setString(1, descripcion);
            preparestatement.setInt(2, idCurso); 
            
            preparestatement.executeUpdate(); 
            
            
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
    
    public Curso getByid(int idCurso) {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                              
                if (resultSet.getInt("idcurso")==idCurso){
                    Curso curso = new Curso();
                    curso.setIdCurso(resultSet.getInt("idcurso"));
                    curso.setDescripcion(resultSet.getString("descripcion"));
                    resultSet.close();
                    return curso; 
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
