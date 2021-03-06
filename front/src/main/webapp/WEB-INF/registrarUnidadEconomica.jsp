<%@ page import="java.util.List" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>SITE</title>
        <meta name="description" content="">
        <!-- link(rel='shortcut icon', href='favicon.ico')-->
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="bower_components/fontawesome/css/font-awesome.min.css">
        <!-- pickadate-->
        <link rel="stylesheet" href="bower_components/pickadate/lib/compressed/themes/default.css">
        <link rel="stylesheet" href="bower_components/pickadate/lib/compressed/themes/default.date.css">
        <!-- fancybox-->
        <link rel="stylesheet" href="css/fancybox.css">
        <!-- google maps-->
        <script type="text/javascript"
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAUBFh3N56APo7c_AdXB2k9AJjiTG_2faY&amp;sensor=FALSE"></script>
        <%
            if (request.getAttribute("exito") != null) {
                boolean exito = (Boolean) request.getAttribute("exito");
                if (exito) {
        %>
            <script type="text/javascript">
                window.onload = function(){
                    alert('Unidad econ\u00f3mica registrada exitosamente');
                }
            </script>
        <%
                }
            }
        %>
    </head>
    <body>
        <div class="main-wrapper">
            <header class="main-header">
                <div class="main-logo"><a href="index.html">site</a></div>
            </header>
            <label for="activate-menu" class="btn-alpha btn-activate-menu"><i class="fa fa-bars"></i>Menú</label>
            <label for="activate-notification" class="btn-alpha btn-activate-notification"><i class="fa fa-bell-o"></i>Alertas<span
                    class="count">2</span></label>
            <input type="checkbox" id="activate-menu" class="activate-menu">
            <input type="checkbox" id="activate-notification" class="activate-notification">
            <nav class="main-nav">
                <ul class="nav-listing">
                    <li><a href="index.html"><span class="icon"></span><span class="tag">Dashboard de inicio</span></a>
                    </li>
                    <li><a href="actualidad.html"><span class="icon"></span><span
                            class="tag">Actualidad de la industria</span></a></li>
                    <li><a href="question.html"><span class="icon"></span><span class="tag">Perfil</span></a></li>
                    <li><a href="alerts.html"><span class="icon"></span><span class="tag">Alertas y notifiaciones</span></a>
                    </li>
                    <li><a href="ic.html"><span class="icon"></span><span class="tag">Inteligencia comercial</span></a>
                    </li>
                    <li><a href="#"><span class="icon"></span><span class="tag">Inteligencia social</span></a></li>
                </ul>
            </nav>
            <section class="main-container">
                <div class="main-container-overlay js-main-container-overlay"></div>
                <div class="panel-title">
                    <div class="container">
                        <h1>Registro de Unidad Económica</h1>
                    </div>
                </div>
                <div class="panel-question-bar">
                    <div class="container">
                        <div class="half">
                            <div class="left"><br></div>
                            <div class="right">
                                <button type="submit" class="btn"><i class='fa fa-save'></i> Guardar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-signup">
                    <div class="container">
                        <form action="unidadEconomica" method="post" class="form">
                            <fieldset>
                                <legend>Información de la empresa</legend>
                                <dl class="question">
                                    <dt>
                                        <label>Nombre de la Unidad Económica:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="nombre">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Razón social:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="razonSocial">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Código de la clase de actividad SCIAN:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="claseActividad">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Personal ocupado:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-select">
                                                <select name="segmentoPersonalOcupado">
                                                    <option disabled selected>Seleciona el personal ocupado en la
                                                        empresa
                                                    </option>
                                                    <option value="1">0 a 5 personas</option>
                                                    <option value="2">6 a 10 personas</option>
                                                    <option value="3">11 a 30 personas</option>
                                                    <option value="4">31 a 50 personas</option>
                                                    <option value="5">51 a 100 personas</option>
                                                    <option value="6">101 a 250 personas</option>
                                                    <option value="7">251 y más personas</option>
                                                </select>
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                            </fieldset>
                            <fieldset>
                                <legend>Dirección / Ubicación</legend>
                                <dl class="question">
                                    <dt>
                                        <label>Calle:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="calle">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Número exterior:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="numeroExterior">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Número interior:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="numeroInterior">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Colonia:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="colonia">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Municipio:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-select">
                                                <select name="municipio">
                                                    <option disabled selected>Seleciona tu municipio</option>
                                                    <option value="1">Acatlán</option>
                                                    <option value="2">Acaxochitlán</option>
                                                    <option value="3">Actopan</option>
                                                    <option value="4">Agua Blanca de Iturbide</option>
                                                    <option value="5">Ajacuba</option>
                                                    <option value="6">Alfajayucan</option>
                                                    <option value="7">Almoloya</option>
                                                    <option value="8">Apan</option>
                                                    <option value="9">El Arenal</option>
                                                    <option value="10">Atitalaquia</option>
                                                    <option value="11">Atlapexco</option>
                                                    <option value="12">Atotonilco el Grande</option>
                                                    <option value="13">Atotonilco de Tula</option>
                                                    <option value="14">Calnali</option>
                                                    <option value="15">Cardonal</option>
                                                    <option value="16">Cuautepec de Hinojosa</option>
                                                    <option value="17">Chapantongo</option>
                                                    <option value="18">Chapulhuacán</option>
                                                    <option value="19">Chilcuautla</option>
                                                    <option value="20">Eloxochitlán</option>
                                                    <option value="21">Emiliano Zapata</option>
                                                    <option value="22">Epazoyucan</option>
                                                    <option value="23">Francisco I. Madero</option>
                                                    <option value="24">Huasca de Ocampo</option>
                                                    <option value="25">Huautla</option>
                                                    <option value="26">Huazalingo</option>
                                                    <option value="27">Huehuetla</option>
                                                    <option value="28">Huejutla de Reyes</option>
                                                    <option value="29">Huichapan</option>
                                                    <option value="30">Ixmiquilpan</option>
                                                    <option value="31">Jacala de Ledezma</option>
                                                    <option value="32">Jaltocán</option>
                                                    <option value="33">Juárez Hidalgo</option>
                                                    <option value="34">Lolotla</option>
                                                    <option value="35">Metepec</option>
                                                    <option value="36">San Agustín Metzquititlán</option>
                                                    <option value="37">Metztitlán</option>
                                                    <option value="38">Mineral del Chico</option>
                                                    <option value="39">Mineral del Monte</option>
                                                    <option value="40">La Misión</option>
                                                    <option value="41">Mixquiahuala de Juárez</option>
                                                    <option value="42">Molango de Escamilla</option>
                                                    <option value="43">Nicolás Flores</option>
                                                    <option value="44">Nopala de Villagrán</option>
                                                    <option value="45">Omitlán de Juárez</option>
                                                    <option value="46">San Felipe Orizatlán</option>
                                                    <option value="47">Pacula</option>
                                                    <option value="48">Pachuca de Soto</option>
                                                    <option value="49">Pisaflores</option>
                                                    <option value="50">Progreso de Obregón</option>
                                                    <option value="51">Mineral de la Reforma</option>
                                                    <option value="52">San Agustín Tlaxiaca</option>
                                                    <option value="53">San Bartolo Tutotepec</option>
                                                    <option value="54">San Salvador</option>
                                                    <option value="55">Santiago de Anaya</option>
                                                    <option value="56">Santiago Tulantepec de Lugo Guerrero</option>
                                                    <option value="57">Singuilucan</option>
                                                    <option value="58">Tasquillo</option>
                                                    <option value="59">Tecozautla</option>
                                                    <option value="60">Tenango de Doria</option>
                                                    <option value="61">Tepeapulco</option>
                                                    <option value="62">Tepehuacán de Guerrero</option>
                                                    <option value="63">Tepeji del Río de Ocampo</option>
                                                    <option value="64">Tepetitlán</option>
                                                    <option value="65">Tetepango</option>
                                                    <option value="66">Villa de Tezontepec</option>
                                                    <option value="67">Tezontepec de Aldama</option>
                                                    <option value="68">Tianguistengo</option>
                                                    <option value="69">Tizayuca</option>
                                                    <option value="70">Tlahuelilpan</option>
                                                    <option value="71">Tlahuiltepa</option>
                                                    <option value="72">Tlanalapa</option>
                                                    <option value="73">Tlanchinol</option>
                                                    <option value="74">Tlaxcoapan</option>
                                                    <option value="75">Tolcayuca</option>
                                                    <option value="76">Tula de Allende</option>
                                                    <option value="77">Tulancingo de Bravo</option>
                                                    <option value="78">Xochiatipan</option>
                                                    <option value="79">Xochicoatlán</option>
                                                    <option value="80">Yahualica</option>
                                                    <option value="81">Zacualtipán de Ángeles</option>
                                                    <option value="82">Zapotlán de Juárez</option>
                                                    <option value="83">Zempoala</option>
                                                    <option value="84">Zimapán</option>
                                                </select>
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Código Postal</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="codigoPostal">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Latitud:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="latitud">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Longitud:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="longitud">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                            </fieldset>
                            <fieldset>
                                <legend>Datos de contacto</legend>
                                <dl class="question">
                                    <dt>
                                        <label>Nombre del representante:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="nombreRepresentante">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Teléfono:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="telefono">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Extensión:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="extension">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Correo electrónico:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="correo">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Sitio web:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="url">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Facebook:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="facebook">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                                <dl class="question">
                                    <dt>
                                        <label>Twitter:</label>
                                    </dt>
                                    <dd class="answers">
                                        <ul>
                                            <li class="input-text">
                                                <input type="text" name="twitter">
                                            </li>
                                        </ul>
                                    </dd>
                                </dl>
                            </fieldset>
                            <%
                                if (request.getAttribute("errores") != null) {
                                    List<String> errores = (List<String>) request.getAttribute("errores");
                                    if (!errores.isEmpty()) {
                            %>
                            <div class="error">
                                <%
                                    for (String error : errores) {
                                %>
                                <span><%= error%></span>
                                <%
                                    }
                                %>
                            </div>
                            <%
                                    }
                                }
                            %>
                            <div class="action">
                                <div class="half">
                                    <div class="left"><br></div>
                                    <div class="right">
                                        <button type="submit" class="btn"><i class='fa fa-save'></i> Guardar</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
            <aside class="main-notification">
                <div class="action"><a href="alerts.html" class="btn-outline">Ver todas <i
                        class='fa fa-chevron-right'></i></a></div>
                <div class="alert-listing-aside">
                    <ul>
                        <li class="selected"><a href="alerts.html">Se espera un incremento del 5% en los costos de
                            manufactura en la región.</a></li>
                        <li class="new"><a href="alerts-view.html">Congreso de la industria textil 2014.</a></li>
                        <li class="new"><a href="alerts.html">Propuesta de nueva ley en materia de comercio exterior
                            podría beneficiar al sector textil en el norte</a></li>
                        <li><a href="alerts.html">Taller gratuito de tecnologías de la información para PyMES.</a></li>
                        <li><a href="alerts.html">La importancia de tener un sitio web para la promoción de tus
                            servicios a nivel global.</a></li>
                    </ul>
                </div>
            </aside>
        </div>
        <script src="bower_components/jquery/dist/jquery.js"></script>
        <script src="bower_components/chartjs/Chart.min.js"></script>
        <script src="bower_components/pickadate/lib/compressed/picker.js"></script>
        <script src="bower_components/pickadate/lib/compressed/picker.date.js"></script>
        <script src="bower_components/pickadate/lib/compressed/translations/es_ES.js"></script>
        <script src="js/jquery.fancybox.pack.js"></script>
        <script src="js/scripts.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/controllers.js"></script>
    </body>
</html>