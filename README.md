# Sistema de Inteligencia Competitiva y Vigilacia tecnológica 

### Construcción:
**Dependencias:** 
		maven (3.x+)

**Comando:** En el directorio raíz del proyecto

```
maven clean install (-DskipTests) 

```			
La opción **-DskipTests** se usa si se quiere evitar correr las pruebas de unidad.

### Instalando Maven

* Descargar Maven Liga para la versión 3.2.1: http://apache.webxcreen.org/maven/maven-3/3.2.1/binaries/apache-maven-3.2.1-bin.zip

* Descomprimir en el directorio de su preferencia (pe. Downloads)

* (Opcional) Copiar o mover el contenido a una carpeta de su preferencia 
		Por ejemplo, se puede usar la carpeta /usr/local/maven
		Para copiar el contenido de la carpeta descomprimida a la carpeta /usr/local/maven Ejecutar

  ```		
    sudo cp -r carpetaDondeSeDescomprimioMaven /usr/local/maven
  ```

* **Agregar variables de entorno** para indicar la ruta dónde queda instalado Maven. Por ejemplo, si se copió la carpeta a /usr/local/maven, se agregaran las variables*

	``` 
			M2_HOME=/usr/local/maven
			M2=/usr/local/maven/bin o M2=$M2_HOME/bin
	```

En OS X, se pueden agregar las variables de entorno agregando las siguiente líneas al archivo **.profile** del home del usuario

```
			export M2_HOME=/usr/local/maven
			export M2=$M2_HOME/bin
			export PATH=$PATH:$M2
```


**Nota:** Si el archivo .profile no existe se puede crear en la consola ubicándose en la carpeta home y ejecutando: touch .profile
Para que las variables de entorno sean leídas por la terminal basta con cerrarla y volverla a abrir o ejecutar el comando:
source ~/.profile

De preferencia se debe tener establecida la variable de entorno JAVA_HOME. En caso de que no se tenga, seguir el mismo procedimiento
que para agregar M2_HOME y M2. 
La ubicación del JDK 1.6 en OS X es usualmente /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/
En caso de tener instalado JDK 1.7.x en OS X éste normalmente está en /Library/Java/JavaVirtualMachines/jdk1.7.0_x.jdk/Contents/Home/	