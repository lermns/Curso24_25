using System.ComponentModel;

namespace ExamenUD3_Leonardo_Ramos.DTO
{
    public class Cliente : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {

        // Declaracion de las distintas variables con sus seter y geters
        private String nombre_p;

        public String nombre
        {
            get { return this.nombre_p; }
            set
            {
                this.nombre_p = value;
                //  Esta Interfaz lo que hace es avisar constantemente de los cambios que se hagan sobre las variables de los objetos
                //  ya que el binding solo escucha los cambios en la lista mas no los cambios que se hagan dentro de los valores de la lista,
                //  Esto se aplica a todos los atributos de la lista.
                PropertyChanged(this, new PropertyChangedEventArgs("nombre"));
            }
        }
        private String categoria_p;
        public String categoria
        {
            get { return this.categoria_p; }
            set
            {
                this.categoria_p = value;
                PropertyChanged(this, new PropertyChangedEventArgs("categoria"));
            }
        }


        //  uso byte porque el rango de valores es corto y asi no ocupamos mas espacio del necesario
        private byte valoracion_p;
        public byte valoracion
        {
            get { return this.valoracion_p; }
            set
            {
                this.valoracion_p = value;
                PropertyChanged(this, new PropertyChangedEventArgs("valoracion"));
            }
        }
        private DateTime fechaNacimiento_p;
        public DateTime fechaNacimiento
        {
            get { return this.fechaNacimiento_p; }
            set
            {
                this.fechaNacimiento_p = value;
                PropertyChanged(this, new PropertyChangedEventArgs("fechaNacimiento"));
            }
        }


        public Cliente(String nombre, String categoria, byte valoracion, DateTime fechaNacimiente)
        {
            this.nombre_p = nombre;
            this.categoria_p = categoria;
            this.valoracion_p = valoracion;
            this.fechaNacimiento_p = fechaNacimiente;
        }

        //  segundo constructor sin parametros inicializado con la fecha actual y con las varibles String vacias ya que dejarlas null seria un problema
        //  no se iniciaiza la variable byte ya que es 0 por defecto
        public Cliente()
        {
            this.fechaNacimiento_p = DateTime.Now;
            this.nombre_p = "";
            this.categoria_p = "";
        }

        //  metodo que implementamos para poder avisar al binding del cambio de variables de los objetos en la lista
        public event PropertyChangedEventHandler? PropertyChanged;

        public object Clone()
        {
            //  Usamos esta interfaz para evitar que el binding haga cambios antes de darle a aceptar, solo cuando este de aceptar se haran los cambios sobre
            // el objeto que nos interesa, mientras solo edita el objeto copia
            return this.MemberwiseClone();
        }

        public string Error => "";

        //  en caso de que el nombre este vacio nos salta un error y deshabilita el boton para no agregar al cliente
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
