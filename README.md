# Microservicio Auth Service

El propocito de este micro es generar y validar tokens de acceso.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Documentacion](#Documentacion)

## Descripción

Este proyecto es una aplicación de Spring Boot que gestiona usuarios y pedidos.
Está orientada a un enfoque distribuido. 
Este proyecto está conformado de 5 microservicios los cueles tienen 
que ser levantados en el siguiente orden:
1. micro-discovery-service
2. micro-gateway-service
3. micro-auth-service
4. micro-order-service
5. micro-user-service

## Tecnologías Utilizadas

- **Java 17+**
- **Spring Boot 3.2.3**
- **Maven**
- **Base de datos PostgreSQL**

## Requisitos

Antes de comenzar, asegúrate de tener instaladas y configurado(variables de entorno) las siguientes herramientas:

- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)

**NOTA:: Recuerda el orden mencionado en la Descripción del proyecto**

## Instalación

Sigue estos pasos para configurar y ejecutar el proyecto en tu máquina local.

1. Clona este repositorio:

   ```bash
   git clone https://github.com/Jhoelus/micro-auth-service.git
    
2. Ingresar a la carperta descargada
    ```bash
    cd  micro-auth-service/
   
3. Ejecutamos los siguientes comandos mvn
    ```bash
    mvn clean compile package
 
4. Ejecutamos el siguientes comandos mvn para correr nuestro micro
    ```bash
    mvn spring-boot:run
    
5. Para asegurar que el micro esta correctamente arriba ir a http://localhost:8761/
   deberiamos ver el micro **AUTH-SERVICE** registrado en eureka

## Documentación
La documentación del API orders la podemos encontrar a través del gateway en:
http://localhost:8080/swagger-ui.html

**NOTA** usuario valido para generar TOKEN
**user:** admin
**password:** password

```bash
curl --request POST \
--url http://localhost:8080/api/auth/login \
--header 'Content-Type: application/json' \
--header 'User-Agent: insomnia/10.1.0' \
--data '{ 	"user": "admin", 	"password": "password" }'
