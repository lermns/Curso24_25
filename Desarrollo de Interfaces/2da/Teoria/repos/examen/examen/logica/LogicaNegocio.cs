using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace examen.logica
{
    class LogicaNegocio
    {
        public ObservableCollection<Persona> ListaPersonas { get; set; }

        public LogicaNegocio()
        {
            ListaPersonas = new ObservableCollection<Persona>();
            ListaPersonas.Add(new Persona("Fulanito", "Vago", DateTime.Now, 10));
        }
    }
}
