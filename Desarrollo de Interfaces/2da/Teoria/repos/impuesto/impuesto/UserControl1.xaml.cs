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


namespace impuesto
{
    public partial class UserControl1 : UserControl
    {
        private double tipoIVA;

        public UserControl1()
        {
            InitializeComponent();
        }

        public double TipoIVA
        {
            get { return tipoIVA; }
            set
            {
                if (value == 0.04 || value == 0.10 || value == 0.21)
                {
                    tipoIVA = value;
                    CalcularIVA();
                }
            }
        }

        private void CalcularIVA()
        {
            if (double.TryParse(textBoxNumero.Text, out double numero))
            {
                double resultado = numero * (1 + tipoIVA);
                textBoxResultado.Text = resultado.ToString("N2");
            }
            else
            {
                MessageBox.Show("Por favor, ingrese un número válido.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        private void textBoxNumero_LostFocus(object sender, System.Windows.RoutedEventArgs e)
        {
            CalcularIVA();
        }
    }
}