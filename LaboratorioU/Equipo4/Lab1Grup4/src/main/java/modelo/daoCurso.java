/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsCurso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCurso {

    private static final String SQL_SELECT = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos";
    private static final String SQL_INSERT = "INSERT INTO cursos(nombre_curso, estatus_curso) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE cursos SET nombre_curso=?, estatus_curso=? WHERE codigo_curso = ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE codigo_curso=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos WHERE nombre_curso = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_curso, nombre_curso, estatus_curso FROM cursos WHERE codigo_curso = ?";    

    public List<clsCurso> consultaCrusos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCurso> cursos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_curso");
                String nombreCur = rs.getString("nombre_curso");
                String estatusCur = rs.getString("estatus_curso");
                clsCurso curso = new clsCurso();
                curso.setCodigoCurso(codigo);
                curso.setNombreCurso(nombreCur);
                curso.setEstatusCurso(estatusCur);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cursos;
    }

    public int ingresaCursos(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getEstatusCurso());

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

    public int actualizaCursos(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, curso.getNombreCurso());
            stmt.setString(2, curso.getEstatusCurso());
            stmt.setInt(3, curso.getCodigoCurso());

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

    public int borrarCursos(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, curso.getCodigoCurso());
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

    public clsCurso consultaCursosPorNombre(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + curso);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, curso.getNombreCurso());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_curso");
                String nombreCur = rs.getString("nombre_curso");
                String estatusCur = rs.getString("estatus_curso");

                //usuario = new clsUsuario();
                curso.setCodigoCurso(codigo);
                curso.setNombreCurso(nombreCur);
                curso.setEstatusCurso(estatusCur);
                System.out.println(" registro consultado: " + curso);                
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
        return curso;
    }
    public clsCurso consultaCursosPorCodigo(clsCurso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + curso);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, curso.getCodigoCurso());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_curso");
                String nombreCur = rs.getString("nombre_curso");
                String estatusCur = rs.getString("estatus_curso");

                //usuario = new clsUsuario();
                curso.setCodigoCurso(codigo);
                curso.setNombreCurso(nombreCur);
                curso.setEstatusCurso(estatusCur);
                System.out.println(" registro consultado: " + curso);                
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
        return curso;
    }    
}
