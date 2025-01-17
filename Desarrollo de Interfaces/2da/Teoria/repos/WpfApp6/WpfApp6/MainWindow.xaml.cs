using System;
using System.Collections.Generic;
using System.Globalization;
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
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void GenerarMensaje_Click(object sender, RoutedEventArgs e)
        {
            int dia = Convert.ToInt32(FechaControl.MiComboBox.SelectedItem);
            string mes = (string)MesControl.MiComboBox.SelectedItem;
            int anio = Convert.ToInt32(AnioControl.MiComboBox.SelectedItem);

            DateTime fechaNacimiento = new DateTime(anio, MesACodigo(mes), dia);

            CultureInfo culturaEspañola = new CultureInfo("es-ES");
            string diaSemana = fechaNacimiento.ToString("dddd", culturaEspañola);

            ResultadoLabel.Content = $"Has nacido el {dia} de {mes} de {anio}, {diaSemana}";
        }

        private int MesACodigo(string mes)
        {
            // Convierte el nombre del mes a su número correspondiente
            switch (mes)
            {
                case "Enero": return 1;
                case "Febrero": return 2;
                case "Marzo": return 3;
                case "Abril": return 4;
                case "Mayo": return 5;
                case "Junio": return 6;
                case "Julio": return 7;
                case "Agosto": return 8;
                case "Septiembre": return 9;
                case "Octubre": return 10;
                case "Noviembre": return 11;
                case "Diciembre": return 12;
                default: return 1;
            }
        }
    }
}
