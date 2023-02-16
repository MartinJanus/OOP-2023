package ie.tudublin;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList; 

public class StarMap extends PApplet
{
	ArrayList<Star> stars = new ArrayList<Star>();
	
	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		
		smooth();
		
		loadStars();
		printStars();
		displayStars();

	}


	public void drawGrid()
	{
		stroke(0, 255, 255);
		float border = width * 0.1f;

		//int count = 11;
		//float gap = (width - (border * 2.0f)) / (float) count;

		for(int i = -5 ; i <= 5 ; i ++)
		{
			//float x = border + (gap * (i + 5));
			float x = map(i,-5,5,border, width - border);
			line(x, border, x, height - border);
			line(border, x, width - border, x);
			
			textAlign(CENTER, CENTER);
			//text(i, x + (gap * 0.5f), gap * 0.5f);
			text(i,x,border*0.5f);
			text(i, border * 0.5f, x);

		}

		//float f = map(5, 0, 10, 100, 200);
		//float f1 = map1(5, 0, 10, 100, 200);

		
	}
	
	float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c - b; 
		float r2 = e - d; 

		float howFar = a - b; 
		
		return d + ((howFar / r1) * r2); 
	}
	
	public void draw()
	{	
		strokeWeight(1);		

		drawGrid();
	}

	void printStars()
	{
		for(int i = 0; i < stars.size(); i++)
		{
			println(stars.get(i)); 
		}
	}

	void displayStars()
	{
		for(int i = 0; i < stars.size(); i++)
		{
			stars.get(i).render(this);
		}
	}

	void loadStars()
	{
		Table table = loadTable("HabHYG15ly.csv", "header");
		for(TableRow r:table.rows())
		{
			Star s = new Star(r);
			stars.add(s);
		}
	}

}
