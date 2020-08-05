package theme5;

// 1. Класс кота из прошлого ДЗ расширить функционалом потребления пищи.
// У каждого кота есть аппетит, т.е. количество еды, которое он съедает за один раз;

public class Cat extends Animal {

    private final int appetite;
    private boolean satiety;

    public Cat(int _appetite) {
        super(200, 2, 0);
        appetite = _appetite;
        satiety = false;
    }

    public Cat(double _mR, double _mS, double _mJ, int _appetite) {
        super(_mR, _mS, _mJ);
        appetite = _appetite;
        satiety = false;
    }

    public void getSatiety(){
        System.out.printf("Satiety: %s", this.satiety);
        System.out.println();
    }

    // 3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е.,
    // конкретный кот ест из конкретной миски, уменьшая объём еды в ней;

    // 4. Предусмотрите проверку, при которой в миске не может получиться отрицательного количества
    // еды (например, в миске 10 единиц еды, а кот пытается съесть 15);

    // 5. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    // Если коту удалось поесть (хватило еды), сытость = true;
    //Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
    // то есть не может быть наполовину сыт (это сделано для упрощения логики программы);

    public void feed(Bowl bowl){
        if(bowl.getMealSize() >= appetite){
            bowl.getMeal(appetite);
            this.satiety = true;
        }
    }

}
