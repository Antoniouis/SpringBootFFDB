# SpringBootFFDB


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

# Autor

Proyecto desarrollado con Spring Boot para la gestión empresarial.
