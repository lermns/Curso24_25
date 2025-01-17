using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace WpfApp7
{
    public partial class HundirLaFlota : Window
    {
        private readonly List<List<int>> tablero = new List<List<int>>();
        private readonly Random random = new Random();

        public HundirLaFlota()
        {
            InitializeComponent();
            InicializarTablero();
            CrearTableroVisual();
        }

        private void InicializarTablero()
        {
            for (int i = 0; i < 10; i++)
            {
                var fila = new List<int>();
                for (int j = 0; j < 10; j++)
                {
                    // Inicializa el tablero con agua (0)
                    fila.Add(0);
                }
                tablero.Add(fila);
            }

            // Coloca un barco (1) en una fila aleatoria
            int filaBarco = random.Next(10);
            for (int i = 0; i < 10; i++)
            {
                tablero[filaBarco][i] = 1;
            }
        }

        private void CrearTableroVisual()
        {
            for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    var userControl = new UserControl1
                    {
                        Juego = "HF",
                        Valor = 0, // Inicialmente, todas las celdas son agua
                        ErrorValidacion = "No hay error"
                    };

                    // Agrega un controlador de eventos Click para revelar la celda al hacer clic
                    userControl.MouseLeftButtonDown += (sender, args) => RevelarCelda(i, j);

                    Grid.SetRow(userControl, i);
                    Grid.SetColumn(userControl, j);
                    MiGrid.Children.Add(userControl);
                }
            }
        }

        private void RevelarCelda(int fila, int columna)
        {
            // Actualiza el valor visual basado en el tablero
            UserControl1 userControl = (UserControl1)MiGrid.Children[(fila * 10) + columna];
            userControl.Valor = tablero[fila][columna];

            // Puedes agregar lógica adicional según si es agua o barco
            if (userControl.Valor == 0)
            {
                MessageBox.Show("Agua");
            }
            else if (userControl.Valor == 1)
            {
                MessageBox.Show("¡Barco!");
            }
        }
    }
}
