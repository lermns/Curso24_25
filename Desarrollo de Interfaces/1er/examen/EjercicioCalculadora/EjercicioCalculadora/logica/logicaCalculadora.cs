using System;

namespace EjercicioCalculadora.logica
{
    public class logicaCalculadora
    {

        // Metodo para sumar.
        public double sumar(string num1, string num2)
        {
            double.TryParse(num1, out double result1);
            double.TryParse(num2, out double result2);

            Console.WriteLine($"{result2} + {result1}");

            return result2 + result1;
        }


        // Metodo para restar.
        public double restar(string num1, string num2)
        {
            double.TryParse(num1, out double result1);
            double.TryParse(num2, out double result2);

            Console.WriteLine($"{result2} - {result1}");

            return result2 - result1;
        }

        // Metodo para multiplicar.
        public double multiplicar(string num1, string num2)
        {
            double.TryParse(num1, out double result1);
            double.TryParse(num2, out double result2);

            Console.WriteLine($"{result2} * {result1}");

            return result2 * result1;
        }

        // Metodo para divir.
        public double dividir(string num1, string num2)
        {
            double.TryParse(num1, out double result1);
            double.TryParse(num2, out double result2);

            Console.WriteLine($"{result2} / {result1}");


            return result2 / result1;
        }

    }
}
