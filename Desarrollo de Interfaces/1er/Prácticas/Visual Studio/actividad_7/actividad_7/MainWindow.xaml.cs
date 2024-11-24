
using System.Collections.ObjectModel;
using System.Windows;
using actividad_7.DTO;

namespace actividad_7
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public ObservableCollection<Persona> listaPersona { get; set; }
        private static int cont;

        public MainWindow()
        {
            listaPersona = new ObservableCollection<Persona>();
            listaPersona.Add(new Persona("carlos", "bite"));
            listaPersona.Add(new Persona("alba", "blame"));
            listaPersona.Add(new Persona("safi", "roger"));

            this.DataContext = this;

        }


        private void ButtonAdd_Click(object sender, RoutedEventArgs e)
        {
            listaPersona.Add(new Persona(TextName.Text, TextApe.Text));
        }

        private void ButtonDelete_Click(object sender, RoutedEventArgs e)
        {
            listaPersona.RemoveAt(listaPersona.Count()-1);
        }
    }
}
