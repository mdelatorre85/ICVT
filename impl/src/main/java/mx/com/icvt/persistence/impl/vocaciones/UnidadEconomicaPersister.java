package mx.com.icvt.persistence.impl.vocaciones;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class UnidadEconomicaPersister {
    public boolean persist(UnidadEconomica unidadEconomica, int idLocalidad, int idSegmentoPersonalOcupado, int idClaseActividad, int idMunicipio) {
        boolean success = false;

        Localidad localidad;
        PersonalOcupado segmentoPersonalOcupado;
        ClaseActividad claseActividad;
        Municipio municipio;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();

        localidad = manager.find(Localidad.class, idLocalidad);
        segmentoPersonalOcupado = manager.find(PersonalOcupado.class, idSegmentoPersonalOcupado);
        claseActividad = manager.find(ClaseActividad.class, idClaseActividad);
        municipio = manager.find(Municipio.class, idMunicipio);

        if (localidad != null && segmentoPersonalOcupado != null && claseActividad != null && municipio != null) {
            try {
                manager.getTransaction().begin();

                unidadEconomica.setLocalidad(localidad);
                unidadEconomica.setPersonalOcupado(segmentoPersonalOcupado);
                unidadEconomica.setClaseActividad(claseActividad);
                unidadEconomica.setMunicipio(municipio);
                manager.persist(unidadEconomica);

                manager.getTransaction().commit();
                success = true;
            } catch (PersistenceException e) {
                System.err.printf("Excepción al actualizar la base de datos: %s\n", e.getMessage());
            }
        } else {
            System.err.println("Alguna de las dependencias (localidad, personal ocupado, actividad y/o municipio) no pudo ser encontrada");
            System.err.println("No se registrará la unidad económica");
        }


        manager.close();

        return success;
    }

}
