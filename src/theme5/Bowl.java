package theme5;

// 2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней,
// а также методами наполнения и получения информации о количестве еды;

public class Bowl {
    private final int capacity;
    private int meal;

    public Bowl(int _capacity){
        this.capacity = _capacity;
        this.meal = 0;
    }

    // 7. Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.

    public void getMeal(int _meal){
        meal -= _meal;
        if(meal == 0){
            System.out.println("Low meal in this bowl");
        }
    }

    public void setMeal(){
        meal = capacity;
    }

    public int getMealSize(){
        return meal;
    }

}
