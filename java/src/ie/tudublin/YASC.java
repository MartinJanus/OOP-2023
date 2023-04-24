package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class YASC extends PApplet
{
	public boolean[] keys = new boolean[1024]; 

	public void keyPressed()
	{
		keys[keyCode] = true;
	}

	public void keyReleased()
	{
		keys[keyCode] = false;
	}

	// Generic
	public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();


	public void settings()
	{
		size(500, 500);

		PVector a = new PVector(10, 10);
        PVector b = new PVector(20, 20);

        b = a;
        
        b.x = 30;
        b.y = 30;

        println(a);
		
	}

	String s3 = "Hello";

	public void setup() {
		Ship ship = new Ship(width / 2, height / 2, 50, 70, this);
		Ship ship1 = new Ship(100, 50, 50, 6, this);

		gameObjects.add(ship);
		gameObjects.add(ship1);

		gameObjects.add(new HealthPowerup(60,100,0,255,this));
		

		colorMode(HSB);

		String s = "I love Star Trek";

		s += " & 200AD";

		String s1 = s.substring(2, 6);

		println(s.substring(7, 11));

		println(s.indexOf("Trek"));

		println(s.startsWith("Ilove"));

		String ss3 = "Hell";
		String temp = "o";
		String s2 = "Hello";
		
		String s4 = ss3 + temp;

		println(s4 == s2);
		println(s4.equals(s2));
		


		println();

		background(0);

		/*startsWith
		endsWidth
		substring
		indexOf
		s1.chatAt
		s1.lastIndexOf
		s1.toUpperCase()
		s1.compareTo(s)
		s1.equals
		s1.

		println(s1);
		*/
	}
	public void TwoD()
	{
		int size = 100;
		boolean[][] board = new boolean[100][100];

		for(int row = 0; row < size; row++)
		{
			for(int col = 0; col < size; col++)
			{
				if(board[row][col])
				{
					fill(100, 255, 255);
				}
				float x = PApplet.map(col, 0, size, 0, width);
				float y = PApplet.map(row, 0, size, 0, height);

				rect(x,y,10,10);
			}
		}


		
	}


	public void draw()
	{	
		fill(0, 20);
		noStroke();
		rect(0, 0, width, height);		
		
		for(int i = gameObjects.size() - 1 ; i >= 0 ; i --)
		{
			GameObject b = gameObjects.get(i);
			b.render();
			b.update();
		}
		

		fill(255);
		text("Game Objects: " + gameObjects.size(), 50, 50);

	}
}
