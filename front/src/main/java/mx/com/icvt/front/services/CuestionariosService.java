package mx.com.icvt.front.services;

import mx.com.icvt.front.presenters.cuestionarios.Cuestionario;
import mx.com.icvt.front.presenters.cuestionarios.CuestionariosAgrupados;
import mx.com.icvt.front.presenters.cuestionarios.Pregunta;
import mx.com.icvt.front.presenters.cuestionarios.Tema;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by miguelangeldelatorre on 15/05/14.
 */
@Path("/cuestionarios")
public class CuestionariosService {

    @POST
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public CuestionariosAgrupados getCuestionario(@FormParam("unidadEconomicaId") long unidadEconomicaId) {
        //TODO Quitar la implementación Dummy por la real.

        CuestionariosAgrupados retorno = new CuestionariosAgrupados();
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setId(1l);
        cuestionario.setTitulo("Cuestionario Inicial");

        Tema economia = new Tema();
        economia.setId(1l);
        economia.setTitulo("Economía");
        cuestionario.getTemas().add(economia);

        Pregunta preguntaUtil = new Pregunta();
        preguntaUtil.setId(1l);
        preguntaUtil.setTextoPregunta("¿Cónoce el significado de los principales indicadores económicos de su industria?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        economia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(2l);
        preguntaUtil.setTextoPregunta("¿Ha solicitado apoyo económico del gobierno para su empresa?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        economia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(3l);
        preguntaUtil.setTextoPregunta("Clasificación por tamaño");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Micro");
        preguntaUtil.getOpcionesPosibles().add("Pequeña");
        preguntaUtil.getOpcionesPosibles().add("Mediana");
        preguntaUtil.getOpcionesPosibles().add("Grande");
        economia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(4l);
        preguntaUtil.setTextoPregunta("¿En qué tipo de noticias de la industria está interesado?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Negocios");
        preguntaUtil.getOpcionesPosibles().add("Tecnología");
        preguntaUtil.getOpcionesPosibles().add("Acerca de sus clietes");
        economia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(5l);
        preguntaUtil.setTextoPregunta("En que áreas de la empresa tiene dificultades para su desarrollo económico");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Administración");
        preguntaUtil.getOpcionesPosibles().add("Finanzas");
        preguntaUtil.getOpcionesPosibles().add("Producción");
        preguntaUtil.getOpcionesPosibles().add("Legal");
        preguntaUtil.getOpcionesPosibles().add("Ventas");
        preguntaUtil.getOpcionesPosibles().add("Mercadotecnia");
        preguntaUtil.getOpcionesPosibles().add("Asesoría fiscal");
        economia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(6l);
        preguntaUtil.setTextoPregunta("¿Conoce usted sus Costos de Producción?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        economia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(7l);
        preguntaUtil.setTextoPregunta("¿Conoce usted su Punto de Equilibrio?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        economia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(8l);
        preguntaUtil.setTextoPregunta("¿Conoce usted su Nivel de Deuda?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        economia.getPreguntas().add(preguntaUtil);

        Tema produccion = new Tema();
        produccion.setId(2l);
        produccion.setTitulo("Producción");
        cuestionario.getTemas().add(produccion);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(9l);
        preguntaUtil.setTextoPregunta("¿Conoce su capacidad de producción?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        produccion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(10l);
        preguntaUtil.setTextoPregunta("¿Su producto o servicio pertenece a que sector o actividad?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        produccion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(11l);
        preguntaUtil.setTextoPregunta("¿Con cuantas sucursales cuenta su negocio?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        produccion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(12l);
        preguntaUtil.setTextoPregunta("¿Con qué sistema de control de inventarios cuenta su negocio?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        produccion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(13l);
        preguntaUtil.setTextoPregunta("¿Cuáles son sus principales materias primas?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        produccion.getPreguntas().add(preguntaUtil);

        Tema comercial = new Tema();
        comercial.setId(3l);
        comercial.setTitulo("Comercial");
        cuestionario.getTemas().add(comercial);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(14l);
        preguntaUtil.setTextoPregunta("¿Conoce como puede ser proveedor del Gobierno?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(15l);
        preguntaUtil.setTextoPregunta("¿Cuentan con identidad corporativa?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(16l);
        preguntaUtil.setTextoPregunta("¿Cuentan con diseño de marca?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(17l);
        preguntaUtil.setTextoPregunta("¿Quienes son sus principales proveedores?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(18l);
        preguntaUtil.setTextoPregunta("¿Tiene proveedores de outsourcing?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(19l);
        preguntaUtil.setTextoPregunta("¿Quiénes son sus distribuidores?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(20l);
        preguntaUtil.setTextoPregunta("¿Quiénes son sus principales clientes?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(21l);
        preguntaUtil.setTextoPregunta("¿Quiénes son sus principales competidores?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(22l);
        preguntaUtil.setTextoPregunta("¿Cuales son sus principales productos o servicios?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(23l);
        preguntaUtil.setTextoPregunta("¿Tiene exportaciones?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(24l);
        preguntaUtil.setTextoPregunta("¿Tiene importaciones?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(25l);
        preguntaUtil.setTextoPregunta("¿Cuentan con una estrategia de marketing digital?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(26l);
        preguntaUtil.setTextoPregunta("¿En que redes sociales tienen presencia?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONMULTIPLE);
        preguntaUtil.getOpcionesPosibles().add("Facebook");
        preguntaUtil.getOpcionesPosibles().add("Twitter");
        preguntaUtil.getOpcionesPosibles().add("Youtube");
        preguntaUtil.getOpcionesPosibles().add("Ninguna");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(27l);
        preguntaUtil.setTextoPregunta("¿Realiza compras por Internet?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(28l);
        preguntaUtil.setTextoPregunta("¿Utiliza algún servicio de envío?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(29l);
        preguntaUtil.setTextoPregunta("¿Realiza publicidad del negocio?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(30l);
        preguntaUtil.setTextoPregunta("¿Realiza promociones del producto o servicio?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(31l);
        preguntaUtil.setTextoPregunta("Seleccione los servicios con los que cuenta por la naturaleza de su negocio");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONMULTIPLE);
        preguntaUtil.getOpcionesPosibles().add("Código de Barras");
        preguntaUtil.getOpcionesPosibles().add("Registro de marca");
        preguntaUtil.getOpcionesPosibles().add("Patente");
        preguntaUtil.getOpcionesPosibles().add("Envase y Embalaje");
        preguntaUtil.getOpcionesPosibles().add("Normatividad de etiquetado");
        preguntaUtil.getOpcionesPosibles().add("Otro");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(31l);
        preguntaUtil.setTextoPregunta("La comercialización de su producto o servicio es:");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Local");
        preguntaUtil.getOpcionesPosibles().add("Estatal");
        preguntaUtil.getOpcionesPosibles().add("Nacional");
        preguntaUtil.getOpcionesPosibles().add("Internacional");
        comercial.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(31l);
        preguntaUtil.setTextoPregunta("Seleccione los factores que conozca de su negocio:");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONMULTIPLE);
        preguntaUtil.getOpcionesPosibles().add("Producto");
        preguntaUtil.getOpcionesPosibles().add("Mercado");
        preguntaUtil.getOpcionesPosibles().add("Competencia");
        preguntaUtil.getOpcionesPosibles().add("Necesidades de Mercado");
        preguntaUtil.getOpcionesPosibles().add("Nivel de Satisfacción del Cliente");
        comercial.getPreguntas().add(preguntaUtil);

        Tema innovacionTecnologia = new Tema();
        comercial.setId(4l);
        comercial.setTitulo("Innovación/Tecnología");
        cuestionario.getTemas().add(innovacionTecnologia);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(32l);
        preguntaUtil.setTextoPregunta("¿Cuenta con alguna patente?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        innovacionTecnologia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(33l);
        preguntaUtil.setTextoPregunta("¿Su empresa realiza actividades de investigación y desarrollo?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        innovacionTecnologia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(34l);
        preguntaUtil.setTextoPregunta("Escolaridad máxima de los empleados del negocio");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Ninguna");
        preguntaUtil.getOpcionesPosibles().add("Primaria");
        preguntaUtil.getOpcionesPosibles().add("Secundaria");
        preguntaUtil.getOpcionesPosibles().add("Bachillerato");
        preguntaUtil.getOpcionesPosibles().add("Licenciatura");
        preguntaUtil.getOpcionesPosibles().add("Posgrado");
        innovacionTecnologia.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(35l);
        preguntaUtil.setTextoPregunta("La empresa está comprometida con el diseño, desarrollo y producción de nuevos productos y/o procesos de fabricación innovadores, a través de la aplicación sistemática de conocimientos técnicos y científicos");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        innovacionTecnologia.getPreguntas().add(preguntaUtil);

        Tema administracion = new Tema();
        comercial.setId(5l);
        comercial.setTitulo("Administración");
        cuestionario.getTemas().add(administracion);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(36l);
        preguntaUtil.setTextoPregunta("¿Es una empresa familiar?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(37l);
        preguntaUtil.setTextoPregunta("¿Cuénta su empresa con misión y visión?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(38l);
        preguntaUtil.setTextoPregunta("¿Tiene manual de procedimientos?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(39l);
        preguntaUtil.setTextoPregunta("¿Tiene manual de organización?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(40l);
        preguntaUtil.setTextoPregunta("¿Cuenta con un plan de crecimiento para su empresa?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(41l);
        preguntaUtil.setTextoPregunta("¿Cuales son sus alternativas para su crecimiento?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONMULTIPLE);
        preguntaUtil.getOpcionesPosibles().add("Ampliar mercado");
        preguntaUtil.getOpcionesPosibles().add("Innovación e producto");
        preguntaUtil.getOpcionesPosibles().add("Finaciamiento");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(42l);
        preguntaUtil.setTextoPregunta("¿Tiene procedimientos para contratar a su personal?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(43l);
        preguntaUtil.setTextoPregunta("¿Su empresa cuenta con un programa de capacitación?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(44l);
        preguntaUtil.setTextoPregunta("¿Con que institución?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(45l);
        preguntaUtil.setTextoPregunta("¿Cuenta con una tarjeta de crédito corporativa?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(46l);
        preguntaUtil.setTextoPregunta("¿Se empresa cuenta con algún crédito Financiero?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(47l);
        preguntaUtil.setTextoPregunta("Indique si el propietario o directora de la empresa es mujer");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(48l);
        preguntaUtil.setTextoPregunta("Esta Empresa ocupa personal con discapacidad");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(49l);
        preguntaUtil.setTextoPregunta("Seleccione el rango de Ventas (Valor de las ventas anuales totales (mdp)) o capture el monto de las ventas (exprese la cantidad en millones de pesos)");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Hasta $4");
        preguntaUtil.getOpcionesPosibles().add("Entre $4 y $50");
        preguntaUtil.getOpcionesPosibles().add("Más de $50");
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(50l);
        preguntaUtil.setTextoPregunta("Asesoría o vinculación /programas de emprendimiento /Formacion de capital humano");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(51l);
        preguntaUtil.setTextoPregunta("Número de empleados Indígenas");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        administracion.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(52l);
        preguntaUtil.setTextoPregunta("Estatus Legal");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Persona Física");
        preguntaUtil.getOpcionesPosibles().add("Persona MORAL");
        preguntaUtil.getOpcionesPosibles().add("No Registrada");
        administracion.getPreguntas().add(preguntaUtil);

        Tema ti = new Tema();
        comercial.setId(6l);
        comercial.setTitulo("TI");
        cuestionario.getTemas().add(ti);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(53l);
        preguntaUtil.setTextoPregunta("¿Cuénta con computadoras en su negocio?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(54l);
        preguntaUtil.setTextoPregunta("¿Cuenta con conexión a internet en su empresa?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(55l);
        preguntaUtil.setTextoPregunta("¿Cuentan con algún sistema que les ayude a predecir la demanda de sus productos?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(56l);
        preguntaUtil.setTextoPregunta("¿Cuenta con herramientas administrativas de colaboración? (por ejemplo: Google docs, Microsoft 360) ");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(57l);
        preguntaUtil.setTextoPregunta("¿Cuentan con una tienda en línea?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(58l);
        preguntaUtil.setTextoPregunta("¿Cuentan con algún sistema que les ayude a registrar - controlar la logística de la empresa (tiempos de producción, fallas en máquinas, producción esperada vs real)");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(59l);
        preguntaUtil.setTextoPregunta("¿Realizan algún seguimiento auxiliado por recursos tecnológicos de los cambios en su mercado real - potencial? (Búsquedas en internet, seguimiento de bolsas de valores, etc)");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(60l);
        preguntaUtil.setTextoPregunta("¿Con cuantas línas telefónicas cuenta?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(61l);
        preguntaUtil.setTextoPregunta("¿Cuenta con un sistema de cobro/pago digital?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(62l);
        preguntaUtil.setTextoPregunta("¿Cuenta con herremientas de administración de correo electrónico?");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.OPCIONUNICA);
        preguntaUtil.getOpcionesPosibles().add("Si");
        preguntaUtil.getOpcionesPosibles().add("No");
        ti.getPreguntas().add(preguntaUtil);

        preguntaUtil = new Pregunta();
        preguntaUtil.setId(63l);
        preguntaUtil.setTextoPregunta("¿Cuentan con sitio web? proporcione el URL");
        preguntaUtil.setTipoDePregunta(Pregunta.TipoDePregunta.PREGUNTAABIERTA);
        ti.getPreguntas().add(preguntaUtil);

        retorno.getCuestionarios().add(cuestionario);
        return retorno;
    }

}
