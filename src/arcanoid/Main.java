package arcanoid;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Main
{
	public static JFrame tela;
	public static Context context;
	public static Player player;
	public static Ball ball;
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static ArrayList<Color> color = new ArrayList<Color>();
	public static int row = 4;
	public static int column = 13;
	public static void main(String[] args)
	{
		tela = new JFrame("JOJO");
		tela.setDefaultCloseOperation(3);
                tela.setResizable(false);
		tela.setVisible(true);
		tela.setSize(800, 600);
                tela.setLocationRelativeTo(null);
		color.add(Color.RED);
		color.add(Color.BLUE);
		color.add(Color.YELLOW);
		color.add(Color.GREEN);
		player = new Player(350, 500, 100, 30, Color.RED);
		ball = new Ball(390, 290, 15, Color.BLUE);
		tela.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{   
			
			}
			
			@Override
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == 37)
				{
					player.setMoveLeft(false);
				}
				if(e.getKeyCode() == 39)
				{
					player.setMoveRight(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == 37)
				{
					player.setMoveLeft(true);
				}
				if(e.getKeyCode() == 39)
				{
					player.setMoveRight(true);
				}
			}  
		});
		context = new Context(tela);
		for(int j = 0; j < row; j++)
		{
			for(int i = 0; i < column; i++)
			{
				Block bloco = new Block(30 + i * 55, 30 + j * 55, 50, 50, color.get(j));
				context.addElement(bloco);
				blocks.add(bloco);
			}
		}
		context.addElement(player);
		context.addElement(ball);
		tela.add(context);
	}
}