using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Examen_Leo.DTO {
    public class Cliente : INotifyPropertyChanged, ICloneable, IDataErrorInfo{

        private String nombre_p;

        public String nombre {
            get { return this.nombre_p; }
            set { 
                this.nombre_p = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("nombre"));
                }
            }
        private String categoria_p;
        public String categoria
        {
            get { return this.categoria_p; }
            set
            {
                this.categoria_p = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("categoria"));
            }
        }

        private byte valoracion_p;
        public byte valoracion
        {
            get { return this.valoracion_p; }
            set
            {
                this.valoracion_p = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("valoracion"));
            }
        }
        private DateTime fechaNacimiento_p;
        public DateTime fechaNacimiento
        {
            get { return this.fechaNacimiento_p; }
            set
            {
                this.fechaNacimiento_p = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("fechaNacimiento"));
            }
        }


        public Cliente(String nombre, String categoria, byte valoracion, DateTime fechaNacimiente) { 
            this.nombre_p = nombre;
            this.categoria_p = categoria;
            this.valoracion_p = valoracion;
            this.fechaNacimiento_p = fechaNacimiente;
        }

        public Cliente()
        {
            this.fechaNacimiento_p = DateTime.Now;
        }

        public event PropertyChangedEventHandler? PropertyChanged;

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public string Error => "";

        public string this[string columnName]
        {
            get
            {
                String result = "";
                if (columnName == "nombre")
                {
                    if (string.IsNullOrEmpty(nombre))
                    {
                        result = "debe de introducir el nombre";
                    }
                }
                return result;
            }
        }
    }
}
