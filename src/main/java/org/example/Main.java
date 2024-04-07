package org.example;

import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("C://Users//79195//Desktop//IdeaProjects//shell_sort//src//main//java//org//example//data")));
        String line = reader.readLine();
        while (line != null) {
            String[] lines = line.split(" ");
            int[] array = new int[lines.length];
            for (int i = 0; i < array.length; ++i){
                array[i] = Integer.parseInt(lines[i]);
            }
            double start = System.nanoTime();
            shellSort(array);
            double end = System.nanoTime();

            System.out.println( (end - start) + " " + array.length);
            line = reader.readLine();
        }

    }

    public static int shellSort(int[] array) {
        for (int s = array.length / 2; s > 0; s /= 2) {
            for (int i = s; i < array.length; ++i) {
                int key = array[i];
                int j = i - s;
                while (j >= 0 && array[j] > key) {
                    array[j + s] = array[j];
                    j -= s;
                }
                array[j + s] = key;
            }
        }
    }

    //генератор данных
    private static int[][] data(){
        int a = (int) ((Math.random() * ((100 - 50) + 1)) + 50); // количество наборов
        int[][] data = new int[a][];
        for (int i = 0; i < a; ++i){
            int b = (int) ((Math.random() * ((10000 - 100) + 1)) + 100); // количество элементов в наборе
            data[i] = new int[b];
            for (int j = 0; j < b; ++j){
                data[i][j] = (int) (Math.random() * 10000);
            }
        }
        return data;
    }

}