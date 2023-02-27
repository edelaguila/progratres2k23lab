/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import controlador.clsSedes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoSedes {

    private static final String SQL_SELECT = "SELECT sedeid, sedenombre, sedeestatus FROM tbl_Sedes";
    private static final String SQL_INSERT = "INSERT INTO tbl_Sedes(sedenombre, sedeestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Sedes SET sedenombre=?, sedeestatus=? WHERE sedeid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Sedes WHERE sedeid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT sedeid, sedenombre, sedeestatus FROM tbl_Sedes WHERE sedenombre = ?";
    private static final String SQL_SELECT_ID = "SELECT sedeid, sedenombre, sedeestatus FROM tbl_Sedes WHERE sedeid = ?";    

    public List<clsSedes> consultaSedes() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsSedes> Sedes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("sedeid");
                String nombre = rs.getString("sedenombre");
                String contrasena = rs.getString("sedecontrasena");
                clsSedes sedes = new clsSedes();
                sedes.setIdSedes(id);
                sedes.setNombreSedes(nombre);
                sedes.setContrasenaSedes(contrasena);
                Sedes.add(Sedes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Sedes;
    }

    public int ingresaSedes(clsSedes Sedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, Sedes.getNombreSedes());
            stmt.setString(2, Sedes.getContrasenaSedes());

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

    public int actualizaSedes(clsSedes Sedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, Sedes.getNombreSedes());
            stmt.setString(2, Sedes.getContrasenaSedes());
            stmt.setInt(3, Sedes.getIdSedes());

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

    public int borrarSedes(clsSedes Sedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, Sedes.getIdSedes());
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

    public clsSedes consultaSedesPorNombre(clsSedes Sedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + Sedes);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, Sedes.getIdSedes());            
            stmt.setString(1, Sedes.getNombreSedes());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("sedeid");
                String nombre = rs.getString("sedenombre");
                String contrasena = rs.getString("sedecontrasena");

                //Sedes = new clsSedes();
                Sedes.setIdSedes(id);
                Sedes.setNombreSedes(nombre);
                Sedes.setContrasenaSedes(contrasena);
                System.out.println(" registro consultado: " + Sedes);                
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
        return Sedes;
    }
    public clsSedes consultaSedesPorId(clsSedes Sedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + Sedes);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, Sedes.getIdSedes());            
            //stmt.setString(1, Sedes.getNombreSedes());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("sedeid");
                String nombre = rs.getString("sedenombre");
                String contrasena = rs.getString("sedecontrasena");

                //Sedes = new clsSedes();
                Sedes.setIdSedes(id);
                Sedes.setNombreSedes(nombre);
                Sedes.setContrasenaSedes(contrasena);
                System.out.println(" registro consultado: " + Sedes);                
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
        return Sedes;
    }    
}

