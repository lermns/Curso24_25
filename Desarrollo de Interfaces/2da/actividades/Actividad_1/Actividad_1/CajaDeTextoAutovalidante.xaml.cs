using System.Windows;
using System.Windows.Controls;

namespace Actividad_1
{
    public partial class CajaDeTextoAutovalidante : UserControl
    {
        public String TipoValidacion { get; set; }
        public String ErrorValidacion { get; set; }
        public CajaDeTextoAutovalidante()
        {
            InitializeComponent();
        }

        private void MiTextoAutovalidante_LostFocus(object sender, RoutedEventArgs e)
        {
            ErrorValidacion = "No hay Error";
            
            if (TipoValidacion == "DNI") {
                ChequeoDNI();
            }else if (TipoValidacion == "TFN")
            {
                ChequeoTFN();
            }else if (TipoValidacion == "CP")
            {
                ChequeoCP();
            }

            MiLabelControlError.Content = ErrorValidacion;
        }

        private void ChequeoCP() {
            String TextoInsertado;
            TextoInsertado = MiTextoAutovalidante.Text;

            if (TextoInsertado.Length == 5)
            {
                try
                {
                    int numeros = Int32.Parse(TextoInsertado);
                    ErrorValidacion = "No hay Error";
                }
                catch (FormatException e)
                {
                    ErrorValidacion = "El CP solo debe tener numeros";
                }
            }else {
                ErrorValidacion = "El codigo postal debe tener 5 dígitos";
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
                    ErrorValidacion = "El teléfono solo debe tener numeros";
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
                    int numeros = Int32.Parse(TextoInsertado.Substring(0, 7));
                    try
                    {
                        int letra = Int32.Parse(TextoInsertado.Substring(8));
                        ErrorValidacion = "El ultimo digito debe ser una letra";
                    }
                    catch (FormatException e)
                    {
                        ErrorValidacion = "No hay errores";
                    }
                }catch (FormatException e)
                {
                    ErrorValidacion = "Los 8 primeros digitos del dni deben de ser numeros.";
                }
            }
            else
            {
                ErrorValidacion = "El DNI debe tener 9 dígitos";
            }
        }
    }
}
