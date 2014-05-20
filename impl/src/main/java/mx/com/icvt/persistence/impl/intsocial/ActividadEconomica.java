package mx.com.icvt.persistence.impl.intsocial;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "actividad_economica")
public class ActividadEconomica {
    @Id
    private int id;
    private int descripcion;

    @OneToMany(mappedBy = "actividadEconomica")
    private List<CensosEconomicos> censosEconomicos;

    public ActividadEconomica() {
        this.censosEconomicos = new LinkedList<CensosEconomicos>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public List<CensosEconomicos> getCensosEconomicos() {
        return censosEconomicos;
    }

    public void setCensosEconomicos(List<CensosEconomicos> censosEconomicos) {
        this.censosEconomicos = censosEconomicos;
    }
}
