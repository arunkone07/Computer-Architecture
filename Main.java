import java.io.*;
import java.util.*;


public class Main {

    public static int simulate(int l, int w, double p)
    {

        int t;
        Infiltrator inf = new Infiltrator(l, w, p);
        Clock c = new Clock(10);

        //int x = inf.getX();
        int y = 0;

        while(!inf.enteredDC(y))
        {
          inf.move();
          c.nextT();
        }

        t = c.nextT();
        return t;
    }
    public static void main(String[] args) {

      String fin1 = "in1.txt";
      String fin2 = "in2.txt";
      String fout = "out1.txt";

      Scanner width_input;
      Scanner probability_input;
      FileWriter time_output;
      ArrayList<Integer> width = new ArrayList<Integer>();
      ArrayList<Double> prob = new ArrayList<Double>();

      try 
      {

        width_input = new Scanner(new File(fin1));
        probability_input = new Scanner(new File(fin2)); 

        while (width_input.hasNextLine()) 
          width.add(Integer.parseInt(width_input.nextLine()));
        width_input.close();

        while (probability_input.hasNextLine()) 
          prob.add(Double.parseDouble(probability_input.nextLine()));
        probability_input.close();

      } 

      catch (FileNotFoundException e) 
      {

        System.out.println("File not found");
        e.printStackTrace();

      }

      int L = 1000;
      int w_sz = width.size();
      int p_sz = prob.size();
      double[] time = new double[w_sz*p_sz];
      var k = 0;
      int sum;
      int num_iter = 50;
      try
      {
        time_output = new FileWriter(fout);

        time_output.write("WIDTH      PROBABILITY      TIME");

      for (int i = 0; i < w_sz; i++) 
      {
        for (int j = 0; j < p_sz; j++) 
        {
          sum = 0;
          for(int z=0; z<num_iter; z++)
            sum += simulate(L, width.get(i), prob.get(j));

	        time[k] = (float)sum/num_iter;

	        String data = String.valueOf(width.get(i)) + " " + String.valueOf(prob.get(j)) + " " + String.valueOf(time[k]);
	        time_output.write(data);
	        k++;
        }
      }
      time_output.close();
      }
      catch (IOException e) 
      {

        System.out.println("File not found");
        e.printStackTrace();

      }
      
  }
}