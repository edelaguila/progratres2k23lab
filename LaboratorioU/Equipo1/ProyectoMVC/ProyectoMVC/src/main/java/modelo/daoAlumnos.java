/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import controlador.clsAlumnos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cdavi
 */
public class daoAlumnos {
    
   
    private static final String SQL_SELECT = "SELECT alumnoscarnet, alumnosnombre, alumnostelefono, alumnosdireccion, alumnosemail, alumnosestatus FROM tbl_alumnos";
    private static final String SQL_INSERT = "INSERT INTO tbl_alumnos(alumnosnombre, alumnostelefono, alumnosdireccion, alumnosemail, alumnosestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_alumnos SET alumnosnombre=?, alumnostelefono=?, alumnosdireccion=?, alumnosemail=?, alumnosestatus=? WHERE alumnoscarnet = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_alumnos WHERE alumnosid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT alumnoscarnet, alumnosnombre, alumnostelefono, alumnosdireccion, alumnosemail FROM tbl_alumnos WHERE alumnosnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT alumnoscarnet, alumnosnombre, alumnostelefono, alumnosdireccion, alumnosemail, alumnosestatus FROM tbl_alumnos WHERE alumnosid = ?";    

    public List<clsAlumnos> consultaAlumnos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsAlumnos> alumnos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet = rs.getInt("alumnosid");
                String nombre = rs.getString("alumnosnombre");
                String Telefono = rs.getString("alumnostelefono");
                String direccion = rs.getString("alumnosdireccion");
                String email = rs.getString("alumnosemail");
                String estatus = rs.getString("alumnosestatus");
                clsAlumnos alumno = new clsAlumnos();
                alumno.setCarnetAlumnos(carnet);
                alumno.setNombreAlumnos(nombre);
                alumno.setTelefonoAlumnos(Telefono);
                alumno.setEmailAlumnos(email);
                alumno.setDireccionAlumnos(direccion);
                alumno.setEstatusAlumnos(estatus);
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return alumnos;
    }

    public int ingresaAlumnos(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumnos.getNombreAlumnos());
            stmt.setString(2, alumnos.getCarnetAlumnos());

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

    public int actualizaAlumnos(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumnos.getNombreAlumnos());
            stmt.setString(2, alumnos.getTelefonoAlumnos());
            stmt.setInt(3, alumnos.getCarmetAlumnos());

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

    public int borrarAlumnos(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumnos.getCarnetAlumnos());
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

    public clsAlumnos consultaAlumnosPorNombre(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + alumnos);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, alumnos.getIdAlumnos());            
            stmt.setString(1, alumnos.getNombreAlumnos());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet = rs.getInt("alumnosid");
                String nombre = rs.getString("alumnosnombre");
                String telefono = rs.getString("alumnoscontrasena");
                String direccion = rs.getString("alumnosdireccion");
                String email = rs.getString("alumnosemail");
                String estatus = rs.getString("alumnosestatus");
                //alumnos = new clsAlumnos();
                alumnos.setCarnetAlumnos(carnet);
                alumnos.setNombreAlumnos(nombre);
                alumnos.setContrasenaAlumnos(telefono);
                alumnos.setDireccionAlumnos(direccion);
                alumnos.setEmailAlumnos(email);
                alumnos.setEstatusAlumnos(estatus);
                System.out.println(" registro consultado: " + alumnos);                
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
        return alumnos;
    }
    public clsAlumnos consultaAlumnosPorId(clsAlumnos alumnos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + alumnos);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, alumnos.getCarnetAlumnos());            
            //stmt.setString(1, alumnos.getNombreAlumnos());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int carnet = rs.getInt("alumnoscarnet");
                String nombre = rs.getString("alumnosnombre");
                String telefono = rs.getString("alumnostelefono");
                String direccion = rs.getString("alumnosdireccion");
                String email = rs.getString("alumnosemail");
                String estatus = rs.getString("alumnosestatus");
                //alumnos = new clsAlumnos();
                alumnos.setCarnetAlumnos(carnet);
                alumnos.setNombreAlumnos(nombre);
                alumnos.setTelefonoAlumnos(telefono);
                alumnos.setDireccionAlumnos(direccion);
                alumnos.setEmailAlumnos(email);
                alumnos.setEstatusAlumnos(estatus);
                System.out.println(" registro consultado: " + alumnos);                
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
        return alumnos;
    }
}