import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main 
{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		View gui = new View();
		Model model = new Model();
		Controller control = new Controller(gui, model);
	}
}