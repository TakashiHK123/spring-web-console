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

import com.bolsadeideas.springboot.web.app.entities.Materia;
import com.bolsadeideas.springboot.web.utils.ConnectionManager;




public class MateriaManager {

	private static final String SQL_INSERT = "INSERT INTO materia (idmateria, descripcion) VALUES (?, ?)";
    private static final String SQL = "SELECT * FROM materia";
    private static final String SQL_DELETE = "DELETE FROM materia WHERE idmateria=?";
    private static final String SQL_MODIFY = "UPDATE materia SET descripcion=? WHERE idmateria=?";
    
    
    public List<Materia> getAllMateria() {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            List<Materia> listaMaterias = new ArrayList();
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(resultSet.getInt("idmateria"));
                materia.setDescripcion(resultSet.getString("descripcion"));
                
                listaMaterias.add(materia);
            }
            resultSet.close();
            return listaMaterias;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        return Collections.EMPTY_LIST; 
    }
    
    public void add(String descripcion) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_INSERT)) {
        	MateriaManager materiaC = new MateriaManager(); 
            preparestatement.setInt(1, materiaC.generarCodigo());
            preparestatement.setString(2, descripcion);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void delete(int idMateria) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_DELETE)) {

            preparestatement.setInt(1, idMateria);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void modify(int idMateria, String descripcion){
        try(Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_MODIFY)){
            
            preparestatement.setString(1, descripcion);
            preparestatement.setInt(2, idMateria); 
            
            preparestatement.executeUpdate(); 
            
            
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
    
    public Materia getByid(int idMateria) {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                              
                if (resultSet.getInt("idmateria")==idMateria){
                    Materia materia = new Materia();
                    materia.setIdMateria(resultSet.getInt("idmateria"));
                    materia.setDescripcion(resultSet.getString("descripcion"));
                    resultSet.close();
                    return materia; 
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
