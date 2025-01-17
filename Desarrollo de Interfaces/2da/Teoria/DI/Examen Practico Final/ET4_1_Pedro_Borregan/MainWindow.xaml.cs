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


namespace ET4_1_Pedro_Borregan
{

    public partial class MainWindow : Window
    {
        private ConversorMonedas _conversorMonedas;

        public MainWindow()
        {
            InitializeComponent();
            _conversorMonedas = new ConversorMonedas();
            DataContext = _conversorMonedas;
        }

        private void Convertir_Click(object sender, RoutedEventArgs e)
        {
            _conversorMonedas.Convertir();
        }

        private void Invertir_Click(object sender, RoutedEventArgs e)
        {
            _conversorMonedas.Invertir();

            // Cambiar el estado de las cajas de texto
            txtCantidad.IsReadOnly = !_conversorMonedas.Invertido;
            txtResultado.IsReadOnly = _conversorMonedas.Invertido;
        }
    }
}
