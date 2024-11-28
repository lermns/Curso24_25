using EjercicioCalculadora.logica;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Windows;
using System.Windows.Controls;

namespace EjercicioCalculadora
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, INotifyPropertyChanged, ICloneable
    {
        private logicaCalculadora logica;
        private List<char> caracteres;
        private bool accion = false;
        private string operando = "";
        private string numeroPrincipalCopia = "";
        private string numeroPrincipal = "0";

        public string NumeroPrincipal
        {
            get 
            {
                return numeroPrincipal;
            }
            set
            {
                numeroPrincipal = value;
                
                if (!numeroSecundario.Contains("="))
                {
                    numeroPrincipalCopia = numeroPrincipal.Clone() as string;
                }
                
                
                // Forma segura de invocar eventos, si PropertyChanged es null,
                // no se ejecutara la llamada y se evitara la excepcion.
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs("NumeroPrincipal"));
                
            }
        }

        private string numeroSecundario = "";
        private string soloNumeroSecundario = "";

        public string NumeroSecundario
        {
            get
            {
                return numeroSecundario;
            }
            set
            {
                numeroSecundario = value;
                // Forma segura de invocar eventos, si PropertyChanged es null,
                // no se ejecutara la llamada y se evitara la excepcion.
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs("NumeroSecundario"));
            }
        }



        public MainWindow()
        {
            InitializeComponent();
            DataContext = this;
            logica = new logicaCalculadora();
        }

        private void btn0_Click(object sender, RoutedEventArgs e)
        {
            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "0";
                accion = false;
            } 
            else
            {
                NumeroPrincipal += "0";
            }
            
        }

        private void btn1_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "1";
                accion = false;
            } 
            else
            {
                NumeroPrincipal += "1";
            }
            
            
        }

        private void btn2_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "2";
                accion = false;
            }
            else
            {
                NumeroPrincipal += "2";
            }

            
        }

        private void btn3_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "3";
                accion = false;
            }
            else
            {
                NumeroPrincipal += "3";
            }

            
        }

        private void btn4_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "4";
                accion = false;
            }
            else
            {
                NumeroPrincipal += "4";
            }

            
        }

        private void btn5_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "5";
                accion = false;
            }
            else
            {
                NumeroPrincipal += "5";
            }

            
        }

        private void btn6_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "6";
                accion = false;
            }
            else
            {
                NumeroPrincipal += "6";
            }


        }

        private void btn7_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "7";
                accion = false;
            }
            else
            {
                NumeroPrincipal += "7";
            }


        }

        private void btn8_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "8";
                accion = false;
            }
            else
            {
                NumeroPrincipal += "8";
            }

        }

        private void btn9_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroPrincipal.Equals("0") || accion)
            {
                NumeroPrincipal = "9";
                accion = false;
            }
            else
            {
                NumeroPrincipal += "9";
            }

        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {


            if (!string.IsNullOrEmpty(NumeroPrincipal) && NumeroPrincipal.Length > 1)
            {

                // Eliminar el último carácter
                NumeroPrincipal = NumeroPrincipal.Substring(0, NumeroPrincipal.Length - 1);

            }
            else
            {
                // Si está vacio, limpiar el label
                NumeroPrincipal = "0";
            }

        }

        private void btnCE_Click(object sender, RoutedEventArgs e)
        {
            NumeroPrincipal = "0";
            NumeroSecundario = "";
        }

        private void btnC_Click(object sender, RoutedEventArgs e)
        {
            NumeroPrincipal = "0";
        }

        private void btnDividir_Click(object sender, RoutedEventArgs e)
        {
            NumeroSecundario = NumeroPrincipal + " / ";
            accion = true;
        }

        private void btnMultiplicar_Click(object sender, RoutedEventArgs e)
        {
            NumeroSecundario = NumeroPrincipal + " x ";
            accion = true;
        }

        private void btnRestar_Click(object sender, RoutedEventArgs e)
        {
            NumeroSecundario = NumeroPrincipal + " - ";
            accion = true;
        }

        private void btnSumar_Click(object sender, RoutedEventArgs e)
        {
            NumeroSecundario = NumeroPrincipal + " + ";
            accion = true;
        }

        private void btnIgual_Click(object sender, RoutedEventArgs e)
        {

            if (NumeroSecundario.Length > 3)
            {

                if (!NumeroSecundario.Contains("="))
                {
                    // Consigo todos los caracteres que tenga el operando 1
                    caracteres = NumeroSecundario.Trim().ToCharArray().ToList();

                    // Elijo solo el ultimo caracter, que sera la accion (+,-,/,x).
                    operando = caracteres[caracteres.Count - 1].ToString();

                    // Consigo solo el operando 1 quitando el simbolo (ej: 59,60). 
                    soloNumeroSecundario = NumeroSecundario.Trim().Substring(0, NumeroSecundario.Length - 3);
                }


                if (!NumeroSecundario.Contains("="))
                {
                    NumeroSecundario += NumeroPrincipal + " =";
                }
                else
                {
                    // Encontrar la posicion del operador
                    int operadorIndex = numeroSecundario.IndexOf(operando);

                    // Verificar si encontro el operador
                    if (operadorIndex != -1)
                    {
                        // Actualiza el NumeroSecundario quitando la parte anterior y colocando el NumeroPrincipal
                        NumeroSecundario = NumeroPrincipal + " " + NumeroSecundario.Substring(operadorIndex);
                    }
                    else
                    {
                        // Escribir por consola que ha ocurrido un error
                        Console.WriteLine("Error: No se encontró el operador en NumeroSecundario.");
                    }

                }
                
                
                // Dependiendo de lo que tenga como accion, se llamara a un metodo o a otro.
                if (operando.Equals("+"))
                {
                    soloNumeroSecundario = logica.sumar(numeroPrincipalCopia, soloNumeroSecundario).ToString();
                    NumeroPrincipal = soloNumeroSecundario;
                    Console.WriteLine("Estoy en la suma");
                }

                if (operando.Equals("-"))
                {
                    soloNumeroSecundario = logica.restar(numeroPrincipalCopia, soloNumeroSecundario).ToString();
                    NumeroPrincipal = soloNumeroSecundario;
                    Console.WriteLine("Estoy en la resta");
                }

                if (operando.Equals("/") && !NumeroPrincipal.Equals("0"))
                {

                    soloNumeroSecundario = logica.dividir(numeroPrincipalCopia, soloNumeroSecundario).ToString();
                    NumeroPrincipal = soloNumeroSecundario;
                    Console.WriteLine("Estoy en la division");
                } 
                else if (operando.Equals("/") && NumeroPrincipal.Equals("0"))
                {
                    NumeroSecundario = "";
                    NumeroPrincipal = "No se puede dividir entre cero";
                    accion = true;
                }

                if (operando.Equals("x"))
                {
                    soloNumeroSecundario = logica.multiplicar(numeroPrincipalCopia, soloNumeroSecundario).ToString();
                    NumeroPrincipal = soloNumeroSecundario;
                    Console.WriteLine("Estoy en la multiplicacion");
                }
                
            }

        }

        private void btnComa_Click(object sender, RoutedEventArgs e)
        {
            NumeroPrincipal += ",";
        }

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}
