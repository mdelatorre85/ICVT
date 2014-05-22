<%@ page import="mx.com.icvt.model.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    News noticia = (News) request.getAttribute("noticia");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Editar noticia</title>
        <style type="text/css">
            label {
                float: left;
                width: 100px;
            }

            textarea{
                width: 300px;
            }
        </style>
    </head>
    <body>
        <form action="administrarNoticias" method="post" accept-charset="utf-8">
            <div>
                <label for="titulo">Título: </label>
                <textarea name="titulo" id="titulo">
                    <%= noticia.getTitle()%>
                </textarea>
            </div>
            <div>
                <label for="descripcion">Descripción: </label>
                <textarea name="descripcion" id="descripcion">
                    <%= noticia.getDescription()%>
                </textarea>
            </div>

            <input type="hidden" name="action" value="guardarCambios"/>
            <input type="hidden" name="idNoticia" value="<%=noticia.getID()%>"/>
            <input type="submit" value="Guardar cambios"/>
        </form>
    </body>
</html>