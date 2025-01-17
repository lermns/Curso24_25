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

namespace Calculadora
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        long num1 = 0;
        long num2 = 0;
        string operacion = "";

        public MainWindow()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "") // detecta 
            {
                num1 = (num1 * 10) + 1; //multiplica 10 sobre el num para añadir el dígito
                label_Resultado.Content = num1.ToString(); //lo pinta en resultado
            }
            else
            {
                num2 = (num1 * 10) + 1; //aplica lo mismo al num2
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button2_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 2;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 2;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button3_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 3;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 3;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button4_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 4;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 4;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button5_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 5;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 5;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button6_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 6;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 6;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button7_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 7;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 7;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button8_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 8;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 8;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button9_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 9;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 9;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void button0_Click(object sender, RoutedEventArgs e)
        {
            if (operacion == "")
            {
                num1 = (num1 * 10) + 0;
                label_Resultado.Content = num1.ToString();
            }
            else
            {
                num2 = (num1 * 10) + 0;
                label_Resultado.Content = num1.ToString();
            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if(operacion == "") //Sui hay algo en operación, aplica a cero
            {
                num1 = 0;
            }
            else
            {
                num2 = 0;
            }
            label_Resultado.Content = "0";
        }

        private void button_Sumar_Click(object sender, RoutedEventArgs e)
        {
            operacion = "+";
            label_Resultado.Content = "0";
        }

        private void button_Igual_Click(object sender, RoutedEventArgs e)
        {
            switch(operacion){
                case "+":
                    label_Resultado.Content = (num1 + num2).ToString();
                    break;
                case "-":
                    label_Resultado.Content = (num1 - num2).ToString();
                    break;
            }
            num1 = 0;
            num2 = 0;
            operacion = "";
        }

        private void button_Menos_Click(object sender, RoutedEventArgs e)
        {
            operacion = "-";
            label_Resultado.Content = "0";
        }
    }
}
