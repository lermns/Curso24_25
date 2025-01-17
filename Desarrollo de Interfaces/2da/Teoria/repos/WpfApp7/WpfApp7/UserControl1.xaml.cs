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

namespace WpfApp7
{
    /// <summary>
    /// Lógica de interacción para UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl
    {
        public string Juego { get; set; }
        public int Valor { get; set; }
        public string ErrorValidacion { get; set; }

        public UserControl1()
        {
            InitializeComponent();
        }

        private void MiTextoAutovalidante_LostFocus(object sender, RoutedEventArgs e)
        {
            ErrorValidacion = "No hay error";

            // Resto del código de validación según el TipoValidacion (DNI, TFN, CP)...

            MiLabelControlError.Content = ErrorValidacion;
        }

        public void ActualizarVisualizacion()
        {
            // Actualizar la visualización basada en los valores de Juego y Valor
            if (Juego == "HF")
            {
                if (Valor == 0)
                {
                    // Configurar la visualización para agua (puedes cambiar el color de fondo, texto, etc.)
                    this.Background = System.Windows.Media.Brushes.Blue;
                    MiTextoAutovalidante.Text = "Agua";
                }
                else if (Valor == 1)
                {
                    // Configurar la visualización para barco (puedes cambiar el color de fondo, texto, etc.)
                    this.Background = System.Windows.Media.Brushes.Black;
                    MiTextoAutovalidante.Text = "Barco";
                }
            }
            else if (Juego == "TR")
            {
                // Configurar la visualización para el juego de tres en raya (alternando entre X y O)
                MiTextoAutovalidante.Text = Valor == 1 ? "X" : (Valor == 0 ? "O" : "");
            }
        }
    }
}