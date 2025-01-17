using System;
using System.Windows;
using System.Windows.Controls;

namespace Conversor
{
    public partial class ConversorComponent : UserControl
    {
        public string OrigenPlaceholder { get; set; }

        public event Action<double> ConversionRequested;

        public ConversorComponent()
        {
            InitializeComponent();
        }

        private void Convertir(object sender, RoutedEventArgs e)
        {
            if (double.TryParse(txtOrigen.Text, out double valorOrigen))
            {
                ConversionRequested?.Invoke(valorOrigen);
            }
            else
            {
                MessageBox.Show($"Por favor, introduce un valor válido en la casilla de {OrigenPlaceholder}.");
            }
        }
    }
}
