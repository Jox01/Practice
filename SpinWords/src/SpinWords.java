public class SpinWords {

    public SpinWords() {
    }

    public String spinWords(String sentence) {
        //split sentence in words
        String[] wordsSentence = sentence.split(" ");
        
        for(int i = 0 ; i <= wordsSentence.length-1 ; i++){
          //check lentgh word by word
          if(wordsSentence[i].length() >= 5){
            wordsSentence[i] = reverse(wordsSentence[i]);
          }
          
        }
        //join all words of the sentence
        sentence = String.join(" ", wordsSentence);
        
        return sentence;
            
      }
      
      private String reverse(String word){
        String revertWord = "";
        //reverse the word
        for(int i = word.length()-1; i >= 0 ; i--){
          char letter = word.charAt(i);
          
          revertWord += letter;
          
        }
        
        return revertWord;
      }
}
