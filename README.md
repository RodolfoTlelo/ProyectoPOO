# ProyectoPOO
Proyecto de programacion orientada a objetos hecho en base a centralizar diferentes funciones de la universidad en un solo programa, utilizando interfaces graficas como JFrame

## Modelo de Datos

El sistema utiliza dos bases de datos SQLite locales para separar responsabilidades:

1.  **usuarios.db**: Almacena la información personal y credenciales.
    * Tabla `usuarios`: `id`, `password`, `nombre`, `apellido`, `edad`, `genero`.
2.  **tarjetas.db**: Simula la entidad bancaria o de control de accesos.
    * Tabla `tarjetas`: `id_usuario`, `numero`, `expiracion`, `cvc`.

## Configuración de Librerías (Importante)

Este proyecto no utiliza gestores de dependencias como Maven o Gradle, por lo que las librerías se gestionan manualmente.

**Para evitar errores de compilación ("package does not exist"):**

1.  Asegúrese de que su IDE (VS Code, IntelliJ, NetBeans, etc.) reconozca los archivos `.jar` ubicados en la carpeta **/lib**.
2.  **En VS Code:**
    * Vaya al apartado "Java Projects" en la barra lateral.
    * Busque "Referenced Libraries".
    * Haga clic en el botón `+` y seleccione todos los archivos `.jar` dentro de la carpeta `lib` del proyecto.
3.  **En IntelliJ IDEA:**
    * Vaya a `File` > `Project Structure` > `Modules`.
    * En la pestaña `Dependencies`, añada los JARs de la carpeta `lib`.
4.  **En NetBeans:**
    * Haga clic derecho en el proyecto > `Properties`.
    * En `Libraries`, añada los JARs al "Compile-time libraries".

## Credenciales de Prueba

Para probar la funcionalidad del sistema, puede utilizar el siguiente usuario en el panel de Login, seleccionando `Estudiante` entre las 4 opciones:

* **ID Usuario:** `173876`
* **Contraseña:** `1234`

> **Nota:** La base de datos `usuarios.db` incluye además 100 usuarios generados aleatoriamente para pruebas de carga y validación.
