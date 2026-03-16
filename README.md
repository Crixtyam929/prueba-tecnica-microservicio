# Microservicio de Gestión de Pedidos - Tienda

## Descripción

Este proyecto consiste en un microservicio REST desarrollado con **Java
y Spring Boot** para la gestión de pedidos de una tienda.

El sistema permite administrar:

-   Clientes
-   Productos
-   Pedidos

El microservicio implementa reglas de negocio como validación de
clientes existentes, control de stock y cálculo automático del total del
pedido.

Este proyecto fue desarrollado como parte de una **prueba técnica para
desarrollador Java Junior**.

------------------------------------------------------------------------

# Tecnologías utilizadas

-   Java 17
-   Spring Boot
-   Spring Data JPA
-   MySQL
-   Maven
-   Docker
-   Docker Compose
-   Postman

------------------------------------------------------------------------

# Arquitectura del proyecto

El proyecto sigue una arquitectura por capas:

controller → exposición de endpoints REST\
service → lógica de negocio\
repository → acceso a datos con JPA\
entity → modelos de base de datos\
dto → objetos de transferencia de datos\
exception → manejo global de excepciones

------------------------------------------------------------------------

# Modelo de Datos

### Cliente

-   id
-   nombre
-   email
-   telefono

### Producto

-   id
-   nombre
-   precio
-   stock

### Pedido

-   id
-   fecha
-   cliente_id
-   total

### DetallePedido

-   id
-   pedido_id
-   producto_id
-   cantidad
-   precio

------------------------------------------------------------------------

# Reglas de negocio implementadas

-   No se puede crear un pedido si el cliente no existe
-   No se puede crear un pedido si no hay stock suficiente
-   El total del pedido se calcula automáticamente
-   Al crear un pedido se descuenta el stock del producto

------------------------------------------------------------------------

# Endpoints REST

## Clientes

### Crear cliente

POST /clientes

### Listar clientes

GET /clientes

### Obtener cliente por ID

GET /clientes/{id}

------------------------------------------------------------------------

## Productos

### Crear producto

POST /productos

### Listar productos

GET /productos

### Obtener producto por ID

GET /productos/{id}

------------------------------------------------------------------------

## Pedidos

### Crear pedido

POST /pedidos

### Listar pedidos

GET /pedidos

### Obtener pedido por ID

GET /pedidos/{id}

------------------------------------------------------------------------

# Ejecución del proyecto

## Requisitos

-   Java 17
-   Maven
-   Docker
-   Docker Compose

------------------------------------------------------------------------

# Ejecutar con Docker (recomendado)

Desde la raíz del proyecto ejecutar:

docker compose up --build

Esto levantará automáticamente:

-   MySQL
-   Microservicio Spring Boot

La API quedará disponible en:

http://localhost:8080

------------------------------------------------------------------------

# Base de datos

La base de datos utilizada es:

tienda_db

Docker creará automáticamente el contenedor de MySQL.

------------------------------------------------------------------------

# Pruebas de la API

El repositorio incluye una **colección de Postman** que permite probar
fácilmente todos los endpoints del microservicio.

Ubicación dentro del proyecto:

tienda\Postman\API Tienda - Prueba Técnica.postman_collection.json

## Cómo usar la colección

1.  Abrir **Postman**
2.  Seleccionar **Import**
3.  Importar el archivo:

API Tienda - Prueba Técnica.postman_collection.json

4.  Ejecutar las peticiones en el siguiente orden recomendado:

-   Crear cliente
-   Crear producto
-   Listar productos
-   Crear pedido
-   Listar pedidos

Esto permite validar correctamente el flujo completo del sistema.

------------------------------------------------------------------------

# Manejo de errores

El proyecto implementa **manejo global de excepciones** utilizando:

@ControllerAdvice

Esto permite devolver respuestas HTTP estructuradas cuando ocurre un
error.

Ejemplo:

{ "mensaje": "Cliente no encontrado", "status": 404, "timestamp":
"2026-03-15T20:00:00" }
------------------------------------------------------------------------

# Autor

Cristian Andres Agudelo Henao

Tecnólogo En Desarrollo De Software - ITM
Técnico En Diseño e Integración Multimedia - SENA
