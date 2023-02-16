package ie.tudublin;
import processing.core.PApplet;
import processing.data.TableRow;

public class Star 
{

    public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag) 
	{
		this.hab = hab;
		this.displayName = displayName;
		this.distance = distance;
		this.xG = xG;
		this.yG = yG;
		this.zG = zG;
		this.absMag = absMag;
	}

    public Star(TableRow row)
	{
		this(
			row.getInt("Hab?") == 1, 
			row.getString("Display Name"), 
			row.getFloat("Distance"),
			row.getFloat("Xg"),
			row.getFloat("Yg"),
			row.getFloat("Zg"),
			row.getFloat("AbsMag")
		);

	}

    public void render(PApplet p)
    {
        float border = p.width * 0.1f;
        float x = PApplet.map(xG, -5, 5, border, p.width - border);
        float y = PApplet.map(yG, -5, 5, border, p.height - border);

        p.stroke(255, 255, 0);

        p.line(x, y-5, x, y+5);
        p.line(x-5, y, x+5, y);
        p.stroke(255,0,0);
        p.circle(x, y, absMag);
        p.fill(255);
        p.textAlign(PApplet.LEFT, PApplet.CENTER); 
        p.textSize(12);
        p.text(displayName, x + 20, y);
        p.noFill();
    


    }

    private boolean hab;
    private String displayName;
    private float distance;
    private float xG;
    private float yG;
    private float zG;
    private float absMag;
    
    //sourcing getter + setter
    public boolean isHab() {
        return hab;
    }
    public String getDisplayName() {
        return displayName;
    }
    public float getDistance() {
        return distance;
    }
    public float getxG() {
        return xG;
    }
    public float getyG() {
        return yG;
    }
    public float getzG() {
        return zG;
    }
    public float getAbsMag() {
        return absMag;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }
    public void setxG(float xG) {
        this.xG = xG;
    }
    public void setyG(float yG) {
        this.yG = yG;
    }
    public void setzG(float zG) {
        this.zG = zG;
    }
    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    //return string version of class, for testing and printing 
    @Override
    public String toString() {
        return "Star [hab=" + hab + ", displayName=" + displayName + ", distance=" + distance + ", xG=" + xG + ", yG="
                + yG + ", zG=" + zG + ", absMag=" + absMag + "]";
    }
    
    

	
}

