   M S B A M L   `   `   `  ����   ActividadAgenda     ActividadAgenda.MainWindow   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml       � Title$  ActividadAgenda��$	��350��$	��525��.��� .+�&   System.Windows.Controls.DataGrid  -     Name$ DatagridEventos��   
IsReadOnly .    AutoGenerateColumns .  $��204,44,10,0q�$	��Top=�$	��163������  �� Path$( "logicaNegocio.ListaEventosFiltrada�   Columns 0  *System.Windows.Controls.DataGridTextColumn  ,  &System.Windows.Controls.DataGridColumn   Header$ Texto��1  +System.Windows.Controls.DataGridBoundColumn   Binding �� $ Texto�  $ Lugar�� �� $ Lugar�  $ 
Fecha/Hora�� �� $ 	FechaHora�&   System.Windows.Controls.Calendar  -     Name$ CalendarAgenda��$
��Left=�	   SelectionMode$	 MultipleRange=�$��	10,44,0,0q�$	��Top=�$	��168��
 J� RenderTransformOrigin$
 0.5,0.5&�z�V� .~��� ��  �� AngleX$ 0.377Q��� T�  T� X$
 0.74Q�o� $
��Left=�$��21��$	��Top=�$	��517��.@�m� $��Agenda��.@�m� -    m�Name$ MenuAniadirEvento��$��Añadir evento...��$
��Left=�$	��197��$��	0,0,-52,0q��� -    ��Name$ ButtonEliminar��$��Eliminar��$
��Left=�$��284,212,0,0q�$	��Top=�$��75���� -   $ ButtonModificar��$��Modificar ...��$
��Left=�$��204,212,0,0q�$	��Top=�$��75��