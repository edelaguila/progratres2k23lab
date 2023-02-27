/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoMaestros;


/**
 *
 * @author cdavi
 */
public class clsMaestros {
    private int CarnetMaestros;
    private String NombreMaestros;
    private String TelefonoMaestros;
    private String DireccionMaestros;
    private String EmailMaestros;
    private String EstatusMaestros;
    
    
    public clsMaestros() {
    }
    
    public clsMaestros(int CarnetMaestros) {
        this.CarnetMaestros = CarnetMaestros;
    }    
    
    public clsMaestros(String NombreMaestros, String TelefonoMaestros, String DireccionMaestros, String EmailMaestros, String EstatusMaestros) {
        this.NombreMaestros = NombreMaestros;
        this.TelefonoMaestros = TelefonoMaestros;
        this.DireccionMaestros = DireccionMaestros;
        this.EmailMaestros = EmailMaestros;
        this.EstatusMaestros = EstatusMaestros;
    }
    
    public clsMaestros(int CarnetAlumno, String NombreAlumno, String TelefonoMaestros,String DireccionMaestros, String EmailMaestros, String EstatusMaestros) {
        this.CarnetMaestros = CarnetAlumno;
        this.NombreMaestros = NombreAlumno;
        this.TelefonoMaestros = TelefonoMaestros;
        this.DireccionMaestros = DireccionMaestros;
        this.EmailMaestros = EmailMaestros;
        this.EstatusMaestros = EstatusMaestros;
    }    

    public int getCarnetMaestros() {
        return CarnetMaestros;
    }

    public void setCarnetMaestros(int CarnetMaestros) {
        this.CarnetMaestros = CarnetMaestros;
    }
    
    public String getDireccionMaestros() {
        return DireccionMaestros;
    }

    public void setDireccionMaestros(int DireccionMaestros) {
        this.DireccionMaestros = DireccionMaestros;
    }


    public String getNombreMaestros() {
        return NombreMaestros;
    }

    public void setNombreMaestros(String NombreMaestros) {
        this.NombreMaestros = NombreMaestros;
    }

    public String getTelefonoMaestros() {
        return TelefonoMaestros;
    }

    public void setContrasenaMaestros(String TelefonoMaestros) {
        this.TelefonoMaestros = TelefonoMaestros;
    }
    
    public String getEmailMaestros() {
        return DireccionMaestros;
    }

    public void setEmailMaestros(int EmailMaestros) {
        this.EmailMaestros = EmailMaestros;
    }

    
    public String getEstatusMaestros() {
        return DireccionMaestros;
    }

    public void setEsatstusMaestros(int EstatusMaestros) {
        this.DireccionMaestros = DireccionMaestros;
    }

    @Override
    public String toString() {
        return "clsMaestros{" + "CarnetMaestros=" + CarnetMaestros + ", NombreMaestros=" + NombreMaestros + ", TelefonoMaestros=" + TelefonoMaestros + ",DireccionMaestros="+ DireccionMaestros + ",EmailMaestros="+ EmailMaestros +",EstatusMaestros="+ EstatusMaestros + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsMaestros getBuscarInformacionMaestrosPorNombre(clsMaestros maestro)
    {
        daoMaestros daoMaestros = new daoMaestros();
        return daoMaestros.(maestro);
    }
    public clsMaestros getBuscarInformacionMaestrosPorCarnet(clsMaestros maestro)
    {
        daoMaestros daoMaestros = new daoMaestros();
        return daoMaestros.consultaMaestrosPorId(maestro);
    }    
    public List<clsMaestros> getListadoMaestros()
    {
        daoMaestros daoMaestros = new daoMaestros();
        List<clsMaestros> listadoMaestros = daoMaestros.consultaMaestros();
        return listadoMaestros;
    }
    public int setBorrarMaestros(clsMaestros Maestros)
    {
        daoMaestros daoalumno = new daoMaestros();
        return daoalumno.borrarMaestros(Maestros);
    }          
    public int setIngresarMaestros(clsMaestros Maestros)
    {
        daoMaestros daoMaestros = new daoMaestros();
        return daoMaestros.ingresaMaestros(Maestros);
    }              
    public int setModificarMaestros(clsMaestros Maestros)
    {
        daoMaestros daoMaestros = new daoMaestros();
        return daoMaestros.actualizaMaestros(Maestros);
    }
    
}