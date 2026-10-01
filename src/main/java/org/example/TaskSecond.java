package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
    Заполните список (тип “ArrayList<Double>”) случайным числами и
    отсортируйте его. Метод сортировки выбирается в соответствии с вашим
    вариантом. Сортировку необходимо реализовать вручную (не использовать
    встроенные возможности Java или сторонних библиотек).
    3. Пузырьковая сортировка (Bubble Sort).
    Входные данные: количество элементов в формируемом массиве n [0, ∞).
    Выходные  данные:  в  консоль  напечатаны  исходный  и  отсортированный списки
 */

public class TaskSecond {
    public static void main(String[] args) {
        TaskSecond taskSecond = new TaskSecond();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        ArrayList<Double> list = taskSecond.getRandomDoubleArraylist(input);
        System.out.println(list);
        System.out.println(taskSecond.BubbleSort(list));
    }


    public ArrayList<Double> getRandomDoubleArraylist(int len) {
        Random random = new Random();
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            double randomDouble = (double) Math.round(random.nextDouble(100) * 100) / 100;
            arrayList.add(randomDouble);
        }
        return arrayList;
    }

    public ArrayList<Double> BubbleSort(ArrayList<Double> doubleArrayList) {
        int len = doubleArrayList.size();
        boolean swapped;
        for (int i = 0; i < len - 1; i++) {
            swapped = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (doubleArrayList.get(j) > doubleArrayList.get(j + 1)) {
                    double temp = doubleArrayList.get(j);
                    doubleArrayList.set(j, doubleArrayList.get(j + 1));
                    doubleArrayList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return doubleArrayList;
    }
}
