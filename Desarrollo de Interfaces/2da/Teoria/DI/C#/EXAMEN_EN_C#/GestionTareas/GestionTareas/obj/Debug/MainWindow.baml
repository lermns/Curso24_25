   M S B A M L   `   `   `  ����  GestionTareas    GestionTareas.MainWindow   5   	   R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	     � Title$  Ventana principal��5   	   $	��350��6#   $	��525��60    � Icon$ imgs/imagen1.png��6<   .��5      �  � RowDefinitions 5   
   �� 5      .+�5	   
   o� $��21��6   $	��Top=�6   .@�5
      m� $��Archivo��6   .@�5      m� -   5         m�Name$ MenuItemNuevo��5      $��Nuevo...��62   6D   5      5      &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ DataGridTareas��5         CanUserAddRows .     CanUserSortColumns .     AutoGenerateColumns .  $��10,26,10,10q�6�   ��6]   �� *listaTareas+   RowStyle 5      �� 5      	 �� 
TargetType)  #System.Windows.Controls.DataGridRow"	  6   
 �� Triggers
 5      �� 5       �� Binding 6&   �� *TareaProxima+ �� Value True6G   .a�5      ��  �� Property � �� �� Value �	#FFFF8E8E6O   5      �� 5       6&   �� *
Finalizada+ True6E   .a�5      ��  � ��
 ����6P   5      5         Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Título��6%      
IsReadOnly . 1  +System.Windows.Controls.DataGridBoundColumn   Binding 65   �� *Titulo+6P     5      $ Fecha límite��6%    .  6;   �� *FechaLimite+ �� StringFormat$ d��6j   4  .System.Windows.Controls.DataGridCheckBoxColumn  5      $ 
Finalizada��6)    .   6=   �� *
Finalizada+ �� UpdateSourceTrigger$ PropertyChanged=�6�   5!      5"      5#      