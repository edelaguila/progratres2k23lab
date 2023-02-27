/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoCarreras;
/**
 *
 * @author visitante
 */
public class clsCarreras {
    private String CodigoCarrera;
    private String NombreCarrera;
    private String EstatusCarrera;

    public clsCarreras() {
    }
    
    
    public clsCarreras(String CodigoCarrera, String NombreCarrera, String EstatusCarrera) {
        this.CodigoCarrera = CodigoCarrera;
        this.NombreCarrera = NombreCarrera;
        this.EstatusCarrera= EstatusCarrera;
    }
    
 

    public String getCodigoCarrera() {
        return CodigoCarrera;
    }

    public void setCodigoCarrera(String CodigoCarrera) {
        this.CodigoCarrera = CodigoCarrera;
    }

    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String NombreCarrera) {
        this.NombreCarrera = NombreCarrera;
    }

    public String getEstatusCarrera() {
        return EstatusCarrera;
    }

    public void setEstatusCarrera(String EstatusCarrera) {
        this.EstatusCarrera = EstatusCarrera;
    }
    @Override
    public String toString() {
        return "clsCarreras{" + "CodigoCarrera" + CodigoCarrera + ", NombreCarrera=" + NombreCarrera + ", EstatusCarrerea=" + EstatusCarrera + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsCarreras getBuscarInformacionCarreraPorNombre(clsCarreras carrera)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.consultaCarrerasPorNombre(carrera);
    }
    public clsCarreras getBuscarInformacionCarreraPorId(clsCarreras carrera)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.consultaCarrerasPorId(carrera);
    }    
    public List<clsCarreras> getListadoCarreras()
    {
        daoCarreras daocarreras = new daoCarreras();
        List<clsCarreras> listadoCarreras = daocarreras.consultaCarreras();
        return listadoCarreras;
    }
    public int setBorrarCarrera(clsCarreras carrera)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.borrarCarreras(carrera);
    }          
    public int setIngresarCarrera(clsCarreras carrera)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.ingresaCarreras(carrera);
    }              
    public int setModificarCarrera(clsCarreras carrera)
    {
        daoCarreras daocarreras = new daoCarreras();
        return daocarreras.actualizaCarreras(carrera);
    }              
}
