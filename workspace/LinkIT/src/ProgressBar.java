import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
	 
public class ProgressBar extends JFrame
{	
	JProgressBar meinLadebalken;
	
	public ProgressBar(int min, int max, int wert)
	{
		this.setSize(200, 75);
		this.setTitle("JProgressBar Beispiel");
		
		
		JPanel meinPanel = new JPanel();
 
		meinLadebalken = new JProgressBar(min, max);
 
		meinLadebalken.setValue(0);
 
		meinLadebalken.setStringPainted(true);
 
		meinPanel.add(meinLadebalken);
 
		this.add(meinPanel);
		this.setVisible(true);
	}
	
	public void setValue(int wert)
	{
		System.out.println(wert);
		
		meinLadebalken.setValue(wert);
	}
}
