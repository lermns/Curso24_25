   M S B A M L   `   `   `  ����  ActividadAgenda     ActividadAgenda.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  ActividadAgenda��5   	   $	��350��6!   $	��525��6.   .��5      � .+�5   
   &   System.Windows.Controls.DataGrid  -   5          Name$ DatagridEventos��5         
IsReadOnly .    AutoGenerateColumns .  $��204,44,10,0q�6�   $	��Top=�6�   $	��163��6�   ��6Z   ��  �� Path$( "logicaNegocio.ListaEventosFiltrada�   Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Texto��6%   1  +System.Windows.Controls.DataGridBoundColumn   Binding 64   �� $ Texto�  5	      $ Lugar��6%    64   �� $ Lugar�  5
      $ 
Fecha/Hora��6%    69   �� $ 	FechaHora�5      &   System.Windows.Controls.Calendar  5   
   -   5          Name$ CalendarAgenda��5      $
��Left=�6+   	   SelectionMode$	 MultipleRange=�6F   $��	10,44,0,0q�6d   $	��Top=�6w   $	��168��6�   
 J� RenderTransformOrigin$
 0.5,0.5&�6�   z�5      V� 5      .~�5      �� �� 5       �� AngleX$ 0.377Q�6$   �� 5      T� 5       T� X$
 0.74Q�6)   5      5      o� 5   
   $
��Left=�6   $��21��6*   $	��Top=�66   $	��517��6N   .@�5      m� $��Agenda��6   .@�5      m� -   5         m�Name$ MenuAniadirEvento��5      $��Añadir evento...��66   $
��Left=�6P   $	��197��6k   $��	0,0,-52,0q�6�   5      5      �� 5   
   -   5         ��Name$ ButtonEliminar��5      $��Eliminar��6)   $
��Left=�6<   $��284,212,0,0q�6W   $	��Top=�6l   $��75��6�   6�   �� 5   
   -   5        $ ButtonModificar��5      $��Modificar ...��6*   $
��Left=�6B   $��204,212,0,0q�6]   $	��Top=�6r   $��75��6�   6�   5      5       