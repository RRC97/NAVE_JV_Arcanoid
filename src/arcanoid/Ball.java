package arcanoid;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Ball extends Element
{
	private int x;
	private int y;
	private int radius;
	private int width;
	private int height;
	private int speedX = 1;
	private int speedY = 1;
	private Color color;
	
	public Ball(int a, int b, int c, Color d)
	{
		x = a;
		y = b;
		radius = c;
		width = radius * 2;
		height = radius * 2;
		color = d;
	}
	
	public void update(JFrame tela)
	{
		x += speedX;
		y += speedY;
	
		if(x <= 0 || x + width >= tela.getWidth())
		{
			speedX *= -1;
		}
		if(y <= 0 || y + height >= tela.getHeight())
		{
			speedY *= -1;
		}
		if(testCollision(Main.player))
		{
			speedY *= -1;
		}
		for(int i = 0; i < Main.blocks.size(); i++)
		{
			if(testCollision(Main.blocks.get(i)))
			{
				System.out.println("Colidiu");
			}
		}
		
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getSpeedX()
	{
		return speedX;
	}
	public int getSpeedY()
	{
		return speedY;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	
	public void setSpeed(int x, int y)
	{
		speedX = x;
		speedY = y;
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
		a.fillArc(x, y, width, height, 0, 360);
	}
}