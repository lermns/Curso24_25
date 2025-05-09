﻿using System;
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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace examen
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public LogicaNegocio LogicaNegocio { get; set; }
        public MainWindow()
        {
            InitializeComponent();
            LogicaNegocio = new LogicaNegocio();
            this.DataContext = this;
        }

        private void MenuItem_Click(object sender, RoutedEventArgs e)
        {
            dialogoPersona dialogoPersona = new dialogoPersona(LogicaNegocio);
            dialogoPersona.ShowDialog();
        }

        private void buttonModificar_Click(object sender, RoutedEventArgs e)
        {
            Persona personaModificar = (Persona)DataGridPersonas.SelectedItem;
            DialogoPersona dialogoPersona = new DialogoPersona(LogicaNegocio, personaModificar, DataGridPersonas.SelectedIndex);
            dialogoPersona.ShowDialog();
        }
    }
    }
}
