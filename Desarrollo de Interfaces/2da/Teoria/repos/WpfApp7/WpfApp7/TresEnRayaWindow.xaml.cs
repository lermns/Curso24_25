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
using System.Windows.Shapes;

namespace WpfApp7
{
    /// <summary>
    /// Lógica de interacción para TresEnRayaWindow.xaml
    /// </summary>
    public partial class TresEnRayaWindow : Window
    {
        private int turno; // Variable para alternar entre X y O (0 para O, 1 para X)
        public TresEnRayaWindow()
        {
            InitializeComponent();
            InicializarJuego();
        }

        private void InicializarJuego()
        {
            turno = 0; // Iniciar con O
            // Asociar el mismo evento de clic a todas las celdas
            Celda00.MouseLeftButtonDown += Celda_Click;
            Celda01.MouseLeftButtonDown += Celda_Click;
            Celda02.MouseLeftButtonDown += Celda_Click;
            Celda10.MouseLeftButtonDown += Celda_Click;
            Celda11.MouseLeftButtonDown += Celda_Click;
            Celda12.MouseLeftButtonDown += Celda_Click;
            Celda20.MouseLeftButtonDown += Celda_Click;
            Celda21.MouseLeftButtonDown += Celda_Click;
            Celda22.MouseLeftButtonDown += Celda_Click;
        }

        private void Celda_Click(object sender, RoutedEventArgs e)
        {
            var celda = sender as UserControl1;
            if (celda != null)
            {
                // Verificar si la celda ya ha sido marcada
                if (string.IsNullOrEmpty(celda.MiTextoAutovalidante.Text))
                {
                    // Alternar entre X y O
                    celda.Valor = turno;
                    celda.ActualizarVisualizacion();
                    turno = 1 - turno; // Alternar entre 0 y 1
                }
            }

            // Aquí puedes agregar lógica para verificar si hay un ganador, etc.
        }
    }
}
