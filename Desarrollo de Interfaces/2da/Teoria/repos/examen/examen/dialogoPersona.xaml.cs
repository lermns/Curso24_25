﻿using examen.dto;
using examen.logica;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace examen
{
    /// <summary>
    /// Lógica de interacción para dialogoPersona.xaml
    /// </summary>
    public partial class dialogoPersona : Window
    {
        public partial class DialogoPersona : Window
        {
            public Persona Persona { get; set; }
            private LogicaNegocio logicaNegocio;
            private int posicion = -1;
            private int numErrores = 0;

            public DialogoPersona(LogicaNegocio LogicaNegocio)
            {
                InitializeComponent();
                this.logicaNegocio = LogicaNegocio;
                Persona = new Persona();
                this.DataContext = this;
            }

            public DialogoPersona(LogicaNegocio LogicaNegocio, Persona personaModificar, int posicion)
            {
                InitializeComponent();
                this.logicaNegocio = LogicaNegocio;
                Persona = (Persona)personaModificar.Clone();
                this.posicion = posicion;
                this.DataContext = this;
            }

            private void buttonAceptar_Click(object sender, RoutedEventArgs e)
            {
                if (posicion != -1)
                    logicaNegocio.ListaPersonas[posicion] = Persona;
                else
                    logicaNegocio.ListaPersonas.Add(Persona);

                this.Close();
            }

            private void Validation_Error(object sender, ValidationErrorEventArgs e)
            {
                if (e.Action == ValidationErrorEventAction.Added)
                {
                    numErrores++;
                    ((Control)sender).ToolTip = e.Error.ErrorContent;
                }
                else if (e.Action == ValidationErrorEventAction.Removed)
                {
                    numErrores--;
                    ((Control)sender).ToolTip = null;
                }
                if (numErrores == 0)
                    buttonAceptar.IsEnabled = true;
                else
                    buttonAceptar.IsEnabled = false;


            }

            private void buttonCancelar_Click(object sender, RoutedEventArgs e)
            {

            }
        }
    }
}
