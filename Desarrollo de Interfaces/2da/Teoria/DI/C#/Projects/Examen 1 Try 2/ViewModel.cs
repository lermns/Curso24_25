using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace PracticasDocumentos
{
    public class MainViewModel : INotifyPropertyChanged
    {
        private ObservableCollection<Cliente> clientes;
        private Cliente selectedCliente;

        public ObservableCollection<Cliente> Clientes
        {
            get { return clientes; }
            set
            {
                clientes = value;
                OnPropertyChanged(nameof(Clientes));
            }
        }

        public Cliente SelectedCliente
        {
            get { return selectedCliente; }
            set
            {
                selectedCliente = value;
                OnPropertyChanged(nameof(SelectedCliente));
            }
        }

        // Comandos para botones
        public ICommand ModificarCommand { get; private set; }

        public MainViewModel()
        {
            // Inicializa la colección de clientes y otros elementos necesarios
            Clientes = new ObservableCollection<Cliente>();
            ModificarCommand = new RelayCommand(ModificarCliente);
        }

        private void ModificarCliente()
        {
            if (SelectedCliente != null)
            {
                // Abre el diálogo para modificar el cliente
                var dialogViewModel = new DialogViewModel(SelectedCliente.Clone() as Cliente);
                var dialog = new DialogView { DataContext = dialogViewModel };
                if (dialog.ShowDialog() == true)
                {
                    // Actualiza el cliente después de la modificación
                    int index = Clientes.IndexOf(SelectedCliente);
                    Clientes[index] = dialogViewModel.ClienteModificado;
                }
            }
        }

        // Implementa INotifyPropertyChanged para notificar cambios en las propiedades
        public event PropertyChangedEventHandler PropertyChanged;

        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
