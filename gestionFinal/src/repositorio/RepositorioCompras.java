/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import modelo.Compra;

/**
 *
 * @author Luca
 */
public class RepositorioCompras {
    
    private static ArrayList<Compra> compras = new ArrayList<>();
    
    public static void agregarCompra(Compra c){
        
        compras.add(c);
    }
    
}
