using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WpfApp3.dto;

namespace WpfApp3.logica
{
    public class LogicaNegocio
    {
        public ObservableCollection<Libro> listaLibros { get; set; }

        public LogicaNegocio()
        {
            listaLibros = new ObservableCollection<Libro>();
            listaLibros.Add(new Libro("Sistemas", "Marta", DateTime.Now));
        }
        public void aniadirLibro(Libro libro)
        {
            listaLibros.Add(libro);
        }
    }
}
