import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[] spin ={"\uD83C\uDF49" , "\uD83C\uDF4B" , "\uD83D\uDD14" , "\uD83C\uDF4F"};
    public static void main(String[] args) throws InterruptedException {
        int balance = 1000 ;
        int bet;
        int reward;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Here is the slot machine , Let's play and earn rewards!");
        Thread.sleep(2000);
        System.out.print("Are you in ?(Y/N) :");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Let's get started!\uD83D\uDE0A");
            Thread.sleep(2000);
            showSpin();
            Thread.sleep(2000);
            System.out.print("Place your bet: ");
            bet = sc.nextInt();
            if(bet < balance && bet > 0){
                balance -= bet;


            }
            else{
                System.out.println("you can't bet a negative amount  or place a bet which exceeds your balance");
            }


        }
        else if (answer.equalsIgnoreCase("N")) {
            System.out.println(" \uD83D\uDE1E See you next time  when you ready to play");

        }
        else {
            System.out.println("Invalid input");
        }

    }
    public static void showSpin() {
        System.out.println("*************");
        System.out.print("Our spinners : ");
        for (String s : spin) {
            System.out.print(s + " ");
        }
        System.out.println("\n***********");

    }
    public static void spin(){


    }
}
