public class Autosomal
{
    private String name;
    private String mother[] = new String[2];
    private String father[] = new String[2];
    private boolean isDominant;

    public Autosomal(String trait, String mother1, String mother2, String father1, String father2) // creates a trait w/ specific inheritance patterns
    {
        name = trait;
        //isDominant = inheritance.equals("dominant");
        mother[0] = mother1;
        mother[1] = mother2;
        father[0] = father1;
        father[1] = father2;
    }

    public String[][] cross() // creates a punnett square using mother and father genotypes
    {
        String cross[][] = new String[2][2];
        for (int i = 0; i < father.length; i++)
        {
            for (int j = 0; j < mother.length; j++)
            {
                cross[i][j] = mother[j] + father[i];
            }
        }
        return cross;
    }
}