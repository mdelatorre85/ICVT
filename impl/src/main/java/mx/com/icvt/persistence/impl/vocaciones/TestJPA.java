package mx.com.icvt.persistence.impl.vocaciones;

import java.util.List;

public class TestJPA {
    public static void main(String[] args){
        UnidadEconomicaModel model = new UnidadEconomicaModel("");
        List<UnidadEconomica> unidadesEconomicas = model.executeQuery("");
        System.out.printf("Número de unidades económicas: %d\n", unidadesEconomicas.size());
        for (UnidadEconomica unidadEconomica : unidadesEconomicas){
            System.out.println("Nombre: " + unidadEconomica.getNombreEstablecimiento());
            System.out.println("Razón social: " + unidadEconomica.getRazonSocial());
        }
    }
}
