package arcanoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.*;

public class Player extends Element
{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	private boolean moveLeft = false;
	private boolean moveRight = false;
	
	public Player(int a, int b, int c, int d, Color e)
	{
		x = a;
		y = b;
		width = c;
		height = d;
		color = e;
	}
	
	public void update(JFrame tela)
	{
		if(moveLeft)
		{
			x -= 1;
		}
		if(moveRight)
		{
			x += 1;
		}
		if(x <= 0)
		{
			x = 0;
		}
		if(x + width >= tela.getWidth())
		{
			x = tela.getWidth() - width;
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
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	
	public void setMoveLeft(boolean a)
	{
		moveLeft = a;
	}	
	
	public void setMoveRight(boolean a)
	{
		moveRight = a;
	}	
	
	public void draw(Graphics a)
	{
		a.setColor(color);
		a.fillRect(x, y, width, height);
	}
}