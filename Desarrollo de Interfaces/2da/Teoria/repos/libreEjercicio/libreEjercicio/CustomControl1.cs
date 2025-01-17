using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace libreEjercicio
{
    /// <summary>
    /// Lógica de interacción para UserControl1.xaml
    /// </summary>
    public partial class CustomControl1 : CustomControl1
    {
        public CustomControl1()
        {
            InitializeComponent();
        }

        public string TipoSituacion
        {
            get { return (string)GetValue(TipoSituacionProperty); }
            set { SetValue(TipoSituacionProperty, value); }
        }

        public static readonly DependencyProperty TipoSituacionProperty =
            DependencyProperty.Register("TipoSituacion", typeof(string), typeof(UserControl1), new PropertyMetadata(string.Empty, TipoSituacionPropertyChanged));

        private static void TipoSituacionPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
        {
            if (d is CustomControl1 userControl)
            {
                userControl.CambiarEstilo();
            }
        }

        private void CambiarEstilo()
        {
            string texto = TextBox.Text.ToLower();

            switch (TipoSituacion.ToLower())
            {
                case "seguro":
                    AplicarEstilo(Colors.Red, Colors.Yellow, FontStyles.Normal, FontWeights.Bold);
                    break;
                case "precaucion":
                    AplicarEstilo(Colors.Yellow, Colors.Green, FontStyles.Normal, FontWeights.Bold);
                    break;
                case "peligro":
                    AplicarEstilo(Colors.Green, Colors.Red, FontStyles.Normal, FontWeights.Bold);
                    break;
                default:
                    MessageBox.Show("Tipo de situación no especificado correctamente.");
                    break;
            }
        }

        private void AplicarEstilo(Color colorTexto, Color colorFondo, FontStyle estiloTexto, FontWeight pesoTexto)
        {
            textBox.Text = textBox.Text.ToUpper();
            textBox.Foreground = new SolidColorBrush(colorTexto);
            textBox.Background = new SolidColorBrush(colorFondo);
            textBox.FontStyle = estiloTexto;
            textBox.FontWeight = pesoTexto;
        }
    }
}
