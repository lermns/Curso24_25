   M S B A M L   `   `   `  ����F  BCalculadora, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null)clr-namespace:CalculadoraCalculadora  5   	       Calculadora.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   +localclr-namespace:Calculadora     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      �  � ColumnDefinitions 5   
   �� 5      $��* �6   6+   �� 5      $��* �6   6+   �� 5      $��* �6   6+   �� 5      $��* �6   6+    � RowDefinitions 5   
   �� 5      $��* �6   6)   �� 5      $��* �6   6)   �� 5      $��* �6   6)   �� 5      $��* �6   6)   �� 5      $��* �6   6)   .+�5   
   �� -   5         ��Name$ label_Resultado��5      $��3��6)   $��0��6=   $��Right=�6J   $��48(�6f   $��0��6t   �� 5   
   -   5         ��Name$ button_Borrar��5      $��3��6(   $��0��68   $��48(�6Z   $��Borrar��6h   6{   �� 5   
   -   5        $ button7��5      $��0��6"   $��1��62   $��48(�6?   .��6c   76f   �� 5   
   -   5        $ button4��5      $��0��6"   $��2��62   $��48(�6?   .��6c   46f   �� 5   
   -   5        $ button1��5      $��0��6"   $��3��62   $��48(�6?   .��6c   16f   �� 5   
   -   5        $ 
button_Div��5      $��0��6%   $��4��65   $��48(�6B   .��6P   /6S   �� 5    
   -   5        $ button8��5       $��1��6"   $��1��62   $��48(�6?   .��6c   86f   �� 5!   
   -   5        $ button5��5!      $��1��6"   $��2��62   $��48(�6?   .��6c   56f   �� 5"   
   -	   5        $ button2��5"      $��1��6"   $��3��62   $��48(�6?   .��6c   26f   �� 5#   
   $��1��6   $��4��6!   $��48(�6.   .��6<   06?   �� 5$   
   -
   5        $ button0��5$      $��1��6"   $��4��62   $��48(�6?   .��6c   06f   �� 5%   
   -   5        $ button9��5%      $��2��6"   $��1��62   $��48(�6?   .��6c   96f   �� 5&   
   -   5        $ button6��5&      $��2��6"   $��2��62   $��48(�6?   .��6c   66f   �� 5'   
   -   5        $ button3��5'      $��2��6"   $��3��62   $��48(�6?   .��6c   36f   �� 5(   
   -   5        $ button_Coma��5(      $��2��6&   $��4��66   $��48(�6C   .��6Q   .6T   �� 5)   
   -   5        $ button_Sumar��5)      $��3��6'   $��1��67   $��48(�6D   .��6m   +6p   �� 5*   
   -   5        $ button_Menos��5*      $��3��6'   $��2��67   $��48(�6D   .��6m   -6p   �� 5+   
   -   5        $ button_Mult��5+      $��3��6&   $��3��66   $��48(�6C   .��6Q   *6T   �� 5,   
   -   5        $ button_Igual��5,      $��3��6'   $��4��67   $��48(�6D   .��6m   =6p   5-      5/      