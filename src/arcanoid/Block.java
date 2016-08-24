package arcanoid;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Block extends Element
{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	public Block(int a, int b, int c, int d, Color e)
	{
		x = a;
		y = b;
		width = c;
		height = d;
		color = e;
	}
	
	public void update(JFrame tela)
	{
		if(testCollision(Main.ball))
		{
			Main.blocks.remove(this);
			Main.context.removeElement(this);
			Main.ball.setSpeed(Main.ball.getSpeedX(), Main.ball.getSpeedY() * -1);
		}
	}
	
	public int getX()
	{
		return x;
	}
	
	public boolean testCollision(Element a)
	{
		if(x + width > a.getX() && x < a.getX() + a.getWidth()
		&& y + height > a.getY() && y < a.getY() + a.getHeight())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void draw(Graphics a)
	{
		a.setColor(color);
		a.fillRect(x, y, width, height);
	}
}