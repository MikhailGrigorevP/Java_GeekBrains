import java.util.Arrays;

public class Task_2 {
    public static void main(String[] args) {
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    static void task_1(){
        int[] binary = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i = 0; i < binary.length; i++){
            if(binary[i] == 1)
                binary[i] = 0;
            else
                binary[i] = 1;
        }
    }

    // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    static void task_2(){
        int[] nums = new int[8];
        int j = 0;
        for(int i = 0; i < nums.length * 3; i+=3) {
            nums[j++] = i;
        }
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;

    static void task_3(){
        int[] nums = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] *= 2;
            }
        }
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

    static void task_4(){
        int[][] matrix = new int[10][10];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    // 5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

    static void task_5() {
        int[] nums = {1, 5, 3, 2, 11, 4, 5, 0, 4, 8, 9, 111};
        int min = nums[1];
        int max = nums[1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            if (nums[i] > max)
                max = nums[i];
        }
        System.out.println(min);
        System.out.println(max);
    }

    // 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
    // граница показана символами ||, эти символы в массив не входят;

    static void task_6(int[] nums) {
        int half = 0;
        int length = nums.length;
        if(length % 2 == 1)
            half = length / 2 + 1;
        else
            half = length / 2;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < half; i++) {
            sum1 += nums[i];
        }
        for (int i = half; i < length; i++) {
            sum2 += nums[i];
        }

        if(sum1 == sum2)
            System.out.println("true");
        else
            System.out.println("false");

    }

    // 7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.

    static void task_7(int[] nums, int shift) {
        if(shift != 0){
            if (shift > nums.length){
                shift = Math.abs(shift % nums.length);
            }

            if (shift > 0) {
                for (int n = 0; n < shift; n++) {
                    int buffer = nums[0];
                    nums[0] = nums[nums.length - 1];
                    for (int j = 1; j < nums.length - 1; j++) {
                        nums[nums.length - j] = nums[nums.length - j - 1];
                    }
                    nums[1] = buffer;
                }
            }
            else if (shift < 0) {
                for (int i = 0; i > shift; i--) {
                    int buffer = nums[nums.length - 1];
                    nums[nums.length - 1] = nums[0];
                    for (int j = 1; j < nums.length - 1; j++) {
                        nums[j - 1] = nums[j];
                    }
                    nums[nums.length - 2] = buffer;
                }
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }

}
