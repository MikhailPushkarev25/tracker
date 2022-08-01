package ru.job4j.tracker.search;

import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int call) {
        int groups = (int) Math.ceil((double) list.size() / call);
        int[][] array = new int[groups][call];
        int row = 0, cell = 0;
        for (Integer num : list) {
            array[row][cell++] = num;
            if (cell == call) {
                row++;
                cell = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
