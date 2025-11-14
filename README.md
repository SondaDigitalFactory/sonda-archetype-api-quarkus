# sonda-archetype-api-quarkus

Plantilla de referencia para construir microservicios Quarkus alineados con buenas prácticas hexagonales (dominio, aplicación, infraestructura) y preparados para convertirse en arquetipo Maven reutilizable.

## Objetivo del Proyecto

- Proveer un ejemplo mínimo de microservicio REST que consulta personas e instituciones a través de un puerto de infraestructura.
- Servir como base para generar arquetipos personalizados que unifiquen estándares internos (estructura de paquetes, configuración, dependencias).
- Demostrar cómo empaquetar el servicio como binario nativo y cómo contenerizarlo con Docker para despliegues eficientes, incluidos entornos bancarios con restricciones.

## Requisitos Previos

- **Java 21** instalado si deseas compilar directamente en la máquina.
- **Docker** para compilar y ejecutar la imagen nativa sin instalar GraalVM localmente.
- **Acceso a Internet** para descargar dependencias (Maven Wrapper, imágenes base de Docker).

> El repositorio incorpora el *Maven Wrapper* (`./mvnw`), por lo que no es necesario tener Maven preinstalado.

## Estructura Principal

```
src/main/java/co/com/keralty/archetype/
 ├── domain
 │   ├── model
 │   └── port
 ├── application
 │   └── usecase
 └── infrastructure
     ├── external
     └── rest
```

## Uso del Proyecto como Microservicio

### Compilación y ejecución en JVM

```bash
./mvnw clean package
```

```bash
./mvnw quarkus:dev
```

```bash
./mvnw quarkus:run
```

La API REST expone el recurso `POST /consulta-personas-instituciones`.

### Compilación nativa local (GraalVM instalado)

```bash
./mvnw clean package -Pnative -DskipTests
```

```bash
./target/sonda-archetype-api-quarkus-1.0.0-SNAPSHOT-runner
```

## Generación del Arquetipo Maven

Este proyecto puede transformarse en un arquetipo mediante el plugin oficial. Asegúrate de contar con un `~/.m2/settings.xml` válido (aunque sea vacío) para que el invoker se ejecute correctamente.

```bash
mvn clean
```

```bash
mvn archetype:create-from-project
```

El arquetipo generado quedará en `target/generated-sources/archetype`. Para instalarlo en el repositorio local:

```bash
cd target/generated-sources/archetype
```

```bash
mvn install
```

Luego podrás reutilizarlo con:

```bash
mvn archetype:generate \
  -DarchetypeGroupId=co.com.keralty.base \
  -DarchetypeArtifactId=sonda-archetype-api-quarkus-archetype \
  -DarchetypeVersion=1.0.0-SNAPSHOT
```

## Construcción y Ejecución Nativa con Docker

El repositorio incluye `src/main/docker/Dockerfile.native` con un flujo multi-stage que:

1. Usa `quay.io/quarkus/ubi-quarkus-mandrel-builder-image:23.1-java21` para construir el binario con `./mvnw`.
2. Empaqueta el ejecutable en `registry.access.redhat.com/ubi9/ubi-minimal:9.4`, ideal para entornos financieros.

### Construcción de la imagen

```bash
docker build -f src/main/docker/Dockerfile.native -t quarkus/arquetipo-quarkus .
```

### Ejecución de la imagen

```bash
docker run -i --rm -p 8082:8082 --name arquetipo-native quarkus/arquetipo-quarkus
```

La aplicación quedará disponible en `http://localhost:8082`. Para completar la validación:

```bash
curl -X POST http://localhost:8082/consulta-personas-instituciones \
     -H "Content-Type: application/json" \
     -d '{"numIdent":"123"}'
```

> Si no cuentas con el servicio externo configurado, la respuesta será un error controlado (`HTTP 500` con causa 400). Ajusta `application.properties` o sustituye la integración con un mock según tus necesidades.

Con estos pasos tendrás un microservicio Quarkus listo para producción, empaquetado como arquetipo y con soporte para compilación nativa eficiente en Docker. Ajusta las secciones según los lineamientos internos de tu organización antes de distribuirlo.

