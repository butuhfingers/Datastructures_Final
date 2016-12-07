import javax.swing.text.Document;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Recreational on 12/7/2016.
 */
public class WordDocument {
    public String getName(){
        return name;
    }
    public Integer getSize(){ return wordsIHave.size(); }
    public ArrayList<DocumentWord> wordList(){
        return wordsIHave;
    }

    private String name;
    private ArrayList<DocumentWord> wordsIHave = new ArrayList<DocumentWord>();

    public WordDocument(String name){
        this.name = name;
    }

    public void AddWord(DocumentWord word){
        wordsIHave.add(word);
    }

    @Override
    public String toString(){
        return getName();
    }
}
