using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace datagrind.dto
{
    public class Persona
    {
        public String Nombre { get; set; }
        public String Apellidos { get; set; }

        public Persona(string nombre, String apellidos)
        {
            this.Nombre = nombre;
            this.Apellidos = apellidos;
        }
        public override string ToString()
        {
            return Nombre + " " + Apellidos;
        }
    }
}
