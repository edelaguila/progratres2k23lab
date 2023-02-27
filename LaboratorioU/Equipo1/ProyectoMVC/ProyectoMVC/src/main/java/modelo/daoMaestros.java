/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import controlador.clsMaestros;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cdavi
 */
public class daoMaestros {
    private static final String SQL_SELECT = "SELECT maestrosid, maestrosnombre, maestroscontrasena FROM tbl_maestros";
    private static final String SQL_INSERT = "INSERT INTO tbl_maestros(maestrosnombre, maestroscontrasena) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_maestros SET maestrosnombre=?, maestroscontrasena=? WHERE maestrosuid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_maestros WHERE maestrosid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT maestrosid, maestrosnombre, maestroscontrasena FROM tbl_maestros WHERE usunombre = ?";
    private static final String SQL_SELECT_ID = "SELECT maestrosid, maestrosnombre, maestroscontrasena FROM tbl_maestros WHERE maestrosid = ?";    

    public List<clsMaestros> consultaMaestros() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMaestros> maestros = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("maestrosid");
                String nombre = rs.getString("maestrosnombre");
                String contrasena = rs.getString("maestroscontrasena");
                clsMaestros maestro = new clsMaestros();
                maestro.setIdMaestro(id);
                maestro.setNombreMaestro(nombre);
                maestro.setContrasenaMaestro(contrasena);
                maestros.add(maestro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return maestros;
    }

    public int ingresaMaestros(clsMaestros maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, maestro.getNombreMaestro());
            stmt.setString(2, maestro.getContrasenaMaestro());

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

    public int actualizaMaestros(clsMaestros maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, maestro.getNombreMaestro());
            stmt.setString(2, maestro.getContrasenaMaestro());
            stmt.setInt(3, maestro.getIdMaestro());

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

    public int borrarMaestros(clsMaestros maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, maestro.getIdMaestro());
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

    public clsMaestros consultaMaestroPorNombre(clsMaestros maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + maestro);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, maestro.getIdMaestros());            
            stmt.setString(1, maestro.getNombreMaestro());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("maestrosid");
                String nombre = rs.getString("maestrosnombre");
                String contrasena = rs.getString("maestroscontrasena");

                //maestro = new clsMaestros();
                maestro.setIdMaestro(id);
                maestro.setNombreMaestro(nombre);
                maestro.setContrasenaMaestro(contrasena);
                System.out.println(" registro consultado: " + maestro);                
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
        return maestro;
    }
    public clsMaestros consultaMaestroPorId(clsMaestros maestro) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + maestro);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, maestro.getIdMaestro());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("maestrosid");
                String nombre = rs.getString("maestrosnombre");
                String contrasena = rs.getString("maestroscontrasena");

                //maestro = new clsMaestros();
                maestro.setIdMaestro(id);
                maestro.setNombreMaestro(nombre);
                maestro.setContrasenaMaestro(contrasena);
                System.out.println(" registro consultado: " + maestro);                
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
        return maestro;
    }
}