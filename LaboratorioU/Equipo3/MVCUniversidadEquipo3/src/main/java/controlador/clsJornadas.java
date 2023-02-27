/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoJornadas;
/**
 *
 * @author visitante
 */
public class clsJornadas {
    private String CodigoJornada;
    private String NombreJornada;
    private String EstatusJornada;

    public clsJornadas() {
    }
    
    
    public clsJornadas(String CodigoJornada, String NombreJornada, String EstatusJornada) {
        this.CodigoJornada = CodigoJornada;
        this.NombreJornada = NombreJornada;
        this.EstatusJornada = EstatusJornada;
    }
    
 

    public String getCodigoJornada() {
        return CodigoJornada;
    }

    public void setCodigoJornada(String CodigoJornada) {
        this.CodigoJornada = CodigoJornada;
    }

    public String getNombreJornada() {
        return NombreJornada;
    }

    public void setNombreJornada(String NombreJornada) {
        this.NombreJornada = NombreJornada;
    }

    public String getEstatusJornada() {
        return EstatusJornada;
    }

    public void setEstatusJornada(String EstatusJornada) {
        this.EstatusJornada = EstatusJornada;
    }
    @Override
    public String toString() {
        return "clsJornadas{" + "CodigoJornada=" + CodigoJornada + ", NombreJornada=" + NombreJornada + ", EstatusJornada=" + EstatusJornada + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsJornadas getBuscarInformacionJornadaPorNombre(clsJornadas jornada)
    {
        daoJornadas daojornadas = new daoJornadas();
        return daojornadas.consultaJornadasPorNombre(jornada);
    }
    public clsJornadas getBuscarInformacionJornadaPorId(clsJornadas jornada)
    {
        daoJornadas daojornadas = new daoJornadas();
        return daojornadas.consultaJornadasPorId(jornada);
    }    
    public List<clsJornadas> getListadoJornadas()
    {
        daoJornadas daojornadas = new daoJornadas();
        List<clsJornadas> listadoJornadas = daojornadas.consultaJornadas();
        return listadoJornadas;
    }
    public int setBorrarJornada(clsJornadas jornada)
    {
        daoJornadas daojornadas = new daoJornadas();
        return daojornadas.borrarJornadas(jornada);
    }          
    public int setIngresarJornada(clsJornadas jornada)
    {
        daoJornadas daojornadas = new daoJornadas();
        return daojornadas.ingresaJornadas(jornada);
    }              
    public int setModificarJornada(clsJornadas jornada)
    {
        daoJornadas daojornadas = new daoJornadas();
        return daojornadas.actualizaJornadas(jornada);
    }              
}
