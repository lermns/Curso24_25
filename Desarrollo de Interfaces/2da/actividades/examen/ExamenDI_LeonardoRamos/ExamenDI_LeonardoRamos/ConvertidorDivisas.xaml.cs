using System.Windows;
using System.Windows.Controls;

namespace ConvertidorDivisas
{
    public partial class ConvertidorDivisas : UserControl
    {
        // Propiedad para configurar la moneda
        public string Moneda
        {
            get { return (string)GetValue(MonedaProperty); }
            set { SetValue(MonedaProperty, value); ActualizarMoneda(); }
        }

        // Registrar la propiedad de dependencia
        public static readonly DependencyProperty MonedaProperty =
            DependencyProperty.Register("Moneda", typeof(string), typeof(ConvertidorDivisas), new PropertyMetadata("Dollar", OnMonedaChanged));

        // Diccionario con los factores de conversión
        private readonly Dictionary<string, double> conversionFactor = new()
        {
            { "Dolar", 0.92 },
            { "Libra", 1.13 },
            { "Yuan", 0.14 },
            { "dirham", 0.091}

        };

        private bool invertido = false;

        public ConvertidorDivisas()
        {
            InitializeComponent();
        }

        private static void OnMonedaChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
        {
            if (d is ConvertidorDivisas control)
            {
                control.ActualizarMoneda();
            }
        }

        private void ActualizarMoneda()
        {
            // Actualizar el texto de la moneda en pantalla
            if (!string.IsNullOrEmpty(Moneda) && conversionFactor.ContainsKey(Moneda))
            {
                if (invertido)
                {
                    MonedaTextBlock.Text = "Euro";
                    ResultadoTextBlock.Text = Moneda;
                }
                else
                {
                    MonedaTextBlock.Text = Moneda;
                    ResultadoTextBlock.Text = "Euro";
                }
            }
        }

        private void ConvertirButton_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                double cantidad = double.Parse(CantidadTextBox.Text);
                double factor = conversionFactor[Moneda];

                double resultado = invertido ? cantidad / factor : cantidad * factor;
                ResultadoTextBox.Text = resultado.ToString("F2");
            }
            catch (Exception)
            {
                MessageBox.Show("Por favor, ingrese un número válido.");
            }
        }

        private void InvertirButton_Click(object sender, RoutedEventArgs e)
        {
            invertido = !invertido;
            ActualizarMoneda();

            // Recalcular inmediatamente con la cantidad actual
            if (!string.IsNullOrEmpty(CantidadTextBox.Text))
            {
                ConvertirButton_Click(sender, e);
            }
        }
    }
}
