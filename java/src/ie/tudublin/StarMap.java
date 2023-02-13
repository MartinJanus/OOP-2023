package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(1);

		smooth();
		
	}

	public void drawGrid()
	{
		float border = 50.0f; 
		int count = 10; 
		for(int i = 0; i<=count; i++)
		{	
			stroke(102,255,153);
			fill(102,255,153);
			float gap = ((width - (border * 2.0f)) / count);
			float x = border + (gap * i);
			line(x, border , x , height - border);
			line(border, x , width - border, x);
		}
	}
		
	public void draw()
	{	
		strokeWeight(2);		
		drawGrid();
	}

}
