/*{
Programer: Jaspreet Khatkar
CS 145
1/27/2023
Assignment: Assignment 1 Word Search
Purpose: To generate a word search game users can customize
*/

/* recommended words to enter:
   cat
   mat
   hello
   bad
   computer
 */     



import java.util.*;
import java.io.*;

 public class WordSearchJK {

       
        private static Scanner input = new Scanner(System.in);
        
        // words 
        private static String secondWord = "";
        private static String thirdWord = "";
        private static String fourthWord = "";
        private static String fiveWord = "";
        
        private static String reverseWord= "";
        
        
              
         private static int aLength = 20;
         
         private static String[][] wordSearch = new String[aLength][aLength]; // word search array
         private static String[][] wordSearchKey = new String[aLength][aLength]; // answer key array
         
         private static ArrayList<String> words = new ArrayList<String>(); // array to collect words
         
         private static Random random = new Random(); // randome # generator
         
         private static String currentWord = ""; // words to collect
         private static String reversed = ""; // string for reverse of current word
         
         private static int posA= 0; // vertical array postion for previous string
         private static int posB = 0; // horizontal array postion for previous string
      
         private static int tempA = 0; // vertical array postion for next string
         private static int tempB = 0; // vertical array postion for next string
         
        private static boolean placement = false; // to check if line was placed
         
        


    public static void main(String[] args) {

        menu();
        
    } // end of main

    public static void menu() {
        Scanner input = new Scanner(System.in);
        String menu="";
        while(!menu.equals("g")&&!menu.equals("p")&&!menu.equals("s")&&!menu.equals("q")){ 
        
            System.out.println("This program will allow you to make your own word search puzzle");
            System.out.println("please select an option: ");
            System.out.println("generate a new word search (g)");
            System.out.println("print your word search (p)");
            System.out.println("show the solution to your word search (s)");
            System.out.println("quit program (q)");
            menu = input.next();
         } // end while

         if(menu.equals("g")){
         
            words.clear();
            wordSearch = new String[aLength][aLength];
            wordSearchKey = new String[aLength][aLength];
      
         
            //allows user to enter 5 words
            for(int i = 0; i < 5; i++) {
               System.out.print("Please choose a word that is less than 10 letters \t");
               
               //word 1
               if (i == 0){
               wordOne();
               }
               
               //word 2
               else if (i == 1){
               
               wordTwo();
               }
               
                //word 3              
                else if (i == 2){              
                 wordThree();               
               } // end for
               
                             
               //word 4
                else if (i == 3){               
                wordFour();            
                }
             
               
               //word 5
                else if (i == 4){                
                wordFive();                      
               }              
              
            }
            
           // adds random filler letters
           for(int j = 0; j < 20; j++) {
              for(int k = 0; k < 20; k ++) {
                  int number = random.nextInt(26);
                  char letter = (char) (number + 97);
                  String sLetter = "" + letter;
                  
                  if(wordSearch[j][k] == null) {
                      wordSearch[j][k] = sLetter;
                      wordSearchKey[j][k] = "|";
                  } // end of if
               } // end of for-loop j
            }// end of for-loop i
                
          
                      
          } // end of g
         
         
          else if(menu.equals("p")){
           System.out.println("WORD SEARCH:");
           // for loop to print wordsearch
           for(int i = 0; i < 20; i++) {
               for(int j = 0; j < 20; j ++) {
                   System.out.print(" " + wordSearch[i][j] + " ");
               } // end of for-loop j
               System.out.println();
           } // end of for-loop i
         }
         

         else if(menu.equals("s")){
           System.out.println("WORD SEARCH ANSWER KEY:");
           // for loop to print wordsearch key
           for(int i = 0; i < 20; i++) {
               for(int j = 0; j < 20; j ++) {
                   System.out.print(" " + wordSearchKey[i][j] + " ");
               } // end of for-loop j
               System.out.println();
           } // end of for-loop i
         }

         else if(menu.equals("q")){
         System.out.println("Thank you for playing!");
            System.exit(0);
         }
         menu();
    } // end menu
    
    
         public static void wordOne () {
    
           currentWord = input.next();
           words.add(currentWord);
              
              //adds word to this position 
              posA = 10; 
              posB = posA - currentWord.length()/2;
              
              for(int i = 0; i < currentWord.length(); i++) {
                  String character = "" + currentWord.charAt(i);
                  wordSearch[posA][posB + i] = character.toLowerCase(); // adds word to wordSearch lower case
                  wordSearchKey[posA][posB + i] = character.toUpperCase(); // adds the word all caps
              }
    
        }//end word one
        
        public static void wordTwo () {
        
              currentWord = input.next();
              words.add(currentWord);

              placement = false;
              
             for(int x = 0; x < words.get(words.size() - 2).length(); x++) {
                 for(int y = 0; y < currentWord.length(); y++) { // goes through second word
                 
                 if(words.get(words.size() - 2).charAt(x) == currentWord.charAt(y)) {
                   if(placement == false) {
                   placement = true;
                   posA= posA - y;
                   posB = posB + x;
                      for(int i = 0; i < currentWord.length(); i++) { // places on left side
                      String character = "" + currentWord.charAt(i);
                     
                   
                     wordSearch[posA + i] [posB] = character;
                     wordSearchKey[posA+ i][posB] = character.toUpperCase(); // adds the word all caps
                     
                      } // end of for
                   } // end of if false
                 } // end of if matching letter
               } // end of for-loop y
             } // end of  for-loop x
   
          if(placement == false) { // default position if no letters match
         
            posA= posA- 2;
            posB = posB - 2;
            for(int j = 0; j < currentWord.length(); j++) { // places on left side
               String character = "" + currentWord.charAt(j);
               wordSearch[posA+ j][posB] = character; // adds word to wordSearch lower case
               wordSearchKey[posA+ j][posB] = character.toUpperCase(); // adds the word all caps                 
               }
           
             }
        }//end wordTwo
        
    public static void wordThree () {
        
        
        thirdWord = input.next();
        currentWord = thirdWord;
        words.add(thirdWord);

                      
        placement = false;
                   
         for (int x = 0; x < words.get(words.size() - 2).length(); x++) {
             for (int y = 0; y < currentWord.length(); y++) {
                  if (words.get(words.size() - 2). charAt(x) ==  currentWord.charAt(y)){
                     if (placement == false) {
                           
                         placement = true;
                              
                         tempA = posA + x;
                         tempB = posB + y;
                              
                         for (int j = 0; j < currentWord.length(); j++){
                             String character = "" + currentWord.charAt(j);
                              
                            if (tempA + x < 0 || tempA + x > 19 || tempB - x < 0 || tempB - x > 19) {
                                placement = false;                   
                      
                           }else {   
                                            
                            if (wordSearch [tempA] [tempB - x] != null && !wordSearch[tempA] [tempB- x].equals(character)) {
                   
                               placement = false;
                     
                           }//end if
                         
                         }//end else
                  
                              
                       }//end for 
                           
               if (placement) {
                                 
                  posA = posA + x;
                  posB = posB + y;
                                 
                      for (int i = 0; i < currentWord.length(); i++) {
                         String character = "" + currentWord.charAt(i);
                         wordSearch[posA][posB - i] = character;
                         wordSearchKey[posA][posB - i] = character.toUpperCase();
                                 
                      }//end for
                              
               }//end if placement
                           
             }//end placement 
                        
           }//end if 
                     
         }//end for y
                   
       }//end for
                   
                   
              if (placement == false) {
                   
                  posA = posA + 4;
                  posB = posB + 4;
                     
                     
                  for (int j = 0; j < currentWord.length(); j++){
                      String character = "" + currentWord.charAt(j);
                      wordSearch[posA][posB - (currentWord.length() - 1) + j] = character;
                      wordSearchKey[posA][posB - (currentWord.length() - 1) + j] = character.toUpperCase();
                     
                     
                   }//end for
                   
                                      
               }//end placement
     
              
           }//end word three
        
        
        public static void wordFour () {
        
        
           fourthWord = input.next();
           currentWord = fourthWord;
           words.add(fourthWord);

                placement = false;
                
                  for(int x = 0; x < words.get(words.size() - 2).length(); x++) {
                      for(int y = 0; y < currentWord.length(); y++) { // goes through second word
                          if(words.get(words.size() - 2).charAt(x) == currentWord.charAt(y)) {
                              if(placement == false) {
                                 placement = true;
                                 tempA = posA + y;
                                 tempB = posB - x;
                                    
                  for(int j = 0; j < currentWord.length(); j++) {
                     String character = "" + currentWord.charAt(j);
                     
                     if (tempA + j < 0 || tempA + j > 19 || tempB - j < 0 || tempB - j > 19) {
                         placement = false;                   
                      
                          }//end if
                          
                     else {
                     
                     if(wordSearch[tempA - j][tempB] != null && !wordSearch[tempA - j][tempB].equals(character)) {
                        placement = false;
                     }
                     }
                  } // end for
                                 
                     
                  if(placement == true) {
                     posA = posA + y;
                     posB = posB - x;
                     for(int j = 0; j < currentWord.length(); j++) { // places on left side
                        String character = "" + currentWord.charAt(j);
                        wordSearch[posA - j][posB] = character; // adds word to wordSearch lower case
                        wordSearchKey[posA - j][posB] = character.toUpperCase(); // adds the word all caps
                        
                     }//for
                  } //end of if            
               } // end of if           
         } // end of if
      } // end of Y
      } // end of X
   
      if(placement == false) {
         posA = 19;
         posB = 0;
         for(int j = 0; j < currentWord.length(); j++) { // places on left side
            String character = "" + currentWord.charAt(j);
            wordSearch[posA - j][posB] = character; // adds word to wordSearch lower case
            wordSearchKey[posA - j][posB] = character.toUpperCase(); // adds the word all caps
         }//end for
        }//end if
               
        
        } // end word four       
        
        public static void wordFive () {
        
         fiveWord = input.next();
         currentWord = fiveWord;
         words.add(fiveWord);


                
                placement = false;
                
                for (int x = 0; x < words.get(words.size() - 2).length(); x++){
                  for ( int y = 0; y < currentWord.length(); y ++){
                     if (words.get(words.size() - 2).charAt(x) == currentWord.charAt(y)) {
                     
                        if (placement == false) {
                        
                           placement = true;
                           tempA = posA + y;
                           tempB = posB - x;
                           
                           for (int j =0; j < currentWord.length(); j++) {
                              String character = "" + currentWord.charAt(j);
                              if (wordSearch [tempA + j] [tempB -j] != null && !wordSearchKey [tempA + j] [tempB - j].equals(character)){
                              
                              placement = false;
                              
                              }//end if
                           
                           }//end for
                           
                           if (placement == true) {
                              posA = posA + y;
                              posB = posB - x;
                              
                              for(int k = 0; k < currentWord.length(); k++) {
                                 String character = "" + currentWord.charAt(k);
                                 wordSearch [posA + k][posB - k] = character;
                                 wordSearchKey[posA + k][posB - k] = character.toUpperCase();
                              
                              }//end for
                           
                           }//end if placement true
                        
                        
                        }//end if placement
                     
                     }//end if
                  } //end for
                
                }//end for x
                
                
                
                if(placement == false) {
                
                  posA = 0;
                  posB = 19;
                  
                  while(wordSearch[posA][posB] == null) {
                  
                     posA++;
                     posB--;
                  
                  }//end while
                  
                  posA -= currentWord.length() + 1;
                  posB += currentWord.length() + 1;
                  
                  
                  for (int j = 0; j < currentWord.length(); j ++){
                     String character = "" + currentWord.charAt(j);
                     wordSearch[posA + j] [posB - j] = character;
                     wordSearchKey[posA + j] [posB - j] = character.toUpperCase();
                  
                  }//end for
                  
                             
         } //end if
       
       
       }//end word five
        
    
}//end class  