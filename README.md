# CRMGYM - Sistema de Gestión para Gimnasios 🏋️‍♂️ (Fase 1)

**CRMGYM** es un sistema desarrollado en **Java** para modernizar la gestión de gimnasios, reemplazando métodos tradicionales como cuadernos, hojas de cálculo y WhatsApp por una solución centralizada e intuitiva. Este proyecto está diseñado en **tres fases incrementales**, y actualmente se encuentra en la **Fase 1**, que utiliza **JDBC** y **MySQL** para la gestión básica de clientes.

---

## 📌 Características Principales

- **Gestión de Clientes**:
  - Registro de clientes con datos como nombre, apellido, DNI, email, celular y estado de membresía.
  - Operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para clientes.
  - Validaciones robustas para garantizar la integridad de los datos.

- **Interfaz de Consola**:
  - Menú interactivo para realizar operaciones de manera sencilla.
  - Mensajes claros y formateados para mejorar la experiencia del usuario.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje de programación**: Java 21
- **Base de datos**: MySQL
- **Conexión a la base de datos**: JDBC
- **Control de versiones**: Git

---

## 🚀 Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes y clases principales:

### **Paquetes y Clases**

- **`model`**: Contiene las clases de modelo (entidades).
  - `Client`: Representa la entidad cliente con atributos como nombre, apellido, DNI, email, celular y estado de membresía.

- **`dao`**: Contiene las clases de acceso a datos (Data Access Object).
  - `ClientDao`: Implementa las operaciones CRUD para la entidad `Client`.
  - `IClientDao`: Interfaz que define las operaciones CRUD.

- **`service`**: Contiene la lógica de negocio.
  - `ClientService`: Gestiona las operaciones relacionadas con los clientes, como validaciones y llamadas al DAO.

- **`validations`**: Contiene clases para validaciones de datos.
  - `ClientValidation`: Valida los datos de los clientes antes de ser procesados.

- **`presentation`**: Contiene la clase principal de la aplicación.
  - `CrmGymApp`: Punto de entrada de la aplicación y menú interactivo.

- **`util`**: Contiene utilidades generales.
  - `DataBaseConnection`: Gestiona la conexión a la base de datos MySQL.

---

## 🚀 Instalación y Ejecución

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local:

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/Joni23s/CRMGYM.git
   cd CRMGYM
   ```

2. **Configura la base de datos**:
   - Crea una base de datos en MySQL llamada `crmgym_test`.
   - Importa el archivo SQL inicial (falta) para crear las tablas necesarias.

3. **Configura las variables de entorno**:
   - Define las variables de entorno `DB_USER` y `DB_PASSWORD` con las credenciales de tu base de datos.

4. **Compila y ejecuta el proyecto**:
   - Ejecuta la clase `CrmGymApp` en el paquete `presentation` para iniciar la aplicación:
     ```bash
     javac presentation/CrmGymApp.java
     java presentation.CrmGymApp
     ```

---

## 📋 Ejemplo de Uso

1. **Listar Clientes**:
   - Selecciona la opción `1` en el menú para ver todos los clientes registrados.

2. **Agregar un Cliente**:
   - Selecciona la opción `3` en el menú y sigue las instrucciones para ingresar los datos del cliente.

3. **Buscar un Cliente por DNI**:
   - Selecciona la opción `2` en el menú e ingresa el DNI del cliente que deseas buscar.

4. **Modificar o Eliminar un Cliente**:
   - Selecciona las opciones `4` o `5` en el menú y sigue las instrucciones.

---

## 📧 Contacto

Si tienes preguntas, sugerencias o feedback, no dudes en contactarme:
- **Nombre**: Jonathan Araujo
- **GitHub**: [Joni23s](https://github.com/Joni23s)
- **Correo**: [jonathanaraujo232g@gmail.com]
- **Linkedin**: [https://www.linkedin.com/in/jonathan-araujo-750634181/]

---

¡Gracias por tu interés en **CRMGYM**! Espero que este proyecto sea de utilidad para la comunidad y los gimnasios que buscan modernizar su gestión. 🚀

---

### Notas adicionales:
- Aqui agregare el enlace a las futuras fases del proyecto que manejaran otras tecnologías, a saber:
Fase 1.b: Hibernate
Ampliación de clases, nuevas funcionalidades

Fase 2: Spring Boot + API REST
Integración de pagos (posible integración con Mercado Pago).

Ampliación de funcionalidades con una API RESTful.

Implementación de JPA (Hibernate) para una mejor gestión de la base de datos.

Fase 3: Java Swing
Desarrollo de una interfaz gráfica de escritorio para administradores.

Mejora de la usabilidad y experiencia del usuario.
