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

namespace EjercicioImprovisado
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            
            //Dias
            List<int> listaDias = new List<int>();

            for (int i = 1; i <= 31; i++) {
                listaDias.Add(i);
            }

            foreach (int dia in listaDias) {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = dia;
                comboBoxDia.Items.Add(cbi);
            }


            //Meses
            List<String> listaMeses = new List<String>();

            listaMeses.Add("Enero");
            listaMeses.Add("Febrero");
            listaMeses.Add("Marzo");
            listaMeses.Add("Abril");
            listaMeses.Add("Mayo");
            listaMeses.Add("Junio");
            listaMeses.Add("Julio");
            listaMeses.Add("Agosto");
            listaMeses.Add("Septiembre");
            listaMeses.Add("Octubre");
            listaMeses.Add("Noviembre");
            listaMeses.Add("Diciembre");

            foreach (String mes in listaMeses) {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = mes;
                comboBoxMes.Items.Add(cbi);
            }


            //Años
            List<int> listaAnios = new List<int>();

            for (int i = ((int)DateTime.Today.Year); i >= 1900; i--) {
                listaAnios.Add(i);
            }

            foreach (int anio in listaAnios) {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = anio;
                comboBoxAnio.Items.Add(cbi);
            }


            //Dia de la semana
            List<String> listaDiasSemana = new List<String>();

            listaDiasSemana.Add("Lunes");
            listaDiasSemana.Add("Martes");
            listaDiasSemana.Add("Miercoles");
            listaDiasSemana.Add("Jueves");
            listaDiasSemana.Add("Viernes");
            listaDiasSemana.Add("Sabado");
            listaDiasSemana.Add("Domingo");

            foreach (String diaSemana in listaDiasSemana) {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = diaSemana;
                comboBoxDiaSemana.Items.Add(cbi);
            }
        }

        private void botonAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (comboBoxDia.SelectedItem != null && comboBoxMes.SelectedItem != null && comboBoxAnio.SelectedItem != null && comboBoxDiaSemana.SelectedItem != null)
                labelSalida.Content = comboBoxDiaSemana.SelectionBoxItem.ToString() + ", " + comboBoxDia.SelectionBoxItem.ToString() + " de " + comboBoxMes.SelectionBoxItem.ToString() + " de " + comboBoxAnio.SelectionBoxItem.ToString();
            else
                labelSalida.Content = "Por favor, introduzca todos los datos.";
        }
    }
}
