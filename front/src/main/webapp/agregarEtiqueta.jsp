<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Agregar etiqueta a noticia</title>
    </head>
    <body>
        <h2>Agregar etiqueta a noticia</h2>

        <form action="modificarNoticia" method="post">
            <label>Id noticia:
                <input type="text" name="idNoticia"/>
            </label>
            <label>Id etiqueta:
                <input type="text" name="idEtiqueta"/>
            </label>
            <input type="hidden" name="action" value="agregaEtiqueta"/>
            <input type="submit"/>
        </form>
    </body>
</html>