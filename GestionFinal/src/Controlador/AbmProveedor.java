/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.compra.Proveedor;
import vista.AltaProveedor;

/**
 *
 * @author Luca
 */
public class AbmProveedor {
    conectar cc = new conectar();
    Connection cn = cc.conexion();
    public static ArrayList<Proveedor> proveedores = new ArrayList<>();
    
    public static void agregarProveedor(String nombre, String cuit, String provincia, String localidad, String direccion, int telefono){
        
        Proveedor proveedor = new Proveedor(nombre, cuit, provincia, localidad, direccion, telefono);
            proveedores.add(proveedor);
            System.out.println(proveedor);
        
    }
    
    public void eliminarProveedor(int codigo){
        
        Proveedor v = buscarProveedor(codigo);
        if(v != null){
            proveedores.remove(v);
        }
        
    }
    
    public Proveedor buscarProveedor(int codigo){
        
        Proveedor auxiliar = null;
         for(int i=0; i< proveedores.size(); i++){
            if( codigo == proveedores.get(i).getIdProveedor()){
                
                auxiliar = proveedores.get(i);
            }
            
        } return auxiliar;
    }
    
    
}
