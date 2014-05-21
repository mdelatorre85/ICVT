package mx.com.icvt.persistence.impl.vocaciones;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "personal_ocupado")
public class PersonalOcupado {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "personalOcupado")
    private List<UnidadEconomica> unidadesEconomicas;

    public PersonalOcupado() {
        this.unidadesEconomicas = new LinkedList<UnidadEconomica>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
