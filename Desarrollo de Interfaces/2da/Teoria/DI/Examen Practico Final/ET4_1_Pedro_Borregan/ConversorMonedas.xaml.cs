using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
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

namespace ET4_1_Pedro_Borregan
{

    public partial class ConversorMonedas : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        public ObservableCollection<string> Monedas { get; } = new ObservableCollection<string> { "DOLLAR", "DIRHAM", "YUAN", "LIBRA" };

        private string _selectedMoneda;
        public string SelectedMoneda
        {
            get { return _selectedMoneda; }
            set
            {
                if (_selectedMoneda != value)
                {
                    _selectedMoneda = value;
                    OnPropertyChanged(nameof(SelectedMoneda));
                }
            }
        }

        private double _cantidad;
        public double Cantidad
        {
            get { return _cantidad; }
            set
            {
                if (_cantidad != value)
                {
                    _cantidad = value;
                    OnPropertyChanged(nameof(Cantidad));
                }
            }
        }

        private double _resultado;
        public double Resultado
        {
            get { return _resultado; }
            set
            {
                if (_resultado != value)
                {
                    _resultado = value;
                    OnPropertyChanged(nameof(Resultado));
                }
            }
        }

        private bool _invertido;
        public bool Invertido
        {
            get { return _invertido; }
            set
            {
                if (_invertido != value)
                {
                    _invertido = value;
                    OnPropertyChanged(nameof(Invertido));
                }
            }
        }

        public ConversorMonedas()
        {
            SelectedMoneda = Monedas.FirstOrDefault();
        }

        public void Convertir()
        {
            double factor = Invertido ? 1 / ObtenerFactor(SelectedMoneda) : ObtenerFactor(SelectedMoneda);
            Resultado = Cantidad * factor;
        }

        public void Invertir()
        {
            Invertido = !Invertido;
        }

        private double ObtenerFactor(string moneda)
        {
            switch (moneda)
            {
                case "DOLLAR": return 0.92;
                case "DIRHAM": return 0.091;
                case "YUAN": return 0.14;
                case "LIBRA": return 1.13;
                default: return 1.0;
            }
        }

        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }

}
