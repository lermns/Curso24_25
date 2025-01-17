using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace WpfApp7
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            string juegoSeleccionado = ((ComboBoxItem)JuegosComboBox.SelectedItem)?.Content.ToString();

            if (!string.IsNullOrEmpty(juegoSeleccionado))
            {
                if (juegoSeleccionado == "Hundir la Flota (HF)")
                {
                    // Muestra la ventana Hundir la Flota
                    HundirFlota hundirFlota = new HundirFlota();
                    hundirFlota.ShowDialog();
                }
                else if (juegoSeleccionado == "Tres en Raya (TR)")
                {
                    // Muestra la ventana Tres en Raya
                    TresEnRayaWindow tresEnRayaWindow = new TresEnRayaWindow();
                    tresEnRayaWindow.ShowDialog();
                }
                else
                {
                    MessageBox.Show($"Has seleccionado: {juegoSeleccionado}");
                }
            }
            else
            {
                MessageBox.Show("Por favor, selecciona un juego antes de hacer clic en el botón.");
            }
        }
    }
}