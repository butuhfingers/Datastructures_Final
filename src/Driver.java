import sun.font.CreatedFontTracker;

import javax.swing.text.Document;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


/**
 * Created by Recreational on 12/7/2016.
 */
public class Driver {
    //Variables
    static URL wordUrl = null;
    static URL documentUrl = null;
    static Scanner wordScanner = null;
    static Scanner documentScanner = null;
    static ArrayList<WordDocument> documents = new ArrayList<WordDocument>();
    static ArrayList<DocumentWord> words = new ArrayList<DocumentWord>();
    static TreeSet<DocumentWord> wordsTree = new TreeSet<DocumentWord>();

    public static void main(String[] args){
        try {
            //The words text file
            wordUrl = new URL("http://cs.rocky.edu/~bennera/Courses/csc251/notes/resources/words.txt");
            wordScanner = new Scanner(wordUrl.openStream());

            //The documents text file
            documentUrl = new URL("http://cs.rocky.edu/~bennera/Courses/csc251/notes/resources/documents.txt");
            documentScanner = new Scanner(documentUrl.openStream());
        }catch(MalformedURLException mue){
            mue.printStackTrace();
            //Do nothing for now
        }catch(IOException ioe){
            ioe.printStackTrace();
            //Do nothing for now
        }

        //Create the word list
        words = CreateWords();
 //       System.out.println(words.size());
        documents = CreateDocuments();

        Menus myMenu = new Menus();
        myMenu.StartMenu();
    }

    private static ArrayList<DocumentWord> CreateWords(){
        //Create the words
        ArrayList<DocumentWord> words = new ArrayList<DocumentWord>();

        //Create the list of words
        while(wordScanner.hasNextLine()){
            String line = wordScanner.nextLine();

            words.add(new DocumentWord(line));
            wordsTree.add(new DocumentWord(line));
        }

        return words;
    }

    private static ArrayList<WordDocument> CreateDocuments(){
        ArrayList<WordDocument> wordDocuments = new ArrayList<WordDocument>();
        while(documentScanner.hasNextLine()){
            //Get the next line as a string
            String next = documentScanner.nextLine();

            //Create a string array
            String[] splits = next.split(" ");
            WordDocument currentDoc = new WordDocument(splits[0]);

            wordDocuments.add(currentDoc);

            //Go through the word list
            for(int i = 1;i < splits.length;i++){
                DocumentWord wordWeWant = words.get(Integer.parseInt(splits[i]));

                currentDoc.AddWord(wordWeWant);

                wordWeWant.AddDocument(currentDoc);
            }
        }

        return wordDocuments;
    }

    private static void CreateTreeSet(){
        for(DocumentWord word : words){
            wordsTree.add(word);
        }
    }

    public static void listDocumentWords(int docId){
        System.out.println(documents.size());

        for(DocumentWord word : documents.get(docId).wordList()){
            System.out.println(word.getWord());
        }

    }

    public static void listWordDocuments(String word){
        DocumentWord wordToSearchFor = new DocumentWord(word);

        //Look through the words
        for(DocumentWord wordIn : words){
            //Check if they are the same
            if(wordIn.compareTo(wordToSearchFor) == 0){
                //For all the documents, print them out
                for(WordDocument document : wordIn.documents()){
                    System.out.println(document.toString());
                }

                return;
            }
        }
    }

    public static void occursWith(String word) {
        DocumentWord wordToSearchFor = new DocumentWord(word);

        //Look through the words
        for (DocumentWord wordIn : words) {
            //Check if they are the same
            if (wordIn.compareTo(wordToSearchFor) == 0) {
                //For all the documents, print them out
                for (WordDocument document : wordIn.documents()) {
                    //Print out the document
                    System.out.println(document.toString());

                    //For all the words in a document
                    for (DocumentWord wordOut : document.wordList()) {
                        System.out.println("    " + wordOut.toString());
                    }
                }


                return;
            }
        }
    }
}
