using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;

namespace EjercicioComboBoxMultiLista
{
    public partial class ComboBoxMultiLista : UserControl
    {
        private string _tipoDato;

        public ComboBoxMultiLista()
        {
            InitializeComponent();

            // Llenar ComboBox inicialmente con días de la semana
            tipoDato = "DS";
            LlenarComboBoxDiasSemana();
        }

        public string tipoDato {
            get { return _tipoDato; }
            set
            {
                _tipoDato = value;
                setTipoDato();
            }
        }

        private void setTipoDato()
        {
            // Limpiar ComboBox antes de llenarlo con una nueva lista
            miComboBox.Items.Clear();

            if (tipoDato.Equals("DS"))
            {
                LlenarComboBoxDiasSemana();
            }
            else if (tipoDato.Equals("DM"))
            {
                LlenarComboBoxDias();
            }
            else if (tipoDato.Equals("M"))
            {
                LlenarComboBoxMeses();
            }
            else if (tipoDato.Equals("A"))
            {
                LlenarComboBoxAnios();
            }
        }

        private void LlenarComboBoxDiasSemana()
        {
            List<string> listaDiasSemana = new List<string> { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

            foreach (var diaSemana in listaDiasSemana)
            {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = diaSemana;
                miComboBox.Items.Add(cbi);
            }
        }

        private void LlenarComboBoxDias()
        {
            for (int i = 1; i <= 31; i++)
            {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = i;
                miComboBox.Items.Add(cbi);
            }
        }

        private void LlenarComboBoxMeses()
        {
            List<string> listaMeses = new List<string> { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };

            foreach (var mes in listaMeses)
            {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = mes;
                miComboBox.Items.Add(cbi);
            }
        }

        private void LlenarComboBoxAnios()
        {
            for (int i = 2030; i >= 2000; i--)
            {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = i;
                miComboBox.Items.Add(cbi);
            }
        }
    }
}
