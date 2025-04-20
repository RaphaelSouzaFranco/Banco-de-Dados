package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", // ou sua URL do Oracle
                "usuario", // seu usuário
                "senha"    // sua senha
        );
    }
}
