using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace examen.dto
{
    public class Persona : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {

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

        private double valoracion;
        public double Valoracion
        {
            get
            {
                return valoracion;
            }
            set
            {
                this.valoracion = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Valoracion"));
            }
        }

        public Persona()
        {
        }

        public Persona(String nombre, String categoria, DateTime fecha_nacimiento, double valoracion)
        {
            this.nombre = nombre;
            this.categoria = categoria;
            this.fecha_nacimiento = fecha_nacimiento;
            this.valoracion = valoracion;
        }

        public override string ToString()
        {
            return nombre + " " + categoria + " " + fecha_nacimiento + " " + valoracion;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public object Clone()
        {
            return this.MemberwiseClone();
        }

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