using System;
using System.Globalization;
using System.Windows;

namespace Actividad_2
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Generar_Click(object sender, RoutedEventArgs e)
        {
                       
            try
            {
                if (ComboDia.MiComboBox.SelectedItem == null ||
                    ComboMes.MiComboBox.SelectedItem == null ||
                    ComboAnio.MiComboBox.SelectedItem == null)
                {
                    MessageBox.Show("Por favor, selecciona un valor en todos los campos.", "Error de validación", MessageBoxButton.OK, MessageBoxImage.Warning);
                    return;
                }

                int dia = Convert.ToInt32(ComboDia.MiComboBox.SelectedItem);
                string mes = ComboMes.MiComboBox.SelectedItem.ToString();
                int anio = Convert.ToInt32(ComboAnio.MiComboBox.SelectedItem);

                int mesIndex = DateTime.ParseExact(mes, "MMMM", CultureInfo.CurrentCulture).Month;

                DateTime fechaNacimiento = new DateTime(anio, mesIndex, dia);
                string diaSemana = fechaNacimiento.ToString("dddd", new CultureInfo("es-ES"));

                DiaSemana.Text = diaSemana;

                Resultado.Content = $"Has nacido el {dia} de {mes} de {anio}, {diaSemana}.";
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al generar la fecha: {ex.Message}", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

    }
}