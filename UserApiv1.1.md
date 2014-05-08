## ICVT User API  V1.1

El Api user permite hacer altas, bajas, consultas y login para usuarios.

## Login
Login permite verificar si un usuario pertenece al sistema.

#### Url del recurso
**POST** http://infra1.cloudapp.net:8080/front-1.0-SNAPSHOT/api/v1/user/login


 
#### Parámetros POST

```
identity="test@api.com"
password="lamisma00"
```

#### HTML form

```
<input type="text" name="identity" />
<input type="text" name="password" />

```

#### Ejemplo de la petición

```
curl -X POST  --data "identity=test@api.com&password=lamisma00"  http://infra1.cloudapp.net:8080/front-1.0-SNAPSHOT/api/v1/user/login
```


Si todos los datos enviados, superan todas las pruebas de validación, recibiremos una respuesta tipo **JSON** con el id de usuario y su access_token para acceder a todos los metodos authorizados cabe mencionar que la llave **role_social_id** pertenece a los roles de la plataforma social y la llave **role_site_id** pertenece a la plataforma ICVT.

```
{
    "data": {
        "id": 6,
        "access_token": "CAclx2JI7od3yfl1odFB",
        "role_site_id": 1,
        "role_social_id": 1,
        "status": 1,
        "unidad_economica_id": 1453,
        "identity": "test@api.com",
        "name": "Jair",
        "avatar": "http://lols.com/img.com",
        "first_name": "Peña",
        "last_name": "Trejo",
        "phone": "5544963762"
    },
    "errors": null
}

```

El API valida los datos enviados, basándose en las reglas de negocio para cada uno definidas, si hay algun error nos enviara un **JSON** con todos los errores.

Tipo de respuesta  **JSON** :

Error de authorización

```
{
    "data": null,
    "errors": {
               "message": "user or password not valid",
    		  }
}
```


