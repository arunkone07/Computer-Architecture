public class Border {
    
    int length;
    int width;
    double prob;
    Sensor s;
    boolean[][] cell;

    Border(int l, int w, double p)
    {

        length = l;
        width = w;
        prob = p;
        
        s = new Sensor(p);
        cell = new boolean[l][w];
        for(int i=0; i<l; i++)
            for(int j=0; j<w; j++)
                cell[i][j] = s.toss();

    }

    public boolean stateOfCell(int x, int y)
    {
        if(x<0 || y<0 || x>length)
            return true;
        return cell[x][y];
    }
}
