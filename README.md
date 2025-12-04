# ProyectoPOO
Proyecto de programacion orientada a objetos hecho en base a centralizar diferentes funciones de la universidad en un solo programa, utilizando interfaces graficas como JFrame

## Modelo de Datos

El sistema utiliza dos bases de datos SQLite locales para separar responsabilidades:

1.  **usuarios.db**: Almacena la información personal y credenciales.
    * Tabla `usuarios`: `id`, `password`, `nombre`, `apellido`, `edad`, `genero`.
2.  **tarjetas.db**: Simula la entidad bancaria o de control de accesos.
    * Tabla `tarjetas`: `id_usuario`, `numero`, `expiracion`, `cvc`.

## Herramientas Utilizadas

* **Interfaz Gráfica:** Java Swing (JFrame/JPanel).
* **Base de Datos:** SQLite (Persistencia de datos local).
* **Librerías Externas:**
    * `ZXing` (Core & JavaSE): Para la generación de códigos QR de acceso.
    * `JCalendar`: Para la selección de fechas en el módulo de Gimnasio.
    * `JUnit 4`: Para pruebas unitarias y validación de lógica.
    * `SQLite JDBC`: Driver de conexión a base de datos.

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
  
## Pruebas Unitarias (Testing)

Para garantizar la robustez del código y la lógica de negocio, se implementaron pruebas unitarias utilizando el framework **JUnit 4**.

### Cobertura de Pruebas
Los tests se encuentran en la carpeta `src` y cubren los siguientes módulos críticos:

* **`TestGimnasio.java`**:
    * Verifica la lógica de acceso de usuarios al gimnasio, siendo esto el formato de hora y fecha validos
* **`TestPago.java`**:
    * Prueba la validación de tarjetas y métodos de pago.
* **`TestMenuComedor.java`**:
    * Comprueba la correcta selección de menús y la validación de opciones disponibles.
* **`TestTransporte.java`**:
    * Valida la asignación y selección de rutas de transporte.

### Cómo ejecutar las pruebas

Las pruebas deben ejecutarse desde el IDE:

1.  **En Visual Studio Code:**
    * Asegúrese de que las librerías `junit-4.13.2.jar` y `hamcrest-core-1.3.jar` (ubicadas en `/lib`) estén agregadas a las *Referenced Libraries*.
    * Abra cualquiera de los archivos `.java` mencionados arriba.
    * Haga clic en el botón **Run Test** (o el icono de "Play" verde) que aparece al lado de la definición de la clase o de cada método `@Test`.
    * Alternativamente, vaya a la pestaña de "Testing" (icono del matraz) en la barra lateral para correr todas las pruebas juntas.

## Cómo Ejecutar

Una vez configuradas las librerías:

1.  Ubique el archivo principal: `src/App.java`.
2.  Ejecute el archivo como **Java Application**.
3.  Se abrirá la ventana de selección de usuario (Estudiante, Profesor, Trabajador, Externo).
    
## Credenciales de Prueba

Para probar la funcionalidad del sistema, puede utilizar el siguiente usuario en el panel de Login, seleccionando `Estudiante` entre las 4 opciones:

* **ID Usuario:** `173876`
* **Contraseña:** `1234`

> **Nota:** La base de datos `usuarios.db` incluye además 100 usuarios generados aleatoriamente para pruebas de carga y validación.

## Manual de Uso Rápido

* **Login:** Valida las credenciales contra `usuarios.db`.
* **Comedor:** Permite seleccionar elementos para un menu estudiantil, pagar con tarjeta o cargar al usuario.
* **Gimnasio:** Control de acceso mediante validación de ID, reservando con una fecha y hora.
* **Transporte:** Módulo para gestión de rutas, compra de boleto y consulta de datos.

## Autores - Equipo 02

* **Gustavo Alejandro Moreno Torres**
* **Rodolfo Tlelo Manzano**
* **Rashid Manzur Rodriguez**
* **Miguel Efrain Gutiérrez Medina**

Universidad de las Américas Puebla (UDLAP) - Otoño 2024
