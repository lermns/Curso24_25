using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PruebaCopiadoCambiado.dto
{
    public class Cliente: INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {

        // El objeto cliente que se utilizará para  una lista que esta conectada al DATAGRID de la ventana principal
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

        private int valoracion;
        public int Valoracion
        {
            get
            {
                return valoracion;
            }
            set
            {
                valoracion = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("valoracion"));
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


        public string Error
        {
            get { return ""; }
        } //este no se usa


        ///Compruebas si el nombre de la columna está vacío
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

        public Cliente(string nombre,  string categorias, int valoracion, DateTime fechaNacimiento)
        {
            this.nombre = nombre;
            this.categorias = categorias;
            this.fechaNacimiento = fechaNacimiento;
            this.valoracion = valoracion;
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
