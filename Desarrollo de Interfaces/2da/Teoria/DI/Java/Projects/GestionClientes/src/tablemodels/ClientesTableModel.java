/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import data.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PedroBorreganBurgos
 */
public class ClientesTableModel extends AbstractTableModel {

    private List<Cliente> listCliente;
    
    public ClientesTableModel (List<Cliente> listCliente){
        this.listCliente = listCliente;
    }
    
    @Override
    public int getRowCount() {
        return listCliente.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return listCliente.get(rowIndex).getNombre();
            case 1: return listCliente.get(rowIndex).getApellidos();
            case 2: return listCliente.get(rowIndex).getEdad();
            case 3: return listCliente.get(rowIndex).getFechaAlta();
            case 4: return listCliente.get(rowIndex).getProvincia();
        }
        return null;
    }
}
