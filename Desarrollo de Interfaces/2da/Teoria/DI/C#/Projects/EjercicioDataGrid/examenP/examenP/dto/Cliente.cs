using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace examenP.dto
{
    public class Cliente: INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {
        private String nombre;
        public String Nombre
        {
            get { return nombre; 
            }
            set {
                nombre = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("nombre"));

            }

        }
        private String categorias;
        public String Categorias
        {
            get
            {
                return categorias;
            }
            set
            {
                categorias = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("categorias"));

            }

        }

        private DateTime fechaNacimiento;
        public DateTime FechaNacimiento
        {
            get
            {
                return fechaNacimiento;

            }
            set
            {
                fechaNacimiento = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("fechaNacimiento"));
            }
        }

        public string Error => throw new NotImplementedException();

        public string this[string columnName]
        {
            get
            {
                string result = "";
                if (columnName == "Nombre")
                {
                    if (string.IsNullOrEmpty(nombre))
                        result = "Debe introducir el nombre";
                }
               
                return result;

            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public Cliente(string nombre,  string categorias, DateTime fechaNacimiento)
        {
            this.nombre = nombre;
            this.categorias = categorias;
            this.fechaNacimiento = fechaNacimiento;
        }
     
        public Cliente()
        {
            this.fechaNacimiento = DateTime.Now;

        }
       
        //se necesita un Clone vacío para que no se modifique el cliente en tiempo real 
        public object Clone()
        {
            return this.MemberwiseClone();
        }
    }
}
