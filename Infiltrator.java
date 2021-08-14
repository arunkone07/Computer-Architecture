public class Infiltrator {
    int len;
    int wid;
    int x=0;
    int y=0;
    Border border;

    Infiltrator(int l, int w, double p)
    {
        len = l;
        wid = w;
        border = new Border(l, w, p);
    }
    
    public void move()
    {
        if(!border.stateOfCell(x, y+1))
        {
            y++;
        }
            
        else if(x<len && !border.stateOfCell(x+1, y+1))
        {
            x++;
            y++;
        }

        else if(x>0 && !border.stateOfCell(x-1, y+1))
        {
            x--;
            y++;
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

    public boolean enteredDC(int y)
    {
        if(y>wid)
            return true;
        return false;
    }


}
