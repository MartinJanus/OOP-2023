package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB);
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	float off = 0;

	public void draw() {
		fill(255);
		background(0);
		noStroke();

		switch (mode) {
			case 0:
				int numCircles = (int) max(1, mouseX / 50.0f);
				float d = width / numCircles;
				for (int j = 0; j < numCircles; j++) {
					for (int i = 0; i < numCircles; i++) {
						float x = (d * 0.5f) + (d * i);
						float y = (d * 0.5f) + (d * j);
						float c = ((i + j) / ((numCircles - 1) * 2.0f)) * 255.0f;
						fill((c + off) % 256, 255, 255);
						circle(x, y, d);
					}
				}
				off += (mouseY / 50.0f);
				break;
			case 1:
				if(mouseX > 500)
				{
					fill(256, 255, 255);
					rect(0,0,500,1000);
				}
				else
				{
					fill(256, 255, 255);
					rect(500,0,500,1000);
				}
				break;
			case 2: 
				if(mouseX < 500 && mouseY < 500)
				{
					fill(256, 255, 255);
					rect(0,0,500,500);
				}
				else if(mouseX < 500 && mouseY > 500)
				{
					fill(256, 255, 255);
					rect(0,500,500,500);
				}
				else if(mouseX > 500 && mouseY > 500)
				{
					fill(256, 255, 255);
					rect(500,500,500,500);
				}
				else
				{
					fill(256, 255, 255);
					rect(500,0,500,500);
				}
				break;
			case 3: 
				if(mouseX < 750 && mouseX > 250 && mouseY < 650 && mouseY > 350)
				{
					fill(256, 255, 255);
					rect(250,350,500,300);
				}
				else
				{
					fill(0, 0, 255);
					rect(250,350,500,300);
				}
				break;
			case 4: 
				for(int i = 0; i < 10; i++)
				{
					fill(i*20, 255, 255);
					rect(i * 100, 0, 100, 1000);
				}
				break;
			case 5:
				for(int i = 0; i < 10; i++)
				{
					fill(i*20, 255, 255);
					rect(i * 100, i * 100, 100, 100);
				}
				break;
			case 6: 
				for(int i = 0; i < 10; i++)
				{
					fill(i*20, 255, 255);
					rect(i * 100, i * 100, 100, 100); 
					rect(900 - (i * 100), i * 100, 100, 100); //reverse of it left corner must be 900 on X axis
				}
				break;
			case 7:
				for(int i = 0; i < 11; i++)
				{
					fill(i*20, 255, 255);
					ellipse(500, 500, 1000 - (i * 100), 1000 - (i*100)); //shrinking the size of the ellipse on each iteration by 100 pxl
				}
				break;
			case 8: 
				for(int i = 0; i < 10; i++)
				{
					fill(i*20, 255, 255);
					ellipse(50 + (i * 100), 50, 100, 100);
				}
				break;
			case 9: 
				for(int i = 0; i < 10; i++)
				{
					for(int j = 0; j < 10; j++)
					{
						fill(j*(20 - i), 255, 255);
						ellipse(50 + (i * 100), 50 + (j * 100), 100, 100);
					} 
				}
				break;
			case 55: //'g'
				float border = 70.0f; 
				int count = 10; 
				int sideCount = -5;
				for(int i = 0; i<=count; i++)
				{	
					stroke(102,255,153);
					fill(102,255,153);
					float gap = ((width - (border * 2.0f)) / count);
					float x = border + (gap * i);
					text(sideCount, gap - 50, x);
					text(sideCount, x, gap - 50);
					line(x, border , x , height - border);
					line(border, x , width - border, x);
					sideCount++;
				}
				break;
			
			case 56:
				for(int i = 0; i < 20; i++)
				{
					for(int j = 0; j < 20; j++)
					{
						if((j + i) % 2 == 0)
						{
							fill(150, 255, 255);
							rect(j * 50, i * 50, 50, 50);
						}
						else
						{
							fill(120, 255, 255);
							rect(j * 50, i * 50, 50, 50 );
						}
					}
				}

			default:
				break;
		}

	}
}
