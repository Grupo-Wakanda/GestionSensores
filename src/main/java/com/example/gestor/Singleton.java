package com.example.gestor;

import com.example.exceptions.ErrorConexionBasedeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    //crear la instancia de la bdd en el singleton
    //la bdd se encuentra en el docker por tanto hay que llamarlo con el contenedor levantado
    //crear el constructor privado
    //metodo para controlar el acceso a la instancia

    private static Singleton singleton;
    private Connection connection;

    private static final String url = "jdbc:postgresql://db:5432/sensores-db";
    private static final String user = "usuario";
    private static final String password = "contraseña";

    private Singleton() {
        try{
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new ErrorConexionBasedeDatos("Error al conectar a la base de datos");
        }
    }

    public static synchronized Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public Connection getConnection() {
        return connection;
    }
}
