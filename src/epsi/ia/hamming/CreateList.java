package epsi.ia.hamming;

import java.util.Scanner;

public class CreateList {

    public static void CreateList() {

        int numberOfExamples, numberOfEntities;

        Scanner scan = new Scanner(System.in);

        System.out.println("Combien d'exemples allez-vous utiliser (entier > 0)?");
        numberOfExamples = scan.nextInt();
        //numberOfExamples = 10;

        while (numberOfExamples < -1) {
            System.out.println("Le chiffre choisi n'est pas un entier > � 0");
            numberOfExamples = scan.nextInt();
        }

        if (numberOfExamples == 1) {
            System.out.println("Vous avez choisi d'entrer " + numberOfExamples + " exemple.");
        } else {
            System.out.println("Vous avez choisi d'entrer " + numberOfExamples + " exemples.");
        }

        System.out.println("Combien d'entit�s formeront votre tableau (entier > 0) ?");
        numberOfEntities = scan.nextInt();
        //numberOfEntities = 4;
        while (numberOfEntities < -1) {
            System.out.println("Le chiffre choisi n'est pas un entier > � 0");
            numberOfEntities = scan.nextInt();
        }

        if (numberOfExamples == 1) {
            System.out.println("Vous avez choisi d'entrer " + numberOfEntities + " entit�.");
        } else {
            System.out.println("Vous avez choisi d'entrer " + numberOfEntities + " entit�s.");
        }

        Object[][] TableList = new Object[numberOfExamples][numberOfEntities];
        /*
        for (int i = 0; i < numberOfExamples; i++) {
            
        }
        
        o[0][0] = 1;
        o[0][1] = "hello";

        System.out.println(o[0][0]);
        System.out.println(o[0][1]);
         */
    }

}
