package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    
	DictionaryLL() {
		dict = new LinkedList<String>();
	}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	String lowercaseWord = word.toLowerCase();
    	if(!dict.contains(lowercaseWord)) {
    		dict.add(lowercaseWord);
    		return true;
    	} else {
    		return false;
    	}
      
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        if(dict.contains(s.toLowerCase())) {
        	return true;
        }
        return false;
    }

    
}
