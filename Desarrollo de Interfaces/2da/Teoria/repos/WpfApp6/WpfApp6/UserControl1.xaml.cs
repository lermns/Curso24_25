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

namespace WpfApp6
{
    /// <summary>
    /// Lógica de interacción para UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl
    {
        public String TipoDato { get; set; }
        public String ErrorValidacion { get; set; }


        public UserControl1()
        {
            InitializeComponent();
            Loaded += UserControl1_Loaded;
        }
        private void UserControl1_Loaded(object sender, RoutedEventArgs e)
        {
            CargarDatos();
        }

        private void CargarDatos()
        {
            ErrorValidacion = "No hay error";

            switch (TipoDato)
            {
                case "DM":
                    CargarDiasDelMes();
                    break;
                case "DS":
                    CargarDiasDeLaSemana();
                    break;
                case "M":
                    CargarMeses();
                    break;
                case "A":
                    CargarAnios();
                    break;
                default:
                    ErrorValidacion = "TipoDato no reconocido";
                    break;
            }

        }

        private void CargarDiasDelMes()
        {
            // Cargar días del mes (1 a 31)
            List<string> diasDelMes = Enumerable.Range(1, 31).Select(dia => dia.ToString()).ToList();
            MiComboBox.ItemsSource = diasDelMes;
        }

        private void CargarDiasDeLaSemana()
        {
            // Cargar días de la semana (lunes a domingo)
            List<string> diasDeLaSemana = new List<string> { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
            MiComboBox.ItemsSource = diasDeLaSemana;
        }

        private void CargarMeses()
        {
            // Cargar meses (enero a diciembre)
            List<string> meses = new List<string> { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
            MiComboBox.ItemsSource = meses;
        }

        private void CargarAnios()
        {
            // Cargar años (2000 a 2030)
            List<string> anios = Enumerable.Range(2000, 31).Select(anio => anio.ToString()).ToList();
            MiComboBox.ItemsSource = anios;
        }
    }
}