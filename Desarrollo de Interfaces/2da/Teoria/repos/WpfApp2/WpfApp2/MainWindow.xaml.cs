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

namespace WpfApp2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<persona> listaPersonas { get; set; }
        public MainWindow()
        {
            InitializeComponent();
            List<persona> listaPersonas = new List<persona>();
            listaPersonas.Add(new persona("Pablo", "González"));
            listaPersonas.Add(new persona("Pedro", "Fernández"));
            this.DataContext = this;
        }

        private void ComboBoxPersona_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ComboBoxItem cbi = (ComboBoxItem)ComboBoxPersona.SelectedItem;
            persona persona = (persona)cbi.Content;
            labelNombre.Content = persona.Nombre;
            labelApellidos.Content = persona.Apellidos;
        }

        private void BotonNuevoClick(object sender, RoutedEventArgs e)
        {
            listaPersonas.Add(new persona("Nuevo", "Nuevo"));
        }
    }
}
