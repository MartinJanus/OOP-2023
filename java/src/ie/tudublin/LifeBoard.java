package ie.tudublin;
import processing.core.PApplet;

public class LifeBoard{
    boolean[][] board;
    boolean[][] next;
    private int size;
    PApplet p;

    float cellWidth;

    public boolean getCell(int row, int col)
    {
        if(row >= 0 && row < size && col >= 0 && col < size)
        {
            return board[row][col];
        }
        else
        {
            return false; 
        }
    }


    public int countCells(int row, int col)
    {
        int count = 0;
        for(int i = row -1; i <= row + 1; i++)
        {
            for(int j = col -1; j <= col + 1; j++)
            {
                if (!( i == row && j == col))
                {
                    if (getCell(i, j))
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void applyRules()
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                int count = countCells(row, col);
                // < 2 > 3 dies 
                //2-3 survives
                // dead -> 3 neighbours -> alive
                if(board[row][col] == true)
                {
                    if(count == 2 || count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                }
                else
                {
                    if(count == 3)
                    {
                        next[row][col] = true;
                    }
                    else
                    {
                        next[row][col] = false;
                    }
                }
            }
        }
        boolean temp[][];
        temp = board;
        board = next; 
        next = temp;    
    }

    public LifeBoard(int size, PApplet p)
    {
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];

        this.p = p;
        cellWidth = p.width / (float)size;
    }

    public void randomise()
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                float dice = p.random(0,1);
                board[row][col] = (dice <=0.5f);
            }
        }
    }

    public void render()
    {
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                float x = col * cellWidth; 
                float y = row * cellWidth;
                if(board[row][col] == true)
                {
                    p.fill(0,255,0);
                }
                else
                {
                    p.noFill();
                }
                p.rect(x, y, cellWidth, cellWidth);

            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    } 

    
}
