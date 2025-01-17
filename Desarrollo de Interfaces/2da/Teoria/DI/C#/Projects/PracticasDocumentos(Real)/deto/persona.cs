using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PracticasDocumentos
{
    internal class Persona
    {
        private String nombre { get; set; }
        private String apellidos;

        public Persona(String nombre, String apellidos)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }

        public override string ToString()    //Con esto damos formato al texto que van a recoger las casillas del Combo Box, para que salga su contenido en texto.
        {
            return nombre + " " + apellidos;
        }
    }
}
