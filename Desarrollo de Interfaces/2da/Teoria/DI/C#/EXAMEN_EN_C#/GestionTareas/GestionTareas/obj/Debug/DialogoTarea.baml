   M S B A M L   `   `   `  ����  GestionTareas     GestionTareas.DialogoTarea   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  Tarea��5   	   $��350.145��6   $	��300��6(   $��350.145��5   	   $	��300��6   .��5      �  � ColumnDefinitions 5   
   �� 5	      $	��49* �6   �� 5
      $	��97* �6   .+�5   
   �� $��Título:��6   $��10,24,185,0q�6"   $	��Top=�67   $��2��6O   �� 5   
   $��Fecha límite:��6   $��	10,80,3,0q�6(   $	��Top=�6;    J� RenderTransformOrigin$ 0.541,0.509&�6S   �� 5   
   $��Descripción:��6   $��10,148,171,0q�6'   $	��Top=�6=   $��2��6U   (  "System.Windows.Controls.DatePicker  5   
   -   5          Name$ DatePickerFechaLimite��5      $��	2,81,10,0q�6Y   $	��Top=�6l    � ToolTip$/ )Fecha límite de realización de la tarea��6�   $��1��6�      SelectedDate 64   �� *FechaLimite+6�   �� 5   
   -   5         ��Name$ TextBoxTitulo��5       �� 	MaxLength$ 50��6)   $��23��6�   $��	2,27,10,0q�6�    �� TextWrapping$
 Wrap=�6�   $	��Top=�6�   $&  Introduce el título de la tarea��6�   $��1��6!  ��6\   �� *Titulo+	 �� NotifyOnValidationError	 . 
 �� ValidatesOnDataErrors
 . 6!  �� 5   
   -   5         ��Name$ CheckBoxFinalizada��5      $��Tarea realizada��6P   $��
2,130,77,0q�6j   $	��Top=�6~   $ 0.757,0.521&�6�   $��18��6�   $. (Indica si está finalizada o no la tarea��6�   $��1��6�    d� 	IsChecked 6/   �� *
Finalizada+6�   �� 5   
   -   5         ��Name$ ButtonCancelar��5      $��Cancelar��6)   $
��Left=�6<   $��	10,0,0,10q�6W   $	��120��6j   $��35��6�   $��Bottom=�6�   $��2��6�   �� 5   
   -   5        $ ButtonAceptar��5      $��Aceptar��6(   $��	0,0,10,10q�6:   $��35��6i   $��Bottom=�6u   $��Right=�6�   $	��120��6�   $��1��6�   �� 5   
   $
 Wrap=�60    �� AcceptsReturn . $��10,174,10,50q�6Y   $ Descripción de la tarea��6o   $��2��6�   ��6   �� *Descripcion+6�   �� 5   
   $��imgs/imagen1.png��6   $��46��6*   $��
0,116,10,0q�66   $	��Top=�6J   $��Right=�6b   $��49��6~   $��1��6�   5      5      