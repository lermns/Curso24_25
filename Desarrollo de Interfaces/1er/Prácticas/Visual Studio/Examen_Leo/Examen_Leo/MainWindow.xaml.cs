using System.Windows;
using Examen_Leo.DTO;
using Examen_Leo.DTO.Logica;

namespace Examen_Leo
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Logica logica;
        public MainWindow()
        {
            InitializeComponent();
            this.logica = new Logica();
            DialogoCliente.main = this;
            DataGridClientes.DataContext = logica;
        }

        private void MenuItemNuevo_Click(object sender, RoutedEventArgs e)
        {
            DialogoCliente dialogoCliente = new DialogoCliente(logica);
            dialogoCliente.Show();
            this.Visibility= Visibility.Collapsed;//oculta la ventana sin cerrarla, esto nos permite luego volver a hacerla visible
        }

        private void ButtonModificar_Click(object sender, RoutedEventArgs e)
        {
            if (DataGridClientes.SelectedIndex != -1)
            {
                Cliente cliente = DataGridClientes.SelectedItem as Cliente;
                DialogoCliente dialogoCliente = new DialogoCliente(logica, cliente.Clone() as Cliente, DataGridClientes.SelectedIndex);
                dialogoCliente.Show();
                this.Visibility = Visibility.Collapsed;
            }
        }
    }
}