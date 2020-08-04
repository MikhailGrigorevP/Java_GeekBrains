package Theme4;

// 5. Создать классы Собака и Кот с наследованием от класса Животное;

// 6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
// В качестве параметра каждому методу передается величина,
// означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);

// 7. У каждого животного есть ограничения на действия
// (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
// плавание: кот не умеет плавать, собака – 10 м.);

// 8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
// (Например, dog1.run(150); -> результат: run: true);

public abstract class Animal {

    double maxRunLength;
    double maxSwimLength;
    double maxJumpLength;

    public Animal(double _mR, double _mS, double _mJ){
        this.maxRunLength = _mR;
        this.maxSwimLength = _mS;
        this.maxJumpLength = _mJ;
    }

    public void run(double length){
        System.out.printf("run: %b", length <= this.maxRunLength);
        System.out.println();
    }

    public void swim(double length) {
        System.out.printf("swim: %b", length <= this.maxSwimLength);
        System.out.println();

    }

    public void jump(double height){
        System.out.printf("jump: %b", height <= this.maxJumpLength);
        System.out.println();

    }

}
