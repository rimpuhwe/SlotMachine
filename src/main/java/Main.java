
import java.util.*;

public class Main {
    static String[] spin ={"\uD83C\uDF49" , "\uD83C\uDF4B" , "\uD83D\uDD14" , "\uD83C\uDF4F"};
    public static void main(String[] args) throws InterruptedException {
        int balance = 1000 ;
        int bet;
        String[] row ;
        int payout;
        String playAgain = "Yes";

        Scanner sc = new Scanner(System.in);
        System.out.println("Here is the slot machine , Let's play and earn rewards!");
        Thread.sleep(2000);
        System.out.print("Are you in ?(Y/N) :");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Let's get started!\uD83D\uDE0A");
            Thread.sleep(2000);
            showSpin();
            while(balance > 0){
                Thread.sleep(2000);
                System.out.println("current balance : $" + balance);
                System.out.print("Place your bet: ");
                bet = sc.nextInt();
                sc.nextLine();
                if(bet > balance ){
                    System.out.println("INSUFFICIENT BALANCE");
                    continue;
                }
                else if(bet <= 0){
                    System.out.println("Bet must be greater than 0 , not negative one ");
                    continue;
                }
                else{
                    balance -= bet;
                   row =  spin();

                    System.out.println("Spinning .....");
                    Thread.sleep(2500);
                    System.out.println("*************");
                    printRow(row);
                    System.out.println("*************");
                    payout = getPayout(row , bet);
                    if (payout > 0){
                        System.out.println("you win this round");
                        System.out.println("payout : $" + payout);
                        balance += payout;
                    }
                    else{
                        System.out.println("sorry , you lost this round");
                    }
                    System.out.print("Do you want to continue playing? (Y/N) :");
                    playAgain = sc.nextLine();
                    if(!playAgain.equalsIgnoreCase("Y")){
                        break;
                    }
                }

            }


        }
        else if (answer.equalsIgnoreCase("N")) {
            System.out.println(" \uD83D\uDE1E See you next time  when you ready to play");

        }
        else {
            System.out.println("Invalid input");
        }
        System.out.println("GAME OVER , your final balance : $" + balance);

    }
    static void showSpin() {
        System.out.println("*************");
        System.out.print("Our spinners : ");
        for (String s : spin) {
            System.out.print(s + " ");
        }
        System.out.println("\n***********");

    }
    static String[] spin(){
        Random random = new Random();
        String[] newSpin = new String[3];
        for (int i = 0; i < 3; i++) {
            newSpin[i] = spin[random.nextInt(spin.length)];
        }
        return newSpin;

    }
    static  void printRow(String[] row){
        System.out.println(" " + String.join(" | ", row));
    }
    static int getPayout(String[] row , int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
           return  switch (row[0]) {
               case "\uD83C\uDF49" -> bet * 2;
               case "\uD83C\uDF4B" -> bet * 4;
               case "\uD83D\uDD14" -> bet * 6;
               case "\uD83C\uDF4F" -> bet * 10;
               default ->  0;

           };
        }
        else if (row[0].equals(row[1])) {
            return  switch (row[0]) {
                case "\uD83C\uDF49" -> bet * 2;
                case "\uD83C\uDF4B" -> bet * 3;
                case "\uD83D\uDD14" -> bet * 4;
                case "\uD83C\uDF4F" -> bet * 5;
                default ->  0;

            };
        }
        else if (row[1].equals(row[2])) {
            return  switch (row[1]) {
                case "\uD83C\uDF49" -> bet * 2;
                case "\uD83C\uDF4B" -> bet * 3;
                case "\uD83D\uDD14" -> bet * 4;
                case "\uD83C\uDF4F" -> bet * 5;
                default ->  0;

            };
        }
        return 0;
    }

}
