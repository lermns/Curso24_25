using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AltaModificacion.dto
{
    // Definición de la clase Persona que implementa interfaces para notificación de cambios, clonación y manejo de errores de datos
    public class Persona : INotifyPropertyChanged,ICloneable,IDataErrorInfo
    {

        //Propiedades pública y privada para nombre, categoría, fecha de nacimiento y valoración
        private String nombre;
        public String Nombre
        {
            get
            {
                return nombre;
            }
            set
            {
                this.nombre = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Nombre"));
            }
        }
        private String categoria;
        public String Categoria
        {
            get
            {
                return categoria;
            }
            set
            {
                this.categoria = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Categoria"));
            }
        }

        private DateTime fecha_nacimiento;
        public DateTime Fecha_nacimiento
        {
            get
            {
                return fecha_nacimiento;
            }
            set
            {
                fecha_nacimiento = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Fecha_nacimiento"));
            }
        }

        private int valoracion;
        public int Valoracion
        {
            get
            {
                return valoracion;
            }
            set
            {
                valoracion = Math.Max(1, Math.Min(10, value));
                this.PropertyChanged(this, new PropertyChangedEventArgs("Valoracion"));
            }
        }

        //Constructor para facililtar la creación de instancias
        public Persona(String nombre, String categoria, DateTime fecha_nacimiento, int valoracion)
        {
            this.nombre = nombre;
            this.categoria = categoria;
            this.fecha_nacimiento = fecha_nacimiento;
            this.valoracion = valoracion;
        }

        public Persona()
        {
        }

        public override string ToString()
        {
            return nombre + " " + categoria + " " + fecha_nacimiento + " " + valoracion;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        //Clonación para la modificación del registro marcado
        public object Clone()
        {
            return this.MemberwiseClone();
        }
        //validación del campo de nombre
        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get 
            {
                string resultado = "";
                if (columnName == "Nombre")
                {
                    if (string.IsNullOrEmpty(Nombre))
                        resultado = "Error: El nombre no puede ser vacío";
                }

                return resultado;
            }
        }
    }

}
