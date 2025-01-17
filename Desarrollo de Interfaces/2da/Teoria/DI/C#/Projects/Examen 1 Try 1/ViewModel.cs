using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static PracticaExamen1.MainWindow;
using System.Windows.Input;
using System.Windows;

namespace PracticaExamen1
{
    public class DialogViewModel : INotifyPropertyChanged
    {
        private Cliente clienteOriginal;
        private Cliente clienteModificado;

        public Cliente ClienteModificado
        {
            get { return clienteModificado; }
            set
            {
                clienteModificado = value;
                OnPropertyChanged(nameof(ClienteModificado));
            }
        }

        // Comandos para botones
        public ICommand AceptarCommand { get; private set; }
        public ICommand CancelarCommand { get; private set; }

        public DialogViewModel(Cliente cliente)
        {
            clienteOriginal = cliente;
            ClienteModificado = cliente.Clone() as Cliente;

            AceptarCommand = new RelayCommand(Aceptar);
            CancelarCommand = new RelayCommand(Cancelar);
        }

        private void Aceptar()
        {
            // Realiza la validación del campo obligatorio
            if (string.IsNullOrEmpty(ClienteModificado.Nombre))
            {
                MessageBox.Show("El campo Nombre es obligatorio.", "Error de validación", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            // Cierra el diálogo con resultado verdadero (aceptar)
            Close(true);
        }

        private void Cancelar()
        {
            // Restaura el cliente original al cancelar
            ClienteModificado = clienteOriginal.Clone() as Cliente;

            // Cierra el diálogo con resultado falso (cancelar)
            Close(false);
        }

        // Evento para cerrar el diálogo
        public event EventHandler<DialogResult> RequestClose;

        private void Close(bool dialogResult)
        {
            RequestClose?.Invoke(this, new DialogResult(dialogResult));
        }

        // Implementa INotifyPropertyChanged para notificar cambios en las propiedades
        public event PropertyChangedEventHandler PropertyChanged;

        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
