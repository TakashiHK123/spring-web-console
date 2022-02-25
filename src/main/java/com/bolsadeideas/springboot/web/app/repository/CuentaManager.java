package com.bolsadeideas.springboot.web.app.repository;

import java.sql.Connection;
import java.util.Date;
import java.text.DateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.bolsadeideas.springboot.web.app.entities.Cuenta;
import com.bolsadeideas.springboot.web.utils.ConnectionManager;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class CuentaManager {
	
	private static final String SQL_INSERT = "INSERT INTO cuenta (idcuenta, saldo, fecha, hora, id_inscripcion) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL = "SELECT * FROM cuenta";
    private static final String SQL_DELETE = "DELETE FROM cuenta WHERE idcuenta=?";
    private static final String SQL_MODIFY = "UPDATE cuenta SET saldo=?, fecha=?, hora=? WHERE idcuenta=?";
    private static final int saldoC=120000; 
    public List<Cuenta> getAllCuenta() {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            List<Cuenta> listaCuenta = new ArrayList();
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setId_Cuenta(resultSet.getInt("idcuenta"));
                cuenta.setSaldo(resultSet.getInt("saldo"));
                cuenta.setFecha(resultSet.getDate("fecha"));
                cuenta.setHora(resultSet.getTime("hora"));
                cuenta.setId_Inscripcion(resultSet.getInt("id_inscripcion"));
                
                listaCuenta.add(cuenta);
            }
            resultSet.close();
            return listaCuenta;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        
        return Collections.EMPTY_LIST; 
    }

    public void generarCuenta() {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_INSERT)) {
        	
        	CuentaManager cuentaManager = new CuentaManager(); 
            preparestatement.setInt(1, cuentaManager.generarCodigo());
            preparestatement.setInt(2, saldoC);            
            preparestatement.setDate(3, cuentaManager.sacarFecha());
            preparestatement.setTime(4, hora);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }

    public void delete(int idcuenta) {

        try (Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_DELETE)) {

            preparestatement.setInt(1, idcuenta);

            preparestatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }

    }
    
    public void modify(int idCuenta, int saldo, Date fecha, Time hora){
        try(Connection conn = ConnectionManager.getConnection();
                PreparedStatement preparestatement = conn.prepareStatement(SQL_MODIFY)){
            
            preparestatement.setInt(1, saldo);
            preparestatement.setDate(2, fecha);
            preparestatement.setTime(3, hora);
            preparestatement.setInt(4, idCuenta); 
            
            preparestatement.executeUpdate(); 
            
            
        }catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    public Alumno getByid(int idAlumno) {

        try (Connection conn = ConnectionManager.getConnection();
                Statement statement = conn.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(SQL);
            
            while (resultSet.next()) {
                              
                if (resultSet.getInt("idalumno")==idAlumno){
                    Alumno student = new Alumno();
                    student.setIdAlumno(resultSet.getInt("idalumno"));
                    student.setNombre(resultSet.getString("nombre"));
                    student.setApellido(resultSet.getString("apellido"));
                    resultSet.close();
                    return student; 
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
    
    public Date sacarFecha() {
		Date date = new Date();
        long timeInMilliSeconds = date.getTime();
        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
    	return date1;  
    }

}
