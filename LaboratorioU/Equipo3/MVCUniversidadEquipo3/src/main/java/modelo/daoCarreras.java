/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsCarreras;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCarreras {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera, estatus_carrera FROM carreras";
    private static final String SQL_INSERT = "INSERT INTO carreras(codigo_carrera, nombre_carrera, estatus_carrera) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre_carrera=?, estatus_carrera=? WHERE codigo_carrera = ?";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE codigo_carrera=?";
    private static final String SQL_SELECT_NOMBRE = "codigo_carrera, nombre_carrera, estatus_carrera FROM carreras WHERE nombre_carrera = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_carrera, nombre_carrera, estatus_carrera FROM carreras WHERE codigo_carrera = ?";    

    public List<clsCarreras> consultaCarreras() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCarreras> carreras = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String estatus = rs.getString("estatus_carrera");
                clsCarreras carrera = new clsCarreras();
                carrera.setCodigoCarrera(codigo);
                carrera.setNombreCarrera(nombre);
                carrera.setEstatusCarrera(estatus);
                carreras.add(carrera);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return carreras;
    }

    public int ingresaCarreras(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, carrera.getCodigoCarrera());
            stmt.setString(2, carrera.getNombreCarrera());
            stmt.setString(3, carrera.getEstatusCarrera());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaCarreras(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, carrera.getNombreCarrera());
            stmt.setString(2, carrera.getEstatusCarrera());
            stmt.setString(3, carrera.getCodigoCarrera());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarCarreras(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, carrera.getCodigoCarrera());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsCarreras consultaCarrerasPorNombre(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + carrera);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, carrera.getNombreCarrera());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String estatus = rs.getString("estatus_carrera");

                //usuario = new clsUsuario();
                carrera.setCodigoCarrera(id);
                carrera.setNombreCarrera(nombre);
                carrera.setEstatusCarrera(estatus);
                System.out.println(" registro consultado: " + carrera);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return carrera;
    }
    public clsCarreras consultaCarrerasPorId(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + carrera);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, carrera.getCodigoCarrera());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String estatus = rs.getString("estatus_carrera");

                //usuario = new clsUsuario();
                carrera.setCodigoCarrera(id);
                carrera.setNombreCarrera(nombre);
                carrera.setEstatusCarrera(estatus);
                System.out.println(" registro consultado: " + carrera);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return carrera;
    }    
}
