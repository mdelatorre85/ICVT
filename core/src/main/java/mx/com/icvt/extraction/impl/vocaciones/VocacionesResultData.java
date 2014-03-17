package mx.com.icvt.extraction.impl.vocaciones;

import mx.com.icvt.extraction.ResultData;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 09/03/14
 * Time: 18:05
 */

@PersistenceCapable
public class VocacionesResultData implements ResultData {


    @PrimaryKey
    @Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
    private int d_llave;
    @Persistent
    private int cve_ent;


    public VocacionesResultData() {
        super();
    }


    public int getD_llave(){

        return this.d_llave;
    }

    public int getCve(){
        return this.cve_ent;
    }

    public VocacionesResultData(int cve_ent){
        super();
        this.cve_ent=cve_ent;

    }
}
