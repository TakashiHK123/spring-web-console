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

import com.bolsadeideas.springboot.web.app.entities.CursoHabilitados;
import com.bolsadeideas.springboot.web.utils.ConnectionManager;

public class CursoHabilitadosManager {

	private static final String SQL_INSERT = "INSERT INTO cursohabilitado (idcursohabilitado, id_curso, id_materia, id_profesor) VALUES (?, ?, ?, ?)";
    private static final String SQL = "SELECT * FROM cursohabilitado";
    private static final String SQL_DELETE = "DELETE FROM cursohabilitado WHERE idcursohabilitado=?";
    private static final String SQL_MODIFY = "UPDATE cursohabilitado SET id_curso=?, id_materia=?, id_profesor=? WHERE idcursohabilitado=?";
    
    
    public List<CursoHabilitados> getAllcursoHabilitado() {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            List<CursoHabilitados> listaCursos = new ArrayList();
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                CursoHabilitados cursohabilitados = new CursoHabilitados();
                cursohabilitados.setIdCursoHabilitado(resultSet.getInt("idcursohabilitado"));
                cursohabilitados.setIdCurso(resultSet.getInt("id_curso"));
                cursohabilitados.setIdMateria(resultSet.getInt("id_materia"));
                cursohabilitados.setIdProfesor(resultSet.getInt("id_materia")); 
                listaCursos.add(cursohabilitados);
            }
            resultSet.close();
            return listaCursos;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        return Collections.EMPTY_LIST; 
    }
    
    public void add(int idcurso, int idmateria, int idprofesor) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_INSERT)) {
        	CursoHabilitadosManager cursohabilitados = new CursoHabilitadosManager(); 
        	preparestatement.setInt(1, cursohabilitados.generarCodigo());
            preparestatement.setInt(2, idcurso);
            preparestatement.setInt(3, idmateria);
            preparestatement.setInt(4, idprofesor);
            
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
    
    public void modify(int idCursoHabilitado, int idcurso, int idmateria, int idprofesor){
        try(Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_MODIFY)){
            
            preparestatement.setInt(1, idprofesor);
            preparestatement.setInt(2, idcurso);
            preparestatement.setInt(3, idmateria);
            preparestatement.setInt(4, idCursoHabilitado);
            
            preparestatement.executeUpdate(); 
            
            
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
    
    public CursoHabilitados getByid(int idCursohabilitado) {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                              
                if (resultSet.getInt("idcursohabilitado")==idCursohabilitado){
                    CursoHabilitados cursohabilitados = new CursoHabilitados();
                    cursohabilitados.setIdCursoHabilitado(resultSet.getInt("idcursohabilitado")); 
                    cursohabilitados.setIdCurso(resultSet.getInt("id_curso"));
                    cursohabilitados.setIdMateria(resultSet.getInt("id_materia"));
                    cursohabilitados.setIdProfesor(resultSet.getInt("id_profesor"));
                    resultSet.close(); 
                    return cursohabilitados; 
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
