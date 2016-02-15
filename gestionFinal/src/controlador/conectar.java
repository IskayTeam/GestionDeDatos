package Controlador;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Sony
 */

public class conectar {
Connection conect = null;
public static conectar instance;
   
public Connection conexion()
    {
      try {            
           //Cargamos el Driver MySQL
           Class.forName("com.mysql.jdbc.Driver");
           conect = DriverManager.getConnection
            ("jdbc:mysql://localhost/finalgestion","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
     
}
   public synchronized static conectar comprobarEstado() {
        if (instance == null) {
            instance = new conectar();
        }
        return instance;
   }
 public void cerrarConexion() {
        conectar.instance = null;
    }
}
