using examenP.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace examenP.logica
{
    public class LogicaNegocio
    {
        public ObservableCollection<Cliente> listaClientes { get; set; }
        public LogicaNegocio()
        {
            listaClientes = new ObservableCollection<Cliente>();
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
