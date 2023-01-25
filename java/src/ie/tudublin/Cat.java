package ie.tudublin;

public class Cat 
{

    private int numLives; 
    String name;
    
	public Cat(String name)
	{
		this.name = name;
        this.numLives = 9;
	}

    public int checklives()
    {
        return numLives;
    }

    public void speak()
	{
		System.out.println("Meow");
	}
    
    public void kill()
    {
        if(numLives > 0){
            numLives--;
            System.out.println("Ouch!");
        }else{
            System.out.println("Dead");
        }
    }


}
