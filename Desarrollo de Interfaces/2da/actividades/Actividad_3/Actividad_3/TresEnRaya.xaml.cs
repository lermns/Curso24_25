using System.Windows;
using System.Windows.Input;

namespace Actividad_3
{
    public partial class TresEnRaya : Window
    {
        // Esta variable controla a qué jugador le toca (0 = O, 1 = X)
        private int jugadorActual = 0;

        public TresEnRaya()
        {
            InitializeComponent();
        }

        // Manejador de clics para las celdas
        private void MiCelda_Click(object sender, MouseButtonEventArgs e)
        {
            var celda = sender as MiCelda;
            if (celda != null && celda.Valor == -1) // Solo se puede hacer clic si la celda está vacía (Valor = -1)
            {
                // Alternar entre X y O
                celda.Valor = jugadorActual;
                celda.ActualizarCelda();

                // Cambiar el turno
                jugadorActual = (jugadorActual == 0) ? 1 : 0;
            }
        }
    }

}
