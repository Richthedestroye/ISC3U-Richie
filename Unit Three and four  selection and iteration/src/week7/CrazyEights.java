package week7;

import java.util.Scanner;

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

   private static String playRound(Scanner in) { // this method does everything the game needs like dealing the cards at
                                                 // the start and making the strings to hold the players hand and
                                                 // decideding the topcard and caluculating the points and showing the
                                                 // hands

      String playerHand = "";
      String c1Hand = "";
      String c2Hand = "";
      for (int i = 0; i < 5; i++) {
         playerHand += getCard() + " ";
         c1Hand += getCard() + " ";
         c2Hand += getCard() + " ";
      }

      String topCard = "";
      topCard = getCard();
      if (topCard.indexOf("8") >= 0) {
         topCard = getCard();
      }

      // "7H 3D AC JS-9D"

      while (playerHand.isBlank() == false || c1Hand.isBlank() == false || c2Hand.isBlank() == false) {
         System.out.println("your hand is: " + playerHand);
         System.out.println("comp1 hand is: " + makeintox(c1Hand));
         System.out.println("comp2 hand is: " + makeintox(c2Hand));

         String temp = processPlayer(playerHand, topCard, in);
         playerHand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         temp = processComputer(c1Hand, topCard, playerHand, c2Hand);
         c1Hand = temp.substring(0, temp.indexOf("-"));
         topCard = temp.substring(temp.indexOf("-") + 1);
         temp = processComputer(c2Hand, topCard, playerHand, c1Hand);
         c2Hand = temp.substring(temp.indexOf("*") + 1, temp.indexOf("#"));
         topCard = temp.substring(temp.indexOf("#") + 1);
      }

      String points = calucpoints(playerHand, c1Hand, c2Hand);
      String playerPoints = points.substring(0, points.indexOf("-"));
      String c1Points = points.substring(points.indexOf("#") + 1, points.indexOf("*"));
      String c2Points = points.substring(points.indexOf("*") + 1);
      System.out.println("points from this round");
      System.out.println("player points: " + playerPoints);
      System.out.println("comp1 points: " + c1Points);
      System.out.println("comp1 points: " + c2Points);
      return points;
   }

   // for scoring method
   // interate through the string check if its = to value of card add that but for
   // 8 or the jqk add 50 or 10 check if blank and make it 0 and add up

   private static String calucpoints(String playerHand, String c1Hand, String c2Hand) { // calculates the points at the
                                                                                        // end of the game by going
                                                                                        // through each hand and add
                                                                                        // points for corresponding card
                                                                                        // value
      int playerPoints = 0;
      int c1Points = 0;
      int c2Points = 0;
      for (int i = 0; i < playerHand.length(); i++) {
         if (playerHand.indexOf("8") > 0) {
            playerPoints += 50;
         }
         if (playerHand.indexOf("Q") > 0) {
            playerPoints += 10;
         }
         if (playerHand.indexOf("J") > 0) {
            playerPoints += 10;
         }
         if (playerHand.indexOf("A") > 0) {
            playerPoints += 1;
         }
         if (playerHand.indexOf("K") > 0) {
            playerPoints += 10;
         }
         if (playerHand.indexOf("10") > 0) {
            playerPoints += 10;
         }
         if (playerHand.indexOf("2") > 0) {
            playerPoints += 2;
         }
         if (playerHand.indexOf("3") > 0) {
            playerPoints += 3;
         }
         if (playerHand.indexOf("4") > 0) {
            playerPoints += 4;
         }
         if (playerHand.indexOf("5") > 0) {
            playerPoints += 5;
         }
         if (playerHand.indexOf("6") > 0) {
            playerPoints += 6;
         }
         if (playerHand.indexOf("7") > 0) {
            playerPoints += 7;
         }
         if (playerHand.indexOf("9") > 0) {
            playerPoints += 9;
         }

      }
      for (int i = 0; i < c1Hand.length(); i++) {
         if (c1Hand.indexOf("8") > 0) {
            c1Points += 50;
         }
         if (c1Hand.indexOf("Q") > 0) {
            c1Points += 10;
         }
         if (c1Hand.indexOf("J") > 0) {
            c1Points += 10;
         }
         if (c1Hand.indexOf("A") > 0) {
            c1Points += 1;
         }
         if (c1Hand.indexOf("K") > 0) {
            c1Points += 10;
         }
         if (c1Hand.indexOf("10") > 0) {
            c1Points += 10;
         }
         if (c1Hand.indexOf("2") > 0) {
            c1Points += 2;
         }
         if (c1Hand.indexOf("3") > 0) {
            c1Points += 3;
         }
         if (c1Hand.indexOf("4") > 0) {
            c1Points += 4;
         }
         if (c1Hand.indexOf("5") > 0) {
            c1Points += 5;
         }
         if (c1Hand.indexOf("6") > 0) {
            c1Points += 6;
         }
         if (c1Hand.indexOf("7") > 0) {
            c1Points += 7;
         }
         if (c1Hand.indexOf("9") > 0) {
            c1Points += 9;
         }
      }
      for (int i = 0; i < c2Hand.length(); i++) {
         if (c2Hand.indexOf("8") > 0) {
            c2Points += 50;
         }
         if (c2Hand.indexOf("Q") > 0) {
            c2Points += 10;
         }
         if (c2Hand.indexOf("J") > 0) {
            c2Points += 10;
         }
         if (c2Hand.indexOf("A") > 0) {
            c2Points += 1;
         }
         if (c2Hand.indexOf("K") > 0) {
            c2Points += 10;
         }
         if (c2Hand.indexOf("10") > 0) {
            c2Points += 10;
         }
         if (c2Hand.indexOf("2") > 0) {
            c2Points += 2;
         }
         if (c2Hand.indexOf("3") > 0) {
            c2Points += 3;
         }
         if (c2Hand.indexOf("4") > 0) {
            c2Points += 4;
         }
         if (c2Hand.indexOf("5") > 0) {
            c2Points += 5;
         }
         if (c2Hand.indexOf("6") > 0) {
            c2Points += 6;
         }
         if (c2Hand.indexOf("7") > 0) {
            c2Points += 7;
         }
         if (c2Hand.indexOf("9") > 0) {
            c2Points += 9;
         }
      }
      return Integer.toString(playerPoints) + "#" + Integer.toString(c1Points) + "*" + Integer.toString(c2Points);
   }

   private static String makeintox(String xhand) { // makes the comp 2 and 1 hands into XX to show how many cards they
                                                   // have and it works so it doesnt expose if they have a 10 it works
                                                   // by iterating through the hand checking each thing wherether its a
                                                   // space and keeps it a space and other then that it makes it a x and
                                                   // the end makes xxx into xx so it doesnt expose 10
      String Hand = "";
      for (int i = 0; i < xhand.length(); i++) {
         String tempstring = xhand.substring(i, i + 1);
         if (tempstring.equals(" ")) {
            Hand += " ";
         } else {
            Hand += "X";
         }
      }
      return Hand.replaceAll("XXX", "XX");
   }

   // c1Hand + "-" + topCard + "*" + c2Hand + "#" + topCard
   private static String processPlayer(String playerHand, String topCard, Scanner in) { // uses checksuit and face to
                                                                                        // make sure they can play and
                                                                                        // shows what is in their hand
                                                                                        // and what the top card is then
                                                                                        // it takes input and make sure
                                                                                        // its a card they can use and
                                                                                        // if they decided to play 8 it
                                                                                        // gives them the option to pick
                                                                                        // what suit they want to change
                                                                                        // it too and if they dont have
                                                                                        // anything to play it forces
                                                                                        // them to draw 5 cards
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
                  if (card.indexOf("8") < 0) {
                     if (topCard.trim().length() == 3) {
                        if (card.contains(topCard.substring(0, 2))) {
                           topCard = card;
                           System.out.println(topCard);
                        }
                     } else {
                        if (card.contains(topCard.substring(0, 1))) {
                           topCard = card;
                           System.out.println(topCard);
                        }
                     }
                     if (card.contains(topCard.substring(topCard.length() - 1, topCard.length()))) {
                        topCard = card;
                        System.out.println(topCard);
                     }
                  }
                  if (card.indexOf("8") > 0) {
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
         } else if ((checkfacecard(playerHand, topCard) == false && checksuitcard(playerHand, topCard) == false
               && playerHand.indexOf("8") < 0)) {
            System.out.println("im forcing you to draw cards ");
            if (maxcards < 5) {
               playerHand += getCard() + " ";
               redo = true;
               maxcards++;
               System.out.println(playerHand);
            } else {
               System.out.println("you have drawn enough");
            }
         }

      }
      return playerHand + "-" + topCard;
   }

   private static String processComputer(String c1Hand, String topCard, String playerHand, String c2Hand) { // runs the
                                                                                                            // two
                                                                                                            // computers
                                                                                                            // separately
                                                                                                            // when its
                                                                                                            // their
                                                                                                            // turn and
                                                                                                            // runs rule
                                                                                                            // 4 first
                                                                                                            // if not it
                                                                                                            // just runs
                                                                                                            // through
                                                                                                            // rules 1-3
                                                                                                            // if those
                                                                                                            // dont work
                                                                                                            // it forces
                                                                                                            // the
                                                                                                            // computers
                                                                                                            // to draw
                                                                                                            // up to 5
                                                                                                            // cards
      int maxcardsforcomp = 0;
      boolean redocomp1 = true;
      boolean redocomp2 = true;
      String card = "";
      int index1 = c1Hand.indexOf(0, topCard.length() - 1);
      int index = c1Hand.indexOf(topCard.length() - 1);
      while (redocomp1) {
         redocomp1 = false;
         // computer 1
         if (playerHand.length() <= 3 || c2Hand.length() <= 3) {// rule 4
            if (checkfacecardomputer1(c1Hand, topCard) && c1Hand.indexOf("8") < 0 && index1 >= 0) {// rule 2 make it
                                                                                                   // play the first
                                                                                                   // face card that
                                                                                                   // matches the top
                                                                                                   // card in its hand
                                                                                                   // that it can
               if (topCard.substring(0, 2).equals("10")) {
                  topCard = c1Hand.substring(index1, index1 + 3);
                  System.out.println(topCard);
               } else {
                  topCard = c1Hand.substring(index1, index1 + 2);
                  System.out.println(topCard);
               }
            } else if (c1Hand.indexOf("8") >= 0) {// rule 3 make them play the 8 and the first suit card in the hand
                                                  // change it too that suit
               String eight = c1Hand.substring(c1Hand.indexOf("8"), c1Hand.indexOf("8") + 2);
               c1Hand = c1Hand.replaceFirst(eight + " ", "");
               if (c1Hand.indexOf("D") >= 0) {
                  topCard = "8D";
                  System.out.println(topCard);
               } else if (c1Hand.indexOf("S") >= 0) {
                  topCard = "8S";
                  System.out.println(topCard);
               } else if (c1Hand.indexOf("H") >= 0) {
                  topCard = "8H";
                  System.out.println(topCard);
               } else if (c1Hand.indexOf("C") >= 0) {
                  topCard = "8C";
                  System.out.println(topCard);
               }
            }
         }

         if (checksuitcardcomputer1(c1Hand, topCard) && c1Hand.indexOf("8") < 0 && index >= 0) {// rule 1 make it play
                                                                                                // the first suit card
                                                                                                // in its hand that it
                                                                                                // can
            if (c1Hand.substring(index - 1, index).equals("0")) {
               index = (c1Hand.indexOf(topCard.length() - 1));
               card = c1Hand.substring(index - 1, c1Hand.indexOf(" ", index));
               topCard = "" + card;
               c1Hand = c1Hand.replaceFirst(card + " ", "");
            } else {
               index = (c1Hand.indexOf(topCard.length() - 1));
               card = c1Hand.substring(index, c1Hand.indexOf(" ", index));
               topCard = "" + card;
               c1Hand = c1Hand.replaceFirst(card + " ", "");
            }

         } else if (checkfacecardomputer1(c1Hand, topCard) && c1Hand.indexOf("8") < 0 && index1 >= 0) {// rule 2 make it
                                                                                                       // play the first
                                                                                                       // face card that
                                                                                                       // matches the
                                                                                                       // top card in
                                                                                                       // its hand that
                                                                                                       // it can
            if (topCard.substring(0, 2).equals("10")) {
               topCard = c1Hand.substring(index1, index1 + 3);
               System.out.println(topCard);
            } else {
               topCard = c1Hand.substring(index1, index1 + 2);
               System.out.println(topCard);
            }
         } else if (c1Hand.indexOf("8") >= 0) {// rule 3 make them play the 8 and the first suit card in the hand change
                                               // it too that suitcheck what the suit of the first card in their hand is
            String eight = c1Hand.substring(c1Hand.indexOf("8"), c1Hand.indexOf("8") + 2);
            c1Hand = c1Hand.replaceFirst(eight + " ", "");
            if (c1Hand.indexOf("D") >= 0) {
               topCard = "8D";
               System.out.println(topCard);
            } else if (c1Hand.indexOf("S") >= 0) {
               topCard = "8S";
               System.out.println(topCard);
            } else if (c1Hand.indexOf("H") >= 0) {
               topCard = "8H";
               System.out.println(topCard);
            } else if (c1Hand.indexOf("C") >= 0) {
               topCard = "8C";
               System.out.println(topCard);
            }
         } else {
            if (maxcardsforcomp < 5) {
               c1Hand += getCard() + " ";
               redocomp1 = true;
               maxcardsforcomp++;
            }
         }
      }
      while (redocomp2) {
         redocomp2 = false;
         // computer 2
         if (playerHand.length() <= 3 || c1Hand.length() <= 3) {// rule 4
            if (checkfacecardomputer2(c2Hand, topCard) && c2Hand.indexOf("8") < 0 && index1 >= 0) {// rule 2 make it
                                                                                                   // play the first
                                                                                                   // face card that
                                                                                                   // matches the top
                                                                                                   // card in its hand
                                                                                                   // that it can
               if (topCard.substring(0, 2).equals("10")) {
                  topCard = c2Hand.substring(index1, index1 + 3);
                  System.out.println(topCard);
               } else {
                  topCard = c2Hand.substring(index1, index1 + 2);
                  System.out.println(topCard);
               }
            } else if (c2Hand.indexOf("8") >= 0) { // rule 3 make them play the 8 and the first suit card in the hand
                                                   // change it too that suit
               String eight = c2Hand.substring(c2Hand.indexOf("8"), c2Hand.indexOf("8") + 2);
               c2Hand = c2Hand.replaceFirst(eight + " ", "");
               if (c2Hand.indexOf("D") >= 0) {
                  topCard = "8D";
                  System.out.println(topCard);
               } else if (c2Hand.indexOf("S") >= 0) {
                  topCard = "8S";
                  System.out.println(topCard);
               } else if (c2Hand.indexOf("H") >= 0) {
                  topCard = "8H";
                  System.out.println(topCard);
               } else if (c2Hand.indexOf("C") >= 0) {
                  topCard = "8C";
                  System.out.println(topCard);
               }
            }
         }
         if (checksuitcardcomputer2(c2Hand, topCard) && c2Hand.indexOf("8") < 0 && index >= 0) {// rule 1 make it play
                                                                                                // the first suit card
                                                                                                // in its hand that it
                                                                                                // can
            card = c1Hand.substring(index, c1Hand.indexOf(" ", index));
            topCard = "" + card;
            c1Hand = c1Hand.replaceFirst(card + " ", "");

         } else if (checkfacecardomputer2(c2Hand, topCard) && c2Hand.indexOf("8") < 0 && index1 >= 0) {// rule 2 make it
                                                                                                       // play the first
                                                                                                       // face card that
                                                                                                       // matches the
                                                                                                       // top card in
                                                                                                       // its hand that
                                                                                                       // it can
            if (topCard.substring(0, 2).equals("10")) {
               topCard = c2Hand.substring(index1, index1 + 3);
               System.out.println(topCard);
            } else {
               topCard = c2Hand.substring(index1, index1 + 2);
               System.out.println(topCard);
            }
         } else if (c2Hand.indexOf("8") >= 0) { // rule 3 make them play the 8 and the first suit card in the hand
                                                // change it too that suit
            String eight = c2Hand.substring(c2Hand.indexOf("8"), c2Hand.indexOf("8") + 2);
            c2Hand = c2Hand.replaceFirst(eight + " ", "");
            if (c2Hand.indexOf("D") >= 0) {
               topCard = "8D";
               System.out.println(topCard);
            } else if (c2Hand.indexOf("S") >= 0) {
               topCard = "8S";
               System.out.println(topCard);
            } else if (c2Hand.indexOf("H") >= 0) {
               topCard = "8H";
               System.out.println(topCard);
            } else if (c2Hand.indexOf("C") >= 0) {
               topCard = "8C";
               System.out.println(topCard);
            }
         } else {
            if (maxcardsforcomp < 5) {
               c2Hand += getCard() + " ";
               redocomp1 = true;
               maxcardsforcomp++;
            }
         }
      }

      return c1Hand + "-" + topCard + "*" + c2Hand + "#" + topCard;
   }

   private static boolean checkfacecardomputer1(String c1Hand, String topCard) { // runs if loop to check if the face of
                                                                                 // the card is a 10 if not it is A-9
                                                                                 // j-k and checks if it matches the top
                                                                                 // card so it can be played and returns
                                                                                 // true if not false
      if (topCard.trim().length() == 3) {
         return c1Hand.contains(topCard.substring(0, 2));
      } else {
         return c1Hand.contains(topCard.substring(0, 1));
      }
   }

   private static boolean checksuitcardcomputer1(String c1Hand, String topCard) { // runs to check the back of a card
                                                                                  // and its face then it compares it
                                                                                  // too the top cards suit to see if it
                                                                                  // can be played and returns true if
                                                                                  // not false
      return c1Hand.contains(topCard.substring(topCard.length() - 1, topCard.length()));
   }

   private static boolean checkfacecardomputer2(String c2Hand, String topCard) { // same as check face card but for
                                                                                 // comp2
      if (topCard.trim().length() == 3) {
         return c2Hand.contains(topCard.substring(0, 2));
      } else {
         return c2Hand.contains(topCard.substring(0, 1));
      }
   }

   private static boolean checksuitcardcomputer2(String c2Hand, String topCard) {// same as check suit card but for
                                                                                 // comp2
      return c2Hand.contains(topCard.substring(topCard.length() - 1, topCard.length()));
   }

   private static boolean checkfacecard(String playerHand, String topCard) {// same as check face card but for player
      if (topCard.trim().length() == 3) {
         return playerHand.contains(topCard.substring(0, 2));
      } else {
         return playerHand.contains(topCard.substring(0, 1));
      }
   }

   private static boolean checksuitcard(String playerHand, String topCard) {// same as check suit card but for player
      return playerHand.contains(topCard.substring(topCard.length() - 1, topCard.length()));
   }

   private static boolean gameOver(int p1Points, int c1Points, int c2Points) { // checks points to see if its over 100
                                                                               // and if not game keeps going

      return p1Points >= 100 || c1Points >= 100 || c2Points >= 100;
   }

   private static boolean validatecard(String card) { // just checks if the card inputted by player in process player is
                                                      // a valid card that is in the deck
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

   private static String getCard() { // uses get face and suit and combines them to make a card to give to players
                                     // and computer
      String card = getFace() + getSuit();

      return card;
   }

   private static String getSuit() { // gets a random number depending on number it will return a suit
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

   private static String getFace() {// gets a random number depending on number it will return a face
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
