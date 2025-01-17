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
using System.Collections.ObjectModel;
using System.Globalization;


namespace WpfApp5
{
    /// <summary>
    /// Lógica de interacción para UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl
    {
        public String TipoValidacion { get; set; }
        public String ErrorValidacion { get; set; }

        public UserControl1()
        {
            InitializeComponent();
        }

   
        private void MiTextoAutovalidante_LostFocus(object sender, RoutedEventArgs e)
        {
            ErrorValidacion = "No hay error";

            if (TipoValidacion == "DNI")
            {
                ChequeoDNI();
            }
            else if (TipoValidacion == "TFN")
            {
                ChequeoTFN();
            }
            else if (TipoValidacion == "CP")
            {
                ChequeoCP();
            }
            MiLabelControlError.Content = ErrorValidacion;
        }
        
        private void ChequeoCP()
        {
            String TextoInsertado;
            TextoInsertado = MiTextoAutovalidante.Text;
            if(TextoInsertado.Length == 5)
            {
                try
                {
                    int numeros = Int32.Parse(TextoInsertado);
                    ErrorValidacion = "No hay Error";
                }
                catch (FormatException e)
                {
                    ErrorValidacion = "El CP sólo debe tener números";
                }
            } else
            {
                ErrorValidacion = "El código postal debe tener 5 dígitos";
            }
        }

        private void ChequeoTFN()
        {
            String TextoInsertado;
            TextoInsertado = MiTextoAutovalidante.Text;
            if (TextoInsertado.Length == 9)
            {
                try
                {
                    int numeros = Int32.Parse(TextoInsertado);
                    ErrorValidacion = "No hay Error";
                }
                catch (FormatException e)
                {
                    ErrorValidacion = "El teléfono sólo debe tener números";
                }
            }
            else
            {
                ErrorValidacion = "El teléfono debe tener 9 dígitos";
            }
        }
        private void ChequeoDNI()
        {
            String TextoInsertado;
            TextoInsertado = MiTextoAutovalidante.Text;
            if (TextoInsertado.Length == 9)
            {
                try
                {
                    int numeros = Int32.Parse(TextoInsertado.Substring(0,7));
                    try
                    {
                        int letra = Int32.Parse(TextoInsertado.Substring(8));
                        ErrorValidacion = "El último debe ser una letra";
                    }
                    catch (FormatException e)
                    {
                        ErrorValidacion = "No hay errores";
                    }
                }
                catch (FormatException e)
                {
                    ErrorValidacion = "Los 8 primeros dígitos del dni debe ser números";
                }
            }
            else
            {
                ErrorValidacion = "El DNI debe tener 9 dígitos";
            }
        }
    }
}