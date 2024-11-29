using System.Collections.ObjectModel;

namespace ExamenUD3_Leonardo_Ramos.DTO.Logica
{
    public class Logica
    {
        public ObservableCollection<Cliente> listaClientes { get; set; }

        public Logica()
        {
            //  Se crea un Cliente de prueba para ver que se agrega de forma correcta en el Grid
            listaClientes = new ObservableCollection<Cliente>();
            listaClientes.Add(new Cliente("Juan Perez", "Moda, Juguetes", 6, DateTime.Now));
        }

        public void aniadirCliente(Cliente cliente)
        {
            listaClientes.Add(cliente);
        }

        public void modificarCliente(Cliente cliente, int pos)
        {
            //  en base al indice que le pasamos este coge al cliente editado y sobreescribe el posicion asignandole el nuevo Cliente ya
            //  modificado
            listaClientes[pos] = cliente;
        }

    }
}
