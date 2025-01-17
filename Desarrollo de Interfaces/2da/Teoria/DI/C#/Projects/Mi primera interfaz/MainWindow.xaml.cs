using Mi_primera_interfaz.dto;
using System;
using System.Collections.Generic;
using System.ComponentModel;
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

namespace Mi_primera_interfaz
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        bool traducido = false;
        int clicks = 0;
        List<Persona> listaPersonas;

        public MainWindow()
        {
            InitializeComponent();
            label2.Visibility = Visibility.Hidden;
            comboBoxPersonas.Visibility = Visibility.Hidden;
            listaPersonas = new List<Persona>();
            listaPersonas.Add(new Persona("Pedro", "Martínez de la Rosa"));
            listaPersonas.Add(new Persona("Antonio", "Lobato Porras"));

            foreach (Persona persona in listaPersonas)  //o this.DataContext = this; (Binding)
            {
                ComboBoxItem cbi = new ComboBoxItem();    //Creamos un elemento casilla para añadirlo después al Combo Box.
                cbi.Content = persona;                 //El elemento casilla es igual al contenido (traducido a String) guardado en cada una de las personas (posiciones de la lista).
                comboBoxPersonas.Items.Add(cbi);    //Añadimos el elemento al Combo Box.
            }
        }

        private void Boton_Click(object sender, RoutedEventArgs e)
        {
            clicks++;

            if (clicks == 4)
            {
                this.Close();
            }

            if (clicks == 3)
            {
                label1.Visibility = Visibility.Hidden;
                boton.Content = "Cerrar";
            }

            if (clicks == 2)
            {
                foreach (Persona persona in listaPersonas) {
                    if (comboBoxPersonas.SelectionBoxItem == persona)
                    {
                        label2.Content = "Y buenos días, Sr. " + comboBoxPersonas.SelectionBoxItem;
                    }
                }

                comboBoxPersonas.Visibility = Visibility.Collapsed;
                boton.Content = "Ocultar";
            }

            if (!traducido)
            {
                label1.Content = "Hola, mundo";
                label2.Visibility = Visibility.Visible;
                comboBoxPersonas.Visibility = Visibility.Visible;
                boton.Content = "Introducir";
                traducido = true;
            }
        }
    }
}
