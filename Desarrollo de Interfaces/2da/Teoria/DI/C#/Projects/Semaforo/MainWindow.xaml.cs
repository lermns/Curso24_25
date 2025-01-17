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

namespace Semaforo
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

        private void RadioButton_Checked(object sender, RoutedEventArgs e)
        {
            elipseRoja.Visibility = Visibility.Visible;
            elipseAmarilla.Visibility = Visibility.Hidden;
            elipseVerde.Visibility = Visibility.Hidden;
        }

        private void RadioButton_Checked_1(object sender, RoutedEventArgs e)
        {
            elipseAmarilla.Visibility = Visibility.Visible;
            elipseRoja.Visibility = Visibility.Hidden;
            elipseVerde.Visibility = Visibility.Hidden;
        }

        private void RadioButton_Checked_2(object sender, RoutedEventArgs e)
        {
            elipseVerde.Visibility= Visibility.Visible;
            elipseRoja.Visibility = Visibility.Hidden;
            elipseAmarilla.Visibility = Visibility.Hidden;
        }
    }
}
