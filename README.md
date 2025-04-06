 # 🏁 Laboratorio JPA - Competitor

Este proyecto es parte del laboratorio de Java Persistence API (JPA), utilizando tecnologías como **Jersey**, **Jetty embebido**, **JPA con EclipseLink** y **Derby DB** para gestionar información de competidores y sus productos.

---

## 🚀 Tecnologías utilizadas

- Java JDK 1.8  
- NetBeans 8.1  
- Apache Maven 3.9.9  
- Jersey 1.8 (RESTful API)  
- Jetty embebido  
- Derby DB (conexión a `jdbc:derby://localhost:1527/sample`)  
- Postman Web + Desktop Agent (para pruebas)

---

## 📦 Funcionalidades

### 🔹 Competitors
- 📥 Registrar un competidor:  
  `POST /competitors/add`
- 🔐 Login de competidor con dirección y contraseña:  
  `POST /competitors/login`
- 🔍 Obtener lista de todos los competidores:  
  `GET /competitors/get`

### 🔹 Productos
- Relación @OneToMany desde `Competitor` hacia `Producto`
- Se crean productos asociados a un competidor y se persisten automáticamente con `CascadeType.ALL`

---

## 🔧 Relación entre entidades

### `Competitor.java`

```java
@OneToMany(mappedBy = "competitor", cascade = CascadeType.ALL)
private List<Producto> productos;

