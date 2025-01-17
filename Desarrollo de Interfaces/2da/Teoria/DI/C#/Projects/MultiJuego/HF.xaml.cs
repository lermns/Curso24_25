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
    public partial class HF : Window
    {
        private bool isHFGame; // Flag para controlar el tipo de juego

        public HF()
        {
            InitializeComponent();
            isHFGame = true; // Comienza con Hundir la Flota
        }

        private void CambiarJuego(object sender, RoutedEventArgs e)
        {
            isHFGame = !isHFGame;

            if (isHFGame)
            {
                hfCelda1.Valor = 0; // Establece el valor inicial para Hundir la Flota
                hfCelda1.IsEnabled = true; // Habilita la celda para cambiar el valor
            }
        }
    }
}