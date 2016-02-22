/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.liquidacion.Usuario;
import modelo.liquidacion.Administrativo;
import org.apache.commons.codec.digest.DigestUtils;
import vista.NuevoUsuario;

/**
 *
 * @author Fran
 */
public class AbmUsuario {
    
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static ArrayList<Administrativo> admines = new ArrayList<Administrativo>();
    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
    
    public static void agregarUsuario(int idUsuario, String user, String password, String tipoUsuario){
    Usuario usuario = new Usuario(idUsuario, user, password,tipoUsuario);
    usuarios.add(usuario);
    }
    
    public static void agregarAdmin(int idAdmin, String nombre, String domicilio, String cuit, Usuario idUs){
    Administrativo admin = new Administrativo(nombre, domicilio, cuit, idUs);
    admines.add(admin);
    }
    
    public void mostrarUltimoId(NuevoUsuario nu){
    String sqlid = "SELECT auto_increment FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'usuario' AND table_schema = DATABASE();";
        try {
        
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlid);
            rs.next();
            int id1 = rs.getInt(1);
            nu.getCampoId().setText(String.valueOf(id1));
            
        } catch (SQLException ex) {
            Logger.getLogger(NuevoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void agregarUsuario(NuevoUsuario nu){
    //Para el "usuario"
        Usuario us = new Usuario();
        int idUsuario = Integer.parseInt(nu.getCampoId().getText());
        String user = nu.getCampoUsuario().getText();
        String pass = Arrays.toString(nu.getCampoPass().getPassword());
        String tipoUs = (String)nu.getjComboBox1().getSelectedItem();
        us.setIdUsuario(idUsuario);
        us.setUsuario(user);
        us.setContraseña(pass);
        us.setTipoUsuario(tipoUs);
        //Para el "administrativo"
        Administrativo ad = new Administrativo();
        String nombre = nu.getjTextField1().getText();
        String domicilio = nu.getjTextField2().getText();
        String cuil = nu.getjTextField3().getText();
        ad.setIdAdmin(idUsuario);
        ad.setNombre(nombre);
        ad.setCuil(cuil);
        ad.setDomicilio(domicilio);
        ad.setUsuario(us);
        //Encriptación
        String passC = DigestUtils.md5Hex(pass);
        //Declaracion de la query para la bd
        String sql = "INSERT INTO usuario(user, password, tipoUsuario) VALUES ('"+user+"','"+passC+"','"+tipoUs+"')";
        String sql2 = "INSERT INTO administrativo(nombre, domicilio, cuit, Usuario) VALUES ('"+nombre+"','"+domicilio+"','"+cuil+"','"+idUsuario+"')";
        
        try{
        cc.conexion();
        Statement st = cn.createStatement();
        st.execute(sql);
        st.execute(sql2);
        usuarios.add(us);
        admines.add(ad);
            JOptionPane.showMessageDialog(null, "Se agrego correctamente");
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al insertar");
        }
        System.out.println(usuarios);
        System.out.println(admines);
        nu.setVisible(false);
    }
}
