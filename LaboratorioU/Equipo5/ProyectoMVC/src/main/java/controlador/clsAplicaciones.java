/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoAplicaciones;
/**
 *
 * @author visitante
 */
public class clsAplicaciones {
    private int IdAplicaciones;
    private String NombreAplicaciones;
    private String EstatusAplicacion;

    public int getIdAplicaciones() {
        return IdAplicaciones;
    }

    public void setIdAplicaciones(int IdAplicaciones) {
        this.IdAplicaciones = IdAplicaciones;
    }

    public String getNombreAplicaciones() {
        return NombreAplicaciones;
    }

    public void setNombreAplicaciones(String NombreAplicaciones) {
        this.NombreAplicaciones = NombreAplicaciones;
    }

    public String getEstatusAplicacion() {
        return EstatusAplicacion;
    }

    public void setEstatusAplicacion(String EstatusAplicacion) {
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsAplicaciones(int IdAplicaciones, String NombreAplicaciones, String EstatusAplicacion) {
        this.IdAplicaciones = IdAplicaciones;
        this.NombreAplicaciones = NombreAplicaciones;
        this.EstatusAplicacion = EstatusAplicacion;
    }

    public clsAplicaciones(int IdAplicaciones, String NombreAplicaciones) {
        this.IdAplicaciones = IdAplicaciones;
        this.NombreAplicaciones = NombreAplicaciones;
    }

    public clsAplicaciones(int IdAplicaciones) {
        this.IdAplicaciones = IdAplicaciones;
    }

    public clsAplicaciones() {
    }
    @Override
    public String toString() {
        return "clsAplicaciones{" + "IdAplicaciones=" + IdAplicaciones + ", NombreAplicaciones=" + NombreAplicaciones + ", EstatusAplicacion=" + EstatusAplicacion + '}';
    }

    //Metodos de acceso a la capa controlador
    public clsAplicaciones getBuscarInformacionAplicacionPorNombre(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicaciones = new daoAplicaciones();
        return daoaplicaciones.consultaAplicacionesPorNombre(aplicaciones);
    }
    public clsAplicaciones getBuscarInformacionAplicacionesPorId(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicaciones = new daoAplicaciones();
        return daoaplicaciones.consultaAplicacionesPorId(aplicaciones);
    }    
    public List<clsAplicaciones> getListadoAplicaciones()
    {
        daoAplicaciones daoaplicacion = new daoAplicaciones();
        List<clsAplicaciones> listadoAplicaciones = daoaplicacion.consultaAplicaciones();
        return listadoAplicaciones;
    }
    public int setBorrarAplicaciones(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicacion = new daoAplicaciones();
        return daoaplicacion.borrarAplicaciones(aplicaciones);
    }          
    public int setIngresarAplicaiones(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicacion = new daoAplicaciones();
        return daoaplicacion.ingresaAplicaciones(aplicaciones);
    }              
    public int setModificarAplicaciones(clsAplicaciones aplicaciones)
    {
        daoAplicaciones daoaplicacion = new daoAplicaciones();
        return daoaplicacion.actualizaAplicaciones(aplicaciones);
    }              
}
