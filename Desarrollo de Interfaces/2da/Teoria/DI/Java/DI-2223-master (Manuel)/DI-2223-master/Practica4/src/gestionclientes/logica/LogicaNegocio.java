/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionclientes.logica;
import gestionclientes.dto.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manu
 */
public class LogicaNegocio {
    private static List<Cliente> listaClientes = new ArrayList<>();
    
    public static void aniadirCliente(Cliente cliente)
    {
        listaClientes.add(cliente);
    }
    
    public static List<Cliente> getListaClientes()
    {
        return listaClientes;
    }
}
