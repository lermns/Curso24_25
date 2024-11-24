using System.Collections.ObjectModel;

namespace actividad_8.DTO.Logica
{
    public class Logica
    {
        public ObservableCollection<Libro> listLibros { set; get; }

        public  Logica() { 
            listLibros = new ObservableCollection<Libro>();
            listLibros.Add(new Libro("titulo", "autor", DateTime.Now));
        }

        public void aniadirLibros(Libro libro) { 
            listLibros.Add(libro);
        }

        public void modificarLibro(Libro libro, int pos) {
            listLibros[pos] = libro;
        }
    }
}
