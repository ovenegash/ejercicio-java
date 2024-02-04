
# 💻 Prueba técnica "Registro de Usuarios" 

Guia de despliegue:
- Java 17
- Spring boot 2.7
- Base de datos: h2
- Apache Maven 3.8.8

## Paso  a paso
1. Importar proyecto al IDE de preferencia.
2. Por consola del IDE, posicionarte en la carpete del proyecto.
3. Ejecutar el siguiente comando:  ```mvn clean install ```
4. Luego ejecutar app con el comando:  ```mvn spring-boot:run```
5. Una vez iniciado la app, puede acceder a su SWAGGER: [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

## Base de datos
Para efectos de Base de datos (H2) non fue necesario generar un SCRIPT de creacion de BBDD, ya que este se crea con las anotaciones @Entity. 

Podemos acceder a su consola desde el siguiente link:

 - [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Modificamos los datos de url y de usuario/contraseña:
- Driver Class = org.h2.Driver
- JDBC URL = "jdbc:h2:mem:evaluationbd"
- User Name = sa
- Password = password
