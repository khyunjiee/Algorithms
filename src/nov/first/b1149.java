package nov.first;

import java.util.Scanner;

public class b1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int houses = sc.nextInt();
        int[][] houseCosts = new int[houses][3];
        int[][] houseColor = new int[houses][3];

        for (int i = 0; i < houses; i++) {
            for (int j = 0; j < 3; j++) {
                houseCosts[i][j] = sc.nextInt();
            }
        }

        houseColor[0][0] = houseCosts[0][0];
        houseColor[0][1] = houseCosts[0][1];
        houseColor[0][2] = houseCosts[0][2];

        for (int i = 1; i < houses; i++) {
            houseColor[i][0] = Math.min(houseColor[i - 1][1], houseColor[i - 1][2]) + houseCosts[i][0];
            houseColor[i][1] = Math.min(houseColor[i - 1][0], houseColor[i - 1][2]) + houseCosts[i][1];
            houseColor[i][2] = Math.min(houseColor[i - 1][0], houseColor[i - 1][1]) + houseCosts[i][2];

        }

        System.out.println(Math.min(Math.min(houseColor[houses - 1][0], houseColor[houses - 1][1]), houseColor[houses - 1][2]));
    }
}
