package dao;

import models.Clinic;
import models.Conexion;
import models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;

public class DaoUser {

    public User find(String user, String pass,Connection conn){
        User userLogin=null;

        try {
            String query = "SELECT * FROM usuario where login='"+user+"' and clave='"+pass+"'";
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("idUsuario");
                String name = rs.getString("nombre");
                String login = rs.getString("login");
                String clave = rs.getString("clave");
                userLogin = new User(id,name,login,clave);

            }

            st.close();
        }catch(Exception e){

        }


        return  userLogin;
    }

    public HashSet<User> readUsers(Connection conn){
        User user=null;
        Clinic listUsers = new Clinic();
        try {
            String query = "SELECT * FROM usuario";
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("idUsuario");
                String name = rs.getString("nombre");
                String login = rs.getString("login");
                String clave = rs.getString("clave");
                user = new User(id,name,login,clave);
                listUsers.setListUser(user);

            }
            System.out.println("Viendo lista : "+ listUsers.getListUsers());
            st.close();
        }catch(Exception e){

        }
        return listUsers.getListUsers();
    }
}