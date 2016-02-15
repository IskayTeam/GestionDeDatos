/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.liquidacion.Administrativo;

/**
 *
 * @author Fran
 */
public class AbmUsuario {
    
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static ArrayList<Administrativo> admines = new ArrayList<Administrativo>();
    
    public static void agregarUsuario(String user, String password, String tipoUsuario){
    Usuario usuario = new Usuario(user, password,tipoUsuario);
    usuarios.add(usuario);
    }
    
    public static void agregarAdmin(String nombre, String domicilio, String cuit, int idUs){
    Administrativo admin = new Administrativo(nombre, domicilio, cuit, idUs);
    admines.add(admin);
    }
    
}
