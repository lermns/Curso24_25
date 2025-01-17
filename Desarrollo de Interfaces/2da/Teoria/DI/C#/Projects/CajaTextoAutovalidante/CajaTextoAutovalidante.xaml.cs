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

namespace CajaTextoAutovalidante
{
    /// <summary>
    /// Lógica de interacción para CajaTextoAutovalidante.xaml
    /// </summary>
    public partial class CajaTextoAutovalidante : UserControl
    {
        public String tipoValidacion { get; set; }
        public String errorValidacion { get; set; }
        public CajaTextoAutovalidante()
        {
            InitializeComponent();
        }

        private void TextBox_LostFocus(object sender, RoutedEventArgs e)
        {
            errorValidacion = "No hay error";

            if (tipoValidacion == "DNI")
            {
                ChequeoDNI();
            }
            else if (tipoValidacion == "TFN")
            {
                ChequeoTFN();
            }
            else if (tipoValidacion == "CP")
            {
                ChequeoCP();
            }

            MiLabelControlError.Content = errorValidacion;
        }

        private void ChequeoDNI()
        {
            String textoInsertado;
            textoInsertado = MiTextoAutovalidante.Text;
            if (textoInsertado.Length == 9)
            {
                try
                {
                    int numeros = Int32.Parse(textoInsertado.Substring(0, 7));
                    try
                    {
                        int letra = Int32.Parse(textoInsertado.Substring(8));
                        errorValidacion = "El ultimo digito debe ser una letra.";
                    }
                    catch (FormatException e)
                    {
                        errorValidacion = "No hay errores";
                    }
                }
                catch (FormatException e)
                {
                    errorValidacion = "Los 8 primeros digitos del DNI deben ser numeros.";
                }
            }
            else
            {
                errorValidacion = "El DNI debe tener 9 digitos.";
            }
        }

        private void ChequeoTFN()
        {
            String textoInsertado;
            textoInsertado = MiTextoAutovalidante.Text;
            if (textoInsertado.Length == 9)
            {
                try
                {
                    int numeros = Int32.Parse(textoInsertado);
                    errorValidacion = "No hay error";
                }
                catch (FormatException e)
                {
                    errorValidacion = "El telefono solo debe tener numeros.";
                }
            }
            else
            {
                errorValidacion = "El telefono debe tener 9 digitos.";
            }
        }

        private void ChequeoCP()
        {
            String textoInsertado;
            textoInsertado = MiTextoAutovalidante.Text;
            if (textoInsertado.Length == 5)
            {
                try
                {
                    int numeros = Int32.Parse(textoInsertado);
                    errorValidacion = "No hay error";
                }
                catch (FormatException e)
                {
                    errorValidacion = "El codigo postal solo debe tener numeros.";
                }
            }
            else
            {
                errorValidacion = "El codigo postal debe tener 5 digitos.";
            }
        }
    }
}
