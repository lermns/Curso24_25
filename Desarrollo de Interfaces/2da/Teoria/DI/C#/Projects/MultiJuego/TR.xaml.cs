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
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace MultiJuego
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class TR : Window
    {
        private bool isHFGame; // Flag para controlar el tipo de juego

        public TR()
        {
            InitializeComponent();
            isHFGame = true; // Comienza con Hundir la Flota
        }

        private void CambiarJuego(object sender, RoutedEventArgs e)
        {
            isHFGame = !isHFGame;

            if (!isHFGame)
            {
                trCelda1.Valor = 2; // Establece el valor inicial para Tres en Raya
                trCelda1.IsEnabled = true;
            }
        }
    }
}
