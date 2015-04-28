import java.util.*;
import java.io.*;


/**
 * This program allows you to string match a pattern and see if there is a match or not.
 * 
 * @author (Eric Bowers ) 
 * @version (7/26/2013)
 */
public class StringMatching
{
    public static void main(String[]args) throws IOException
    {
        int [] intReplaceWord;// takes replaces word and puts it in a array
        int [] ACSII = new int[128];// using the acsii numbers to determine the shifts in the array
        String [] line; // transfers input file in to lines for each sentence
        String word;// the pattern goes in it.
        String replaceWord="";//takes in the replace word
        char playAgain;//to play the programs again on your commanda
        
        do
        {    
            
        File myfile = new File(args[0]); // where you put input file in to the argument slot 
        Scanner input = new Scanner (myfile); //turns the file in to a scanner object 
        Scanner keyboard = new Scanner(System.in);// useing the key board for input processing
        Scanner input2 = new Scanner(myfile);// using file for another part of the program
        
        // using the counters to help implement through loops 
        int count = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int num = 0;
        
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");;
       System.out.println("Input File");
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
      // this while loop counts the line in the text file
       while(input.hasNext())
       {
         String test = input.nextLine();
         System.out.println(test+"\n");
         count++;
       }
       line = new String[count];// this iniliatizes the first count
       System.out.print("Pattern:");// display pattern
       word = keyboard.nextLine(); // puts the pattern in to word 
       
       int [] integerWord = new int[word.length()];// integer word is initializes
          
       // this method with if statement dislays the a question to see if you want change a word in the input file 
        System.out.println("Do want to replace the pattern or word you choose to a different pattern or word in file,enter y or n. EXTRA CREDIT");
        playAgain = keyboard.nextLine().charAt(0);
        if(playAgain == 'y' || playAgain == 'Y')
        {
            System.out.println("enter word or a pattern you would like to replace");
            replaceWord = keyboard.nextLine();// where the word will be store in the varible 
        }
       //this  while loop put the inputs file in to separate lines in the array    
      while(input2.hasNext())
       {
         for(int i = 0;i<count;i++)
         {
            line[i] = input2.nextLine(); 
         }
        }
       // this is shift table algorithm 
       char [] scan = new char[word.length()];
       for(int j = word.length()-1;j>=0;j--)// this for loop goes back wards on the pattern
       { 
           char l;
           l = word.charAt(j);// this takes each character of the pattern
            if(j == word.length()-1)// this take last letter and sets it to the length of the word unless there is a duplicate
              { count2++;}// this counts for the next letter 
              else if( j != word.length()-1)//if is not set to j then it checks to see what the next shift is and to see if there is any duplicates 
              { boolean answer = false;
                  for(int m=0;m<count3;m++)// this for loop expands its length to check the word to see if there is any duplicates make sure the shift is in the right most letter
                  {
                      if(scan[m] == l)// if the letter is duplicate then the boolean is set false and loop starts over 
                      {
                      answer = false;
                      break;
                      }  
                      else
                      {answer = true;}// else if it is true it will go in to that if statement down below
                  }
                    if(answer)// if true it will put the shift number in the index of the letter converted to a acsii integer being shifted 
                    {
                    num = (int)l;
                    ACSII[num] = count2;
                    count2++;
                    }
                    if(answer == false)
                   {count2++;}
            }
        if(j != word.length()-1)//it puts the letter in a scan so it can scan again the for loop in the top for duplicate letters 
        {scan[count3] = l;}
         count3++;
       }
       // this for loop sets the rest of the array to word length to be shift 
       for(int k=0;k<128;k++)
       {
           if(ACSII[k]==0)
           {
              ACSII[k] = word.length(); 
           }
        }
      
        ////////////////////////////////////////////////////////////////////////////////////////////////
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
       System.out.println("This is the pattern letter and the shift for each one. ");
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");    
        //for loop shows the patters characters and shift number right beside it 
         for(int tab2 = 0;tab2<word.length();tab2++)
        {
           System.out.println("Pattern Letter" +"|"+ "Shift Number"); 
           System.out.println( word.charAt(tab2) +"\t\t"+ACSII[(int)word.charAt(tab2)]);
        }
        
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
        System.out.println("This is the index number/acsii number with a dash that has the shift number.");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
       // this for loop displays the entire shift table of ascii code 
        for(int tab = 0; tab<128;tab++)
            {   
                if(count6 == 8)
                {
                   System.out.print("\n"); 
                   count6 = 0;
                }
                 
                     System.out.print(tab+"-"+ACSII[tab]+" | ");
                     
                    count6++; 
                 
            }
                
        System.out.print("\n"); 
        
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
       System.out.println("This is all the occurence that the patterne found. EXTRA CREDIT ");
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
        /////////////////////////////////////////////////////////////////////////////////////////////////
        // this is the horsepool algorithm 
        System.out.println("Pattern:"+"\""+ word +"\"\n");
        for(int y =0;y<count;y++)// this uses count for the lline array to use each line at a time 
        {
           ///code changed here
        int [] integerSentence = new int[line[y].length()+2];// this intializes the integer sentence array
        
       // this for loop puts each line in this array that is case sentenive and turns it in too a integer
       for(int n =0;n<line[y].length();n++)
       {    boolean g = true;// checks to see what is true or false 
           // this the extra for case senstive
           for(int cases = 0;cases<word.length();cases++)
           {
               if(word.charAt(cases)+32 == line[y].charAt(n))// checks for lower case 
               {
                   g = false;
                   integerSentence[n] = (int)word.charAt(cases);// takes the case and turn it into integer and puts it back in the line
                }
                else if(word.charAt(cases)-32 == line[y].charAt(n))//check for upper case 
                {
                    g= false;
                    integerSentence[n] = (int)word.charAt(cases);// takes the case and turn it into integer and puts it back in the line
                }
           } 
           if(g)// if true and it was not compared with the for loop up them the letter will go back in there the same if it was not compared 
           {
            integerSentence[n] = (int) line[y].charAt(n);
           }
        }
        // this converts the pattern in to  integers and goes in to the array
        for(int x =0;x<word.length();x++)
        {
           integerWord[x] = (int)word.charAt(x); 
        }
        
        
        StringBuilder builder=new StringBuilder(line[y]);// this inilializes the String builder
        
        
        int e = word.length()-1;// set e to the word length
        int p = word.length()-1;// set p to the word length
        for(int a = e;a<line[y].length()+2;a--)//this starts backward from the last character of the pattern
        {  
             if(a==-1)// this apply only when is at -1 to give it a boost for the algorithm to get back on track 
             {
               a++;
               a++;
               a++;
               e=2;
            }
            if(integerWord[p]==integerSentence[a])// this compared the word and line together to see if there is a match in the algorithm
            {
                // review over this code some you can duplicate it another word
                count4++; 
              
                   p--;
                if(count4 == word.length())// if count 4 get to number of the word link then it will say that there is a match found for that letter then it will start over until 
                { // it letters go in to row together 
                 count5 =1;// helps decide if there is no match at all 
                 System.out.println("Output: match found for "+"\""+word+"\""+" on line "+(y+1)+" starting at character "+(a+1)+"\n");
                     if(playAgain == 'y'||playAgain == 'Y')
                     {
                         line[y]= new String(builder.replace(a,e,replaceWord));// this replaces the pattern with a new pattern
                     }
                 }
                //if p gets to -1 it reset itself to the word link until it find the pattern
                 if(p ==-1)
                {
                  p=word.length()-1;
                  
                }
             }
             else
            {
                e += ACSII[integerSentence[a]];// if there is no comparences then e will add up to number of shift each letter give of from each comparence 
                a=e;// then equals a to compare with the next letter
                count4=0;//count 4 reset itself 
                p=word.length()-1;// p resets itself
           }
       }
     }
    //the question of the find remove the pattern and places another pattern will display the new input message 
     if(playAgain == 'y' || playAgain == 'Y')
    {
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
       System.out.println("This is the input file with replace word in it"
                          +"and if you but word that is not found then it"
                          +"will not change the input file at all. EXTRA CREDIT");
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
    for(int c =0;c<count;c++)
        {
          System.out.println(line[c]+"\n");
        }
    }
      if(count5 != 1)// if count5 does not found a 1 then there is no match 
      {
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
       System.out.println("There was no match found and zero occurences.");
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
       System.out.println("match not found");
    }
    System.out.println("Do you want to find another pattern, enter y");// this ask if you want to run the program again
    playAgain = keyboard.nextLine().charAt(0);
}while(playAgain =='y'||playAgain =='Y');
}
}
