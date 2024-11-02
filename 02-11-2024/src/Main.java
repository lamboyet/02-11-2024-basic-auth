import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();
        User currentUser = null;

        while(true)
        {
            System.out.println("\n Choose an option: register login or exit view-users");
            String choice = scanner.nextLine().trim();

            if(choice.isEmpty())
            {
                continue;
            }

            if(choice.equalsIgnoreCase("register"))
            {
                System.out.println("Enter username: ");
                String username = scanner.nextLine();
                System.out.println("Enter password: ");
                String password = scanner.nextLine();
                auth.register(username,password);
            }
            else if(choice.equalsIgnoreCase("login"))
            {
                System.out.println("Enter username: ");
                String username = scanner.nextLine();
                System.out.println("Enter password: ");
                String password = scanner.nextLine();
                currentUser = auth.login(username,password);
            }

            else if(choice.equalsIgnoreCase("view-users"))
                auth.viewAllUsers();

            if(currentUser !=null)
            {
                manageToDoList(currentUser.getToDoList(),scanner);
            }else if(choice.equalsIgnoreCase("exit"))
            {
                System.out.println("goodbye ");
                break;
            }//else if(choice != "exit" && choice !="view-users" && choice !="login" && choice != "register")
            //{
                //System.out.println("Invalid option");
            //}
        }
        scanner.close();
    }

    private static void manageToDoList(ToDoList toDoList, Scanner scanner)
    {
        while(true)
        {
            System.out.println("\n To do list Options: add view logout");
            String option = scanner.nextLine().trim();

            if( option.isEmpty()){
                continue;
        }
            if(option.equalsIgnoreCase("add"))
            {
                System.out.println("enter task description: ");
                String description = scanner.nextLine();
                toDoList.addtTask(new Task(description));
            }
            else if(option.equalsIgnoreCase("view"))
            {
                toDoList.viewTasks();
            }
            else if(option.equalsIgnoreCase("logout"))
            {
                System.out.println("logged out");
                break;
            }
            else System.out.println("Invalid option");
        }
    }
}
