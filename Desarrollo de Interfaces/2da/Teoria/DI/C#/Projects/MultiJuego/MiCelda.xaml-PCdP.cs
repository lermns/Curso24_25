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
using System.Windows.Threading;

namespace MultiJuego
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MiCelda : UserControl
    {
        public DispatcherTimer timer;
        private bool isHFTurn; // Flag para controlar el turno en Hundir la Flota

        public string Juego { get; set; } // Puede ser "HF" o "TR"

        private int _valor;
        private object ContentPosition;

        public int Valor
        {
            get { return _valor; }
            set
            {
                _valor = value;
                ActualizarApariencia();
            }
        }

        public MiCelda()
        {
            timer = new DispatcherTimer();
            timer.Interval = TimeSpan.FromSeconds(1);
            timer.Tick += Timer_Tick;
            isHFTurn = true;
        }

        private void ActualizarApariencia()
        {
            if (Juego == "HF")
            {
                if (Valor == 0) // Agua
                {
                    Background = Brushes.Blue; // Puedes cambiar el color según tus preferencias
                    Content = "Agua";
                }
                else if (Valor == 1) // Barco
                {
                    Background = Brushes.Black; // Puedes cambiar el color según tus preferencias
                    Content = "Barco";
                }
            }
            else if (Juego == "TR")
            {
                // Alternar entre X y O en Tres en Raya
                if (Valor == 0)
                    Content = "O";
                else if (Valor == 1)
                    Content = "X";
            }
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            if (Juego == "TR")
            {
                // Alternar entre X y O en Tres en Raya
                Valor = (Valor + 1) % 2;
            }
            else if (Juego == "HF")
            {
                // Simular el turno en Hundir la Flota
                if (isHFTurn)
                    Valor = 1; // Barco
                else
                    Valor = 0; // Agua

                isHFTurn = !isHFTurn;
            }
        }
    }
}