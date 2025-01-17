package exrec.logica;

import exrec.PantallaPrincipal;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ViajesTableModel extends AbstractTableModel {
    private ArrayList<Viaje> viajes = Viaje.COCHES;


    @Override
    public int getRowCount() {
        return this.viajes.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return PantallaPrincipal.bundle.getString("Origen");
            case 1:
                return PantallaPrincipal.bundle.getString("Destino");
            case 2:
                return PantallaPrincipal.bundle.getString("Fecha ida");
            case 3:
                return PantallaPrincipal.bundle.getString("Ida y vuelta");
            case 4:
                return PantallaPrincipal.bundle.getString("Fecha vuelta");
            case 5:
                return PantallaPrincipal.bundle.getString("Viajeros");
            case 6:
                return PantallaPrincipal.bundle.getString("Familia numerosa");
            case 7:
                return PantallaPrincipal.bundle.getString("Jubilado/s");
            case 8:
                return PantallaPrincipal.bundle.getString("Maleta adicional");
            case 9:
                return PantallaPrincipal.bundle.getString("Selección asiento");
            case 10:
                return PantallaPrincipal.bundle.getString("Precio total");
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Viaje viaje = this.viajes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return viaje.getOrigen();
            case 1:
                return viaje.getDestino();
            case 2:
                return viaje.getFechaIda();
            case 3:
                return viaje.getIdaYVuelta();
            case 4:
                return viaje.getFechaVuelta();
            case 5:
                return viaje.getNumeroViajeros();
            case 6:
                return viaje.getFamiliaNumerosa();
            case 7:
                return viaje.getJubilados();
            case 8:
                return viaje.getMaletaAdicional();
            case 9:
                return viaje.getSeleccionAsiento();
            case 10:
                return viaje.getPrecioTotal();
        }
        return null;
    }
}
