/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.compra.Material;

/**
 *
 * @author Luca
 */
public class AbmMaterial {
    
    private static ArrayList<Material> materiales = new ArrayList<Material>();
    
    public static void agregarMaterial(int codigo, String descripcion, int precio){
        
        Material material  = new Material(precio, descripcion, precio);
        materiales.add(material);
        
        System.out.println(materiales);
    }
    
    public static void eliminarMaterial(int codigo){
        Material mat = buscarMaterial(codigo);
        if(mat != null){
            materiales.remove(mat);
        }
    }
    
    
    public static Material buscarMaterial(int codigo){
        
        Material auxiliar = null;
        for(int i=0; i<materiales.size(); i++){
            
            if(codigo == materiales.get(i).getIdMaterial()){
                auxiliar = materiales.get(i);
               
            }
        } return auxiliar;
        
    }
}
