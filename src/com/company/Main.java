package com.company;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
   public static  String [] ArrayMovies ;
   public static int numberOfEmptySpace = 0;
  public static String movieName;

    public static void main(String[] args) throws Exception {
        System.out.println("Guess a movie title!");
            DrowMuvieList();
    }
    private static void GetInput(String movieName,int lenght) {

        String[] y = movieName.split(" ");
        for (String s : y) {
            if (s != "") {
                numberOfEmptySpace++;
            }
        }
        ArrayMovies = new String[lenght];

        for (int i = 0; i < lenght; i++) {
            ArrayMovies[i] = "_";
        }
        int titleEptySpace = numberOfEmptySpace -1;
        System.out.println("This is title's size :" + " " + lenght+ " "+ "Title's name:"+ ""+movieName);
        System.out.println(Arrays.toString(ArrayMovies));

        int index = 0;

        int trayLeft = lenght;

        for (int i = 0; i < lenght; i++) {

                  System.out.println("You are guessing, enter a leter");
                Scanner scanner = new Scanner(System.in);
                 String letter = scanner.nextLine();

                  System.out.println("you have " + trayLeft + " " + "chances left");
             trayLeft--;
            System.out.println(letter);
            while (!letter.matches("[a-zA-Z]+")|| !movieName.contains(letter) ||letter.length()>1 ) {
                System.out.println("you have entered a wrong or ilegal caracter!" + "You have:" + " " + trayLeft + " " + "chances left");
                scanner = new Scanner(System.in);
                letter = scanner.nextLine();
                trayLeft--;
                if(trayLeft == 0 ){
                    System.out.println("you lost !!!!"+"Movie's name is:" + " "+ movieName);
                    System.out.println("You got : "+ " "+ Arrays.toString(ArrayMovies));
                    System.exit(0);
                }
            }
            if (movieName.contains(letter)) {

                index = movieName.indexOf(letter);

                System.out.println("letter position is:" + " " + index + " , " + "movie's lenght is:" + lenght);
                char[] strArr = new char[lenght];
                char c = letter.charAt(0);
                for (int j = 0; j < lenght; j++) {
                    strArr = movieName.toCharArray();
                    if (strArr[j] == c) {
                        ArrayMovies[index] = letter;
                        ArrayMovies[j] = letter;

                    } else {
                        ArrayMovies[index] = letter;
                    }
                }
                System.out.println(Arrays.toString(ArrayMovies));
                // System.out.println(String.copyValueOf(strArr));
                System.out.println("you have " + trayLeft + " " + "chances left");
            }
            int empty = 0;
            int lastIndex = 0;
            for( String s : ArrayMovies){
                if( s == "_"){
                    empty++;
                }
            }
                if ( empty + 1  == numberOfEmptySpace){
                    lastIndex = movieName.indexOf(letter);
                    ArrayMovies[lastIndex] = letter;
                    System.out.println( Arrays.toString(ArrayMovies));
                    System.out.println("you won!"+ " "+"Movie's name is:"+ Arrays.toString(ArrayMovies));

                    System.exit(0);
                }
                if(trayLeft == 0 && empty + 1  != numberOfEmptySpace){
                    ArrayMovies[lastIndex] = letter;
                    System.out.println("you lost???" + "You got:"+" "+ Arrays.toString(ArrayMovies));
                    System.out.println("Movie's name is:" + " "+movieName);
                    System.exit(0);
                }
              }
        }
    private static void DrowMuvieList() throws Exception {

        int lengthOfMuvieTitle = 0;
        int TitleCount = 0;

        int RandomNumber = (int) (Math.random() * 25);
        String MuvieList[] = new String[25];
        File file;
        file = new File("movieslist.txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {

            String muvieTitle = fileScanner.nextLine();
            MuvieList[TitleCount] = muvieTitle;

            if (MuvieList[RandomNumber] == muvieTitle) {
                String movieName = MuvieList[RandomNumber];
                lengthOfMuvieTitle = movieName.length();
                GetInput(movieName,lengthOfMuvieTitle);
            }
            TitleCount++;
        }
    }
    }



