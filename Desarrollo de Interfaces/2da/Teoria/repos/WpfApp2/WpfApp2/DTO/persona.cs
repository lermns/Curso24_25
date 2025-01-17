using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp2
{
    class persona
    {
        
        public String Nombre { get; set; }
        private String apellidos;

        public String Apellidos
        {
            get
            {
                return apellidos;
            }
            set
            {
                apellidos = value;
            }
        }
        public persona(String nombre, String apellidos)
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
