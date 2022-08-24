import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Duke {
    private final Storage storage;
    private TaskList list;
    private final Parser p;
    private boolean isExiting;

    public Duke(String filePath) {
        storage = new Storage(filePath);
        try {
            list = new TaskList(storage.load());
        } catch (FileNotFoundException e) {
            list = new TaskList();
        }
        p = new Parser(list);
        isExiting = false;
    }

    public void run() {
        Ui.hello();
        Scanner sc = new Scanner(System.in);
        do {
            String userInput = sc.nextLine();
            try {
                isExiting = p.parseInput(userInput, false);
            } catch (DukeException e) {
                Ui.errorOccurred(e);
            }
        } while (!isExiting);
        sc.close();
        exit();
    }

    public void exit() {
        storage.saveToFile(list);
    }

    public static void main(String[] args) {
        new Duke("data" + File.separator + "taskList.txt").run();
    }
}
