using System.Windows;

namespace Calculadora
{
    public partial class MainWindow : Window
    {
        private double _firstNumber = 0;
        private string _operation = string.Empty;
        private bool _isOperationPressed = false;

        public MainWindow()
        {
            InitializeComponent();
        }

        // Manejar clics de números
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            string number = (sender as System.Windows.Controls.Button)?.Content.ToString();

            if (_isOperationPressed || txtDisplay.Text == "0")
            {
                txtDisplay.Text = number;
                _isOperationPressed = false;
            }
            else
            {
                txtDisplay.Text += number;
            }
        }

        // Manejar clics de operadores (+, -, *, /)
        private void Operator_Click(object sender, RoutedEventArgs e)
        {
            string operation = (sender as System.Windows.Controls.Button)?.Content.ToString();

            if (double.TryParse(txtDisplay.Text, out _firstNumber))
            {
                _operation = operation;
                _isOperationPressed = true;
            }
        }

        // Manejar el botón '='
        private void Equals_Click(object sender, RoutedEventArgs e)
        {
            if (double.TryParse(txtDisplay.Text, out double secondNumber))
            {
                double result = 0;

                switch (_operation)
                {
                    case "+":
                        result = _firstNumber + secondNumber;
                        break;
                    case "-":
                        result = _firstNumber - secondNumber;
                        break;
                    case "*":
                        result = _firstNumber * secondNumber;
                        break;
                    case "/":
                        result = secondNumber != 0 ? _firstNumber / secondNumber : double.NaN;
                        break;
                }

                txtDisplay.Text = result.ToString();
            }
        }

        // Manejar el botón 'C' (Clear)
        private void Clear_Click(object sender, RoutedEventArgs e)
        {
            txtDisplay.Text = "0";
            _firstNumber = 0;
            _operation = string.Empty;
            _isOperationPressed = false;
        }
    }
}
