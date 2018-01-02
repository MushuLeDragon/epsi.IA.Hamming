package epsi.ia.hamming;

import java.util.ArrayList;
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

        System.out.println("Combien d'entit�s formeront votre tableau (entier > 0) ?");
        //numberOfEntities = scan.nextInt();
        numberOfEntities = 4;
        while (numberOfEntities < -1) {
            System.out.println("Le chiffre choisi n'est pas un entier > à 0");
            numberOfEntities = scan.nextInt();
        }

        System.out.println("Vous avez choisi d'entrer " + numberOfEntities + " entit�s.");

        Object[][] TableList = new Object[numberOfExamples][numberOfEntities];

        /*
        for (int i = 0; i < numberOfExamples; i++) {
            System.out.println("Exemple " + (i + 1) + " :");
            for (int j = 0; j < numberOfEntities; j++) {
                System.out.println("---- Entit� " + (j + 1) + " :");

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

        TableList[2][0] = "Fonc�e";
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
        TableList[4][3] = "�paisse";

        TableList[5][0] = "Claire";
        TableList[5][1] = "1";
        TableList[5][2] = "1";
        TableList[5][3] = "�paisse";

        TableList[6][0] = "Fonc�e";
        TableList[6][1] = "2";
        TableList[6][2] = "2";
        TableList[6][3] = "�paisse";

        TableList[7][0] = "Fonc�e";
        TableList[7][1] = "1";
        TableList[7][2] = "1";
        TableList[7][3] = "Fine";

        TableList[8][0] = "Fonc�e";
        TableList[8][1] = "1";
        TableList[8][2] = "1";
        TableList[8][3] = "�paisse";

        TableList[9][0] = "Fonc�e";
        TableList[9][1] = "2";
        TableList[9][2] = "1";
        TableList[9][3] = "�paisse";

        System.out.println("Tableau des entit�s :");
        for (int i = 0; i < numberOfExamples; i++) {
            System.out.println(" | " + TableList[i][0] + " | " + TableList[i][1] + " | " + TableList[i][2] + " | " + TableList[i][3] + " | ");
        }

        //Distance de Hamming :
        int hammingArray[][] = new int[numberOfExamples][numberOfExamples];

        //Nombre d'exemples �tudi�s
        for (int i = 0; i < numberOfExamples; i++) {

            //Nombres de fois ou on compare l'exemple
            for (int j = (i + 1); j < numberOfExamples; j++) {

                int hammingCount = 0;

                //Nombre de fois où on compare les entit�s
                for (int k = 0; k < numberOfEntities; k++) {

                    if (TableList[i][k] != TableList[j][k]) {
                        hammingCount++;
                    }
                }
                hammingArray[i][j] = hammingCount;
                //System.out.println(" Nombre de diff�rences entre l'exemple " + (i + 1) + " et l'exemple " + (j + 1) + " : " + hammingArray[i][j]);

            }
        }

        System.out.println("Tableau des distances de Hamming :");
        for (int i = 0; i < numberOfExamples; i++) {
            System.out.println(" | " + hammingArray[i][0] + " | " + hammingArray[i][1] + " | " + hammingArray[i][2] + " | " + hammingArray[i][3] + " | " + hammingArray[i][4] + " | " + hammingArray[i][5] + " | " + hammingArray[i][6] + " | " + hammingArray[i][7] + " | " + hammingArray[i][8] + " | " + hammingArray[i][9] + " | ");
        }

        //Les Clusters :
        int minHammingDistance = hammingArray[0][1];
        int maxHammingDistance = hammingArray[0][1];

        for (int i = 0; i < numberOfExamples; i++) {
            //System.out.println("Exemple " + (i + 1));
            for (int j = (i + 1); j < numberOfExamples; j++) {
                //System.out.println("Comparaison avec l'exemple " + (j + 1));
                //System.out.println("Hamming mini : " + minHammingDistance + " || Hamming maxi : " + maxHammingDistance + " >> Valeur a comparer : " + hammingArray[i][j]);

                if (minHammingDistance > hammingArray[i][j]) {
                    minHammingDistance = hammingArray[i][j];
                    System.out.println(hammingArray[i][j]);
                }

                if (maxHammingDistance < hammingArray[i][j]) {
                    maxHammingDistance = hammingArray[i][j];
                }

                //System.out.println("R�sultat : Mini = " + minHammingDistance + " || Maxi = " + maxHammingDistance);
            }
        }
        System.out.println("Distance de Hamming minimale : " + minHammingDistance);
        System.out.println("Distance de Hamming maximale : " + maxHammingDistance);

        System.out.println("En combien de clusteurs voulez-vous diviser les exemples ?");
        //int cluster = scan.nextInt();
        int cluster = 2;

        //int clusterArray[] = new int[cluster];
        
        /*
        for (int i = 0; i < cluster; i++) {

            ArrayList<Integer> clusterList = new ArrayList<Integer>();
            clusterArray[i] =;

        }

         */
        ArrayList<ArrayList<Integer>> clusterArray = new ArrayList<ArrayList<Integer>>();
        
                for (int i = 0; i < cluster; i++) {
                    
                }

        ArrayList<Integer> clusterList0 = new ArrayList<Integer>();
        clusterList0.add(1);
        clusterList0.add(2);
        clusterList0.add(3);
        clusterList0.add(4);
        clusterList0.add(5);
        clusterList0.add(7);

        ArrayList<Integer> clusterList1 = new ArrayList<Integer>();
        clusterList1.add(6);
        clusterList1.add(8);
        clusterList1.add(9);
        clusterList1.add(10);

        clusterArray.add(clusterList0);
        clusterArray.add(clusterList1);

        
        for (int i = 0; i < clusterArray.size(); i++) {
            System.out.println("Cluster " + (i + 1));
            ArrayList<Integer> currentList = clusterArray.get(i);
            //now iterate on the current list
            for (int j = 0; j < currentList.size(); j++) {
                Integer s = currentList.get(j);
                System.out.println(s);
            }
        }

        
// https://commons.apache.org/proper/commons-text/jacoco/org.apache.commons.text.similarity/HammingDistance.java.html
    }

}
