   M S B A M L   `   `   `  ����  AltaModificacion.    (AltaModificacion.interfaz.DialogoPersona   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  DialogoPersona��5   	   $	��187��6    $	��339��6-   .��5      � .+�5   
   �� -   5         ��Name$ BotonAceptar��5      $��Aceptar��6'   $
��Left=�69   $��
11,119,0,0q�6T   $	��Top=�6h   $��75��6�   6�   �� 5   
   -   5        $
��Left=�5      $��23��6-   $��	76,10,0,0q�69    �� TextWrapping$
 Wrap=�6L   $	��Top=�6�   $	��120��6�   ��6�   ��  �� Path$ Persona.Nombre� �� NotifyOnValidationError .  �� ValidatesOnDataErrors . 6�   �� 5   
   $
��Left=�6   $��23��6-   $��	76,38,0,0q�69   $	��Top=�6L   $	��120��6d   ��6p   �� $ Persona.Categoria��� 5	   
   $��Nombre:��6   $
��Left=�6"   $��	10,10,0,0q�6=   $	��Top=�6P   �� 5
   
   $��Categoría:��6   $
��Left=�6%   $��	10,35,0,0q�6@   $	��Top=�6S   �� 5   
   $��Fecha de nacimiento:��6   $
��Left=�6/   $��	13,66,0,0q�6J   $	��Top=�6]   �� 5   
   $��Valoración:
��6   $
��Left=�60   $��	11,89,0,0q�6K   $	��Top=�6^   �� 5   
   -   5         ��Name$ sliderValoracion��5      $
��Left=�6+   $��	95,94,0,0q�6F   $	��Top=�6Y   $	��120��6q    � Minimum$ 1Q�6�    � Maximum$ 10Q�6�   	 �� TickPlacement$	 BottomRight=�6  
 �� TickFrequency$
 1Q�61   �� IsSnapToTickEnabled .  � Value 6�   �� $ Persona.valoracion� �� Mode$ TwoWay=� �� UpdateSourceTrigger$ PropertyChanged=�6C  (  "System.Windows.Controls.DatePicker  5   
   $
��Left=�6   $��
136,69,0,0q�60   $	��Top=�6D      SelectedDate 6\   �� $ Persona.Fecha_nacimiento��� 5   
   -   5        $ BotonCancelar��5      $��Cancelar��6(   $
��Left=�6;   $��235,119,0,0q�6V   $	��Top=�6k   $��75��6�   6�   5      5      