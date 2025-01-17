using AltaModificacion.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AltaModificacion.logica
    //Creación de la lista con registro introducido de ejemplo
{
    public class LogicaNegocio
    {
        public ObservableCollection<Persona> ListaPersonas { get; set; }

        public LogicaNegocio()
        {
            ListaPersonas = new ObservableCollection<Persona>();
            ListaPersonas.Add(new Persona("Fulanito", "Vago", DateTime.Now, 10));
        }
    }
}
