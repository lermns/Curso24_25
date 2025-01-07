using System.Windows;
using System.Windows.Input;

namespace Actividad_3
{
    public partial class HundirLaFlota : Window
    {
        public HundirLaFlota()
        {
            InitializeComponent();
        }

        // Manejador de clics para las celdas
        private void MiCelda_Click(object sender, MouseButtonEventArgs e)
        {
            var celda = sender as MiCelda;
            if (celda != null)
            {
                if (celda.Valor == 0) // Si es agua, ponemos barco
                {
                    celda.Valor = 1;
                    celda.ActualizarCelda();
                }
                else if (celda.Valor == 1) // Si es barco, lo cambiamos a agua
                {
                    celda.Valor = 0;
                    celda.ActualizarCelda();
                }
            }
        }
    }

}
