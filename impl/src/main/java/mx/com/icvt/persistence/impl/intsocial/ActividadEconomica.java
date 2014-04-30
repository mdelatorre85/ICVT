package mx.com.icvt.persistence.impl.intsocial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActividadEconomica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int actividad_economica;

    public ActividadEconomica() {
    }

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
