using System.Windows;

namespace Actividad_3
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        // Evento para el botón "Hundir la Flota"
        private void HundirLaFlota_Click(object sender, RoutedEventArgs e)
        {
            // Crea una nueva instancia de la ventana de Hundir la Flota y la muestra
            HundirLaFlota ventanaHF = new HundirLaFlota();
            ventanaHF.Show();
            this.Close(); // Cierra la ventana principal si se desea
        }

        // Evento para el botón "Tres en Raya"
        private void TresEnRaya_Click(object sender, RoutedEventArgs e)
        {
            // Crea una nueva instancia de la ventana de Tres en Raya y la muestra
            TresEnRaya ventanaTR = new TresEnRaya();
            ventanaTR.Show();
            this.Close(); // Cierra la ventana principal si se desea
        }


    }
}

