public class Vowels {

  public static int getCount(String str) {
    int count = 0;
    //str to charArray
    char[] charStr = str.toCharArray();
    //iter all str
      for(char letter : charStr){
        //check vowel
        if(isVowel(letter)) count++;
        
      }   
    
    return count;
  }
  
  private static boolean isVowel(char c){
     
    boolean vowel = false;
    
    switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                vowel = true; 
    }
                
    return vowel;
  }

}