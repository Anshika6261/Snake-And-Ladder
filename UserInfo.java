package username;
import java.util.*;

abstract class Player
{
    protected String name;
    protected int age;

    public Player(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public abstract void displayInfo1();
    public abstract void displayInfo2();
}

class GamePlayer extends Player
{
    private String token;

    public GamePlayer(String name, int age)
    {
        super(name, age);

    }

    public void displayInfo1()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Token"+ "P1");
    }
    public void displayInfo2()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Token"+ "P2");
    }
}


