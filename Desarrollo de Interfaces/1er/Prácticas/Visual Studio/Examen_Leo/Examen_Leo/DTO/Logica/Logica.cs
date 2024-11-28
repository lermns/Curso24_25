using System.Collections.ObjectModel;

namespace Examen_Leo.DTO.Logica {
    public class Logica {
        public ObservableCollection<Cliente> listaClientes { get; set; }

        public Logica() { 
            listaClientes = new ObservableCollection<Cliente>();
            listaClientes.Add(new Cliente("Juan Perez", "Moda, Juguetes", 6, DateTime.Now));
        }

        public void aniadirCliente(Cliente cliente)
        {
            listaClientes.Add(cliente);
        }

        public void modificarCliente(Cliente cliente, int pos)
        {
            listaClientes[pos] = cliente;
        }

    }
}
