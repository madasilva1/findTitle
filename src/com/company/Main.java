package com.company;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
   public static  String [] ArrayMovies ;
   public static int numberOfEmptySpace = 0;

    public static void main(String[] args) throws Exception {
        System.out.println("Guess a movie title!");
            DrowMuvieList();
            System.out.println("you lost");
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
        System.out.println("movie title is:" + " " + movieName);
        System.out.println("This is title's size :" + " " + lenght);
        System.out.println("Empty space in title's name"+ " "+titleEptySpace);
        System.out.println(Arrays.toString(ArrayMovies));

        int index = 0;

        int trayLeft = lenght;

        for (int i = 0; i < lenght; i++) {

            System.out.println("You are guessing, enter a leter");
            Scanner scanner = new Scanner(System.in);
            String letter = scanner.nextLine();
             trayLeft--;
            System.out.println(letter);
            while (!letter.matches("[a-zA-Z]+")) {
                System.out.println("Please enter a valid letter!" + "You have:" + " " + trayLeft + " " + "chances left");
                scanner = new Scanner(System.in);
                letter = scanner.nextLine();
                if(trayLeft == 0){
                    System.out.println("you lost !!!!");
                    System.exit(0);
                }
            }

            if (movieName.contains(letter)) {

                index = movieName.indexOf(letter);

                System.out.println("movie is:" + movieName + ", " + "letter position is:" + " " + index + " , " + "movie's lenght is:" + lenght);
                char[] strArr;
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

                System.out.println("you have " + trayLeft + " " + "chances left");
               // System.out.println("enter a letter");
               // scanner = new Scanner(System.in);
                //letter = scanner.nextLine();
                //letter = validation(letter,trayLeft);


            } else {

                System.out.println("you entered:"+ " "+letter);
                System.out.println("wrong letter,tray again");
                System.out.println("you have " + trayLeft + "  " + "chances left");
            }
            int empty = 0;
            int lastIndex = 0;
            for( String s : ArrayMovies){
                if( s == "_"){
                    empty++;
                }
            }

            System.out.println("empty"+ " "+ empty  + Arrays.toString(ArrayMovies));
                if ( empty + 1  == numberOfEmptySpace){
                    lastIndex = movieName.indexOf(letter);
                    ArrayMovies[lastIndex] = letter;
                    System.out.println( Arrays.toString(ArrayMovies));
                    System.out.println("you won!");

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



