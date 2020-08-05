package theme5;

// 6. Создать массив котов и одну тарелку с едой, попросить всех котов покушать из
// этой тарелки и потом вывести информацию о сытости котов в консоль;

public class CatTest {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat(100);
        cats[1] = new Cat(300);
        cats[2] = new Cat(300);
        cats[3] = new Cat(150);
        cats[4] = new Cat(110);

        Bowl bowl = new Bowl(700);
        bowl.setMeal();

        for (Cat cat: cats){
            cat.feed(bowl);
        }

        for (Cat cat: cats){
            cat.getSatiety();
        }

    }
}
