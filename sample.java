class Animal {
    void eat() {
        System.out.println("eat() of Animal class");
    }

    void talk() {
        System.out.println("talk() of Animal class");
    }
}

class Tiger extends Animal {
    void eat() {
        System.out.println("eat() of Tiger class");
    }

    void talk() {
        System.out.println("talk() of Tiger class");
    }
}

class Elephant extends Animal {
    void eat() {
        System.out.println("eat() of Elephant class");
    }

    void talk() {
        System.out.println("talk() of Elephant class");
    }
}

class sample {
    public static void main(String[] args) {
        Animal zoo[];
        zoo = new Animal[3];
        zoo[0] = new Tiger();
        zoo[1] = new Elephant();
        zoo[2] = new Tiger();
        for (Animal a : zoo) {
            a.eat();
        }
    }
}
