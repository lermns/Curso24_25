using System;
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

namespace WpfApp7
{
    /// <summary>
    /// Lógica de interacción para HundirFlota.xaml
    /// </summary>
    public partial class HundirFlota : Window
    {
        private const int Rows = 5;
        private const int Columns = 5;
        private const int ShipSize = 3;

        private readonly int[,] grid = new int[Rows, Columns];

        public HundirFlota()
        {
            InitializeComponent();
            InitializeGrid();
            CreateGridCells();
        }

        private void InitializeGrid()
        {
            // Initialize the grid with water (0)
            for (int row = 0; row < Rows; row++)
            {
                for (int col = 0; col < Columns; col++)
                {
                    grid[row, col] = 0;
                }
            }

            // Place a ship (1) in a random row
            int shipRow = new Random().Next(0, Rows);
            for (int i = 0; i < ShipSize; i++)
            {
                int col = new Random().Next(0, Columns);
                grid[shipRow, col] = 1;
            }
        }

        private void CreateGridCells()
        {
            // Create and add cells to the grid
            for (int row = 0; row < Rows; row++)
            {
                for (int col = 0; col < Columns; col++)
                {
                    var cell = new Button
                    {
                        Width = 30,
                        Height = 30,
                        Content = " ",
                        Tag = new Tuple<int, int>(row, col) // Store row and col information in Tag
                    };

                    cell.Click += OnCellClick;

                    Grid.SetRow(cell, row);
                    Grid.SetColumn(cell, col);

                    MainGrid.Children.Add(cell);
                }
            }
        }

        private void OnCellClick(object sender, RoutedEventArgs e)
        {
            // Get the clicked cell
            var cell = e.OriginalSource as Button;
            if (cell != null)
            {
                int row = ((Tuple<int, int>)cell.Tag).Item1;
                int col = ((Tuple<int, int>)cell.Tag).Item2;

                // Check if it's a ship or water
                if (grid[row, col] == 0)
                {
                    // Water
                    cell.Background = Brushes.Blue;
                    cell.Content = "Agua";
                }
                else if (grid[row, col] == 1)
                {
                    // Ship
                    cell.Background = Brushes.Red;
                    cell.Content = "Barco";
                }

                // Disable the button after clicking
                cell.IsEnabled = false;
            }
        }
    }
}
