package Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

public class Pikachu extends Pokemon {
    public Pikachu() {
        System.out.println("Pikachu : Pika Pika~");
    }

    public Pikachu(String name, int hp) {
        super(name, hp);
        super.setFlyable(new Nofly());
        this.attackPoint = 15;

        this.skills = new ArrayList<>(Arrays.asList("cheeks bulging", "electric shock", "100,000 volts"));
        this.skillPoints = new ArrayList<>(Arrays.asList(20, 40, 90));

        System.out.println("Pikachu : Pika Pika~");
        System.out.println(" ");
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Type : Electric");
    }

    @Override
    public void attack() {
        System.out.println("Wide area lightning attack~");
    }

    @Override
    public void attack(Pokemon targetPokemon, int s) {
        targetPokemon.setHp(targetPokemon.getHp() - (this.attackPoint + this.skillPoints.get(s)));
        System.out.println(" ");
        System.out.println(this.getName() + " makes a " + this.skills.get(s) + "  at " + targetPokemon.getName() + ".");
        System.out.println("The Hp of the " + targetPokemon.getName() + "was reduced to " + targetPokemon.getHp() + " due to " + this.getName() + "'s attack.");
        try{Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(" ");
    }
}