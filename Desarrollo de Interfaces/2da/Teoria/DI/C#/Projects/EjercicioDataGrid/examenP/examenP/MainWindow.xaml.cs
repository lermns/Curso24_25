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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace examenP
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private LogicaNegocio logicaNegocio;

        public MainWindow()
        {
            InitializeComponent();
            logicaNegocio = new LogicaNegocio();
            DataGridClientes.DataContext = logicaNegocio;
        }

        private void NuevoMenuItem_Click(object sender, RoutedEventArgs e)
        {

            DialogoCliente dialogo = new DialogoCliente(logicaNegocio);
            dialogo.Show();
        }

        private void BModificar_Click(object sender, RoutedEventArgs e)
        {
            if (DataGridClientes.SelectedIndex != -1)
            {
                Cliente cliente = (Cliente) DataGridClientes.SelectedItem;
                DialogoCliente dialogoCliente = new DialogoCliente(logicaNegocio, (Cliente)cliente.Clone(), DataGridClientes.SelectedIndex);
                
                dialogoCliente.Show();


            }
        }
    }
}
