package theme4;

// 7. У каждого животного есть ограничения на действия
// (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
// плавание: кот не умеет плавать, собака – 10 м.);

public class AnimalTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat(300, 2, 0);
        cat1.run(300);
        cat2.run(100);
        cat3.run(300);

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        dog1.run(300);
        dog2.run(100);
    }
}
