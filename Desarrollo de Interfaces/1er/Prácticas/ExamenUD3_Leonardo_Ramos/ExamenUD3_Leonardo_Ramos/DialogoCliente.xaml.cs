using System.Windows;
using System.Windows.Controls;
using ExamenUD3_Leonardo_Ramos.DTO;
using ExamenUD3_Leonardo_Ramos.DTO.Logica;

namespace ExamenUD3_Leonardo_Ramos
{
    public partial class DialogoCliente : Window
    {
        private Logica logica;
        private Cliente cliente;
        // Uso una variable Main estatica para guardar la ventana usada y asi al ocultarla recuperarla cuando la vuelva a usar
        public static MainWindow main;
        private int pos, cont;

        private Boolean bandera;

        // primer constructor que se crea al inicio con un cliente por defecto
        public DialogoCliente(Logica logica)
        {
            InitializeComponent();
            this.logica = logica;
            cliente = new Cliente();
            DataContext = cliente;
            bandera = false;
        }

        // sobrecarga de constructores con parametros para modificar el cliente
        public DialogoCliente(Logica logica, Cliente clienteModificar, int pos)
        {
            InitializeComponent();
            this.logica = logica;
            cliente = clienteModificar;
            this.pos = pos;
            bandera = true;
            DataContext = cliente;
        }



        private void ButtonCancelar_Click(object sender, RoutedEventArgs e)
        {
            // Cierra la ventana y abre la principal que teniamos guardada como estatica
            Close();
            main.Visibility = Visibility.Visible;//muestra la ventana que previamente habiamos cerrado
        }

        private void ButtonAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (bandera)
                logica.modificarCliente(cliente, pos);
            else
                logica.aniadirCliente(cliente);

            // En este caso lo mismo solo que guarda los datos en la lista y cierra la ventana de dialogo para abrir la ventana principal
            Close();
            main.Visibility = Visibility.Visible;
        }

        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            //  en caso de que la cantidad de errores sea mayor a 0 este te desactivara el boton para no agregar los datos a medias
            if (e.Action == ValidationErrorEventAction.Added)
                cont++;
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
