import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
public class Main {
    public static void main(String[] args) throws IOException{
        if (args.length == 0) {
            System.out.println("Usage: gitty <command>");
            return;
        }

        String command = args[0];

        switch (command) {
            case "init":
                init();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }

    static void init() throws IOException {
        //this might throw an exception
       new File(".git/objects").mkdirs();
       /* mkdirs--creates the parent .git folder along w
        the objects folder inside it
        */
       new File(".git/refs").mkdirs();

       new File(".git/HEAD").createNewFile();

       new FileWriter(".git/HEAD").append("ref: refs/heads/main\n").close();

       System.out.println("Initialized empty gitty repository in .git/");


    }
}