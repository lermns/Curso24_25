using System;
using System.Windows;
using System.Windows.Controls;

namespace EjercicioComboBoxMultiLista
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void botonAceptar_Click(object sender, RoutedEventArgs e)
        {
            // Obtener el elemento seleccionado del ComboBox en el UserControl
            var selectedItem1 = MiComboBoxMultiLista1.miComboBox.SelectedItem;
            var selectedItem2 = MiComboBoxMultiLista2.miComboBox.SelectedItem;
            var selectedItem3 = MiComboBoxMultiLista3.miComboBox.SelectedItem;
            var selectedItem4 = MiComboBoxMultiLista4.miComboBox.SelectedItem;

            if (selectedItem1 != null && selectedItem2 != null && selectedItem3 !=  null && selectedItem4 != null)
            {
                var selectedContent = ((ComboBoxItem)selectedItem1).Content + ", " + ((ComboBoxItem)selectedItem2).Content + " de " + ((ComboBoxItem)selectedItem3).Content + " de " + ((ComboBoxItem)selectedItem4).Content;
                labelSalida.Content = selectedContent.ToString();
            }
            else
            {
                labelSalida.Content = "Por favor, seleccione un valor en el ComboBox.";
            }
        }
    }
}
