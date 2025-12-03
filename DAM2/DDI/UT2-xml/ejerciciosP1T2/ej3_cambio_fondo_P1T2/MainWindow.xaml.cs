using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace ej3_cambio_fondo_P1T2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            btnChangeColor.Click += btnChangeColor_Click;
        }

        private void btnChangeColor_Click(object sender, RoutedEventArgs e)
        {
            mainGrid.Background = new SolidColorBrush(Colors.LightBlue);
        }
    }
}