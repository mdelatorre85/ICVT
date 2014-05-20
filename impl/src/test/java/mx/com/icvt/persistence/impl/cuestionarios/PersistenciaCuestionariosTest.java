package mx.com.icvt.persistence.impl.cuestionarios;

import mx.com.icvt.model.EconomicUnit;
import mx.com.icvt.model.cuestionarios.*;
import mx.com.icvt.persistence.impl.questionnaries.Cuestionario;
import mx.com.icvt.persistence.impl.questionnaries.QuestionaryPersister;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by miguelangeldelatorre on 18/05/14.
 */
public class PersistenciaCuestionariosTest {

    QuestionaryPersister qp;

    @Before
    public void init() {
        qp = new QuestionaryPersister();
    }

    //@Test
    public void correctPersistanceTest(){
        Questionary q = new Questionary();
        q.setTittle("Prueba cuestionario 15:09");
        qp.persist(q);
    }

    @Test
    public void happyPersistanceTest(){
        Questionary cuestionario = new Questionary();
        //cuestionario.setId(1l);
        cuestionario.setTittle("Cuestionario Inicial");

        Topic economia = new Topic(cuestionario);
        //economia.setId(1l);
        economia.setTittle("Economía");
        economia.setQuestionary(cuestionario);
        cuestionario.getTopics().add(economia);

        SingleOptionQuestion preguntaUtilSingle = new SingleOptionQuestion("¿Cónoce el significado de los principales indicadores económicos de su industria?");
        //preguntaUtilSingle.setId(1l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Ha solicitado apoyo económico del gobierno para su empresa?");
        //preguntaUtilSingle.setId(2l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);
    }

