import java.util.Scanner;

/**
 * Created by Recreational on 12/7/2016.
 */
public class Menus {
    private MenuOptions option = MenuOptions.none;

    public Menus(){}

    public void StartMenu(){
        while(true){
            System.out.println("----------------------");
            System.out.println("Word List = 1");
            System.out.println("Document List = 2");
            System.out.println("Occurs With = 3");
            System.out.println("Quit = 4");
            System.out.print("Choose one:");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()){
                case 1:
                    WordList(scanner);
                    break;
                case 2:
                    DocList(scanner);
                    break;
                case 3:
                    OccursWith(scanner);
                    break;
                case 4:
                    Quit();
                    break;
                default:
                    Quit();
                    break;
            }
        }
    }

    private void WordList(Scanner scanner){
        System.out.println("----------------------");
        System.out.print("Document ID:");

        Driver.listDocumentWords(scanner.nextInt());
    }

    private void DocList(Scanner scanner){
        System.out.println("----------------------");
        System.out.print("Word for Document list:");

        Driver.listWordDocuments(scanner.next());
    }

    private void OccursWith(Scanner scanner){
        System.out.println("----------------------");
        System.out.print("Word for Document list to word (inefficient as all hell.....):");

        Driver.occursWith(scanner.next());
    }

    private void Quit(){
        System.out.println("Finals are done!!!!");
        System.exit(0);
    }
}
