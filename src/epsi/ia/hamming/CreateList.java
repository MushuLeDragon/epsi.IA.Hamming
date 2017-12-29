package epsi.ia.hamming;

import java.util.Scanner;

public class CreateList {

    public static void CreateList() {

        int numberOfExamples, numberOfEntities;

        Scanner scan = new Scanner(System.in);

        System.out.println("Combien d'exemples allez-vous utiliser (entier > 0)?");
        //numberOfExamples = scan.nextInt();
        numberOfExamples = 10;

        while (numberOfExamples < -1) {
            System.out.println("Le chiffre choisi n'est pas un entier > à 0");
            numberOfExamples = scan.nextInt();
        }

        System.out.println("Vous avez choisi d'entrer " + numberOfExamples + " exemples.");

        System.out.println("Combien d'entités formeront votre tableau (entier > 0) ?");
        //numberOfEntities = scan.nextInt();
        numberOfEntities = 4;
        while (numberOfEntities < -1) {
            System.out.println("Le chiffre choisi n'est pas un entier > à 0");
            numberOfEntities = scan.nextInt();
        }

        System.out.println("Vous avez choisi d'entrer " + numberOfEntities + " entités.");

        Object[][] TableList = new Object[numberOfExamples][numberOfEntities];
        
        /*
        for (int i = 0; i < numberOfExamples; i++) {
            System.out.println("Exemple " + (i + 1) + " :");
            for (int j = 0; j < numberOfEntities; j++) {
                System.out.println("---- Entité " + (j + 1) + " :");

                TableList[i][j] = scan.nextLine();
                System.out.println(TableList[i][j]);
            }
        }
         */
        
        TableList[0][0] = "Claire";
        TableList[0][1] = "2";
        TableList[0][2] = "2";
        TableList[0][3] = "Fine";

        TableList[1][0] = "Claire";
        TableList[1][1] = "1";
        TableList[1][2] = "2";
        TableList[1][3] = "Fine";

        TableList[2][0] = "Foncée";
        TableList[2][1] = "2";
        TableList[2][2] = "2";
        TableList[2][3] = "Fine";

        TableList[3][0] = "Claire";
        TableList[3][1] = "2";
        TableList[3][2] = "1";
        TableList[3][3] = "Fine";

        TableList[4][0] = "Claire";
        TableList[4][1] = "2";
        TableList[4][2] = "2";
        TableList[4][3] = "Épaisse";

        TableList[5][0] = "Claire";
        TableList[5][1] = "1";
        TableList[5][2] = "1";
        TableList[5][3] = "Épaisse";

        TableList[6][0] = "Foncée";
        TableList[6][1] = "2";
        TableList[6][2] = "2";
        TableList[6][3] = "Épaisse";

        TableList[7][0] = "Foncée";
        TableList[7][1] = "1";
        TableList[7][2] = "1";
        TableList[7][3] = "Fine";

        TableList[8][0] = "Foncée";
        TableList[8][1] = "1";
        TableList[8][2] = "1";
        TableList[8][3] = "Épaisse";

        TableList[9][0] = "Foncée";
        TableList[9][1] = "2";
        TableList[9][2] = "1";
        TableList[9][3] = "Épaisse";

        for (int i = 0; i < numberOfExamples; i++) {
            System.out.println(TableList[i][0] + " | " + TableList[i][1] + " | " + TableList[i][2] + " | " + TableList[i][3] + " | ");
        }

        
    }

}