    //@Test
    public void completePersistanceTest(){

        Questionary cuestionario = new Questionary();
        cuestionario.setId(1l);
        cuestionario.setTittle("Cuestionario Inicial");

        Topic economia = new Topic(cuestionario);
        economia.setId(1l);
        economia.setTittle("Economía");
        economia.setQuestionary(cuestionario);
        cuestionario.getTopics().add(economia);

        SingleOptionQuestion preguntaUtilSingle = new SingleOptionQuestion("¿Cónoce el significado de los principales indicadores económicos de su industria?");
        preguntaUtilSingle.setId(1l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Ha solicitado apoyo económico del gobierno para su empresa?");
        preguntaUtilSingle.setId(2l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("Clasificación por tamaño");
        preguntaUtilSingle.setId(3l);
        preguntaUtilSingle.getPossibleOptions().add("Micro");
        preguntaUtilSingle.getPossibleOptions().add("Pequeña");
        preguntaUtilSingle.getPossibleOptions().add("Mediana");
        preguntaUtilSingle.getPossibleOptions().add("Grande");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿En qué tipo de noticias de la industria está interesado?");
        preguntaUtilSingle.setId(4l);
        preguntaUtilSingle.getPossibleOptions().add("Negocios");
        preguntaUtilSingle.getPossibleOptions().add("Tecnología");
        preguntaUtilSingle.getPossibleOptions().add("Acerca de sus clietes");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("En que áreas de la empresa tiene dificultades para su desarrollo económico");
        preguntaUtilSingle.setId(5l);
        preguntaUtilSingle.getPossibleOptions().add("Administración");
        preguntaUtilSingle.getPossibleOptions().add("Finanzas");
        preguntaUtilSingle.getPossibleOptions().add("Producción");
        preguntaUtilSingle.getPossibleOptions().add("Legal");
        preguntaUtilSingle.getPossibleOptions().add("Ventas");
        preguntaUtilSingle.getPossibleOptions().add("Mercadotecnia");
        preguntaUtilSingle.getPossibleOptions().add("Asesoría fiscal");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Conoce usted sus Costos de Producción?");
        preguntaUtilSingle.setId(6l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Conoce usted su Punto de Equilibrio?");
        preguntaUtilSingle.setId(7l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Conoce usted su Nivel de Deuda?");
        preguntaUtilSingle.setId(8l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(economia);
        economia.getQuestions().add(preguntaUtilSingle);

        Topic produccion = new Topic(cuestionario);
        produccion.setId(2l);
        produccion.setTittle("Producción");
        produccion.setQuestionary(cuestionario);
        cuestionario.getTopics().add(produccion);

        preguntaUtilSingle = new SingleOptionQuestion("¿Conoce su capacidad de producción?");
        preguntaUtilSingle.setId(9l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(produccion);
        economia.getQuestions().add(preguntaUtilSingle);

        OpenTextQuestion preguntaUtilAbierta = new OpenTextQuestion("¿Su producto o servicio pertenece a que sector o actividad?");
        preguntaUtilAbierta.setId(10l);
        preguntaUtilAbierta.setTopic(produccion);
        produccion.addQuestion(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("¿Con cuantas sucursales cuenta su negocio?");
        preguntaUtilAbierta.setId(11l);
        preguntaUtilAbierta.setTopic(produccion);
        produccion.addQuestion(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("¿Con qué sistema de control de inventarios cuenta su negocio?");
        preguntaUtilAbierta.setId(12l);
        preguntaUtilAbierta.setTopic(produccion);
        produccion.addQuestion(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("¿Cuáles son sus principales materias primas?");
        preguntaUtilAbierta.setId(13l);
        preguntaUtilAbierta.setTopic(produccion);
        produccion.addQuestion(preguntaUtilAbierta);

        Topic comercial = new Topic(cuestionario);
        comercial.setId(3l);
        comercial.setQuestionary(cuestionario);
        comercial.setTittle("Comercial");
        cuestionario.getTopics().add(comercial);

        preguntaUtilSingle = new SingleOptionQuestion("¿Conoce como puede ser proveedor del Gobierno?");
        preguntaUtilSingle.setId(14l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuentan con identidad corporativa?");
        preguntaUtilSingle.setId(15l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuentan con diseño de marca?");
        preguntaUtilSingle.setId(16l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilAbierta = new OpenTextQuestion("¿Quienes son sus principales proveedores?");
        preguntaUtilAbierta.setId(17l);
        preguntaUtilAbierta.setTopic(comercial);
        comercial.addQuestion(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("¿Tiene proveedores de outsourcing?");
        preguntaUtilAbierta.setId(18l);
        preguntaUtilAbierta.setTopic(comercial);
        comercial.addQuestion(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("¿Quiénes son sus distribuidores?");
        preguntaUtilAbierta.setId(19l);
        preguntaUtilAbierta.setTopic(comercial);
        comercial.addQuestion(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("¿Quiénes son sus principales clientes?");
        preguntaUtilAbierta.setId(20l);
        preguntaUtilAbierta.setTopic(comercial);
        comercial.addQuestion(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("¿Quiénes son sus principales competidores?");
        preguntaUtilAbierta.setId(21l);
        preguntaUtilAbierta.setTopic(comercial);
        comercial.addQuestion(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("¿Cuales son sus principales productos o servicios?");
        preguntaUtilAbierta.setId(22l);
        preguntaUtilAbierta.setTopic(comercial);
        comercial.addQuestion(preguntaUtilAbierta);

        preguntaUtilSingle = new SingleOptionQuestion("¿Tiene exportaciones?");
        preguntaUtilSingle.setId(23l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Tiene importaciones?");
        preguntaUtilSingle.setId(24l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuentan con una estrategia de marketing digital?");
        preguntaUtilSingle.setId(25l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        MultipleOptionQuestion preguntaUtilMultiple = new MultipleOptionQuestion("¿En que redes sociales tienen presencia?");
        preguntaUtilMultiple.setId(26l);
        preguntaUtilMultiple.addPossibleOptions("Facebook");
        preguntaUtilMultiple.addPossibleOptions("Twitter");
        preguntaUtilMultiple.addPossibleOptions("Youtube");
        preguntaUtilMultiple.addPossibleOptions("Ninguna");
        preguntaUtilMultiple.setTopic(comercial);
        comercial.addQuestion(preguntaUtilMultiple);

        preguntaUtilSingle = new SingleOptionQuestion("¿Realiza compras por Internet?");
        preguntaUtilSingle.setId(27l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Utiliza algún servicio de envío?");
        preguntaUtilSingle.setId(28l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Realiza publicidad del negocio?");
        preguntaUtilSingle.setId(29l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Realiza promociones del producto o servicio?");
        preguntaUtilSingle.setId(30l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilMultiple = new MultipleOptionQuestion("¿En que redes sociales tienen presencia?");
        preguntaUtilMultiple.setId(31l);
        preguntaUtilMultiple.addPossibleOptions("Código de Barras");
        preguntaUtilMultiple.addPossibleOptions("Registro de marca");
        preguntaUtilMultiple.addPossibleOptions("Patente");
        preguntaUtilMultiple.addPossibleOptions("Envase y Embalaje");
        preguntaUtilMultiple.addPossibleOptions("Normatividad de etiquetado");
        preguntaUtilMultiple.addPossibleOptions("Otro");
        preguntaUtilMultiple.setTopic(comercial);
        comercial.addQuestion(preguntaUtilMultiple);

        preguntaUtilSingle = new SingleOptionQuestion("La comercialización de su producto o servicio es:");
        preguntaUtilSingle.setId(32l);
        preguntaUtilSingle.getPossibleOptions().add("Local");
        preguntaUtilSingle.getPossibleOptions().add("Estatal");
        preguntaUtilSingle.getPossibleOptions().add("Nacional");
        preguntaUtilSingle.getPossibleOptions().add("Internacional");
        preguntaUtilSingle.setTopic(comercial);
        comercial.getQuestions().add(preguntaUtilSingle);

        preguntaUtilMultiple = new MultipleOptionQuestion("Seleccione los factores que conozca de su negocio:");
        preguntaUtilMultiple.setId(33l);
        preguntaUtilMultiple.addPossibleOptions("Producto");
        preguntaUtilMultiple.addPossibleOptions("Mercado");
        preguntaUtilMultiple.addPossibleOptions("Competencia");
        preguntaUtilMultiple.addPossibleOptions("Necesidades de Mercado");
        preguntaUtilMultiple.addPossibleOptions("Nivel de Satisfacción del Cliente");
        preguntaUtilMultiple.setTopic(comercial);
        comercial.addQuestion(preguntaUtilMultiple);

        Topic innovacionTecnologia = new Topic(cuestionario);
        innovacionTecnologia.setId(4l);
        innovacionTecnologia.setQuestionary(cuestionario);
        innovacionTecnologia.setTittle("Innovación/Tecnología");
        cuestionario.getTopics().add(innovacionTecnologia);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuenta con alguna patente?");
        preguntaUtilSingle.setId(34l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(innovacionTecnologia);
        innovacionTecnologia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Su empresa realiza actividades de investigación y desarrollo?");
        preguntaUtilSingle.setId(35l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(innovacionTecnologia);
        innovacionTecnologia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("Escolaridad máxima de los empleados del negocio");
        preguntaUtilSingle.setId(36l);
        preguntaUtilSingle.getPossibleOptions().add("Ninguna");
        preguntaUtilSingle.getPossibleOptions().add("Primaria");
        preguntaUtilSingle.getPossibleOptions().add("Secundaria");
        preguntaUtilSingle.getPossibleOptions().add("Bachillerato");
        preguntaUtilSingle.getPossibleOptions().add("Licenciatura");
        preguntaUtilSingle.getPossibleOptions().add("Posgrado");
        preguntaUtilSingle.setTopic(innovacionTecnologia);
        innovacionTecnologia.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("La empresa está comprometida con el diseño, desarrollo y producción de nuevos productos y/o procesos de fabricación innovadores, a través de la aplicación sistemática de conocimientos técnicos y científicos");
        preguntaUtilSingle.setId(37l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(innovacionTecnologia);
        innovacionTecnologia.getQuestions().add(preguntaUtilSingle);

        Topic administracion = new Topic(cuestionario);
        administracion.setId(5l);
        administracion.setQuestionary(cuestionario);
        administracion.setTittle("Administración");
        cuestionario.getTopics().add(administracion);

        preguntaUtilSingle = new SingleOptionQuestion("¿Es una empresa familiar?");
        preguntaUtilSingle.setId(38l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuénta su empresa con misión y visión?");
        preguntaUtilSingle.setId(39l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Tiene manual de procedimientos?");
        preguntaUtilSingle.setId(40l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Tiene manual de organización?");
        preguntaUtilSingle.setId(41l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuenta con un plan de crecimiento para su empresa?");
        preguntaUtilSingle.setId(42l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilMultiple = new MultipleOptionQuestion("Cuales son sus alternativas para su crecimiento?");
        preguntaUtilMultiple.setId(43l);
        preguntaUtilMultiple.addPossibleOptions("Ampliar mercado");
        preguntaUtilMultiple.addPossibleOptions("Innovación e producto");
        preguntaUtilMultiple.addPossibleOptions("Finaciamiento");
        preguntaUtilMultiple.setTopic(administracion);
        preguntaUtilMultiple.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilMultiple);

        preguntaUtilSingle = new SingleOptionQuestion("¿Tiene procedimientos para contratar a su personal?");
        preguntaUtilSingle.setId(44l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Su empresa cuenta con un programa de capacitación?");
        preguntaUtilSingle.setId(45l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilAbierta = new OpenTextQuestion("¿Con que institución?");
        preguntaUtilAbierta.setId(46l);
        preguntaUtilAbierta.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilAbierta);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuenta con una tarjeta de crédito corporativa?");
        preguntaUtilSingle.setId(47l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Se empresa cuenta con algún crédito Financiero?");
        preguntaUtilSingle.setId(48l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("Indique si el propietario o directora de la empresa es mujer");
        preguntaUtilSingle.setId(49l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("Esta Empresa ocupa personal con discapacidad");
        preguntaUtilSingle.setId(50l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("Seleccione el rango de Ventas (Valor de las ventas anuales totales (mdp)) o capture el monto de las ventas (exprese la cantidad en millones de pesos)");
        preguntaUtilSingle.setId(51l);
        preguntaUtilSingle.getPossibleOptions().add("Hasta $4");
        preguntaUtilSingle.getPossibleOptions().add("Entre $4 y $50");
        preguntaUtilSingle.getPossibleOptions().add("Más de $50");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        preguntaUtilAbierta = new OpenTextQuestion("Asesoría o vinculación /programas de emprendimiento /Formacion de capital humano");
        preguntaUtilAbierta.setId(52l);
        preguntaUtilAbierta.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilAbierta);

        preguntaUtilAbierta = new OpenTextQuestion("Número de empleados Indígenas");
        preguntaUtilAbierta.setId(53l);
        preguntaUtilAbierta.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilAbierta);

        preguntaUtilSingle = new SingleOptionQuestion("Estatus Legal");
        preguntaUtilSingle.setId(54l);
        preguntaUtilSingle.getPossibleOptions().add("Persona Física");
        preguntaUtilSingle.getPossibleOptions().add("Persona Moral");
        preguntaUtilSingle.getPossibleOptions().add("No Registrada");
        preguntaUtilSingle.setTopic(administracion);
        administracion.getQuestions().add(preguntaUtilSingle);

        Topic ti = new Topic(cuestionario);
        ti.setId(6l);
        ti.setQuestionary(cuestionario);
        ti.setTittle("TI");
        cuestionario.getTopics().add(ti);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuénta con computadoras en su negocio?");
        preguntaUtilSingle.setId(55l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuenta con conexión a internet en su empresa?");
        preguntaUtilSingle.setId(56l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuentan con algún sistema que les ayude a predecir la demanda de sus productos?");
        preguntaUtilSingle.setId(57l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuenta con herramientas administrativas de colaboración? (por ejemplo: Google docs, Microsoft 360)");
        preguntaUtilSingle.setId(58l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuentan con una tienda en línea?");
        preguntaUtilSingle.setId(59l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuentan con algún sistema que les ayude a registrar - controlar la logística de la empresa (tiempos de producción, fallas en máquinas, producción esperada vs real)");
        preguntaUtilSingle.setId(60l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Realizan algún seguimiento auxiliado por recursos tecnológicos de los cambios en su mercado real - potencial? (Búsquedas en internet, seguimiento de bolsas de valores, etc)");
        preguntaUtilSingle.setId(61l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilAbierta = new OpenTextQuestion("¿Realizan algún seguimiento auxiliado por recursos tecnológicos de los cambios en su mercado real - potencial? (Búsquedas en internet, seguimiento de bolsas de valores, etc)");
        preguntaUtilAbierta.setId(62l);
        preguntaUtilAbierta.setTopic(ti);
        ti.getQuestions().add(preguntaUtilAbierta);

        preguntaUtilSingle = new SingleOptionQuestion("¿Con cuantas línas telefónicas cuenta?");
        preguntaUtilSingle.setId(63l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuenta con un sistema de cobro/pago digital?");
        preguntaUtilSingle.setId(64l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilSingle = new SingleOptionQuestion("¿Cuenta con herremientas de administración de correo electrónico?");
        preguntaUtilSingle.setId(65l);
        preguntaUtilSingle.getPossibleOptions().add("Si");
        preguntaUtilSingle.getPossibleOptions().add("No");
        preguntaUtilSingle.setTopic(ti);
        ti.getQuestions().add(preguntaUtilSingle);

        preguntaUtilAbierta = new OpenTextQuestion("¿Cuentan con sitio web? proporcione el URL");
        preguntaUtilAbierta.setId(66l);
        preguntaUtilAbierta.setTopic(ti);
        ti.getQuestions().add(preguntaUtilAbierta);

        EconomicUnit economicUnit = new EconomicUnit();
        economicUnit.setD_llave(666);
        economicUnit.setNom_estab("Camisas finas pachuca");
        economicUnit.getQuestionnaries().add(cuestionario);
        cuestionario.getEconomicUnits().add(economicUnit);

        Cuestionario c = new Cuestionario(cuestionario);
        c.getTemas();

        qp.persist(cuestionario);

    }



    @Test
    public void simpleTest(){
        Questionary q = new Questionary();
        q.setTittle("Prueba cuestionario 23:00");
        Topic topic = new Topic(q);
        topic.setTittle("Prueba 23:00");
        q.getTopics().add(topic);

        OpenTextQuestion preguntaUtilAbierta = new OpenTextQuestion("¿Quiénes son sus principales clientes? 1");
        //preguntaUtilAbierta.setId(20l);
        //preguntaUtilAbierta.setTopic(topic);
        topic.getQuestions().add(preguntaUtilAbierta );

        preguntaUtilAbierta = new OpenTextQuestion("¿Quiénes son sus principales clientes? 2");
        //preguntaUtilAbierta.setId(21l);
        //preguntaUtilAbierta.setTopic(topic);
        topic.getQuestions().add(preguntaUtilAbierta );

        /*
        EconomicUnit economicUnit = new EconomicUnit();
        economicUnit.setNom_estab("Telas Junco");
        economicUnit.getQuestionnaries().add(q);
        q.getEconomicUnits().add(economicUnit);
*/

        qp.persist(q);
    }

/*
    @Test
    public void deleteAllTest(){
        qp.deleteAllPersisted();
    }
*/

}
