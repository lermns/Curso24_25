
package logica;

import gui.App;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PedroBorreganBurgos
 */

public class CocheTableModel extends AbstractTableModel {
    private ArrayList<Coche> coches = Coche.COCHES;


    @Override
    public int getRowCount() {
        return this.coches.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return App.bundle.getString("marca");
            case 1:
                return App.bundle.getString("matriculacion");
            case 2:
                return App.bundle.getString("kilometros");
            case 3:
                return App.bundle.getString("color");
            case 4:
                return App.bundle.getString("transmision");
            case 5:
                return App.bundle.getString("combustible");
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Coche coche = this.coches.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return coche.getMarca();
            case 1:
                return coche.getFechaMatriculacion();
            case 2:
                return coche.getKilometros();
            case 3:
                return coche.getColor();
            case 4:
                return coche.getTransmision();
            case 5:
                return coche.getCombustible();
        }
        return null;
    }
}
