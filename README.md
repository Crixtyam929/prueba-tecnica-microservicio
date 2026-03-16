# Microservicio de Gestión de Pedidos - Tienda

## Descripción

Este proyecto corresponde a una prueba técnica para el desarrollo de un microservicio REST utilizando Java, Spring Boot, Spring Data JPA y MySQL.
El sistema permite gestionar clientes, productos y pedidos, aplicando validaciones, manejo de errores y buenas prácticas en el diseño de la API.

Este proyecto fue desarrollado como parte de una **prueba técnica para
desarrollador Java Junior**.

------------------------------------------------------------------------

## Tecnologías utilizadas

-   Java 17
-   Spring Boot
-   Spring Web
-   Spring Data JPA
-   MySQL
-   Maven
-   Docker
-   Lombok
-   Jakarta Validation

------------------------------------------------------------------------

## Funcionalidades implementadas

### Clientes

-   Crear cliente
-   Listar clientes
-   Obtener cliente por id

### Productos

-   Crear producto
-   Listar productos
-   Obtener producto por id

### Pedidos

-   Crear pedido
-   Listar pedidos
-   Obtener pedido por id
------------------------------------------------------------------------
## Reglas de negocio

El sistema implementa las siguientes validaciones:

-   No se puede crear un pedido si el cliente no existe.
-   No se puede crear un pedido si no hay stock suficiente.
-   El total del pedido se calcula automáticamente.
-   Al crear un pedido se descuenta el stock del producto.
------------------------------------------------------------------------

## Arquitectura del proyecto

La aplicación sigue una arquitectura por capas:

    controller
    service
    repository
    entity
    dto
    exception

Flujo de la aplicación:

    Controller → DTO → Service → Entity → Repository → Base de datos

Se utilizan **DTOs** para evitar exponer directamente las entidades en
los endpoints.

------------------------------------------------------------------------

## Manejo de errores

Se implementa un `GlobalExceptionHandler` para centralizar el manejo de
errores.

Tipos de errores manejados:

-   **400 Bad Request**
    -   errores de validación
    -   reglas de negocio (por ejemplo stock insuficiente)
-   **404 Not Found**
    -   recurso no encontrado (cliente, producto o pedido)
-   **500 Internal Server Error**
    -   errores no controlados

------------------------------------------------------------------------

## Base de datos

Base de datos sugerida:

    tienda_db

Configuración en `application.properties`:

    spring.datasource.url=jdbc:mysql://localhost:3306/tienda_db
    spring.datasource.username=root
    spring.datasource.password=****
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

### Modelo de Datos

#### Cliente

-   id
-   nombre
-   email
-   telefono

#### Producto

-   id
-   nombre
-   precio
-   stock

#### Pedido

-   id
-   fecha
-   cliente_id
-   total

#### DetallePedido

-   id
-   pedido_id
-   producto_id
-   cantidad
-   precio

------------------------------------------------------------------------

## Endpoints REST

### Clientes

#### Crear cliente

    POST /clientes

#### Listar clientes

    GET /clientes

#### Obtener cliente por ID

    GET /clientes/{id}

------------------------------------------------------------------------

### Productos

#### Crear producto

    POST /productos

#### Listar productos

    GET /productos

#### Obtener producto por ID

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

## Ejecución del proyecto

### 1. Clonar el repositorio

    git clone <url-del-repositorio>

### 2. Configurar la base de datos MySQL

Crear la base de datos:

    CREATE DATABASE tienda_db;

### 3. Ejecutar la aplicación

Con Maven:

    mvn spring-boot:run

La API estará disponible en:

    http://localhost:8080

------------------------------------------------------------------------

## Ejecutar con Docker (recomendado)

Desde la raíz del proyecto ejecutar:

docker compose up --build

Esto levantará automáticamente:

-   MySQL
-   Microservicio Spring Boot

La API estará disponible en:

    http://localhost:8080

------------------------------------------------------------------------

## Pruebas de la API

El repositorio incluye una **colección de Postman** que permite probar
fácilmente todos los endpoints del microservicio.

Ubicación dentro del proyecto:

    Postman\API Tienda - Prueba Técnica.postman_collection.json



### Cómo usar la colección

1.  Abrir **Postman**
2.  Seleccionar **Import**
3.  Importar la colección:

Archivo de colección:

    API Tienda - Prueba Técnica.postman_collection.json

4.  Ejecutar las peticiones en el siguiente orden recomendado:

-   Crear cliente
-   Crear producto
-   Listar productos
-   Crear pedido
-   Listar pedidos

Esto permite validar correctamente el flujo completo del sistema.


------------------------------------------------------------------------

## Autor

Cristian Andres Agudelo Henao

Tecnólogo En Desarrollo De Software - ITM
