# api-personas

# Reba api-personas

_Ejercicio Técnico que consiste en la creación de un CRUD de personas con ciertas validaciones, también el manejo de relaciones familiares y stats correspondientes._

## Consignas:

![alt text](https://github.com/marianoponte/api-personas/blob/main/ejercicio_consignas_1.png)

![alt text](https://github.com/marianoponte/api-personas/blob/main/ejercicio_consignas_2.png)

## Comenzando *IMPORTANTE* 🚀

_Se cargan en la base de datos automáticamente:_
- 5 registros de país: { "Argentina", "Brasil", "Paraguay", "Uruguay", "Chile" }
- 3 registros de tipo de documento: {"DNI", "CUIT", "RUC"}

## Diagrama de clases  

![alt text](https://github.com/marianoponte/api-personas/blob/main/diagrama_solucion.png)

### Pre-requisitos 📋

Tecnologías utilizadas para correr la aplicación:

Java 11

Maven 3.8.1

Docker 20.10.5

## Ejecutando las pruebas ⚙️

Una vez descargado el código, ejecutar el siguiente comando para crear el archivo JAR de la aplicación:
```
mvn clean install
```

Despúes con el siguiente comando se levantará la aplicación y la base de datos postgres especificada en el archivo docker-compose.yml.
```
docker-compose up --build
```

Las pruebas se pueden realizar con Postman.

### NIVEL 1: 

_Dar de alta una Persona:_

Método: POST

URL: http://localhost:8080/persona

Header: Content-Type: application/json

Request de ejemplo: 
{
    "documentNumber": "1111111",
    "documentType": 1,
    "name": "Mariano",
    "lastName": "Ponte",
    "country": "Argentina",
    "birthDate": "04-04-1996",
    "contactNumber": "1245"
}

Se validará:
- Que no sea una persona duplicada según la combinación de: documentNumber, documentType y country.
- Que tenga un dato de contacto completo: contactNumber o email.
- Fecha de nacimiento mayor a 18 años.

### NIVEL 2: 

_Relación familiares entre personas a través del padre:_

- Se asigna un padre (persona existente) a una persona:

Método: POST

URL: localhost:8080/personas/{idPersona1}/padre/{idPersona2}

------------------------------------------------------------------

_Se devuelve la relación posible entre dos personas:_
- 'HERMAN@': Si las dos personas tienen el mismo padre.
- 'PRIM@': Si los padres de las personas son hermanos.
- 'TI@': Si una de las personas es hermano del padre de la otra.
- 'No hay relacion entre las personas ingresadas': Si no se cumplen niguna de las 3 relaciones

Método: GET

URL: localhost:8080/relaciones/idPersona1/idPersona2

### NIVEL 3: 

_Porcentajes de personas por país cargado:_

Método: GET

URL: localhost:8080/stats
