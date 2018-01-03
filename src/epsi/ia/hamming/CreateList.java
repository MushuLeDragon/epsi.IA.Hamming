package epsi.ia.hamming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CreateList {

    public static void CreateList() {

        Scanner scan = new Scanner(System.in);
        int numberOfExamples, numberOfEntities;

        System.out.println("Combien d'exemples allez-vous utiliser (entier > 0)?");
        //numberOfExamples = scan.nextInt();
        numberOfExamples = 10;

        while (numberOfExamples < -1) {
            System.out.println("Le chiffre choisi n'est pas un entier > à  0");
            numberOfExamples = scan.nextInt();
        }

        System.out.println("Vous avez choisi d'entrer " + numberOfExamples + " exemples.\n");

        System.out.println("Combien d'entités formeront votre tableau (entier > 0) ?");
        //numberOfEntities = scan.nextInt();
        numberOfEntities = 4;

        while (numberOfEntities < -1) {
            System.out.println("Le chiffre choisi n'est pas un entier > à  0");
            numberOfEntities = scan.nextInt();
        }

        System.out.println("Vous avez choisi d'entrer " + numberOfEntities + " entités.\n");

        Object[][] TableList = new Object[numberOfExamples][numberOfEntities];

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

        System.out.println("Tableau des entités :");
        for (int i = 0; i < numberOfExamples; i++) {
            System.out.println(" | " + TableList[i][0] + " | " + TableList[i][1] + " | " + TableList[i][2] + " | " + TableList[i][3] + " | ");
        }

        //Distance de Hamming :
        int hammingArray[][] = new int[numberOfExamples][numberOfExamples];

        for (int i = 0; i < numberOfExamples; i++) {
            for (int j = (i + 1); j < numberOfExamples; j++) {

                int hammingCount = 0;

                for (int k = 0; k < numberOfEntities; k++) {
                    if (TableList[i][k] != TableList[j][k]) {
                        hammingCount++;
                    }
                }
                hammingArray[i][j] = hammingCount;
                //System.out.println(" Nombre de différences entre l'exemple " + (i + 1) + " et l'exemple " + (j + 1) + " : " + hammingArray[i][j]);

            }
        }

        System.out.println("\nTableau des distances de Hamming :");
        System.out.println("j/y =.|| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < numberOfExamples; i++) {
            System.out.println("i/x=" + i + " || " + hammingArray[i][0] + " | " + hammingArray[i][1] + " | " + hammingArray[i][2] + " | " + hammingArray[i][3] + " | " + hammingArray[i][4] + " | " + hammingArray[i][5] + " | " + hammingArray[i][6] + " | " + hammingArray[i][7] + " | " + hammingArray[i][8] + " | " + hammingArray[i][9] + " | ");
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
                //System.out.println("Résultat : Mini = " + minHammingDistance + " || Maxi = " + maxHammingDistance);
            }
        }

        //System.out.println("Distance de Hamming minimale : " + minHammingDistance);
        //System.out.println("Distance de Hamming maximale : " + maxHammingDistance);
        System.out.println("\nEn combien de clusteurs voulez-vous diviser les exemples ?");
        //int cluster = scan.nextInt();
        int cluster = 2;
        System.out.println("Vous avez choisi de séparer les exemples en " + cluster + " cluster(s).");

        List<Integer> restExampleList = new ArrayList<Integer>();
        List<List<Integer>> clusterArray = new ArrayList<List<Integer>>();

        for (int i = 0; i < cluster; i++) {
            List<Integer> clusterList = new ArrayList<>();

            if (i != 0) {
                if (!restExampleList.isEmpty()) {
                    for (int j = restExampleList.size(); j > 0; j--) {
                        clusterList.add(restExampleList.get((j - 1)));
                        restExampleList.remove(j - 1);
                    }
                }

            } else {
                for (int x = 0; x < numberOfExamples; x++) {
                    //System.out.println("Exemple " + (x + 1));

                    for (int y = (x + 1); y < numberOfExamples; y++) {
                        int z = 0;
                        int clusterToPass = 0;

                        if (restExampleList.size() != 0) {

                            //Optimiser le for en mettant un restExampleList.contains(x+1);
                            for (z = 0; z < restExampleList.size(); z++) {
                                //System.out.println("RestClustur en stck : " + restExampleList.get(z));
                                if ((x + 1) == restExampleList.get(z)) {
                                    //System.out.println("Exemple " + (x + 1) + " non compté car ne fait pas partie du petit cluster");
                                    clusterToPass = restExampleList.get(z);
                                    //System.out.println(clusterToPass);
                                    break;
                                }
                            }
                        }
                        //System.out.println(clusterToPass);
                        if ((x + 1) == clusterToPass) {
                            break;
                        } else if (hammingArray[x][y] == minHammingDistance) {
                            if (!clusterList.contains(x + 1)) {
                                clusterList.add(x + 1);
                                //System.out.println("Ajout de l'exemple " + (x + 1) + " au cluster 1");
                            }
                            if (!clusterList.contains(y + 1)) {
                                clusterList.add(y + 1);
                                //System.out.println("Ajout de l'exemple " + (x + 1) + " au cluster 1");
                            }

                        } else if (hammingArray[x][y] == maxHammingDistance) {
                            if (!restExampleList.contains(y + 1)) {
                                restExampleList.add(y + 1);
                                //System.out.println("Ajout de l'exemple " + (y + 1) + " a la liste d'attente");
                                //System.out.println("Taille de la liste restExampleList " + restExampleList.size());
                            }
                        }
                    }
                }
            }
            Collections.sort(clusterList);
            clusterArray.add(clusterList);
        }

        for (int i = 0; i < clusterArray.size(); i++) {
            System.out.println("Voici la liste du clusters " + (i + 1) + " : " + clusterArray.get(i));
        }
    }
}
