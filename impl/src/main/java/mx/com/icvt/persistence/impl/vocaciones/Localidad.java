package mx.com.icvt.persistence.impl.vocaciones;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "localidad")
public class Localidad {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "localidad")
    private List<UnidadEconomica> unidadesEconomicas;

    public Localidad() {
        unidadesEconomicas = new LinkedList<UnidadEconomica>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<UnidadEconomica> getUnidadesEconomicas() {
        return unidadesEconomicas;
    }

    public void setUnidadesEconomicas(List<UnidadEconomica> unidadesEconomicas) {
        this.unidadesEconomicas = unidadesEconomicas;
    }
}
