using System.Windows;
using System.Windows.Controls;
using actividad_8.DTO;
using actividad_8.DTO.Logica;

namespace actividad_8
{
    public partial class DialogoLibro : Window
    {
        private Logica logica;
        private Libro libro;
        public static MainLibro main;
        private int pos, cont;
        private Boolean bandera;
        public DialogoLibro(Logica logica)
        {
            InitializeComponent();
            this.logica = logica;
            libro = new Libro();
            this.DataContext = libro;
            this.bandera = false;
        }

        public DialogoLibro(Logica logica, Libro libroModificar, int pos)
        {
            InitializeComponent();
            this.logica = logica;
            this.libro = libroModificar;
            this.pos = pos;
            this.bandera = true;
            this.DataContext = libro;
        }

        private void ButtonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
            main.Visibility = Visibility.Visible;//muestra la ventana que previamente habiamos cerrado
        }

        private void ButtonAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (bandera)
                logica.modificarLibro(libro, pos);
            else
                logica.aniadirLibros(libro);
            
            this.Close();
            main.Visibility = Visibility.Visible;
        }

        private void Validation_Error(object sender, ValidationErrorEventArgs e) {
            if (e.Action == ValidationErrorEventAction.Added) {
                cont++;
            }else
                cont--;
            if (cont == 0) { 
                ButtonAceptar.IsEnabled = true;
            }else
                ButtonAceptar.IsEnabled = false;
        }
    }
}
