public class Task_1 {
    // 1
    public static void main(String[] args) {
        //2 Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte _byte = 8;
        short _short = 2020;
        int _int = 1022020;
        long _long = 2020L;
        float _float = 202.0f;
        double _double = 20.20;
        boolean _bool = true;
        char _char = 'c';
        String _str = "Java";

    }
    //3 Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;
    static int math(int a, int b, int c, int d){
        return a * (b + (c / d));
    }
    //4 Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
    static boolean interval(int x, int y){
        return (((x + y) >= 10) && ((x + y) <= 20));
    }
    //5  Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
    static void negOrPos(int num){
        if (num >= 0) {
            System.out.println("Positive");
        }
        else
            System.out.println("Negative");
    }
    //6 Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    static boolean checkNeg(int num){
        return num < 0;
    }

    //7 Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    static void printName(String name){
        System.out.printf("Привет, %s!", name);
    }

    //8 *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static void checkYear(int year){
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            System.out.println("Leap year");
        else
            System.out.println("Common year");

    }

    // 9. *Не набирая код в IDE, ответьте на следующий вопрос...
    // Ответ: Это две разных сигнатуры одного метода

}