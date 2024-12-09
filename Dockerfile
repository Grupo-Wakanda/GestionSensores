# Usar una imagen base de OpenJDK con soporte JDK 17 o superior
FROM openjdk:17-jdk-slim

# Establecer un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por la aplicación Spring Boot al contenedor
# Asegúrate de que el nombre coincida con el archivo generado por tu proyecto (por ejemplo, GestionSensores.jar)
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que utiliza la aplicación (generalmente 8080 en Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
