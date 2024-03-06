Aplicación registro de usuarios - Evaluación Java:

Aplicación de registro de usuarios desarrollado en Java utilizando Spring Boot y Hibernate. 
La aplicación permite registrar nuevos usuarios, listar todos los usuarios registrados.

Funcionalidades:
Registro de nuevos usuarios con nombre.
Asociación de teléfonos a los usuarios registrados.
Listado de todos los usuarios registrados, incluyendo sus teléfonos asociados.
Gestión de errores y excepciones para una experiencia de usuario más robusta.
Logs para la auditoria de información
Pruebas unitarias con Mockito

Tecnologías utilizadas:
Java 17
Spring Boot 3
Hibernate
H2 Database (para desarrollo)
RESTful API
JUnit
Mockito

Pruebas Unitarias:
Se realizaron pruebas unitarias utilizando las siguientes herramientas
JUnit - Framework de pruebas unitarias para Java.
Mockito - Biblioteca de mocking para Java

Configuración y ejecución:
Clona el repositorio a tu máquina local con siguiente comando: git clone https://github.com/JeanPier232/evaluacionjava.git
Importa el proyecto en tu IDE favorito (NetBeans, Eclipse, IntelliJ IDEA, etc.).

Ejecuta la aplicación como una aplicación Spring Boot.

Accede a la API utilizando herramientas como Postman.

Endpoints de la API:
Registro de usuario:
POST /api/users/register-user
Permite registrar un nuevo usuario. Se debe enviar un JSON con la siguiente estructura
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.cl",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}

Listado de usuarios:
GET /api/users/list-users
Devuelve un listado de todos los usuarios registrados, incluyendo sus teléfonos asociados.
