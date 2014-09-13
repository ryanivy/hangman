/***************************************
***   CSIS 2450 SOFTWARE ENGINEERING
***   2014 FALL SEMESTER
***   AUTHOR: RYAN IVY
***   DATE: 09/05/2014
***************************************/

import  java.util.Random;
import  java.util.Scanner;

public class Hangman {
  static int userLives = 6;
  static String[] dictionary = 
    {"AMERICA","BRAZIL","NETHERLANDS","DENMARK","BULGARIA","PARAGUAY","RUSSIA",
    "FINLAND", "SWEDEN","ICELAND","GREENLAND","UKRAINE","ISRAEL","ITALY","CHINA",
    "JAPAN","TAIWAN","VIETNAM","AUSTRALIA","GERMANY","AUSTRIA","SWITZERLAND",
    "CROATIA","PERU","NORWAY"};   
  public static void main(String[] args) throws Exception {
     Scanner name = new Scanner(System.in);
     String word = dictionary[new Random().nextInt(dictionary.length)], guesses = " ";
     int misses = -1;  
     System.out.println("HANGMAN!\nCoutries of the World Edition!\nLimited Extreme Ultra-Ultra!");
     System.out.print("Please enter your name: ");
     System.out.println();
     String userName = name.nextLine();  
     System.out.println("Total Number of Lives: " + userLives);  
     //this is a comment. This is the method
     for(Scanner input = new Scanner(System.in); 
        !word.matches("[" + guesses + "]+") & (misses += word.contains(guesses.substring(0, 1)) ? 0 : 1) <= userLives;
        guesses = input.nextLine().toUpperCase().charAt(0) + guesses){ 
        System.out.println("Your options:" + guesses);
        System.out.println(word.replaceAll("(?<=.)", " ").replaceAll("[^" + guesses + "]", "-") + ("(Lives Left: " + (userLives - misses) + ")"));
     }
       if(word.matches("[" + guesses + "]+")){
           System.out.println("***************************************************************************");
           System.out.println("***************************************************************************");
  System.out.println("**     ACHIEVEMENT UNLOCKED! you  found: " + word);
           System.out.println("**     You prevented global thermonuclear warfare!");
           System.out.println("**     You will forever be known as " + userName + " the kind and merciful!");
           System.out.println("***************************************************************************");
