package ie.tudublin;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class martin extends PApplet {

    public void settings() {
        size(400, 400);
    }

    public void setup() {
        background(0);
        strokeWeight(2);
        smooth();
    }

    public void draw() {
        // Draw face background
        fill(0, 200, 0);
        rect(100, 100, 200, 200);

        // Draw eyes
        fill(0);
        ellipse(150, 150, 50, 50);
        ellipse(250, 150, 50, 50);
        fill(255);
        ellipse(150, 150, 20, 20);
        ellipse(250, 150, 20, 20);

        // Draw mouth
        fill(0);
        rect(150, 250, 100, 50);
        fill(0, 200, 0);
        rect(160, 255, 80, 40);
    }

      
      
}