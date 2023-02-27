/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoJornada;
/**
 *
 * @author visitante
 */
public class clsJornada {

    public clsJornada() {
    }

    public clsJornada(int CodigoJornada) {
        this.CodigoJornada = CodigoJornada;
    }

    public clsJornada(int CodigoJornada, String NombreJornada) {
        this.CodigoJornada = CodigoJornada;
        this.NombreJornada = NombreJornada;
    }

    public clsJornada(int CodigoJornada, String NombreJornada, String EstatusJornada) {
        this.CodigoJornada = CodigoJornada;
        this.NombreJornada = NombreJornada;
        this.EstatusJornada = EstatusJornada;
    }

    public int getCodigoJornada() {
        return CodigoJornada;
    }

    public void setCodigoJornada(int CodigoJornada) {
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
    
    private int CodigoJornada;
    private String NombreJornada;
    private String EstatusJornada;

    
    
    //Metodos de acceso a la capa controlador
    public clsJornada getBuscarInformacionJornadaPorNombre(clsJornada jornada)
    {
        daoJornada daojornada = new daoJornada();
        return daojornada.consultaJornadasPorNombre(jornada);
    }
    public clsJornada getBuscarInformacionJornadaPorcodigo(clsJornada jornada)
    {
        daoJornada daojornada = new daoJornada();
        return daojornada.consultaJornadasPorCodigo(jornada);
    }    
    public List<clsJornada> getListadoJornadas()
    {
        daoJornada daojornada = new daoJornada();
        List<clsJornada> listadosJornadas = daojornada.consultaJornadas();
        return listadosJornadas;
    }
    public int setBorrarJornada(clsJornada jornada)
    {
        daoJornada daojornada = new daoJornada();
        return daojornada.borrarJornadas(jornada);
    }          
    public int setIngresarJornada(clsJornada jornada)
    {
        daoJornada daojornada = new daoJornada();
        return daojornada.ingresaJornadas(jornada);
    }              
    public int setModificarJornada(clsJornada jornada)
    {
        daoJornada daojornada = new daoJornada();
        return daojornada.actualizaJornadas(jornada);
    }              
}
