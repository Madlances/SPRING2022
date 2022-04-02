package madsen;

import java.util.Scanner;

/**
 * This class will get the users input, that simulates the directory listing commands of popular operating command shells.
 * Those commands will be list, listall, chdir, up, count, countall, and q.
 * We will call this in App.java
 */
public class Terminal {
    public static void run(Composite root) {
        Boolean running = true;
        Scanner scanner = new Scanner(System.in);
        Component current = root;

        while (running) {
            System.out.print(current.getName() + "> ");
            String command = scanner.nextLine();

            if (command.equals("list")) {
                current.list(true);
            } else if (command.equals("listall")) {
                current.listAll(0);
            } else if (command.startsWith("chdir ")) {
                String newDirName = command.substring(6, command.length());
                Component newDir = current.chDir(newDirName, true);
                if (newDir != null) {
                    current = newDir;
                } else {
                    System.out.println("no such directory");
                }
            } else if (command.equals("up")) {
                if (current.getParent() != null) {
                    current = current.getParent();
                }
            } else if (command.equals("count")) {
                System.out.println(current.count(true));
            } else if (command.equals("countall")) {
                System.out.println(current.countAll());
            } else if (command.equals("q")) {
                running = false;
            } else {
                System.out.println("invalid command");
            }
        }

        scanner.close();
    }
    
}
