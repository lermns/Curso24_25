using examenP.dto;
using examenP.logica;
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
using System.Windows.Shapes;

namespace examenP
{
    /// <summary>
    /// Lógica de interacción para DialogoCliente.xaml
    /// </summary>
    public partial class DialogoCliente : Window
    {


        private LogicaNegocio logicaNegocio;
        public Cliente cliente; // el cliente esta con un Binding en sus atributos, por eso está en public
        private int posicion;
        private Boolean modificar;
        private int errores;// contabilizas si hay error

        public DialogoCliente(LogicaNegocio logicaNegocio)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            cliente = new Cliente(); // aquí se usa el constructor vacío 
            this.DataContext = cliente;//con el binding rellenas los datos. 
            modificar = false; // si llamas a este constructor es que estas añadiendo un cliente

        }
        // Segundo constructor para modificar cliente, si se llama a este es que estas modificando por tanto modificar=true
        public DialogoCliente(LogicaNegocio logicaNegocio, Cliente clienteModificar, int posicion)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            this.cliente = clienteModificar;
            this.posicion = posicion;
            this.DataContext = cliente;
            modificar = true;
        }


        private void BCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
        //compruebas
        private void BAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (modificar)
                logicaNegocio.modificarCliente(cliente,posicion);
            else
                logicaNegocio.aniadirCliente(cliente);

            this.Close();

        }

        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
                errores++;
            else
                errores--;

            if (errores == 0)
                BAceptar.IsEnabled = true;
            else
                BAceptar.IsEnabled = false;
        }
    }
}
