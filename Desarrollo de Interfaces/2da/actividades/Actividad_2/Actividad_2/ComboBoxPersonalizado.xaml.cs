using System.Windows;
using System.Windows.Controls;

namespace Actividad_2
{
    public partial class ComboBoxPersonalizado : UserControl
    {
        private string tipoDate="";
        public string TipoDato
        {
            get { return tipoDate; }
            set
            {
                tipoDate = value;
                ActualizarComboBox();
            }
        }

        public ComboBoxPersonalizado()
        {
            InitializeComponent();
        }

        private void ActualizarComboBox()
        {
            
            MiComboBox.Items.Clear();

            switch (tipoDate)
            {
                case "DM":
                    Console.WriteLine("awdaawdawdawdawdawdawdawwwwwwwwwwdawwdddddddddddddddddddddddddddddddddddddddddddd");
                    foreach (var dia in Enumerable.Range(1, 31))
                        MiComboBox.Items.Add(dia);
                    break;

                case "DS":
                    var diasSemana = new[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
                    foreach (var dia in diasSemana)
                        MiComboBox.Items.Add(dia);
                    break;

                case "M":
                    var meses = new[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
                    foreach (var mes in meses)
                        MiComboBox.Items.Add(mes);
                    break;

                case "A":
                    foreach (var anio in Enumerable.Range(2000, 31))
                        MiComboBox.Items.Add(anio);
                    break;

                default:
                    MiComboBox.Items.Add("Tipo de dato no válido");
                    break;
            }
        }

    }
}

