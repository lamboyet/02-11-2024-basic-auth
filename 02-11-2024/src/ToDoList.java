import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<Task> tasks;

    public ToDoList()
    {
        tasks = new ArrayList<>();
    }

    public void addtTask(Task task)
    {
        tasks.add(task);
        System.out.println("Task added: " + task.getDescription());
    }

    public void viewTasks()
    {
        if(tasks.isEmpty())
        {
            System.out.println("no tasks in the list");
        }
        else {
        for (int i=0;i<tasks.size();i++)
            System.out.println((i+1) + ". " + tasks.get(i));
        }
    }
}
