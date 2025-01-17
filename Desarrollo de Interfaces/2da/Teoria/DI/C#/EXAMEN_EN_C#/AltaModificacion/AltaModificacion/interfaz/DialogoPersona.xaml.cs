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
using System.Windows.Shapes;

namespace AltaModificacion.interfaz
{
    /// <summary>
    /// Lógica de interacción para DialogoPersona.xaml
    /// </summary>
    public partial class DialogoPersona : Window
    {
        public Persona Persona {get;set;}
        private LogicaNegocio logicaNegocio;
        private int posicion = -1;
        private int numErrores = 0;
        public ObservableCollection<Persona> Personas { get; set; }

        //Constructor para la creación de una nueva persona
        public DialogoPersona(LogicaNegocio LogicaNegocio)
        {
            InitializeComponent();
            this.logicaNegocio = LogicaNegocio;
            Persona = new Persona();
            this.DataContext = this;
            dataGridPersonas.ItemsSource = Personas;

            //suscribir al evento ValueChanged del slider
            sliderValoracion.ValueChanged += SliderValoracion_ValueChanged;
        }

        private void SliderValoracion_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (Persona != null)
            {
                Persona.Valoracion = (int)sliderValoracion.Value;
            }
        }

        //Constructor para la modificación de una persona existente
        public DialogoPersona(LogicaNegocio LogicaNegocio,Persona personaModificar,int posicion)
        {
            InitializeComponent();
            this.logicaNegocio = LogicaNegocio;
            Persona = (Persona)personaModificar.Clone();
            this.posicion = posicion;
            this.DataContext = this;
            sliderValoracion.ValueChanged += Slider_ValueChanged;
            dataGridPersonas.ItemsSource = logicaNegocio.ListaPersonas; // Enlazar DataGrid a la lista de personas
        }

        //Introdución de datos en la lista persona
        private void BotonAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (posicion != -1)
                logicaNegocio.ListaPersonas[posicion] = Persona;
            else
                logicaNegocio.ListaPersonas.Add(Persona);

            this.Close();  //cerrar ventana
        }

        //Método llamado cuando hay error de validación
        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
            {
                numErrores++;
                ((Control)sender).ToolTip = e.Error.ErrorContent;
            }
            else if (e.Action == ValidationErrorEventAction.Removed)
            {
                numErrores--;
                ((Control)sender).ToolTip = null;
            }
            if (numErrores == 0)
                BotonAceptar.IsEnabled = true;
            else
                BotonAceptar.IsEnabled = false;


        }

        //Manejador de eventos para el cambio de valor del slider en caso de modificación
        private void Slider_ValueChanged(object sender, RoutedPropertyChangedEventArgs<double> e)
        {
            if (Persona != null)
            {
                Persona.Valoracion = (int)sliderValoracion.Value;
            }
        }

        //Método llamado al hacer clic en el botón cancelar
        private void BotonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void DataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }
    }
}
