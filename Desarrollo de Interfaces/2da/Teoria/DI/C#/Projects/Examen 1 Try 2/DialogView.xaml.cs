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
using System.Windows.Shapes;
// Examen1\DialogView.xaml.cs
using System;

namespace Examen1
{
    public partial class DialogView : Window
    {
        public DialogView()
        {
            InitializeComponent();
        }

        private void Window_Closed(object sender, EventArgs e)
        {
            DataContext = null;
        }
    }
}