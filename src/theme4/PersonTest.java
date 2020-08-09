package theme4;

public class PersonTest {

    // 4. Создать массив из 5 сотрудников:

    public static void main(String[] args) {
        Person[] personArray = new Person[5];
        personArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000,
                30); // потом для каждой ячейки массива задаем объект
        personArray[1] = new Person("Petrov Petr", "Engineer", " petrov@mailbox.com ", "89400000", 40000,
                40); // потом для каждой ячейки массива задаем объект
        personArray[2] = new Person("Frolov Fedr", "Back-end developer", " frolov@mailbox.com ", "89500000", 50000,
                50); // потом для каждой ячейки массива задаем объект
        personArray[3] = new Person("Sergeyev Sergey", "Back-end developer", " sergeyev@mailbox.com ", "89600000", 60000,
                60); // потом для каждой ячейки массива задаем объект
        personArray[4] = new Person("Antonov Anton", "Front-end developer", " antonov@mailbox.com ", "89700000", 70000,
                70); // потом для каждой ячейки массива задаем объект

        for(Person person: personArray){
            if (person.getAge() > 40)
                person.echo();
        }

    }
}
