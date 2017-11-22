package Controllers;

import dao.DaoUser;
import models.Conexion;
import models.User;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;

public class CtrlUser {

    Connection con;

    public boolean checkUser(String user,String pass){
        User userOn;
        boolean exist=false;
        Conexion co =new Conexion();
        con = co.getConexion();
        DaoUser daouser = new DaoUser();
        userOn = daouser.find(user,pass,con);
        if(userOn!=null){
            exist=true;
        }
        return exist;
    }

    public HashSet<User> checkListUsers(){
        HashSet<User>users=null;
        //Iterator<User>iteratorUsers=null;
        Conexion co =new Conexion();
        con = co.getConexion();
        DaoUser daouser = new DaoUser();
        users= daouser.readUsers(con);
        System.out.println("Viendo lista controlador: "+users);
        return users;
    }
}
