/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.Fecha;
import java.util.ArrayList;
import java.util.Date;
import modelo.liquidacion.Obrero;

/**
 *
 * @author Luca
 */
public interface Callback2 {
    void notificarObra(int idObra, String nombre, String direccion, Date fechaInicio, Date fechaFin, double egresos);
    
}
