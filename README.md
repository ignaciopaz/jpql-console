# UTN FRRO - Asignatura: Diseño de Sistemas.
# jpql-console
Aplicación para hacer consultas JPQL sobre un modelo de clases existente.
Online: https://jpql-console.herokuapp.com/jpql/console
## Correr la aplicación
Para ejecutar la aplicación:
1. Terminar cualquier aplicación que esté corriendo dentro de Eclipse.
2. Ir al Paquete edu.utn.frro.ds.jpql.
3. Clic derecho en **Application.java** y hacer **Run as Java Application**.
4. Abrir el browser en [http://localhost:8080/](http://localhost:8080/)

## Como ver la base de datos H2
Para ver la consola de la base de datos [H2](http://www.h2database.com/) de la aplicación:
1. En el brower ir a: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. En **"JDBC URL"** ingresar: **jdbc:h2:mem:testdb**
3. Clic en **"Connect"**
