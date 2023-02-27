/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoAlumnos;


/**
 *
 * @author cdavi
 */
public class clsAlumnos {
    private int CarnetAlumnos;
    private String NombreAlumnos;
    private String TelefonoAlumnos;
    private String DireccionAlumnos;
    private String EmailAlumnos;
    private String EstatusAlumnos;
    
    
    public clsAlumnos() {
    }
    
    public clsAlumnos(int CarnetAlumnos) {
        this.CarnetAlumnos = CarnetAlumnos;
    }    
    
    public clsAlumnos(String NombreAlumnos, String TelefonoAlumnos, String DireccionAlumnos, String EmailAlumnos, String EstatusAlumnos) {
        this.NombreAlumnos = NombreAlumnos;
        this.TelefonoAlumnos = TelefonoAlumnos;
        this.DireccionAlumnos = DireccionAlumnos;
        this.EmailAlumnos = EmailAlumnos;
        this.EstatusAlumnos = EstatusAlumnos;
    }
    
    public clsAlumnos(int CarnetAlumno, String NombreAlumno, String TelefonoAlumnos,String DireccionAlumnos, String EmailAlumnos, String EstatusAlumnos) {
        this.CarnetAlumnos = CarnetAlumno;
        this.NombreAlumnos = NombreAlumno;
        this.TelefonoAlumnos = TelefonoAlumnos;
        this.DireccionAlumnos = DireccionAlumnos;
        this.EmailAlumnos = EmailAlumnos;
        this.EstatusAlumnos = EstatusAlumnos;
    }    

    public int getCarnetAlumnos() {
        return CarnetAlumnos;
    }

    public void setCarnetAlumnos(int CarnetAlumnos) {
        this.CarnetAlumnos = CarnetAlumnos;
    }
    
    public String getDireccionAlumnos() {
        return DireccionAlumnos;
    }

    public void setDireccionAlumnos(int DireccionAlumnos) {
        this.DireccionAlumnos = DireccionAlumnos;
    }


    public String getNombreAlumnos() {
        return NombreAlumnos;
    }

    public void setNombreAlumnos(String NombreAlumnos) {
        this.NombreAlumnos = NombreAlumnos;
    }

    public String getTelefonoAlumnos() {
        return TelefonoAlumnos;
    }

    public void setContrasenaAlumnos(String TelefonoAlumnos) {
        this.TelefonoAlumnos = TelefonoAlumnos;
    }
    
    public String getEmailAlumnos() {
        return DireccionAlumnos;
    }

    public void setEmailAlumnos(int EmailAlumnos) {
        this.EmailAlumnos = EmailAlumnos;
    }

    
    public String getEstatusAlumnos() {
        return DireccionAlumnos;
    }

    public void setEsatstusAlumnos(int EstatusAlumnos) {
        this.DireccionAlumnos = DireccionAlumnos;
    }

    @Override
    public String toString() {
        return "clsAlumnos{" + "Carnetalumnos=" + CarnetAlumnos + ", NombreAlumnos=" + NombreAlumnos + ", TelefonoAlumnos=" + TelefonoAlumnos + ",DireccionAlumnos="+ DireccionAlumnos + ",EmailAlumnos="+ EmailAlumnos +",EstatusAlumnos="+ EstatusAlumnos + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsAlumnos getBuscarInformacionAlumnosPorNombre(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoAlumnos.(alumnos);
    }
    public clsAlumnos getBuscarInformacionAlumnosPorCarnet(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoAlumnos.consultaAlumnosPorId(alumnos);
    }    
    public List<clsAlumnos> getListadoAlumnos()
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        List<clsAlumnos> listadoAlumnos = daoalumnos.consultaAlumnos();
        return listadoAlumnos;
    }
    public int setBorraralumnos(clsAlumnos alumnos)
    {
        daoAlumnos daoalumno = new daoAlumnos();
        return daoalumno.borrarAlumnos(alumnos);
    }          
    public int setIngresarAlumnos(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoalumnos.ingresaAlumnos(alumnos);
    }              
    public int setModificarAlumnos(clsAlumnos alumnos)
    {
        daoAlumnos daoalumnos = new daoAlumnos();
        return daoalumnos.actualizaAlumnos(alumnos);
    }
    
}