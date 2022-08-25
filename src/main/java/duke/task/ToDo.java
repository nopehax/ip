package duke.task;

public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    public String format() {
        return "todo " + this.description + "|" + this.getStatusIcon();
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }
}