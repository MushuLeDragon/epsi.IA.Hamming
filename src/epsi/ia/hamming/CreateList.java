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
            System.out.println(" | " + TableList[i][0] + " | " + TableList[i][1] + " | " + TableList[i][2] + " | " + TableList[i][3] + " | ");
        }

        //Java ne supporte pas directement les tableaux à plusieurs dimensions : il faut déclarer un tableau de tableau.
        int hammingArray[][] = new int[numberOfExamples][numberOfExamples];
        /*
        for (int i = 0; i < numberOfExamples; i++) {
            hammingArray[i] = new int[numberOfExamples];
        }
         */

        //Nombre d'exemples étudiés
        for (int i = 0; i < numberOfExamples; i++) {

            //Nombres de fois ou on compare l'exemple
            for (int j = (i + 1); j < numberOfExamples; j++) {

                int hammingCount = 0;

                //Nombre de fois où on compare les entités
                for (int k = 0; k < numberOfEntities; k++) {

                    if (TableList[i][k] != TableList[j][k]) {
                        hammingCount++;
                    }

                }

                hammingArray[i][j] = hammingCount;
                System.out.println(" Nombre de différences entre l'exemple " + (i + 1) + " et l'exemple " + (j + 1) + " : " + hammingArray[i][j]);

            }

        }

        for (int i = 0; i < numberOfExamples; i++) {
            System.out.println(" | " + hammingArray[i][0] + " | " + hammingArray[i][1] + " | " + hammingArray[i][2] + " | " + hammingArray[i][3] + " | " + hammingArray[i][4] + " | " + hammingArray[i][5] + " | " + hammingArray[i][6] + " | " + hammingArray[i][7] + " | " + hammingArray[i][8] + " | " + hammingArray[i][9] + " | ");
        }

    }

}
