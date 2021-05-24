// Amanda Chen - 12/07/19 - 12/08/19

import java.util.Arrays;
public class Xlinked
{
    private String name;
    private String mother[] = new String[2];
    private String father[] = new String[2];
    private boolean isDominant;

    public Xlinked(String trait, String inheritance, String mother1, String mother2, String fatherX) // creates a trait w/ specific inheritance patterns
    {
        name = trait;
        isDominant = inheritance.equals("dominant");
        mother[0] = "X" + "(" + mother1 + ")";
        mother[1] = "X" + "(" + mother2 + ")";
        father[0] = "X" + "(" + fatherX + ")";
        father[1] = "Y";
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
        int fDominantCounter = 0; // female homozygous dominant
        int fHetCounter = 0; // female heterozygous
        int fRecessiveCounter = 0; // female homozygous recessive
        int mDominantCounter = 0; // male dominant
        int mRecessiveCounter = 0; // male recessive

        for (int i = 0; i< square.length; i++)
        {
            for (int j = 0; j < square[0].length; j++)
            {
                if (square[i][j].indexOf("Y") != -1) // checks if one if 'Y' - male
                    {
                        if (square[i][j].charAt(2) < 'a') // checks if the allele on the X is dominant
                        {
                            mDominantCounter++;
                        }
                        else // otherwise it must be recessive
                        {
                            mRecessiveCounter++;
                        }
                    }
                    else
                    {
                        if (square[i][j].charAt(2) != square[i][j].charAt(6)) // checks if the two alleles are different
                        {
                            fHetCounter++;
                        }
                        else if (square[i][j].charAt(2) < 'a') // if they are the same, if one is dominant the other must be as well
                        {
                            fDominantCounter++;
                        }
                        else // last case is that both are recessive
                        {
                            fRecessiveCounter++;
                        }
                    }
            }
        }
        return fDominantCounter + ":" + fHetCounter + ":" + fRecessiveCounter + ":" + mDominantCounter + ":" + mRecessiveCounter;

    }

    public String phenotype() // determines phenotype ratio
    {
        String[][] square = cross();
        int fAffectedCounter = 0; // female affected
        int fUnaffectedCounter = 0; // female unaffected
        int mAffectedCounter = 0; // male affected
        int mUnaffectedCounter = 0; // male unaffected

        if (isDominant) // checks to see if it is dominant - phenotype differs
        {
            for (int i = 0; i < square.length; i++)
            {
                for (int j = 0; j < square[0].length; j++)
                {
                    if (square[i][j].indexOf("Y") != -1) // checks to see if male
                    {
                        if (square[i][j].charAt(2) < 'a') // if there is one dominant gene, must show affected phenotype
                        {
                            mAffectedCounter++;
                        }
                        else // otherwise does not
                        {
                            mUnaffectedCounter++;
                        }
                    }
                    else
                    {
                        if (square[i][j].charAt(2) < 'a' || square[i][j].charAt(6) < 'a') // checks to see if either is dominant allele - would show dominant phenotype
                        {
                            fAffectedCounter++;
                        }
                        else // otherwise would be recessive
                        {
                            fUnaffectedCounter++;
                        }
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
                    if (square[i][j].indexOf("Y") != -1) // check if male
                    {
                        if (square[i][j].charAt(2) < 'a') // if the X has dominant allele, recessive trait not shown
                        {
                            mUnaffectedCounter++;
                        }
                        else
                        {
                            mAffectedCounter++;
                        }
                    }
                    else
                    {
                        if (square[i][j].charAt(2) < 'a' || square[i][j].charAt(6) < 'a') // if either X has dominant allel, recessive not shown
                        {
                            fUnaffectedCounter++;
                        }
                        else
                        {
                            fAffectedCounter++;
                        }
                    }
                }
            }

        }
        return fAffectedCounter + ":" + fUnaffectedCounter + ":" + mAffectedCounter + ":" + mUnaffectedCounter;
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
        System.out.println("The genotype ratio is: " + genotype() + " (female homozygous dominant : female heterozygous : female homozygous recessive : male dominant : male recessive)");
        System.out.println("The phenotype ratio is: " + phenotype() + " ( female with " + name + " : female without " + name + " male with " + name + " : male without " + name + ")");
    }

}