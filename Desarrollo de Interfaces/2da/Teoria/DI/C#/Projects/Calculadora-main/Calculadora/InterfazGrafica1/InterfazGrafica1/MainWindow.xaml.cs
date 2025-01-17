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

namespace InterfazGrafica1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public MainWindow()
        {
            InitializeComponent();


        }

        private void ButtonLimpiar(object sender, RoutedEventArgs e)
        {

            _numeritosTexto1 = "";
            _numeritosTexto2 = "";
            _numeritoOperador1 = 0;
            _numeritoOperador2 = 0;
            pantalla.Text = "";
            _resultado = "";
            _operador = "";
            
            
        }

        private void ButtonNumeros(object sender, RoutedEventArgs e)
        {
            Button btn = sender as Button;

            if (_operador=="")
            {
                _numeritosTexto1 = _numeritosTexto1 + (string)btn.Content;
                _numeritoOperador1 = double.Parse(_numeritosTexto1);
            }
            else
            {
                _numeritosTexto2 = _numeritosTexto2 + (string)btn.Content;
                _numeritoOperador2 = double.Parse(_numeritosTexto2);
            }    
            
            //_numeritosTexto2 = _numeritosTexto2 + (string)btn.Content;

            MostrarPantalla(_numeritosTexto1,_numeritosTexto2);




        }

        private void ButtonPunto(object sender, RoutedEventArgs e)
        {
            Button btn = sender as Button;




            if (_numeritosTexto1 != "" && _operador=="" && _numeritoOperador1 % 1 == 0)
            {
                _numeritosTexto1 = _numeritoOperador1.ToString() + ".";

                MostrarPantalla(_numeritosTexto1);

            }

            if (_numeritosTexto2 != "" && _operador!="" && _numeritoOperador2 % 1 == 0)
            {
                _numeritosTexto2 = _numeritoOperador2.ToString() + ".";

                MostrarPantalla(_numeritosTexto1,_numeritosTexto2);

            }





        }


        private void ButtonSigno(object sender, RoutedEventArgs e)
        {

            if (_operador=="")
            {
                _numeritoOperador1 = _numeritoOperador1 * (-1);
                _numeritosTexto1 = Convert.ToString(_numeritoOperador1);

                MostrarPantalla(_numeritosTexto1);
            }
            else
            {
                _numeritoOperador2 = _numeritoOperador2 * (-1);
                _numeritosTexto2 = Convert.ToString(_numeritoOperador2);
                MostrarPantalla(_numeritosTexto1, _numeritosTexto2);
            }
            
            


            



        }

        private void ButtonOperadores(object sender, RoutedEventArgs e)
        {
            Button btn = sender as Button;
            

            if (_operador=="" && _numeritosTexto2=="")
            {
                _numeritosTexto1 = _numeritosTexto1 + (string)btn.Content;
                _numeritosTexto1 = _numeritoOperador1.ToString();
                _operador = (string)btn.Content;
                
                MostrarPantalla(_numeritosTexto1);


            }
            else if(_operador=="")
            {
                _numeritosTexto1 = _numeritosTexto1 + (string)btn.Content;
                _numeritosTexto1 = _numeritoOperador1.ToString();
                _operador = (string)btn.Content;
                MostrarPantalla(_numeritosTexto1, _numeritosTexto2);

            }



            


        }

        private void ButtonIgual(object sender, RoutedEventArgs e)
        {
            Button btn = sender as Button;
            
            if (_numeritosTexto1 != "" && _operador != "")
            {
                switch (_operador)
                {
                    case "+":
                        _resultado = Convert.ToString(_numeritoOperador1 + _numeritoOperador2);
                        
                        break;
                    case "-":
                        _resultado = Convert.ToString(_numeritoOperador1 - _numeritoOperador2);
                        
                        break;
                    case "÷":
                        _resultado = Convert.ToString(_numeritoOperador1 / _numeritoOperador2);
                        
                        break;
                    case "x":
                        _resultado = Convert.ToString(_numeritoOperador1 * _numeritoOperador2);
                        
                        break;


                }


                MostrarPantalla(_numeritosTexto1, _numeritosTexto2);
                
                _numeritoOperador1 = double.Parse(_resultado);
                _numeritosTexto1 = _resultado;
                _numeritoOperador2 = 0;
                _numeritosTexto2 = "";
                _operador = "";
                _resultado = "";
                

            }



            


        }

        private void MostrarPantalla(Object numero, Object numero2 = null)
        {
            if (_resultado == "")
            {
                if (_operador=="")
                {
                    pantalla.Text = Convert.ToString(numero);
                }
                else
                {
                    pantalla.Text = "("+Convert.ToString(numero)+") " + _operador + " (" + Convert.ToString(numero2)+")";

                }
            }

            else
            {
                pantalla.Text = "Resultado: "+Convert.ToString(_resultado);
            }


        }

        private double _numeritoOperador1 = 0;
        private double _numeritoOperador2 = 0;
        private string _numeritosTexto1 = "";
        private string _numeritosTexto2 = "";
        private string _resultado = "";
        private string _operador = "";



    }
}
