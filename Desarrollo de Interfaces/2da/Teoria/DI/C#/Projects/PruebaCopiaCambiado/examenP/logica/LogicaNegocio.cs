using PruebaCopiadoCambiado.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PruebaCopiadoCambiado.logica
{
    public class LogicaNegocio
    {
        public ObservableCollection<Cliente> listaClientes { get; set; }//es público y observable, se hace Binding con DATAGRID
        public LogicaNegocio()
        {

            listaClientes = new ObservableCollection<Cliente>();
            listaClientes.Add(new Cliente("Juan Pérez", "Moda, Juguetes",10, DateTime.Now));// añades un cliente a la lista
        }
        public void aniadirCliente(Cliente cliente)
        {
            listaClientes.Add(cliente);
        }


        public void modificarCliente(Cliente cliente, int posicion)
        {
            listaClientes[posicion] = cliente;
        }
    }
}
