using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace actividad_7.DTO
{
    public class Persona
    {
        public String nombre { get; set; }
        public String apellido { get; set; }

        public Persona(String nombre, String apellido) { 
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public override string ToString()
        {
            return nombre + " " + apellido;
        }
    }
}
