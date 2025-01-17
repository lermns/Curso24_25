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
using WpfApp3.dto;
using WpfApp3.logica;

namespace WpfApp3
{
    /// <summary>
    /// Lógica de interacción para Window1.xaml
    /// </summary>
    public partial class DialogoLibro: Window
    {
        private LogicaNegocio logicaNegocio;
        public Libro libro;
        public DialogoLibro(LogicaNegocio logicaNegocio)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            libro = new Libro();
            this.DataContext = libro;
        }

        private void ButtonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void ButtonAceptar_Click(object sender, RoutedEventArgs e)
        {
            logicaNegocio.aniadirLibro(libro);
            libro = new Libro();
            this.DataContext = libro;
        }
    }
}
