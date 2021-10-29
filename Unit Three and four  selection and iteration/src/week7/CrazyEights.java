package week7;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class CrazyEights {
   private static final int NUM_SUITS = 4;
   private static final String HEARTS = "H";
   private static final String DIAMONDS = "D";
   private static final String CLUBS = "C";
   private static final String SPADES = "S";
   private static final double CARDS_PER_SUIT = 13;
   private static final String ACE = "A";
   private static final String JACK = "J";
   private static final String QUEEN = "Q";
   private static final String KING = "K";

   public static void main(String[] args) {

      int p1Points = 0, c1Points = 0, c2Points = 0;
      Scanner in = new Scanner(System.in);
      while (!gameOver(p1Points, c1Points, c2Points)) {
         String result = playRound(in);
         int firstDash = result.indexOf("-");
         int secondDash = result.indexOf("-", firstDash + 1);
         p1Points += Integer.parseInt(result.substring(0, firstDash));
         c1Points += Integer.parseInt(result.substring(firstDash + 1, secondDash));
         c2Points += Integer.parseInt(result.substring(secondDash + 1));

         System.out.println("Current Score: " + p1Points + " " + c1Points + " " + c2Points);
      }

   }

   private static String playRound(Scanner in) {

      String playerHand = "";
      String c1Hand = "";
      String c2Hand = "";
      for (int i = 0; i < 5; i++) {
         playerHand += getCard() + " ";
         c1Hand += getCard() + " ";
         c2Hand += getCard() + " ";
      }

      String topCard = ""; // no eights
      topCard += getCard();

      // "7H 3D AC JS-9D"
      while (playerHand.length() > 0 || c1Hand.length() > 0 || c2Hand.length() > 0) {
         String temp = processPlayer(playerHand, topCard, in);
         playerHand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         temp = processComputer(c1Hand, topCard, playerHand);
         c1Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         temp = processComputer(c2Hand, topCard, playerHand);
         c2Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
      }
      return "37-0-12";
   }

   private static String processPlayer(String playerHand, String topCard, Scanner in) {
      boolean redo = true;
      int maxcards = 0;
      System.out.println("your hand is: " + playerHand);
      System.out.println("the topcard is: " + topCard);
      while (redo) {
         redo = false;
         if (checkfacecard(playerHand, topCard) && checksuitcard(playerHand, topCard) || playerHand.indexOf("8") >= 0) {
            System.out.println("Select a card to play: ");
            String card = in.nextLine().toUpperCase();
            if (validatecard(card)) {
               if (playerHand.indexOf(card) >= 0) {
                  if(){//same thing as 8 but for card from scanner(card can be played onto top card)

                  }
                  if (card.indexOf("8") > 0) { // check if its 8
                     // play the 8 and get rid of it in their hand and ask what they want to change
                     // it too
                     System.out.println("what would you like to change the suit too: [D] [S] [C] [H] ");
                     String eight = in.nextLine();
                     if (eight.indexOf("D") == 0 && eight.length() == 1) {
                        topCard = "8D";
                     } else if (eight.indexOf("C") == 0 && eight.length() == 1) {
                        topCard = "8C";
                     } else if (eight.indexOf("S") == 0 && eight.length() == 1) {
                        topCard = "8S";
                     } else if (eight.indexOf("H") == 0 && eight.length() == 1) {
                        topCard = "8H";
                     }
                  }
                  topCard = "" + card;
                  playerHand = playerHand.replaceFirst(card + " ", "");

               } else {
                  System.out.println("you dont have that card");
               }
            } else {
               System.out.println("invalid input");
            }
         } else {
            System.out.println("im forcing you to draw cards ");
            if (maxcards < 5) {
               playerHand += getCard() + " ";
               redo = true;
               maxcards++;
            } else {
               System.out.println("you have drawn enough");
            }
         }

      }
      return playerHand + "-" + topCard;
   }

   private static String processComputer(String hand, String topCard, String playerHand) {
      // computer 1
      if (playerHand.length() <= 3) {// rule 4
         if (checkfacecardomputer1(hand, topCard) && hand.indexOf("8") < 0) {// rule 2
            // make it play the first face card that matches the top card in its hand that
            // it can
         } else if (hand.indexOf("8") >= 0) {// rule 3
            // make them play the 8 and the first suit card in the hand change it too that
            // suit
         }
      }
      if (checksuitcardcomputer1(hand, topCard) && hand.indexOf("8") < 0) {// rule 1 use && to also check if its not 8
         // make it play the first suit card in its hand that it can
      } else if (checkfacecardomputer1(hand, topCard) && hand.indexOf("8") < 0) {// rule 2
         // make it play the first face card that matches the top card in its hand that
         // it can
      } else if (hand.indexOf("8") >= 0) {// rule 3
         // make them play the 8 and the first suit card in the hand change it too that
         // suit
      }
      // computer 2
      if (playerHand.length() <= 3) {// rule 4
         if (checkfacecardomputer2(hand, topCard) && hand.indexOf("8") < 0) {// rule 2
            // make it play the first face card that matches the top card in its hand that
            // it can
         } else if (hand.indexOf("8") >= 0) { // rule 3
            // make them play the 8 and the first suit card in the hand change it too that
            // suit
         }
      }
      if (checksuitcardcomputer2(hand, topCard) && hand.indexOf("8") < 0) {// rule 1 use && to also check if its not 8
         // make it play the first suit card in its hand that it can
      } else if (checkfacecardomputer2(hand, topCard) && hand.indexOf("8") < 0) {// rule 2
         // make it play the first face card that matches the top card in its hand that
         // it can
      } else if (hand.indexOf("8") >= 0) { // rule 3
         // make them play the 8 and the first suit card in the hand change it too that
         // suit
      }
      return "-4D";
   }

   private static boolean checkfacecardomputer1(String c1Hand, String topCard) {
      if (topCard.trim().length() == 3) {
         return c1Hand.contains(topCard.substring(0, 2));
      } else {
         return c1Hand.contains(topCard.substring(0, 1));
      }
   }

   private static boolean checksuitcardcomputer1(String c1Hand, String topCard) {
      return c1Hand.contains(topCard.substring(topCard.length() - 1, topCard.length()));
   }

   private static boolean checkfacecardomputer2(String c2Hand, String topCard) {
      if (topCard.trim().length() == 3) {
         return c2Hand.contains(topCard.substring(0, 2));
      } else {
         return c2Hand.contains(topCard.substring(0, 1));
      }
   }

   private static boolean checksuitcardcomputer2(String c2Hand, String topCard) {
      return c2Hand.contains(topCard.substring(topCard.length() - 1, topCard.length()));
   }

   private static boolean checkfacecard(String playerHand, String topCard) {
      if (topCard.trim().length() == 3) {
         return playerHand.contains(topCard.substring(0, 2));
      } else {
         return playerHand.contains(topCard.substring(0, 1));
      }
   }

   private static boolean checksuitcard(String playerHand, String topCard) {
      return playerHand.contains(topCard.substring(topCard.length() - 1, topCard.length()));
   }

   private static boolean gameOver(int p1Points, int c1Points, int c2Points) {

      return p1Points >= 100 || c1Points >= 100 || c2Points >= 100;
   }

   private static boolean validatecard(String card) {
      if (card.equals("AH") || card.equals("2H") || card.equals("3H") || card.equals("4H") || card.equals("5H")
            || card.equals("6H") || card.equals("7H") || card.equals("8H") || card.equals("9H") || card.equals("10H")
            || card.equals("JH") || card.equals("QH") || card.equals("KH")) {
         return true;
      } else if (card.equals("AD") || card.equals("2D") || card.equals("3D") || card.equals("4D") || card.equals("5D")
            || card.equals("6D") || card.equals("7D") || card.equals("8D") || card.equals("9D") || card.equals("10D")
            || card.equals("JD") || card.equals("QD") || card.equals("KD")) {
         return true;
      } else if (card.equals("AS") || card.equals("2S") || card.equals("3S") || card.equals("4S") || card.equals("5S")
            || card.equals("6S") || card.equals("7S") || card.equals("8S") || card.equals("9S") || card.equals("10S")
            || card.equals("JS") || card.equals("QS") || card.equals("KS")) {
         return true;
      } else if (card.equals("AC") || card.equals("2C") || card.equals("3C") || card.equals("4C") || card.equals("5C")
            || card.equals("6C") || card.equals("7C") || card.equals("8C") || card.equals("9C") || card.equals("10C")
            || card.equals("JC") || card.equals("QC") || card.equals("KC")) {
         return true;
      } else {
         return false;
      }
   }

   private static String getCard() {
      String card = getFace() + getSuit();

      return card;
   }

   private static String getSuit() {
      int suit = (int) (Math.random() * NUM_SUITS);

      if (suit == 0)
         return HEARTS;
      else if (suit == 1)
         return DIAMONDS;
      else if (suit == 2)
         return CLUBS;
      else
         return SPADES;

   }

   private static String getFace() {
      int suit = (int) (Math.random() * CARDS_PER_SUIT);
      if (suit >= 2 && suit <= 10)
         return suit + "";
      else if (suit == 1)
         return ACE;
      else if (suit == 11)
         return JACK;
      else if (suit == 12)
         return QUEEN;
      else
         return KING;

   }

}
