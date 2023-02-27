/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoSedes;
/**
 *
 * @author visitante
 */
public class clsSedes {
    private String CodigoSede;
    private String NombreSede;
    private String EstatusSede;

    public clsSedes() {
    }
    
    
    public clsSedes(String CodigoSede, String NombreSede, String EstatusSede) {
        this.CodigoSede = CodigoSede;
        this.NombreSede = NombreSede;
        this.EstatusSede= EstatusSede;
    }
    
 

    public String getCodigoSede() {
        return CodigoSede;
    }

    public void setCodigoSede(String CodigoSede) {
        this.CodigoSede = CodigoSede;
    }

    public String getNombreSede() {
        return NombreSede;
    }

    public void setNombreSede(String NombreSede) {
        this.NombreSede = NombreSede;
    }

    public String getEstatusSede() {
        return EstatusSede;
    }

    public void setEstatusSede(String EstatusSede) {
        this.EstatusSede = EstatusSede;
    }
    @Override
    public String toString() {
        return "clsSedes{" + "CodigoSede=" + CodigoSede + ", NombreSede=" + NombreSede + ", EstatusSede=" + EstatusSede + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsSedes getBuscarInformacionSedePorNombre(clsSedes sede)
    {
        daoSedes daosedes = new daoSedes();
        return daosedes.consultaSedesPorNombre(sede);
    }
    public clsSedes getBuscarInformacionSedePorId(clsSedes sede)
    {
        daoSedes daosedes = new daoSedes();
        return daosedes.consultaSedesPorId(sede);
    }    
    public List<clsSedes> getListadoSedes()
    {
        daoSedes daosedes = new daoSedes();
        List<clsSedes> listadoSedes = daosedes.consultaSedes();
        return listadoSedes;
    }
    public int setBorrarSede(clsSedes sede)
    {
        daoSedes daosedes = new daoSedes();
        return daosedes.borrarSedes(sede);
    }          
    public int setIngresarSede(clsSedes sede)
    {
        daoSedes daosedes = new daoSedes();
        return daosedes.ingresaSedes(sede);
    }              
    public int setModificarSede(clsSedes sede)
    {
        daoSedes daosedes = new daoSedes();
        return daosedes.actualizaSedes(sede);
    }              
}
