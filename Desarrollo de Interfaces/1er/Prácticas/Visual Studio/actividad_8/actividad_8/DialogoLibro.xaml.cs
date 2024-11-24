using System.Windows;
using actividad_8.DTO;
using actividad_8.DTO.Logica;

namespace actividad_8
{
    public partial class DialogoLibro : Window
    {
        private Logica logica;
        private Libro libro;
        public static MainLibro main;
        public DialogoLibro(Logica logica)
        {
            InitializeComponent();
            this.logica = logica;
            libro = new Libro();
            this.DataContext = libro;
        }

        private void ButtonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
            main.Visibility = Visibility.Visible;//muestra la ventana que previamente habiamos cerrado
        }

        private void ButtonAceptar_Click(object sender, RoutedEventArgs e)
        {
            logica.aniadirLibros(libro);
            this.Close();
            main.Visibility = Visibility.Visible;
        }
    }
}
