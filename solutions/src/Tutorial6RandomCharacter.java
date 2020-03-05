public class Tutorial6RandomCharacter {
    /* Generate a random character between ch1 and ch2*/
    public static char getRandomCharacter(char ch1,char ch2){
        return (char) (ch1+Math.random() * (ch2 -ch1 +1));
    }

    /* Generate a random lowercase letter*/
    public static char getRandomLowerCaseLetter(){
        return getRandomCharacter('a','z');
    }

    /* Generate a random uppercase letter*/

    public static char getRandomUpperCaseLetter(){
        return getRandomCharacter('A','Z');
    }

    public static char getRandomDigitCharacter(){
        return getRandomCharacter('0','9');
    }

    public static char getRandomCharacter(){
        return getRandomCharacter('\u0000','\uFFFF');
    }


    public static void main(String[] args){
        //char random=Tutorial6RandomCharacter.getRandomCharacter('a','z');
        //System.out.println(random);

        int count=0,num=0;

        char[] chars = new char[100];
        for(int i=0;i<100;i++){
            chars[i]=Tutorial6RandomCharacter.getRandomLowerCaseLetter();
        }


        int[] counts = new int[26];

        for(char alphabet='a'; alphabet<='z';alphabet++){
            count=0;

            for(int j=0;j<100;j++){
                char x= chars[j];
                if(alphabet==x){
                    count++;
                }

            }
            counts[num]=count;
            num++;
        }


        System.out.println("Random numbers generated are ");
        for(int i=0;i<100;i++){
            System.out.print(" "+ chars[i]);
        }

        System.out.println();

        System.out.println("Character repetition: ");
        for (int i:counts
             ) {
            System.out.println(i);
        }

    }

}

