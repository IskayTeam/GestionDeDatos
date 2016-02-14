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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.liquidacion.Categoria;
import modelo.liquidacion.Obrero;
import vista.ListaPersonal;
import vista.ListaProveedor;

/**
 *
 * @author Luca
 */
public class AbmObrero {

    public static ArrayList<Obrero> obreros = new ArrayList<>();
    Controlador.conectar cc = new Controlador.conectar();
    Connection cn = cc.conexion();

    
    public static void agregarObrero(String nombre, String apellido, String cuil, String estadoCivil, String localidad, String direccion, Date fechaNacimiento, Date fechaIngreso, int dni, int telefono, int idCat) {
        Obrero obrero = new Obrero(nombre, apellido, cuil, estadoCivil, localidad, direccion, fechaNacimiento, fechaIngreso, dni, telefono, idCat);
        obreros.add(obrero);
    }

}
