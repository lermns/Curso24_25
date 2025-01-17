using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Imaging;

namespace ET4_3_Pedro_Borregan
{
    public partial class MiBotonPersonalizado : UserControl
    {
        private string _pj;

        public string Pj
        {
            get { return _pj; }
            set
            {
                _pj = value;
                CambiarPj();
            }
        }

        private void CambiarPj()
        {
        //IMPORTANTE: Tienen que añadirse las rutas al menos la primera vez para que sean reconocidas por el proyecto
                                                                        //(aparecen en el explorador de soluciones =>)
            if (Pj == "Bunny") {
                OurPj.Source = new BitmapImage(new Uri("bugs bunny comunista tenemos.PNG", UriKind.Relative));
            }
            
            if (Pj == "Mouse")
            {
                OurPj.Source = new BitmapImage(new Uri("mickey mouse comunista.PNG", UriKind.Relative));
            }

            if (Pj == "Pooh")
            {
                OurPj.Source = new BitmapImage(new Uri("winnie the pooh comunista.PNG", UriKind.Relative));
            }
        }

        public static readonly DependencyProperty BotonColorProperty =
            DependencyProperty.Register("BotonColor", typeof(Brush), typeof(MiBotonPersonalizado), new PropertyMetadata(Brushes.LightGray));

        public Brush BotonColor
        {
            get { return (Brush)GetValue(BotonColorProperty); }
            set { SetValue(BotonColorProperty, value); }
        }

        public MiBotonPersonalizado()
        {
            InitializeComponent();
            NuestraEtiqueta1.Visibility = Visibility.Collapsed;
            NuestraEtiqueta2.Visibility = Visibility.Collapsed;
            OurPj.Visibility = Visibility.Collapsed;
            NuestraEtiqueta3.Visibility = Visibility.Collapsed;
        }

        private void MiBoton_Click(object sender, RoutedEventArgs e)
        {
            // Cambiar el color al pulsar el botón
            BotonColor = Brushes.Red; // Puedes cambiar esto a cualquier color deseado
            NuestraEtiqueta1.Visibility = Visibility.Visible;
            NuestraEtiqueta2.Visibility = Visibility.Visible;
            OurPj.Visibility = Visibility.Visible;
            NuestraEtiqueta3.Visibility = Visibility.Visible;
        }
    }
}
