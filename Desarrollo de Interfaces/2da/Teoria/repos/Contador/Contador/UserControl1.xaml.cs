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

namespace Contador
{
    /// <summary>
    /// Lógica de interacción para UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl
    {
        private int contador = 0;

        public UserControl1()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // Incrementar el contador y mostrarlo en el TextBlock
            contador++;
            outputText.Text = contador.ToString();

        }
         
        public void ResetCounter()
        {
            // Reiniciar el contador y actualizar el TextBlock
            contador = 0;
            outputText.Text = "0";
        }
    }
}
