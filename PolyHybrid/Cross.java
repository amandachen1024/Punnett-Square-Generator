import java.util.Arrays;
public class Cross
{
    private String cross[][];
    public Cross(int dimensions)
    {
        cross = new String[(int) Math.pow(2,dimensions)][(int) Math.pow(2,dimensions)];
        for (int i = 0; i < cross.length; i++)
        {
            for (int j = 0; j < cross[i].length; j++)
            {
                cross[i][j] = "";
            }
        }
    }

    public void addTrait(String[][] punnettSquare) //nope
    {
        for (int i = 0; i < cross.length/2; i++) // first quarter
        {
            for (int j = 0; j < cross[0].length/2; j++)
            {
                cross[i][j] += punnettSquare[0][0];
            }
        }
        for (int i = 0; i < cross.length/2; i++)
        {
            for (int j = cross[0].length/2; j < cross[0].length; j++)
            {
                cross[i][j] += punnettSquare[0][1];
            }
        }
        for (int i = cross.length/2; i < cross.length; i++) // first quarter
        {
            for (int j = 0; j < cross[0].length/2; j++)
            {
                cross[i][j] += punnettSquare[1][0];
            }
        }
        for (int i = cross.length/2; i < cross.length; i++)
        {
            for (int j = cross[0].length/2; j < cross[0].length; j++)
            {
                cross[i][j] += punnettSquare[1][1];
            }
        }
    }

    public void printCross()
    {
        for (String[] s : cross)
        {
            for (String t: s)
            {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }

}