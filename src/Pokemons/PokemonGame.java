package Pokemons;

import Pokemons.Charizard;
import Pokemons.Pikachu;
import Pokemons.Pokemon;
import Pokemons.Squirtle;

import java.util.Random;
import java.util.Scanner;

public class PokemonGame {

    static Pokemon wildPokemon;
    public static void produceEnemyPokemon(){
        Random random = new Random();   // 시드값 고정 X

        System.out.println("A wild Pokemon has appeared.");
        int select = random.nextInt(3);
        if(select == 0)
            wildPokemon = new Pikachu("Pikachu", 50);
        else if (select == 1)
            wildPokemon = new Squirtle("Squirtle", 55);
        else if (select == 2)
            wildPokemon= new Charizard("Charizard", 74);
        else
            wildPokemon = new Pikachu("Pikachu", 50);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The Pokemon game begins.");   // 게임 시작
        System.out.println("Loading...");
        try{Thread.sleep(1000);   /// 시간 지연
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(" ");
        System.out.println("Choose your pokemonster. 1) Pikachu(default)  2) Squirtle  3) Charizard : ");   // 자신의 포켓몬 선택
        int select = scanner.nextInt();

        Pokemon playerPokemon;
        if(select == 1)
            playerPokemon = new Pikachu("Pikachu", 50);
        else if (select == 2)
            playerPokemon = new Squirtle("Squirtle", 55);
        else if (select == 3)
            playerPokemon = new Charizard("Charizard", 74);
        else
            playerPokemon = new Pikachu("Pikachu", 50);   // default

        try{Thread.sleep(1000);   /// 시간 지연
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        produceEnemyPokemon();   // 야생의 포켓몬 소환

        while(true){
            try{Thread.sleep(1000);   // 시간 지연
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.print("1) Battle  2) Run away  3) quit : ");   // 게임 메뉴
            int menu = scanner.nextInt();

            if(menu == 3){
                System.out.println("Exit the program...");   // 3) quit 선택값 -> 종료
                break;
            } else if (menu == 1) {
                System.out.print("\t1) " + playerPokemon.skills.get(0) + "  2) " + playerPokemon.skills.get(1) + "  3) " + playerPokemon.skills.get(2) + "  : ");
                int skill = scanner.nextInt() -1;
                playerPokemon.attack(wildPokemon, skill);   // 플레이어가 야생 포켓몬 공격
                System.out.println("  ");
                System.out.println("=====================");

                try{Thread.sleep(1500);   // 시간 지연
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("  ");
                System.out.println("emergency! A wild Pokemon attacks.");   // 야생 포켓몬이 플레이어 포켓몬 공격
                wildPokemon.attack(playerPokemon, skill);

                try{Thread.sleep(1500);   // 시간 지연
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                if(wildPokemon.getHp() <= 0){   // Hp가 0 이하로 떨어질 경우 사망
                    System.out.println(wildPokemon.getName() + " is dead. You won!");
                    break;
                } else if (playerPokemon.getHp() <= 0){
                    System.out.println(playerPokemon.getName() + " is dead. You lost!");
                    break;
                }

            } else if (menu == 2) {
                System.out.println("The Player Pokemon runs away.");
                playerPokemon.performFly();

                try{Thread.sleep(1500);   // 시간 지연
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                produceEnemyPokemon();
            }
        }
    }
}