package mx.com.icvt.persistence.impl.vocaciones;

import mx.com.icvt.extraction.ResultData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class VocacionesResultData implements ResultData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int d_llave;
    private int cve_ent;

    public VocacionesResultData() {
    }

    public int getD_llave() {
        return this.d_llave;
    }

    public int getCve() {
        return this.cve_ent;
    }

    public VocacionesResultData(int cve_ent) {
        super();
        this.cve_ent = cve_ent;
    }

    @Override
    public List getResults() {
        return null;
    }
}
