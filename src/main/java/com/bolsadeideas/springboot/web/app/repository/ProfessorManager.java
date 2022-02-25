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

import com.bolsadeideas.springboot.web.app.entities.Profesor;
import com.bolsadeideas.springboot.web.utils.ConnectionManager;


public class ProfessorManager {
	
	private static final String SQL_INSERT = "INSERT INTO profesor (idprofesor, nombre, apellido) VALUES (?, ?, ?)";
    private static final String SQL = "SELECT * FROM profesor";
    private static final String SQL_DELETE = "DELETE FROM profesor WHERE idprofesor=?";
    private static final String SQL_MODIFY = "UPDATE profesor SET nombre=?, SET apellido=? WHERE idprofesor=?";
    
    public List<Profesor> getAllProfessor() {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            List<Profesor> listaProfes = new ArrayList();
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                Profesor profe = new Profesor();
                profe.setIdProfe(resultSet.getInt("idprofesor"));
                profe.setNombre(resultSet.getString("nombre"));
                profe.setApellido(resultSet.getString("apellido"));
                listaProfes.add(profe);
            }
            resultSet.close();
            return listaProfes;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        return Collections.EMPTY_LIST; 
    }
    
    public void add(String nombre, String apellido) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_INSERT)) {
        	
        	ProfessorManager profesor = new ProfessorManager();
            preparestatement.setInt(1, profesor.generarCodigo());
            preparestatement.setString(2, nombre);
            preparestatement.setString(3, apellido);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void delete(int idProfe) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_DELETE)) {

            preparestatement.setInt(1, idProfe);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void modify(int idProfe, String nombre, String apellido){
        try(Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_MODIFY)){
            
            preparestatement.setString(1, nombre);
            preparestatement.setString(2, apellido);
            preparestatement.setInt(3, idProfe);
            
            preparestatement.executeUpdate(); 
            
            
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
    
    public Profesor getByid(int idProfe) {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                              
                if (resultSet.getInt("idprofe")==idProfe){
                	
                    Profesor profesor = new Profesor();
                    profesor.setIdProfe(resultSet.getInt("idprofe"));
                    profesor.setNombre(resultSet.getString("nombre"));
                    profesor.setNombre(resultSet.getString("apellido"));
                    
                    resultSet.close();
                    return profesor; 
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

