/*
abstract class Animal {
    abstract void eat();
    abstract void talk();
    abstract void walk();
};
*/

interface Animal {
    void eat();

    void talk();

    void walk();
}

class Tiger implements Animal {
    public void eat() {
        System.out.println("eat() of Tiger called");
    }

    public void talk() {
        System.out.println("talk() of Tiger called");
    }

    public void walk() {
        System.out.println("walk() of Tiger called");
    }
};

class Elephant implements Animal {
    public void eat() {
        System.out.println("eat() of Elephant called");
    }

    public void talk() {
        System.out.println("talk() of Elephant called");
    }

    public void walk() {
        System.out.println("walk() of Elephant class called");
    }
};

class sample {
    public static void main(String[] args) {
        Animal zoo[];
        zoo = new Animal[3];
        zoo[0] = new Tiger();
        zoo[1] = new Elephant();
        zoo[2] = new Tiger();
        for (Animal a : zoo) {
            a.eat();
            a.walk();
        }
    }
};
