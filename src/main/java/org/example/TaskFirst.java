package org.example;

import java.util.Arrays;
import java.util.Random;

/* Задание No1. Работа с массивом.
    Заполните  массив  (тип  элементов  “int”)  случайными  числами  и
    выполните задание в соответствии со своим вариантом.
    3. Найти среднее значение элементов в массиве
    Входные данные: количество элементов в формируемом массиве n [0, ∞).
    Выходные  данные:  в  консоль  напечатаны  массив  и  результат  поиска  в соответствии с заданием.

 */
public class TaskFirst {
    public static void main(String[] args) {
        TaskFirst taskFirst = new TaskFirst();
        int[] array = taskFirst.getRandomArray(10);
        System.out.println(Arrays.toString(array));
        System.out.println(taskFirst.getAverageNumInArray(array));
    }

    public int[] getRandomArray(int lenArray) {
        if (lenArray == 0) {
            throw new IllegalArgumentException("Количество элементов должно быть больше  0");
        }
        Random random = new Random();
        int[] array = new int[lenArray];
        for (int i = 0; i < lenArray; i++) {
           int randomNum = random.nextInt(10);
           array[i] = randomNum;
       }
        return array;
    }

    public double getAverageNumInArray(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив пуст!");
        }
        int sumOfArray = 0;
        for (int i = 0; i < array.length; i++) {
            sumOfArray += array[i];
        }

        return (double) sumOfArray / array.length;
    }
}
