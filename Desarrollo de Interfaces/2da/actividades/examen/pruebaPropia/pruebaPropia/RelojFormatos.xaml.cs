using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Threading;

namespace PruebaPropia
{
    public partial class RelojFormatos : UserControl
    {
        // Propiedad para controlar el formato de 24 horas
        public int HourFormat { get; set; } = 24;  // Por defecto es 24 horas

        // Hora que se mostrará (inicializada con la hora actual)
        private DateTime _currentTime;

        private readonly DispatcherTimer _timer;

        public RelojFormatos()
        {
            InitializeComponent();

            // Inicializar la hora con la hora actual
            _currentTime = DateTime.Now;

            // Configurar un temporizador para actualizar la hora
            _timer = new DispatcherTimer
            {
                Interval = TimeSpan.FromSeconds(1)
            };
            _timer.Tick += Timer_Tick;
            _timer.Start();

            // Cambiar color de fondo y texto al pasar el mouse
            ClockBorder.MouseEnter += (sender, e) => ChangeBackgroundColor(true);
            ClockBorder.MouseLeave += (sender, e) => ChangeBackgroundColor(false);
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            // Actualizar el texto del reloj con la hora en formato 24 o 12
            TimeText.Text = HourFormat == 24 ? _currentTime.ToString("HH:mm:ss") : _currentTime.ToString("hh:mm:ss tt");
        }

        private void ChangeBackgroundColor(bool isDay)
        {
            // Cambiar el color de fondo: amarillo para el día, azul marino para la noche
            ClockBorder.Background = isDay ? new System.Windows.Media.SolidColorBrush(System.Windows.Media.Colors.Yellow)
                                           : new System.Windows.Media.SolidColorBrush(System.Windows.Media.Colors.MidnightBlue);

            // Cambiar el color del texto a negro cuando el fondo sea amarillo (día)
            TimeText.Foreground = isDay ? new System.Windows.Media.SolidColorBrush(System.Windows.Media.Colors.Black)
                                        : new System.Windows.Media.SolidColorBrush(System.Windows.Media.Colors.White);
        }
    }
}




