
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

## Base de datos
Para efectos de Base de datos, esta es creada por las entidades almacenadas en el codigo, al ser una BBDD en H2, podemos acceder a su consola desde el siguiente link:

 - [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Modificamos los datos de url y de usuario/contraseña:
- Driver Class = org.h2.Driver
- JDBC URL = "jdbc:h2:mem:evaluationbd"
- User Name = sa
- Password = password
