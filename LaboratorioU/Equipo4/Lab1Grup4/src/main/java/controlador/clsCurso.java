/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoCurso;
/**
 *
 * @author visitante
 */
public class clsCurso {
    
    private int CodigoCurso;
    private String NombreCurso;
    private String EstatusCurso;

    public int getCodigoCurso() {
        return CodigoCurso;
    }

    public void setCodigoCurso(int CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public String getEstatusCurso() {
        return EstatusCurso;
    }

    public void setEstatusCurso(String EstatusCurso) {
        this.EstatusCurso = EstatusCurso;
    }

    public clsCurso(int CodigoCurso, String NombreCurso, String EstatusCurso) {
        this.CodigoCurso = CodigoCurso;
        this.NombreCurso = NombreCurso;
        this.EstatusCurso = EstatusCurso;
    }

    public clsCurso(int CodigoCurso, String NombreCurso) {
        this.CodigoCurso = CodigoCurso;
        this.NombreCurso = NombreCurso;
    }

    public clsCurso(int CodigoCurso) {
        this.CodigoCurso = CodigoCurso;
    }

    public clsCurso() {
    }

    

    
    
    //Metodos de acceso a la capa controlador
    public clsCurso getBuscarInformacionCursoPorNombre(clsCurso curso)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.consultaCursosPorNombre(curso);
    }
    public clsCurso getBuscarInformacionCursoPorcodigo(clsCurso curso)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.consultaCursosPorCodigo(curso);
    }    
    public List<clsCurso> getListadoCursos()
    {
        daoCurso daocurso = new daoCurso();
        List<clsCurso> listadosCursos = daocurso.consultaCrusos();
        return listadosCursos;
    }
    public int setBorrarCurso(clsCurso curso)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.borrarCursos(curso);
    }          
    public int setIngresarCurso(clsCurso curso)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.ingresaCursos(curso);
    }              
    public int setModificarCurso(clsCurso curso)
    {
        daoCurso daocurso = new daoCurso();
        return daocurso.actualizaCursos(curso);
    }              
}
