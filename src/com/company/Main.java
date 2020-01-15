package com.company;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
   public static  String [] ArrayMovies ;

    public static void main(String[] args) throws Exception {
        System.out.println("Guess a movie title!");
            DrowMuvieList();
    }
    private static void GetInput(String movieName,int lenght) {
        ArrayMovies = new String[lenght];


        for (int i = 0; i < lenght; i++) {
            ArrayMovies[i] = "_";
        }
        System.out.println("This is title's size :"+ " "+lenght);
        System.out.println(Arrays.toString(ArrayMovies));

        int index = 0;
        System.out.println("You are guessing, enter a leter");

        System.out.println("you have " + " "+ lenght + "chances");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();

        System.out.println(letter);
          int trayLeft = lenght;
         for (int i = 0; i < lenght ; i++){
             while(!letter.matches("[a-zA-Z]+")){
                 trayLeft--;
                 System.out.println("Please enter a valid letter!" + "You have:" +" "+trayLeft+ " "+"chances left");
                 scanner = new Scanner(System.in);
                 letter = scanner.nextLine();

             }
        if (movieName.contains(letter)) {

            index = movieName.indexOf(letter);
            trayLeft--;
            System.out.println("movie is:" + movieName + ", " + "letter position is:" + " " + index + " , " + "movie's lenght is:" + lenght);
            char[] strArr;
            char c = letter.charAt(0);
            for(int j = 0; j < lenght; j++ ){
                strArr = movieName.toCharArray();
                if(strArr[j] == c){
                    ArrayMovies[index] = letter;
                    ArrayMovies[j] = letter;
                }
                else {
                    ArrayMovies[index] = letter;
                }

            }

            System.out.println(Arrays.toString(ArrayMovies));

            System.out.println("you have " + trayLeft+ " " + "chances left");
            System.out.println("enter a letter");
            scanner = new Scanner(System.in);
            letter = scanner.nextLine();
        }
        else {
            trayLeft--;
            System.out.println("wrong letter,tray again");
            System.out.println("you have "+ trayLeft+ "  " + "chances left");
            scanner = new Scanner(System.in);
             letter = scanner.nextLine();
        }
        }
         // check aqui o fim do for loop
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



