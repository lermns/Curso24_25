using System.ComponentModel;

namespace actividad_8.DTO
{
    public class Libro : INotifyPropertyChanged, ICloneable, IDataErrorInfo
    {
        private String titulo_p;
        private String autor_p;
        private DateTime fechaEntrada_p;

        public String titulo {
            get { return this.titulo_p; }
            set {
                this.titulo_p = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("titulo"));

            }
        }

        public String autor
        {
            get { return this.autor_p; }
            set
            {
                this.autor_p = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("autor"));

            }
        }

        public DateTime fechaEntrada
        {
            get { return this.fechaEntrada_p; }
            set
            {
                this.fechaEntrada_p = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("fechaEntrada"));

            }
        }

        public Libro(String titulo, String autor, DateTime fecharEntrada) {
            this.titulo_p = titulo;
            this.autor_p = autor;
            this.fechaEntrada_p = fecharEntrada;
        }

        public Libro()
        {
            this.fechaEntrada_p = DateTime.Now;
        }



        public event PropertyChangedEventHandler? PropertyChanged;

        public object Clone()
        {
            return this.MemberwiseClone();
        }
        public string Error => "";

        public string this[string columnName] {
            get {
                String result = "";
                if (columnName == "titulo") {
                    if (string.IsNullOrEmpty(titulo)) {
                        result = "debe de introducir el titulo";
                    }
                }
                if (columnName == "autor"){
                    if (string.IsNullOrEmpty(autor)){
                        result = "debe de introducir el autor";
                    }
                }
                return result;
            }
         }
    }
}
