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
         coutCaracters(movieName);


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

         for (int i = 0; i < lenght ; i++){
             while(!letter.matches("[a-zA-Z]+")){
                 System.out.println("Please enter a valid letter!");
                 scanner = new Scanner(System.in);
                 letter = scanner.nextLine();
             }

           int trayLeft = lenght - i;
        if (movieName.contains(letter)) {

            index = movieName.indexOf(letter);
            System.out.println("movie is:" + movieName + ", " + "letter position is:" + " " + index + " , " + "movie's lenght is:" + lenght);
            ArrayMovies[index] = letter;
            System.out.println(Arrays.toString(ArrayMovies));

            System.out.println("you have " + trayLeft+ " " + "chances left");
            System.out.println("enter a letter");
            scanner = new Scanner(System.in);
            letter = scanner.nextLine();


        }
        else {

            System.out.println("wrong letter,tray again");
            System.out.println("you have "+ trayLeft+ "  " + "chances left");
            scanner = new Scanner(System.in);
             letter = scanner.nextLine();
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
    public static void coutCaracters(String str){
        char[] strArr;
        int indexOfDuplicate = 0;
        do{
            strArr = str.toCharArray();
            char ch = strArr[0];

            int count = 1;
            for(int i = 1; i < strArr.length; i++){
                if(ch == strArr[i]){
                    indexOfDuplicate = i;
                    String c = Character.toString(ch);
                    ArrayMovies[indexOfDuplicate]= c;
                    System.out.println(Arrays.toString(ArrayMovies));
                    //System.out.println("the strind c is:"+c);

                    count++;
                }

            }

            // We don't need to count spaces
            if(((ch != ' ') && (ch != '\t') && (count > 1))){
                System.out.println(ch + " - " + count+" - ");
            }


            // replace all occurrence of the character
            // which is already iterated and counted
            str = str.replace(""+ch, "");

        }while(strArr.length > 1);
    }
    //String test= "edcba";
    //char[] ar = test.toCharArray();
    //Arrays.sort(ar);
    //String sorted = String.valueOf(ar);

    }



