import java.util.Scanner;
import java.util.Arrays;
public class PolyHybrid
{

    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of traits: ");
        int numOfTraits = input.nextInt();
        Cross cross = new Cross(numOfTraits);

        for (int i = 0; i < numOfTraits; i++)
        {
            System.out.print("Enter a trait: ");
            String trait = input.next();
            System.out.print("What is the mother's genotype: ");
            String mother1 = input.next();
            String mother2 = input.next();
            System.out.print("What is the father's genotype: ");
            String father1 = input.next();
            String father2 = input.next();
            Autosomal punnettSquare1 = new Autosomal(trait, mother1, mother2, father1, father2);
            cross.addTrait(punnettSquare1.cross());
        }
        cross.printCross();
    }
}