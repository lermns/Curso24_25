using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp3.dto
{
    public class Libro : INotifyPropertyChanged
    {
        private String titulo;
        public String Titulo
        {
            get
            {
                return titulo;
            }
            set
            {
                titulo = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("titulo"));
            }
        }
        private String autor;

        public String Autor
        {
            get
            {
                return autor;
            }
            set
            {
                autor = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("autor"));
            }
        }

        private DateTime fechaEntrada;

        public DateTime FechaEntrada
        {
            get
            {
                return fechaEntrada;
            }
            set
            {
                fechaEntrada = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("fechaEntrada"));
            }
        }
            public Libro()
        {
            this.fechaEntrada = DateTime.Now;
        }

            public Libro(String titulo, String autor, DateTime fechaEntrada)
        {
            this.titulo = titulo;
            this.autor = autor;
            this.fechaEntrada = fechaEntrada;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        protected bool SetProperty<T>(ref T field, T newValue, [CallerMemberName] string propertyName = null)
        {
            if (!Equals(field, newValue))
            {
                field = newValue;
                PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
                return true;
            }

            return false;
        }

        private System.Collections.IEnumerable listaLibros1;

        public System.Collections.IEnumerable listaLibros { get => listaLibros1; set => SetProperty(ref listaLibros1, value); }
    }
    }
