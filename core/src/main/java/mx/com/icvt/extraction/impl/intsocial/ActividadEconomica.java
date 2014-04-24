package mx.com.icvt.extraction.impl.intsocial;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(table="actividad_economica")
public class ActividadEconomica {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    public int id;

    @Persistent
    public int actividad_economica;

    public int getActividad_economica() {
        return actividad_economica;
    }

    public void setActividad_economica(int actividad_economica) {
        this.actividad_economica = actividad_economica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
