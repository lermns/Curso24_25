   M S B A M L   `   `   `  ����B  >WpfApp4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null!clr-namespace:WpfApp4WpfApp4  5   	       WpfApp4.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   'localclr-namespace:WpfApp4     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5
      �  � RowDefinitions 5   
   �� 5      $��75 �6   6*   �� 5      $��* �6   6)   .+�5   
   �� $��0��6   .+�5      �� $��	SEMÁFORO��6   $��45(�6(    �� TextAlignment$ Center=�66   
����+��6g   5      �� 5   
   $��1��6   .+�5      �  � ColumnDefinitions 5      �� 5      $
��0.5* �6'   66   �� 5      $
��0.5* �6'   66   .+�5      �� $��0��6   .+�5      	� -   5        $��50, 20, 100, 80q�5   "   .��5      �� $
��Rojo��6$   62   5      	� 5       -   5        $��50, 20, 100, 80q�5    "   .��5!      �� $��Amarillo��6$   66   5"      	� 5#      -   5        $��50, 20, 100, 80q�5#   "   .��5$      �� $��Verde��6$   63   5%      5&      � 5'      $��1��6   .+�5(      �� $9��3D:\Users\IsmaelRezzakMariano\Downloads\semaforo.png��6    J� RenderTransformOrigin$ 0.685,3.132&�5)      $��65,26,65,30q�6@   6W   A� 5*      -   5        $��eRojo��5*   )   
���  ��$y�Hidden=�66   $
��Left=�6J   $��73��6e   $��
165,64,0,0q�6q   $	��Top=�6�   $��69��6�   $ -0.435,0.887&�6�   A� 5+      -   5        $��	eAmarillo��5+   ,   
��� ���$y�Hidden=�6=   $
��Left=�6Q   $��73��6l   $��165,157,0,0q�6x   $	��Top=�6�   $��69��6�   $ -0.435,0.887&�6�   A� 5,      -   5        $��eVerde��5,   +   
��� � �$y�Hidden=�69   $
��Left=�6M   $��73��6h   $��165,250,0,0q�6t   $	��Top=�6�   $��69��6�   $ -0.435,0.887&�6�   5.      5/      50      52      53      