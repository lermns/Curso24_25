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
using System.Windows.Shapes;

namespace Examen1
{
    /// <summary>
    /// Lógica de interacción para DialogView.xaml
    /// </summary>
    public partial class DialogView : Window
    {
        public DialogView()
        {
            InitializeComponent();
        }

        private void Window_Closed(object sender, EventArgs e)
        {
            // Limpia el DataContext al cerrar la ventana para evitar referencias no deseadas
            DataContext = null;
        }
    }
}
