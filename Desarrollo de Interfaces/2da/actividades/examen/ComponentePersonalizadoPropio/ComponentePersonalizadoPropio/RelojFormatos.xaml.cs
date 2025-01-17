using System.Windows.Controls;
using System.Windows.Threading;

namespace ComponentePersonalizadoPropio
{
    public partial class RelojFormatos : UserControl
    {
        // Propiedad para controlar el formato de 24 horas
        public bool Is24HourFormat { get; set; } = true;

        // Eventos personalizados
        public event EventHandler FormatChanged;
        public event EventHandler MidnightReached;

        private readonly DispatcherTimer _timer;

        public RelojFormatos()
        {
            InitializeComponent();

            // Configurar un temporizador para actualizar la hora
            _timer = new DispatcherTimer
            {
                Interval = TimeSpan.FromSeconds(1)
            };
            _timer.Tick += Timer_Tick;
            _timer.Start();
        }

        private void Timer_Tick(object sender, EventArgs e)
        {
            // Obtener la hora actual
            var now = DateTime.Now;

            // Actualizar el texto del reloj
            TimeText.Text = Is24HourFormat ? now.ToString("HH:mm:ss") : now.ToString("hh:mm:ss tt");

            // Lanzar evento si es medianoche
            if (now.Hour == 0 && now.Minute == 0 && now.Second == 0)
            {
                MidnightReached?.Invoke(this, EventArgs.Empty);
            }
        }

        public void ToggleFormat()
        {
            Is24HourFormat = !Is24HourFormat;
            FormatChanged?.Invoke(this, EventArgs.Empty);
        }
    }
}
