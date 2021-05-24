// Amanda Chen - 12/07/19 - 12/08/19, 01/02/20

import java.util.Scanner;
public class MonoHybrid
{

    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a trait: ");
        String trait = input.nextLine();
        String type;
        do
        {
        System.out.print("Is " + trait +" x-linked or autosomal? ");
        type = input.nextLine();
        } while(!type.equals("x-linked") && !type.equals("autosomal"));
        String inheritance;
        do
        {
        System.out.print("Is " + trait + " dominant or recessive? ");
        inheritance = input.nextLine();
        } while (!inheritance.equals("dominant") && !inheritance.equals("recessive"));
        if (type.equals("autosomal"))
        {
            System.out.print("What is the mother's genotype: ");
            String mother1 = input.next();
            String mother2 = input.next();
            System.out.print("What is the father's genotype: ");
            String father1 = input.next();
            String father2 = input.next();

            System.out.print("Does the trait exhibit complete, incomplete, or co- dominance? ");
            String dominance = input.next();
            input.nextLine();
            if (dominance.equals("incomplete"))
            {
                System.out.print("What is the intermediate phenotype: ");
                String intermediate = input.nextLine();
                System.out.print("What is the other phenotype: ");
                String other = input.nextLine();
                IncompleteDominance punnettSquare1 = new IncompleteDominance(trait, intermediate, other, inheritance, mother1, mother2, father1, father2);
                punnettSquare1.printInfo();
            }
            else if (dominance.equals("co-"))
            {
                System.out.print("What is the mixed phenotype: ");
                String combined = input.nextLine();
                System.out.print("What is the other phenotype: ");
                String other = input.nextLine();
                CoDominance punnettSquare1 = new CoDominance(trait, combined, other, inheritance, mother1, mother2, father1, father2);
                punnettSquare1.printInfo();
            }
            else
            {
                Autosomal punnettSquare1 = new Autosomal(trait, inheritance, mother1, mother2, father1, father2);
                punnettSquare1.printInfo();
            }
        }

        else
        {
            System.out.print("What is the mother's genotype: ");
            String mother1 = input.next();
            String mother2 = input.next();
            System.out.print("What is the father's X genotype: ");
            String fatherX = input.next();
            Xlinked punnettSquare1 = new Xlinked(trait, inheritance, mother1, mother2, fatherX);
            punnettSquare1.printInfo();
        }


    }
}