using System.Windows;
using System.Windows.Controls;
using Examen_Leo.DTO;
using Examen_Leo.DTO.Logica;

namespace Examen_Leo
{
    public partial class DialogoCliente : Window
    {
        private Logica logica;
        private Cliente cliente;
        public static MainWindow main;
        private int pos, cont;
        private Boolean bandera;

        public DialogoCliente(Logica logica)
        {
            InitializeComponent();
            this.logica = logica;
            cliente = new Cliente();
            this.DataContext = cliente;
            this.bandera = false;
        }

        public DialogoCliente(Logica logica, Cliente clienteModificar, int pos)
        {
            InitializeComponent();
            this.logica = logica;
            this.cliente = clienteModificar;
            this.pos = pos;
            this.bandera = true;
            this.DataContext = cliente;
        }

        

        private void ButtonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
            main.Visibility = Visibility.Visible;//muestra la ventana que previamente habiamos cerrado
        }

        private void ButtonAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (bandera)
                logica.modificarCliente(cliente, pos);
            else
                logica.aniadirCliente(cliente);

            this.Close();
            main.Visibility = Visibility.Visible;
        }

        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
            {
                cont++;
            }
            else
                cont--;
            if (cont == 0)
            {
                ButtonAceptar.IsEnabled = true;
            }
            else
                ButtonAceptar.IsEnabled = false;
        }
    }
}
