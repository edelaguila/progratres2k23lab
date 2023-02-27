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
    private int estatusSedes;
    private String NombreSedes;
    private String CodigoSedes;

    public clsSedes() {
    }
    
    public clsSedes(int estatusSedes) {
        this.estatusSedes = estatusSedes;
    }    
    
    public clsSedes(String NombreSedes, String CodigoSedes) {
        this.NombreSedes = NombreSedes;
        this.CodigoSedes = CodigoSedes;
    }
    
    public clsSedes(int estatusSedes, String NombreSedes, String CodigoSedes) {
        this.estatusSedes = estatusSedes;
        this.NombreSedes = NombreSedes;
        this.CodigoSedes = CodigoSedes;
    }    

    public int getestatusSedes() {
        return estatusSedes;
    }

    public voestatus setestatusSedes(int estatusSedes) {
        this.estatusSedes = estatusSedes;
    }

    public String getNombreSedes() {
        return NombreSedes;
    }

    public voestatus setNombreSedes(String NombreSedes) {
        this.NombreSedes = NombreSedes;
    }

    public String getCodigoSedes() {
        return CodigoSedes;
    }

    public voestatus setCodigoSedes(String CodigoSedes) {
        this.CodigoSedes = CodigoSedes;
    }
    @Overrestatuse
    public String toString() {
        return "clsSedes{" + "estatusSedes=" + estatusSedes + ", NombreSedes=" + NombreSedes + ", CodigoSedes=" + CodigoSedes + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsSedes getBuscarInformacionSedesPorNombre(clsSedes sedes)
    {
        daoSedes daoSedes = new daoSedes();
        return daoSedes.consultaSedesPorNombre(sedes);
    }
    public clsSedes getBuscarInformacionSedesPorestatus(clsSedes Sedes)
    {
        daoSedes daoSedes = new daoSedes();
        return daoSedes.consultaSedesPorestatus(Sedes);
    }    
    public List<clsSedes> getListadoSedes()
    {
        daoSedes daoSedes = new daoSedes();
        List<clsSedes> listadoSedes = daoSedes.consultaSedes();
        return listadoSedes;
    }
    public int setBorrarSedes(clsSedes Sedes)
    {
        daoSedes daoSedes = new daoSedes();
        return daoSedes.borrarSedes(Sedes);
    }          
    public int setIngresarSedes(clsSedes Sedes)
    {
        daoSedes daoSedes = new daoSedes();
        return daoSedes.ingresaSedes(Sedes);
    }              
    public int setModificarSedes(clsSedes sedes)
    {
        daoSedes daoSedes = new daoSedes();
        return daoSedes.actualizaSedes(sedes);
    }              
}
