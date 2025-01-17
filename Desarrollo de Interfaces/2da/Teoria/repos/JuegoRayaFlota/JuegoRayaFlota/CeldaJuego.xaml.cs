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

namespace JuegoRayaFlota
{

    public partial class CeldaJuego : UserControl
    {
        public int Valor
        {
            get { return (int)GetValue(ValorProperty); }
            set { SetValue(ValorProperty, value); }
        }

        public static readonly DependencyProperty ValorProperty =
            DependencyProperty.Register("Valor", typeof(int), typeof(CeldaJuego), new PropertyMetadata(-1));

        public CeldaJuego()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (Valor == -1)
            {
                Valor = TurnoActual;
                TurnoActual = 1 - TurnoActual; // Alternar entre 0 y 1
            }
        }

        private static int TurnoActual { get; set; } = 0;
    }
}
