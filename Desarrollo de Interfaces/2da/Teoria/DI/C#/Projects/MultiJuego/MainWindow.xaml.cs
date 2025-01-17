using System.Windows;

namespace MultiJuego
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void AbrirHundirLaFlota(object sender, RoutedEventArgs e)
        {
            HF hundirLaFlota = new HF();
            hundirLaFlota.Show();
        }

        private void AbrirTresEnRaya(object sender, RoutedEventArgs e)
        {
            TR tresEnRaya = new TR();
            tresEnRaya.Show();
        }
    }
}
