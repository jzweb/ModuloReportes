package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection conexion;
    String server="jdbc:mysql://localhost/reserva"; /*System.getenv(); --- This will return the envireomment variable on String format*/
    String db_name="root";
    String db_pass="root";
    String driver="com.mysql.jdbc.Driver";

    public Conexion (){
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(server,db_name,db_pass);
            System.out.println("Conexion realizada!");
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexion Fallida");
        }
    }

    public Connection getConexion() {
        return conexion;
    }

}