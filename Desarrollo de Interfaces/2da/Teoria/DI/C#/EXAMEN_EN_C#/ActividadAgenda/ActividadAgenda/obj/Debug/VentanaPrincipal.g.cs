﻿#pragma checksum "..\..\VentanaPrincipal.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "C233E7A6DE0A09FCDCFBAC9684283281CF6384C89B1E1E61930D9DF843F47799"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace ActividadAgenda {
    
    
    /// <summary>
    /// MainWindow
    /// </summary>
    public partial class MainWindow : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 6 "..\..\VentanaPrincipal.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.DataGrid DatagridEventos;
        
        #line default
        #line hidden
        
        
        #line 13 "..\..\VentanaPrincipal.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Calendar CalendarAgenda;
        
        #line default
        #line hidden
        
        
        #line 25 "..\..\VentanaPrincipal.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.MenuItem MenuAniadirEvento;
        
        #line default
        #line hidden
        
        
        #line 28 "..\..\VentanaPrincipal.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button ButtonEliminar;
        
        #line default
        #line hidden
        
        
        #line 29 "..\..\VentanaPrincipal.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button ButtonModificar;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/ActividadAgenda;component/ventanaprincipal.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\VentanaPrincipal.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            this.DatagridEventos = ((System.Windows.Controls.DataGrid)(target));
            
            #line 6 "..\..\VentanaPrincipal.xaml"
            this.DatagridEventos.MouseDoubleClick += new System.Windows.Input.MouseButtonEventHandler(this.DatagridEventos_MouseDoubleClick);
            
            #line default
            #line hidden
            return;
            case 2:
            this.CalendarAgenda = ((System.Windows.Controls.Calendar)(target));
            
            #line 13 "..\..\VentanaPrincipal.xaml"
            this.CalendarAgenda.SelectedDatesChanged += new System.EventHandler<System.Windows.Controls.SelectionChangedEventArgs>(this.CalendarAgenda_SelectedDatesChanged);
            
            #line default
            #line hidden
            return;
            case 3:
            this.MenuAniadirEvento = ((System.Windows.Controls.MenuItem)(target));
            
            #line 25 "..\..\VentanaPrincipal.xaml"
            this.MenuAniadirEvento.Click += new System.Windows.RoutedEventHandler(this.MenuAniadirEvento_Click);
            
            #line default
            #line hidden
            return;
            case 4:
            this.ButtonEliminar = ((System.Windows.Controls.Button)(target));
            
            #line 28 "..\..\VentanaPrincipal.xaml"
            this.ButtonEliminar.Click += new System.Windows.RoutedEventHandler(this.ButtonEliminar_Click);
            
            #line default
            #line hidden
            return;
            case 5:
            this.ButtonModificar = ((System.Windows.Controls.Button)(target));
            
            #line 29 "..\..\VentanaPrincipal.xaml"
            this.ButtonModificar.Click += new System.Windows.RoutedEventHandler(this.ButtonModificar_Click);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}

