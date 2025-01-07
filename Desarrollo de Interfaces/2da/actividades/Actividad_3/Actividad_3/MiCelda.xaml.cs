using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Actividad_3
{
    public partial class MiCelda : UserControl
    {
        // Propiedades
        public string Juego { get; set; } // HF o TR
        public int Valor { get; set; } // 0 para agua/O, 1 para barco/X

        public MiCelda()
        {
            InitializeComponent();
        }

        public void ActualizarCelda()
        {
            // Limpiar contenido previo
            Contenedor.Children.Clear();

            if (Juego == "HF") // Hundir la flota
            {
                if (Valor == 0) // Agua
                {
                    Background = Brushes.Blue;
                    var texto = new TextBlock { Text = "Agua", HorizontalAlignment = HorizontalAlignment.Center, VerticalAlignment = VerticalAlignment.Center };
                    Contenedor.Children.Add(texto);
                }
                else if (Valor == 1) // Barco
                {
                    Background = Brushes.Black;
                    var circulo = new Ellipse
                    {
                        Width = 20,
                        Height = 20,
                        Fill = Brushes.White,
                        HorizontalAlignment = HorizontalAlignment.Center,
                        VerticalAlignment = VerticalAlignment.Center
                    };
                    Contenedor.Children.Add(circulo);
                }
            }
            else if (Juego == "TR") // Tres en Raya
            {
                if (Valor == 0) // O
                {
                    var texto = new TextBlock { Text = "O", FontSize = 30, HorizontalAlignment = HorizontalAlignment.Center, VerticalAlignment = VerticalAlignment.Center };
                    Contenedor.Children.Add(texto);
                }
                else if (Valor == 1) // X
                {
                    var texto = new TextBlock { Text = "X", FontSize = 30, HorizontalAlignment = HorizontalAlignment.Center, VerticalAlignment = VerticalAlignment.Center };
                    Contenedor.Children.Add(texto);
                }
            }
        }
    }
}
