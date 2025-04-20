# 🏬 Sistema de Centro Comercial con Microservicios y APIs

## 🚀 Descripción

Este proyecto es un **Sistema de Centro Comercial** que utiliza una arquitectura basada en **microservicios** y **APIs RESTful** para gestionar diversos aspectos del centro comercial, como la gestión de tiendas, productos, inventarios, ventas y usuarios. Los microservicios se comunican entre sí a través de APIs, lo que permite escalabilidad, flexibilidad y facilidad de mantenimiento.

### **Características principales**:
- Gestión de **tiendas**: Añadir, editar, eliminar tiendas dentro del centro comercial.
- Gestión de **productos**: Administración de productos por tienda, con detalles como nombre, descripción, precio y cantidad disponible.
- **Inventario**: Seguimiento de los productos disponibles y notificación de stock bajo.
- **Ventas**: Registro de ventas.
- **Usuarios**: Administración de usuarios (clientes, empleados, administradores).

---
## 🛠️ Tecnologías Utilizadas

- Java 17

- Spring Boot

- Spring Data MongoDB

- Thymeleaf

- Bootstrap

- Maven

- Docker 

---

## 📋 Servicios Disponibles
1. Store Service API
- GET /stores: Lista todas las tiendas.

- POST /stores: Crea una nueva tienda.

- GET /stores/{id}: Obtiene los detalles de una tienda específica.

- PUT /stores/{id}: Actualiza los datos de una tienda.

- DELETE /stores/{id}: Elimina una tienda.

2. Product Service API
- GET /products: Lista todos los productos.

- POST /products: Crea un nuevo producto.

- GET /products/{id}: Obtiene detalles de un producto.

- PUT /products/{id}: Actualiza un producto.

- DELETE /products/{id}: Elimina un producto.

3. User Service API
- POST /users/login: Autenticación de usuarios.

- POST /users/register: Registro de nuevos usuarios.

- GET /users/{id}: Obtiene detalles de un usuario.

---

## 🏗️ Estructura del Proyecto

```plaintext
src
└── main
    ├── java
    │   └── com
    │       └── CComercial
    │           └── app
    │               ├── controller              # Controladores del sistema
    │               ├── exception               # Clases para manejo de excepciones
    │               ├── repository              # Interfaces de acceso a datos (JPA)
    │               ├── variables               # Clases de constantes y utilidades
    │               └── CComercialApplication.java  # Clase principal de arranque
    └── resources
        ├── application.properties             # Configuración del proyecto
        └── (otros recursos: templates, static, etc.)
```
---

## ⚙️ Configuración de la base de datos

Este proyecto utiliza **MongoDB** como base de datos. En tu `application.properties`:

```properties
# URI de conexión a MongoDB (puede ser local o remoto)
spring.data.mongodb.uri=mongodb://<usuario>:<password>@localhost:8013/<nombreDeTuBase>

# Opciones adicionales (opcional)
spring.data.mongodb.database=<nombreDeTuBase>
spring.data.mongodb.authentication-database=admin
spring.h2.console.enabled=true

```
---

## 🚀 ¿Cómo ejecutar el proyecto?
Pasos claros para ejecutar el proyecto localmente:

1. Clonar el repositorio.

2. Abrirlo en SpringBoot.

3. Configura la base de datos.

4. Ejecutar los micorservicios.

5. Accede a la aplicacion: http://localhost:8013
   
---

## 📋 Funcionalidades por Microservicio

| Microservicio | Funcionalidad |
|---------------|---------------|
| Store Service | Gestión de tiendas dentro del centro comercial|
| Product Service | Gestión de productos y su asociación con las tiendas |
| Sales Service | Registro de ventas |
| User Service | Autenticación y gestión de usuarios (clientes, empleados, admin) |

---

## 📌 Estado del Proyecto

✅ Proyecto finalizado

El sistema de centro comercial basado en microservicios y MongoDB ha sido completamente desarrollado. Incluye:

- Módulos independientes para distintas entidades del sistema
- Integración con base de datos MongoDB
- Exposición de servicios RESTful a través de APIs
- Manejo de errores y excepciones
- Arquitectura limpia y desacoplada basada en buenas prácticas de microservicios

✅ Proyecto desplegado

