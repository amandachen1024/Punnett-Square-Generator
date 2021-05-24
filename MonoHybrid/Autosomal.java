// Amanda Chen - 12/07/19 - 12/08/19

import java.util.Arrays;
public class Autosomal // complete dominance
{
    private String name;
    private String mother[] = new String[2];
    private String father[] = new String[2];
    private boolean isDominant;

    public Autosomal(String trait, String inheritance, String mother1, String mother2, String father1, String father2) // creates a trait w/ specific inheritance patterns
    {
        name = trait;
        isDominant = inheritance.equals("dominant");
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

    public String genotype() // determines genotype ratio
    {
        String[][] square = cross();
        int dCounter = 0; // homozygous dominant
        int rCounter = 0; // homozygous recessive
        int hetCounter = 0; // heterozygous

        for (int i = 0; i< square.length; i++)
        {
            for (int j = 0; j < square[0].length; j++)
            {
                if (square[i][j].charAt(0) != square[i][j].charAt(1)) // see if the 2 alleles are different
                {
                    hetCounter++;
                }
                else if (square[i][j].charAt(0) >= 'a') // if the 2 are the same, if one is lowercase (recessive), both must be
                {
                    rCounter++;
                }
                else // remaining case is that both are same and uppercase
                {
                    dCounter++;
                }
            }
        }
        return dCounter + ":" + hetCounter + ":" + rCounter;
    }

    public String phenotype()
    {
        String[][] square = cross();
        int withCounter = 0;
        int withoutCounter = 0;

        if (isDominant)
        {
            for (int i = 0; i < square.length; i++)
            {
                for (int j = 0; j < square[0].length; j++)
                {
                    if (square[i][j].charAt(0) != square[i][j].charAt(1) || square[i][j].charAt(0) < 'a') // if heterozygous, shows dominant trait; if both are same and one is dominant, shows dominant trait
                    {
                        withCounter++;
                    }
                    else
                    {
                        withoutCounter++; // remaining case is that both are recessive
                    }
                }
            }
        }
        else
        {
           for (int i = 0; i < square.length; i++)
            {
                for (int j = 0; j < square[0].length; j++)
                {
                    if (square[i][j].charAt(0) == square[i][j].charAt(1) && square[i][j].charAt(0) >= 'a') // for recessive trait to show, must be both be recessive
                    {
                        withCounter++;
                    }
                    else // all other cases, dominant shows
                    {
                        withoutCounter++;
                    }
                }
            }
        }
        return  withCounter + ":" + withoutCounter;
    }

    public void printInfo() // print parent genotypes, punette square, genotype ratio, phenotype ratio.
    {
        System.out.print("The mother's genotype was: ");
        for (int i = 0; i < mother.length; i++)
        {
            System.out.print(mother[i]);
        }
        System.out.println();
        System.out.print("The father's genotype was: ");
        for (int i = 0; i < father.length; i++)
        {
            System.out.print(father[i]);
        }
        System.out.println();
        System.out.println("The Punnett Square produced was: ");
        String[][] a = cross();
        for (String[] s : a)
        {
            for (String t: s)
            {
                System.out.print(t + " ");
            }
            System.out.println();
        }
        System.out.println("The genotype ratio is: " + genotype() + " (homozygous dominant : heterozygous : homozygous recessive)");
        System.out.println("The phenotype ratio is: " + phenotype() + " (with " + name + " : without " + name + ")");
    }

}