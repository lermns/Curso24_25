using System.Windows;

namespace ComponentePersonalizadoPropio
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Cambiar el formato del reloj cada 5 segundos
            var formatToggleTimer = new System.Windows.Threading.DispatcherTimer
            {
                Interval = TimeSpan.FromSeconds(5)
            };
            formatToggleTimer.Tick += (s, e) =>
            {
                Reloj.Is24HourFormat = !Reloj.Is24HourFormat;
            };
            formatToggleTimer.Start();
        }

        private void InteractiveClock_FormatChanged(object sender, EventArgs e)
        {
            MessageBox.Show("El formato del reloj ha cambiado.");
        }

        private void InteractiveClock_MidnightReached(object sender, EventArgs e)
        {
            MessageBox.Show("¡Es medianoche!");
        }
    }

}
