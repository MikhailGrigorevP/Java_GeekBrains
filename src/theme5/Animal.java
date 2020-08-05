package theme5;

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
