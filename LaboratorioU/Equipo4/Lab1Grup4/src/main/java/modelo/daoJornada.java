/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsJornada;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoJornada {

    private static final String SQL_SELECT = "SELECT codigo_jornada, nombre_jornada, estatus_jornada FROM jornadas";
    private static final String SQL_INSERT = "INSERT INTO jornadas(nombre_jornada, estatus_jornada) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE jornadas SET nombre_jornada=?, estatus_jornada=? WHERE codigo_jornada = ?";
    private static final String SQL_DELETE = "DELETE FROM jornadas WHERE codigo_jornada=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_jornada, nombre_jornada, estatus_jornada FROM jornadas WHERE nombre_jornada = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_jornada, nombre_jornada, estatus_jornada FROM jornadas WHERE codigo_jornada = ?";    

    public List<clsJornada> consultaJornadas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsJornada> jornadas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoJor = rs.getInt("codigo_jornada");
                String nombreJor = rs.getString("nombre_jornada");
                String estatusJor = rs.getString("estatus_jornada");
                clsJornada jornada = new clsJornada();
                jornada.setCodigoJornada(codigoJor);
                jornada.setNombreJornada(nombreJor);
                jornada.setEstatusJornada(estatusJor);
                jornadas.add(jornada);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return jornadas;
    }

    public int ingresaJornadas(clsJornada jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, jornada.getNombreJornada());
            stmt.setString(2, jornada.getEstatusJornada());

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

    public int actualizaJornadas(clsJornada jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, jornada.getNombreJornada());
            stmt.setString(2, jornada.getEstatusJornada());
            stmt.setInt(3, jornada.getCodigoJornada());

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

    public int borrarJornadas(clsJornada jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, jornada.getCodigoJornada());
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

    public clsJornada consultaJornadasPorNombre(clsJornada jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + jornada);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, jornada.getNombreJornada());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoJor = rs.getInt("codigo_jornada");
                String nombreJor = rs.getString("nombre_jornada");
                String estatusJor = rs.getString("estatus_jornada");

                //usuario = new clsUsuario();
                jornada.setCodigoJornada(codigoJor);
                jornada.setNombreJornada(nombreJor);
                jornada.setEstatusJornada(estatusJor);
                System.out.println(" registro consultado: " + jornada);                
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
        return jornada;
    }
    public clsJornada consultaJornadasPorCodigo(clsJornada jornada) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + jornada);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, jornada.getCodigoJornada());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigoJor = rs.getInt("codigo_curso");
                String nombreJor = rs.getString("nombre_curso");
                String estatusJor = rs.getString("estatus_curso");

                //usuario = new clsUsuario();
                jornada.setCodigoJornada(codigoJor);
                jornada.setNombreJornada(nombreJor);
                jornada.setEstatusJornada(estatusJor);
                System.out.println(" registro consultado: " + jornada);                
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
        return jornada;
    }    
}
