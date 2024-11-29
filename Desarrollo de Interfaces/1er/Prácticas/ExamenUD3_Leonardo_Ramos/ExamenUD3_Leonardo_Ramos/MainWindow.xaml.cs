using System.Windows;
using ExamenUD3_Leonardo_Ramos.DTO;
using ExamenUD3_Leonardo_Ramos.DTO.Logica;

namespace ExamenUD3_Leonardo_Ramos
{
    public partial class MainWindow : Window
    {
        public Logica logica;
        public MainWindow() {
            InitializeComponent();
            this.logica = new Logica();

            //  Le pasamos esta ventana a dialogo para que la guarde y esta se pueda cerrar y asi cuando la queramos volver a ver simplemente tendremos
            //  que volver a mostrarla, asi nos evitamos la instanciacion de las ventanas de forma innecesaria.
            DialogoCliente.main = this;
            DataGridListaClientes.DataContext = logica;
            
        }

        private void MenuItemNuevo_Click(object sender, RoutedEventArgs e)
        {
            DialogoCliente dialogoCliente = new DialogoCliente(logica);
            dialogoCliente.Show();

            // oculta la ventana sin cerrarla, esto nos permite luego volver a hacerla visible
            this.Visibility = Visibility.Collapsed;
        }

        private void ButtonModificar_Click(object sender, RoutedEventArgs e)
        {
            if (DataGridListaClientes.SelectedIndex != -1)
            {
                //  Coge al Cliente seleccionado como Object y lo castea a Cliente para luego pasarlo al constructor que recibe parametros para modificar
                //  al cliente junto a su indice en la lista.
                Cliente cliente = DataGridListaClientes.SelectedItem as Cliente;
                DialogoCliente dialogoCliente = new DialogoCliente(logica, cliente.Clone() as Cliente, DataGridListaClientes.SelectedIndex);
                
                //  Hecho esto mostramos la ventana de Dialogo para editarlo y ocultamos la ventana Main para recuperarlo luego
                //  Todo esto de recoger los datos se encargara la parte de los Binding que esta declara en el Mainwindow y en el Dialogo que son los que estan 
                //  constantemente escuchando los valores de la lista y en caso de editar algun cliente tambien.
                dialogoCliente.Show();
                this.Visibility = Visibility.Collapsed;
            }
        }
    }
}