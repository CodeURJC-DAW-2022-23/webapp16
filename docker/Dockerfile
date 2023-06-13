# Selecciona la imagen base
FROM maven:3.8-openjdk-18 as backend


# Definimos el directorio de trabajo en /usr/src/app/
WORKDIR /project

# Copiamos los ficheros de la aplicación
COPY backend/ .


# Instalamos las dependencias que necesita la app
RUN mvn package -DskipTests=true

FROM openjdk:18.0.2.1

WORKDIR /app

COPY --from=backend project/target/*.jar /app/backend.jar

# Indica el puerto que expone el contenedor
EXPOSE 8443

# Comando que se ejecuta cuando se arranque el contenedor
CMD ["java",  "-jar", "backend.jar"]
