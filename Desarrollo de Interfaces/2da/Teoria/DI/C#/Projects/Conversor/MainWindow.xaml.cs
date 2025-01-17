using System;
using System.Windows;
using System.Windows.Controls;

namespace Conversor
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Configuración de los manejadores de eventos
            conversorComponent1.ConversionRequested += (dolar) => DolarAEuro(dolar, conversorComponent1.txtDestino);
            conversorComponent2.ConversionRequested += (milla) => MillaAKilometro(milla, conversorComponent2.txtDestino);
            conversorComponent3.ConversionRequested += (libra) => LibraAKilogramo(libra, conversorComponent3.txtDestino);
        }

        public void DolarAEuro(double dolar, TextBlock txtDestino)
        {
            double euro = 0.92;
            //MessageBox.Show($"{dolar} dólar/es = {Math.Round(euro * dolar, 2)} euro/s");
            txtDestino.Text = $"{dolar} dólar/es = {Math.Round(euro * dolar, 2)} euro/s";
        }

        public void MillaAKilometro(double milla, TextBlock txtDestino)
        {
            double kilometro = 1.60934;
            //MessageBox.Show($"{milla} milla/s = {Math.Round(kilometro * milla, 2)} kilometro/s");
            txtDestino.Text = $"{milla} milla/s = {Math.Round(kilometro * milla, 2)} kilometro/s";
        }

        public void LibraAKilogramo(double libra, TextBlock txtDestino)
        {
            double kilogramo = 0.453592;
            //MessageBox.Show($"{libra} libra/s = {Math.Round(kilogramo*libra, 2)} kilogramo/s");
            txtDestino.Text = $"{libra} libra/s = {Math.Round(kilogramo * libra, 2)} kilogramo/s";
        }
    }
}
