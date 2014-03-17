package mx.com.icvt.extraction.impl.vocaciones;

import javax.jdo.annotations.*;
import java.io.Serializable;


/**
 * Created by lnx1337 on 16/03/14.
 */

@PersistenceCapable(table = "unidad_economica")
public class UnidadEconomica implements java.io.Serializable  {


    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    int d_llave;

    @Persistent
    int cve_ent;

    @Persistent
    int cve_num;

    @Persistent
    int cve_loc;

    @Persistent
    String nic;

    @Persistent
    String nop;

    @Persistent
    String ageb;

    @Persistent
    String manzana;

    @Persistent
    String nom_estab;

    @Persistent
    String nom_propie;

    @Persistent
    String tipo_calle;

    @Persistent
    String calle;

    @Persistent
    String tipo_vial1;

    @Persistent
    String calle_1;

    @Persistent
    String tipo_vial2;

    @Persistent
    String calle2;

    @Persistent
    String tipo_vial3;

    @Persistent
    String calle3;


    @Persistent
    String numero_ext;

    @Persistent
    String edificio;

    @Persistent
    String numero_int;

    @Persistent
    String tipo_asent;

    @Persistent
    String colonia;

    @Persistent
    String cod_postal;

    @Persistent
    String telefono1;

    @Persistent
    String ext_tel2;

    @Persistent
    String fax;

    @Persistent
    long clase_act;

    @Persistent
    String centro_com;

    @Persistent
    String num_local;

    @Persistent
    String correoelec;

    @Persistent
    String www;

    @Persistent
    String correoelec2;

    @Persistent
    String tipo_estab;

    @Persistent
    String tipo_ue;

    @Persistent
    long est_perocu;

    @Persistent
    String estatus;

    @Persistent
    String alta;

    @Persistent
    Double longitud;

    @Persistent
    Double latitud;

    public int getd_llave(){

        return this.d_llave;
    }

    public UnidadEconomica(int cve_ent,int cve_num,int cve_loc){
        this.cve_ent=cve_ent;
        this.cve_loc=cve_num;
        this.cve_loc=cve_loc;
    }
}
