# SpringBootFFDB
# Índice

1. [SpringBootFFDB](#springbootffdb)
2. [Despliegue y Estructura del Proyecto](#despliegue-y-estructura-del-proyecto)
3. [Descripción General](#descripción-general)
4. [Requisitos Previos](#requisitos-previos)
5. [Clonar el Proyecto](#clonar-el-proyecto)
6. [Configuración de MySQL](#configuración-de-mysql)

   * [Crear Base de Datos](#crear-base-de-datos)
7. [Configuración del application.properties](#configuración-del-applicationproperties)
8. [Compilar el Proyecto](#compilar-el-proyecto)
9. [Iniciar la Aplicación](#iniciar-la-aplicación)

   * [Opción 1 - Desde Maven](#opción-1---desde-maven)
   * [Opción 2 - Ejecutar el JAR](#opción-2---ejecutar-el-jar)
10. [Verificar que la Aplicación Funciona](#verificar-que-la-aplicación-funciona)
11. [URL Base de la API](#url-base-de-la-api)
12. [Probar la API con Postman](#probar-la-api-con-postman)
13. [Estructura del Proyecto](#estructura-del-proyecto)
14. [Explicación de Carpetas](#explicación-de-carpetas)

    * [config](#config)
    * [Controladores](#controladores)
    * [Dominos](#dominos)
    * [Repositorios](#repositorios)
    * [Servicios](#servicios)
15. [Arquitectura de la Aplicación](#arquitectura-de-la-aplicación)
16. [Flujo de Funcionamiento](#flujo-de-funcionamiento)
17. [Posibles Errores](#posibles-errores)

    * [Error de conexión con MySQL](#error-de-conexión-con-mysql)
    * [Puerto ocupado](#puerto-ocupado)
18. [Detener la Aplicación](#detener-la-aplicación)
19. [Manual de Uso](#manual-de-uso)
20. [API REST - Gestión Empresarial](#api-rest---gestión-empresarial)
21. [Configuración Base](#configuración-base)
22. [Tecnologías Utilizadas](#tecnologías-utilizadas)
23. [Uso de la API con Postman](#uso-de-la-api-con-postman)
24. [API Clientes](#api-clientes)

    * [Crear Cliente](#crear-cliente)
    * [Listar Clientes](#listar-clientes)
    * [Buscar Cliente por ID](#buscar-cliente-por-id)
    * [Actualizar Cliente](#actualizar-cliente)
    * [Eliminar Cliente](#eliminar-cliente)
25. [API Empleados](#api-empleados)

    * [Crear Empleado](#crear-empleado)
    * [Listar Empleados](#listar-empleados)
    * [Buscar Empleado por ID](#buscar-empleado-por-id)
    * [Actualizar Empleado](#actualizar-empleado)
    * [Eliminar Empleado](#eliminar-empleado)
26. [API Proyectos](#api-proyectos)

    * [Crear Proyecto](#crear-proyecto)
    * [Listar Proyectos](#listar-proyectos)
    * [Buscar Proyecto por ID](#buscar-proyecto-por-id)
    * [Actualizar Proyecto](#actualizar-proyecto)
    * [Eliminar Proyecto](#eliminar-proyecto)
27. [API Tareas](#api-tareas)

    * [Crear Tarea](#crear-tarea)
    * [Listar Tareas](#listar-tareas)
    * [Buscar Tarea por ID](#buscar-tarea-por-id)
    * [Actualizar Tarea](#actualizar-tarea)
    * [Eliminar Tarea](#eliminar-tarea)
28. [Códigos HTTP Utilizados](#códigos-http-utilizados)
29. [Pruebas y Testing](#pruebas-y-testing)
30. [Autor](#autor)

# Despliegue y Estructura del Proyecto

# Descripción General

Esta aplicación está desarrollada con:

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

La API permite gestionar:

* Clientes
* Empleados
* Proyectos
* Tareas

La aplicación expone endpoints REST que pueden probarse mediante:

* Postman
* cURL
* Navegador web (GET)
* Insomnia

---

# Requisitos Previos

Antes de ejecutar la aplicación es necesario instalar:

| Herramienta | Versión Recomendada |
| ----------- | ------------------- |
| Java JDK    | 17 o superior       |
| Maven       | 3.8+                |
| MySQL       | 8+                  |
| Git         | Última versión      |
| Postman     | Opcional            |

---

# Clonar el Proyecto

```bash id="e7jlwm"
git clone https://github.com/Antoniouis/SpringBootFFDB
```

Entrar en la carpeta del proyecto:

```bash id="h92kzl"
cd SpringBootFFDB
```

---

# Configuración de MySQL

## Crear Base de Datos

Abrir MySQL y ejecutar:

```sql id="0xqj7v"
CREATE DATABASE empresa_db;
```

---

# Configuración del application.properties

Ruta:

```text id="jlwm84"
src/main/resources/application.properties
```

Configurar:

```properties id="p6s9yy"
spring.datasource.url=jdbc:mysql://localhost:3306/empresa_db
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8095
```

---

# Compilar el Proyecto

Desde la raíz del proyecto ejecutar:

```bash id="jlwm2u"
mvn clean install
```

---

# Iniciar la Aplicación

## Opción 1 - Desde Maven

Ejecutar:

```bash id="jlwm6v"
mvn spring-boot:run
```

---

## Opción 2 - Ejecutar el JAR

Generar el archivo JAR:

```bash id="jlwm4n"
mvn clean package
```

Ejecutar:

```bash id="jlwm7m"
java -jar target/nombre-app.jar
```

---

# Verificar que la Aplicación Funciona

Si todo funciona correctamente aparecerá algo parecido a:

```text id="jlwm8b"
Tomcat started on port(s): 8095 (http)
Started ProyectoIntermodularBddApplication
```

---

# URL Base de la API

```http id="jlwm5y"
http://localhost:8095
```

---

# Probar la API con Postman

## Ejemplo GET

```http id="jlwm3f"
GET http://localhost:8095/empresa/clientes/listar
```

---

## Ejemplo POST

```http id="jlwm1a"
POST http://localhost:8095/empresa/clientes/crear
```

Body JSON:

```json id="jlwm9u"
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan@email.com",
  "telefono": "666555444"
}
```

---

# Estructura del Proyecto

```text id="jlwm0p"
src
└── main
    ├── java
    │   └── Proyecto_Intermodular_BDD
    │       ├── config
    │       │   └── DataLoader
    │       │
    │       ├── Controladores
    │       │   ├── ClienteController
    │       │   ├── EmpleadosController
    │       │   ├── ProyectoController
    │       │   └── TareaController
    │       │
    │       ├── Dominos
    │       │   ├── Cliente
    │       │   ├── Empleado
    │       │   ├── Proyecto
    │       │   └── Tarea
    │       │
    │       ├── Repositorios
    │       │   ├── ClienteRepository
    │       │   ├── EmpleadoRepository
    │       │   ├── ProyectoRepository
    │       │   └── TareaRepository
    │       │
    │       ├── Servicios
    │       │   ├── ClienteService
    │       │   ├── EmpleadoService
    │       │   ├── ProyectoService
    │       │   └── TareaService
    │       │
    │       └── ProyectoIntermodularBddApplication
    │
    └── resources
        └── application.properties
```

---

# Explicación de Carpetas

## config

Contiene configuraciones generales de la aplicación.

### DataLoader

Carga datos iniciales automáticamente al iniciar Spring Boot.

---

## Controladores

Gestionan las peticiones HTTP REST.

| Controlador         | Función           |
| ------------------- | ----------------- |
| ClienteController   | CRUD de clientes  |
| EmpleadosController | CRUD de empleados |
| ProyectoController  | CRUD de proyectos |
| TareaController     | CRUD de tareas    |

---

## Dominos

Contiene las entidades del sistema.

Cada clase representa una tabla de la base de datos.

---

## Repositorios

Gestionan el acceso a la base de datos mediante Spring Data JPA.

Permiten:

* Guardar datos
* Buscar registros
* Actualizar información
* Eliminar registros

---

## Servicios

Contienen la lógica de negocio.

Actúan como intermediarios entre:

```text id="jlwm5k"
Controladores → Servicios → Repositorios
```

---

# Arquitectura de la Aplicación

```text id="jlwm6o"
Cliente HTTP
      ↓
Controladores REST
      ↓
Servicios
      ↓
Repositorios JPA
      ↓
Base de Datos MySQL
```

---

# Flujo de Funcionamiento

1. El cliente realiza una petición HTTP.
2. El controlador recibe la petición.
3. El servicio procesa la lógica.
4. El repositorio interactúa con MySQL.
5. Spring Boot devuelve la respuesta JSON.

---

# Posibles Errores

## Error de conexión con MySQL

Verificar:

* MySQL iniciado
* Usuario correcto
* Contraseña correcta
* Base de datos creada

---

## Puerto ocupado

Cambiar:

```properties id="jlwm4r"
server.port=8095
```

---

# Detener la Aplicación

En la terminal:

```text id="jlwm7s"
CTRL + C
```

---

# Autor

Antonio Luis Martos Angulo

---

# Manual de Uso

La aplicación puede utilizarse mediante Postman realizando peticiones HTTP a los distintos endpoints disponibles.

Pasos básicos de uso:

1. Iniciar la aplicación Spring Boot.
2. Abrir Postman.
3. Seleccionar el método HTTP:

   * GET
   * POST
   * PUT
   * DELETE
4. Introducir la URL del endpoint.
5. Para POST y PUT:

   * Ir a `Body`
   * Seleccionar `raw`
   * Elegir `JSON`
6. Enviar la petición.
7. Verificar la respuesta JSON recibida desde la API.

Ejemplo:

```http id="jlwm9x"
POST http://localhost:8095/empresa/clientes/crear
```

```json id="jlwm2z"
{
  "nombre": "Antonio",
  "apellido": "Martos",
  "email": "antonio@email.com",
  "telefono": "600123456"
}
```


# API REST - Gestión Empresarial

API desarrollada con Spring Boot para la gestión de:

* Clientes
* Empleados
* Proyectos
* Tareas

---

# Configuración Base

## Puerto del Servidor

La aplicación se ejecuta en el puerto:

```properties
server.port=8095
```

---

# URL Base

```http
http://localhost:8095
```

---

# Tecnologías Utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Maven
* Postman

---

# Uso de la API con Postman

1. Abrir Postman.
2. Seleccionar el método HTTP correspondiente (`GET`, `POST`, `PUT`, `DELETE`).
3. Introducir la URL del endpoint.
4. En peticiones `POST` y `PUT`:

   * Ir a la pestaña `Body`
   * Seleccionar `raw`
   * Elegir `JSON`
5. Enviar la petición.

---

# API Clientes

## Ruta Base

```http
/empresa/clientes
```

---

## Crear Cliente

### Endpoint

```http
POST http://localhost:8095/empresa/clientes/crear
```

### Body JSON

```json
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan@email.com",
  "telefono": "666555444"
}
```

### cURL

```bash
curl -X POST http://localhost:8095/empresa/clientes/crear \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan@email.com",
  "telefono": "666555444"
}'
```

---

## Listar Clientes

### Endpoint

```http
GET http://localhost:8095/empresa/clientes/listar
```

### cURL

```bash
curl -X GET http://localhost:8095/empresa/clientes/listar
```

---

## Buscar Cliente por ID

### Endpoint

```http
GET http://localhost:8095/empresa/clientes/buscar/1
```

### cURL

```bash
curl -X GET http://localhost:8095/empresa/clientes/buscar/1
```

---

## Actualizar Cliente

### Endpoint

```http
PUT http://localhost:8095/empresa/clientes/actualizar/1
```

### Body JSON

```json
{
  "nombre": "Juan Actualizado",
  "apellido": "Pérez",
  "email": "nuevo@email.com",
  "telefono": "600111222"
}
```

### cURL

```bash
curl -X PUT http://localhost:8095/empresa/clientes/actualizar/1 \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Juan Actualizado",
  "apellido": "Pérez",
  "email": "nuevo@email.com",
  "telefono": "600111222"
}'
```

---

## Eliminar Cliente

### Endpoint

```http
DELETE http://localhost:8095/empresa/clientes/borrar/1
```

### cURL

```bash
curl -X DELETE http://localhost:8095/empresa/clientes/borrar/1
```

---

# API Empleados

## Ruta Base

```http
/empresa/empleados
```

---

## Crear Empleado

### Endpoint

```http
POST http://localhost:8095/empresa/empleados/crear
```

### Body JSON

```json
{
  "nombre": "Carlos",
  "apellido": "Gómez",
  "puesto": "Administrador",
  "salario": 2500
}
```

### cURL

```bash
curl -X POST http://localhost:8095/empresa/empleados/crear \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Carlos",
  "apellido": "Gómez",
  "puesto": "Administrador",
  "salario": 2500
}'
```

---

## Listar Empleados

### Endpoint

```http
GET http://localhost:8095/empresa/empleados/listar
```

### cURL

```bash
curl -X GET http://localhost:8095/empresa/empleados/listar
```

---

## Buscar Empleado por ID

### Endpoint

```http
GET http://localhost:8095/empresa/empleados/buscar/1
```

### cURL

```bash
curl -X GET http://localhost:8095/empresa/empleados/buscar/1
```

---

## Actualizar Empleado

### Endpoint

```http
PUT http://localhost:8095/empresa/empleados/actualizar/1
```

### Body JSON

```json
{
  "nombre": "Carlos Actualizado",
  "apellido": "Gómez",
  "puesto": "Gerente",
  "salario": 3200
}
```

### cURL

```bash
curl -X PUT http://localhost:8095/empresa/empleados/actualizar/1 \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Carlos Actualizado",
  "apellido": "Gómez",
  "puesto": "Gerente",
  "salario": 3200
}'
```

---

## Eliminar Empleado

### Endpoint

```http
DELETE http://localhost:8095/empresa/empleados/borrar/1
```

### cURL

```bash
curl -X DELETE http://localhost:8095/empresa/empleados/borrar/1
```

---

# API Proyectos

## Ruta Base

```http
/empresa/proyectos
```

---

## Crear Proyecto

### Endpoint

```http
POST http://localhost:8095/empresa/proyectos/crear
```

### Body JSON

```json
{
  "nombre": "Sistema ERP",
  "descripcion": "Proyecto de gestión empresarial",
  "estado": "EN_PROCESO",
  "presupuesto": 15000
}
```

### cURL

```bash
curl -X POST http://localhost:8095/empresa/proyectos/crear \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Sistema ERP",
  "descripcion": "Proyecto de gestión empresarial",
  "estado": "EN_PROCESO",
  "presupuesto": 15000
}'
```

---

## Listar Proyectos

### Endpoint

```http
GET http://localhost:8095/empresa/proyectos/listar
```

### cURL

```bash
curl -X GET http://localhost:8095/empresa/proyectos/listar
```

---

## Buscar Proyecto por ID

### Endpoint

```http
GET http://localhost:8095/empresa/proyectos/buscar/1
```

### cURL

```bash
curl -X GET http://localhost:8095/empresa/proyectos/buscar/1
```

---

## Actualizar Proyecto

### Endpoint

```http
PUT http://localhost:8095/empresa/proyectos/actualizar/1
```

### Body JSON

```json
{
  "nombre": "Sistema ERP Actualizado",
  "descripcion": "Proyecto empresarial actualizado",
  "estado": "FINALIZADO",
  "presupuesto": 20000
}
```

### cURL

```bash
curl -X PUT http://localhost:8095/empresa/proyectos/actualizar/1 \
-H "Content-Type: application/json" \
-d '{
  "nombre": "Sistema ERP Actualizado",
  "descripcion": "Proyecto empresarial actualizado",
  "estado": "FINALIZADO",
  "presupuesto": 20000
}'
```

---

## Eliminar Proyecto

### Endpoint

```http
DELETE http://localhost:8095/empresa/proyectos/borrar/1
```

### cURL

```bash
curl -X DELETE http://localhost:8095/empresa/proyectos/borrar/1
```

---

# API Tareas

## Ruta Base

```http
/empresa/tareas
```

---

## Crear Tarea

### Endpoint

```http
POST http://localhost:8095/empresa/tareas/crear
```

### Body JSON

```json
{
  "titulo": "Diseñar Base de Datos",
  "descripcion": "Crear el modelo relacional del sistema",
  "estado": "PENDIENTE",
  "prioridad": "ALTA"
}
```

### cURL

```bash
curl -X POST http://localhost:8095/empresa/tareas/crear \
-H "Content-Type: application/json" \
-d '{
  "titulo": "Diseñar Base de Datos",
  "descripcion": "Crear el modelo relacional del sistema",
  "estado": "PENDIENTE",
  "prioridad": "ALTA"
}'
```

---

## Listar Tareas

### Endpoint

```http
GET http://localhost:8095/empresa/tareas/listar
```

### cURL

```bash
curl -X GET http://localhost:8095/empresa/tareas/listar
```

---

## Buscar Tarea por ID

### Endpoint

```http
GET http://localhost:8095/empresa/tareas/buscar/1
```

### cURL

```bash
curl -X GET http://localhost:8095/empresa/tareas/buscar/1
```

---

## Actualizar Tarea

### Endpoint

```http
PUT http://localhost:8095/empresa/tareas/actualizar/1
```

### Body JSON

```json
{
  "titulo": "Diseñar API REST",
  "descripcion": "Actualizar endpoints del sistema",
  "estado": "EN_PROCESO",
  "prioridad": "MEDIA"
}
```

### cURL

```bash
curl -X PUT http://localhost:8095/empresa/tareas/actualizar/1 \
-H "Content-Type: application/json" \
-d '{
  "titulo": "Diseñar API REST",
  "descripcion": "Actualizar endpoints del sistema",
  "estado": "EN_PROCESO",
  "prioridad": "MEDIA"
}'
```

---

## Eliminar Tarea

### Endpoint

```http
DELETE http://localhost:8095/empresa/tareas/borrar/1
```

### cURL

```bash
curl -X DELETE http://localhost:8095/empresa/tareas/borrar/1
```

---

# Códigos HTTP Utilizados

| Código | Descripción           |
| ------ | --------------------- |
| 200    | OK                    |
| 201    | CREATED               |
| 400    | BAD REQUEST           |
| 404    | NOT FOUND             |
| 500    | INTERNAL SERVER ERROR |

---

 # Pruebas y Testing
# Pruebas Automatizadas de la Aplicación (JUnit 5 & Spring Boot)

Este repositorio contiene la batería de pruebas encargada de verificar la correcta comunicación entre la lógica de negocio (`ClienteService`), el repositorio de datos y la base de datos subyacente.

---

##  Qué se ha probado (Casos de Prueba)

El archivo `ProyectoIntermodularBddApplicationTests.java` incluye dos bloques de pruebas diferenciados para asegurar la calidad del software:

### 1. Pruebas Unitarias
Se han desarrollado tres escenarios aislados para verificar las funciones del servicio `ClienteService`:
* **`pruebaUno()` (Guardar cliente):** Valida que al enviar un cliente con nombre "Pepe", la aplicación lo procese correctamente y devuelva el objeto con sus datos intactos.
* **`pruebaDos()` (Listar todos):** Comprueba que la llamada para obtener el listado completo de clientes no devuelva un valor nulo, asegurando que la conexión con la tabla está activa.
* **`pruebaTres()` (Buscar por ID inexistente):** Verifica la robustez del sistema buscando un ID aleatorio que no existe (`67L`), controlando que el servicio responda devolviendo un `null` en lugar de romper la aplicación.

### 2. Prueba de Integración
* **`pruebaIntegracion()` (Flujo Completo):** Evalúa el comportamiento del sistema simulando una operación real de extremo a extremo. Crea un cliente ("Maria"), lo inserta en la base de datos para que Hibernate le asigne un ID único de forma automática, lo vuelve a buscar mediante ese ID recuperado y confirma con aserciones de JUnit que los datos persisten de manera correcta.

---

##  Cómo ejecutar las pruebas en IntelliJ IDEA

Para lanzar los casos de prueba en tu entorno local, sigue cualquiera de estos tres métodos:

### Método 1: Ejecutar toda la suite (Recomendado)
1.  Busca el archivo de pruebas en la ruta:  
    `src/test/java/Proyecto_Intermodular_BDD/ProyectoIntermodularBddApplicationTests.java`
2.  Haz clic derecho sobre el nombre del archivo en el árbol del proyecto (zona izquierda).
3.  Selecciona la opción **Run 'ProyectoIntermodularBdd...'** (icono de Play verde).
4.  Se abrirá una pestaña inferior llamada *Run* mostrando el estado en verde de los tests superados.

### Método 2: Ejecutar un test individual
Si solo quieres ejecutar la prueba de integración (`pruebaIntegracion`):
1.  Abre el archivo de código de las pruebas.
2.  Busca el método de la prueba y localiza el **icono del Play verde** pequeño que aparece justo a la izquierda de la línea `@Test`.
3.  Haz clic sobre él y selecciona **Run 'pruebaIntegracion()'**.

### Método 3: Ejecución en modo Depuración (Paso a Paso)
Para inspeccionar las variables por dentro y ver cómo se transforman los objetos en tiempo real:
1.  Haz clic en el margen izquierdo de la primera línea de `pruebaIntegracion()` para colocar un **punto de ruptura (Breakpoint)** (aparecerá un círculo rojo).
2.  Haz clic derecho sobre el método y elige la opción **Debug 'pruebaIntegracion()'** (icono del bicho verde).
3.  Cuando el programa se detenga en la línea marcada, pulsa la tecla **`F8` (Step Over)** para ir avanzando línea por línea.
4.  Revisa el panel inferior **Variables** para inspeccionar el contenido de los objetos (`cliente`, `cGuardado`, etc.).
5.  
# Autor

Proyecto desarrollado con Spring Boot para la gestión empresarial diseñado por Antonio Luis Martos Angulo .
