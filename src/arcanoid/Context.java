package arcanoid;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;

public class Context extends JPanel
{
	private ArrayList<Element> elements = new ArrayList<Element>();
	private JFrame screen;
	
	public Context(JFrame a)
	{
		screen = a;
	}
	
	public Context()
	{
		super();
		setSize(800, 600);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(int i = 0; i < elements.size(); i++)
		{
			elements.get(i).draw(g);
			elements.get(i).update(screen);
		}
		repaint();
	}
	
	public void addElement(Element a)
	{
		elements.add(a);
	}
	
	public void removeElement(Element a)
	{
		elements.remove(a);
	}
}