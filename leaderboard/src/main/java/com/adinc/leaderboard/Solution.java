package com.adinc.leaderboard;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int alicesRankIndex = alice.length - 1;
        int [] alicesRank  = new int [alice.length];
        int currentRank = 1;
        int i = 0;

        do {
            if (alice [alicesRankIndex] >= scores[i]) {
                alicesRank [alicesRankIndex] = currentRank;
                alicesRankIndex--;
                continue;
            }

            if ((i < scores.length -1 ) && (scores [i] > scores [i + 1])) {
                currentRank++;
            }

            i++;
        } while (i < scores.length && alicesRankIndex >= 0);

        if (alicesRankIndex >= 0) {
            for (int j = alicesRankIndex; j >= 0; j--){
                alicesRank [j] = currentRank + 1;
            }
        }

        return alicesRank;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(System.getenv("OUTPUT_PATH"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

