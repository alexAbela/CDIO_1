//****************************************************************************************************************************
// Golden Dice v1.0   Date 11/10/2018      Author: Ida Christensen
//                                                 Gustav Nobert
//  A dice game where 2 players                    Martin Grønlykke
//  roll 2 dice untill there is a winner           Anders Eisenhardt
//  which is defined by a set of rules             Alexander Abela
//****************************************************************************************************************************
import java.util.Scanner;

public class maingame {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        dice die1 = new dice();
        dice die2 = new dice();

        final int winningScore = 40;

        while (true) { //Have the start menu in a while loop so that when the game is finished you can return to the menu
            System.out.println("-----------------------------------------\n" +
                               " Welcome to the game of the Golden dice\n" +
                               "-----------------------------------------\n" +
                               "---------------- Menu -------------------\n" +
                               "       (1)  For New Game press 1         \n" +
                               "       (2) For Instructions press 2      \n" +
                               "       (3)   To Exit press 3             \n" +
                               "-----------------------------------------\n");

            String playerInput = scan.next(); // Makes 2 players
            if (playerInput.equals("1")) { // starter spil
                int score1 = 0, score2 = 0;
                System.out.println("Insert player 1 name: ");
                String player1 = scan.next();
                System.out.println("Insert player 2 name: ");
                String player2 = scan.next();

                while(score2 < winningScore) //If player 2 has 40 or more points, they have won.
                {

                    while(true) {    //So it can be the players turn as many times in a row if they roll doubles

                        die1.roll();
                        die2.roll();

                        System.out.println("It is " + player1 + "'s turn ");
                        System.out.println("press 1 to roll");

                        scan.next("1");
                            if (die1.getValue() == 1 && die2.getValue() == 1) {  //If the player rolls 2 1's you they lose all their points but also get another turn
                                System.out.println("Die #1 = " + die1.getValue() + " Die #2 = " + die2.getValue() + "\n" +
                                                   "You rolled two 1's and lose all your points!" + "\n" +
                                                   "But because you rolled doubles you get another turn." + "\n");
                                score1 = 0;
                                System.out.println(player1 + " Total Score: " + score1 + "\n");
                            } else if (die1.getValue() == die2.getValue()) { //If the player rolls doubles
                                score1 += die1.getValue() + die2.getValue();
                                System.out.println("Die #1 = " + die1.getValue() + " Die #2 = " + die2.getValue() + "\n" +
                                                   player1 + " Total Score: " + score1 + "\n" +
                                                   "You rolled doubles so you get another turn!\n");
                            } else { //this is if they don't roll doubles
                                score1 += die1.getValue() + die2.getValue();
                                System.out.println("Die #1 = " + die1.getValue() + " Die #2 = " + die2.getValue() + "\n" +
                                                   player1 + " Total Score: " + score1 + "\n");
                                break; //So it goes on to be the next players turn... as long as this player hasn't won yet
                            }

                    }

                    if(score1 < winningScore) { //If player 2 has 40 or more points, they have won.

                        while(true) {    //So it can be the players turn as many times in a row if they roll doubles
                            die1.roll();
                            die2.roll();

                            System.out.println("It is " + player2 + "'s turn ");
                            System.out.println("press 1 to roll");
                            scan.next("1");
                            if (die1.getValue() == 1 && die2.getValue() == 1) {  //If the player rolls 2 1's you they lose all their points but also get another turn
                                System.out.println("Die #1 = " + die1.getValue() + " Die #2 = " + die2.getValue() + "\n" +
                                                   "You rolled two 1's and lose all your points!" + "\n" +
                                                   "But because you rolled doubles you get another turn." + "\n");
                                score2 = 0;
                                System.out.println(player2 + " Total Score: " + score2 + "\n");
                            } else if(die1.getValue() == die2.getValue()) { //If the player rolls doubles
                                score2 += die1.getValue() + die2.getValue();
                                System.out.println("Die #1 = " + die1.getValue() + " Die #2 = " + die2.getValue() + "\n" +
                                                   player2 + " Total Score: " + score2 + "\n" +
                                                   "You rolled doubles so you get another turn!\n");
                            } else { //this is if they don't roll doubles
                                score2 += die1.getValue() + die2.getValue();
                                System.out.println("Die #1 = " + die1.getValue() + " Die #2 = " + die2.getValue() + "\n" +
                                                   player2 + " Total Score: " + score2 + "\n");
                                break; //So it goes on to be the next players turn... as long as this player hasn't won yet
                            }
                        }
                    } else {
                        break;
                    }

                }

                if (score1 > score2) {
                    System.out.println(player1 + " Wins!");
                    System.out.println("Press 1 to go back to the main menu");
                    scan.next("1");
                }else{
                    System.out.println(player2 + " Wins!");
                    System.out.println("Press 1 to go back to the main menu");
                    scan.next("1");
                }
            } else if(playerInput.equals("2")) {
                System.out.println("Instructions / Rules: \n" +
                        "1. The game is played by 2 players.\n" +
                        "2. Each player takes turns rolling 2 dice.\n" +
                        "3. The values of the 2 dice are added together,\n" +
                        "   which is the player’s score for that round.\n" +
                        "4. A player wins by being the first to reach 40 points.\n" +
                        "4. If the player rolls two 1s, the player loses all their points.\n" +
                        "5. If the player rolls doubles, the player gets another turn.\n");

                System.out.println("press 1 to go back to the main menu");
                scan.next("1");
            } else if (playerInput.equals("3")){
                break;
            }
        }
    }
}