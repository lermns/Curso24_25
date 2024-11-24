using System.Windows;
using actividad_8.DTO.Logica;

namespace actividad_8
{
    
    public partial class MainLibro : Window
    {
        private Logica logica;
        public MainLibro()
        {
            InitializeComponent();
            this.logica = new Logica();
            DialogoLibro.main = this;
            DataGridLibros.DataContext = logica;
        }

        private void MenuMn_Click(object sender, RoutedEventArgs e)
        {
            DialogoLibro dialogoLibro = new DialogoLibro(logica);
            dialogoLibro.Show();
            this.Visibility= Visibility.Collapsed;//oculta la ventana sin cerrarla, esto nos permite luego volver a hacerla visible
        }
    }
}