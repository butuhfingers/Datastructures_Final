import javax.swing.text.Document;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Created by Recreational on 12/7/2016.
 */
public class DocumentWord implements Comparable<DocumentWord>{
    public String getWord(){
        return element;
    }
    public Integer getSize(){ return documentsIAmIn.size(); }
    public ArrayList<WordDocument> documents(){
        return documentsIAmIn;
    }

    private String element;
    private ArrayList<WordDocument> documentsIAmIn = new ArrayList<WordDocument>();

    public DocumentWord(String element){
        this.element = element;
    }

    public void AddDocument(WordDocument doc){
        documentsIAmIn.add(doc);
    }

    @Override
    public int compareTo(DocumentWord o) {
        //Compare the strings
        //If the words are equal, the one if a greater string value wins
//        if(getSize().compareTo(o.getSize()) == 0)


        //The one with the greater amount of documents is higher
        //Efficiency
            return getWord().compareTo(o.getWord());
    }

    @Override
    public String toString(){
        return getWord();
    }
}
