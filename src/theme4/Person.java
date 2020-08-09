package theme4;

public class Person {

    // 1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;

    private final String name;
    private final String position;
    private final String email;
    private final String phone;
    private final int salary;
    private final int age;

    // 2. Конструктор класса должен заполнять эти поля при создании объекта;

    public Person(String _name, String _position, String _email, String _phone, int _salary, int _age){
        this.name = _name;
        this.position = _position;
        this.email = _email;
        this.phone = _phone;
        this.salary = _salary;
        this.age = _age;
    }

    // 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;

    public void echo(){

        System.out.printf("Name: %s, Position: %s, Email: %s, Phone: %s, Salary: %d, Age: %d",
                name, position, email, phone, salary, age);
        System.out.println();
    }

    public int getAge(){
        return this.age;
    }


}
