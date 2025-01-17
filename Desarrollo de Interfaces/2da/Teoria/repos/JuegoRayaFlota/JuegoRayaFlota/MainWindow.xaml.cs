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

namespace JuegoRayaFlota
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            // Suscribir el manejador de eventos para las celdas
            cell00.CeldaClickeada += CeldaClickeada;
            cell01.CeldaClickeada += CeldaClickeada;
            cell02.CeldaClickeada += CeldaClickeada;
            cell10.CeldaClickeada += CeldaClickeada;
            cell11.CeldaClickeada += CeldaClickeada;
            cell12.CeldaClickeada += CeldaClickeada;
            cell20.CeldaClickeada += CeldaClickeada;
            cell21.CeldaClickeada += CeldaClickeada;
            cell22.CeldaClickeada += CeldaClickeada;
        }

        private void CeldaClickeada(object sender, RoutedEventArgs e)
        {
            // Cambiar el turno después de cada clic en la celda
            CeldaJuego.TurnoActual = 1 - CeldaJuego.TurnoActual; // Alternar entre 0 y 1
        }
    }
}
