import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int wordIndex = (int)(Math.random() * words.length);
        int gallowIndex = 0;
        char[] word = new char[(words[wordIndex]).length()];
        char[] orgWord = new char[word.length];
        String misses = "";

        for(int i=0;i<word.length;i++){
            word[i]='_';
            orgWord[i]=words[wordIndex].charAt(i);
        }

        String[] ms = {misses};
        while(gallowIndex<=6){
            printHung(gallowIndex, word, ms[0]);
            char inp = askUser();
            
            if(!checkInp(inp, word, orgWord, ms)){
                gallowIndex++;
                continue;
            }

            if(checkWord(word)){
                printHung(gallowIndex, word, "-1");
                break;
            }

        }

        scan.close();

    }

    public static void printHung(int gallowIndex, char[] word, String misses){
        System.out.println(gallows[gallowIndex]);
        if(gallowIndex==6){
            System.out.print("\n\n");
            System.out.println("RIP !!!");
            System.exit(0);
        }
        
        System.out.print("Word : ");
        for(int i=0;i<word.length;i++){
            System.out.print(word[i]+" ");
        }
        if(misses.equals("-1")){
            System.out.print("\n\n");
            System.out.println("GOOD JOB!!!");
            System.exit(0);
        }
        System.out.print("\n\n");
        
        System.out.println("Misses : "+misses);
    }

    public static char askUser(){
        System.out.print("\nGuess a letter : ");
        String s = scan.next();
        return s.charAt(0);
    }

    public static boolean checkInp(char inp, char[] word, char[] orgWord, String[] misses){
        for(int i=0;i<orgWord.length;i++){
            if(orgWord[i]==inp){
                word[i]=orgWord[i];
                orgWord[i]='-';
                return true;
            }
        }

        misses[0]+=inp;
        return false;

    }

    public static boolean checkWord(char[] word){
        for(int i=0;i<word.length;i++){
            if(word[i]=='_'){
                return false;
            }
        }
        return true;
    }

}





