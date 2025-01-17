using AltaModificacion.dto;
using AltaModificacion.logica;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace AltaModificacion.interfaz
{
    /// <summary>
    /// Lógica de interacción para Pantalla principal.xaml
    /// </summary>
    public partial class PantallaPrincipal : Window
    {
        public LogicaNegocio LogicaNegocio { get; set; }

        public PantallaPrincipal()
        {
            InitializeComponent();
            LogicaNegocio = new LogicaNegocio();
            this.DataContext = this;
        }
        //El botón de modificar que aplica el metodo personaModificar al registro marcado
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Persona personaModificar = (Persona)DataGridPersonas.SelectedItem;
            DialogoPersona dialogoPersona = new DialogoPersona(LogicaNegocio, personaModificar, DataGridPersonas.SelectedIndex);
            dialogoPersona.ShowDialog();
        }
        //El submenu Alta... que lleva a la ventana emergente 
        private void NuevoMenuItem_Click_1(object sender, RoutedEventArgs e)
        {
            DialogoPersona dialogoPersona = new DialogoPersona(LogicaNegocio);
            dialogoPersona.ShowDialog();
        }
    }
}
