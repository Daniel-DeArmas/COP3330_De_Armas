public class TaskItem {
    String title;
    String description;
    String dueDate;
    boolean completed;

    public TaskItem(String inTitle, String inDescription, String inDueDate, boolean inCompleted){
        if (inTitle.length()>=1){
            this.title = inTitle;
        }else{
            throw new IllegalArgumentException("WARNING: title must be at least 1 character long; task not created");
        }
        this.description = inDescription;
        if(inDueDate.length()!=10){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else if(Character.isDigit(inDueDate.charAt(0))!=true){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else if(Character.isDigit(inDueDate.charAt(1))!=true){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else if(Character.isDigit(inDueDate.charAt(2))!=true){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else if(Character.isDigit(inDueDate.charAt(3))!=true){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else if(Character.isDigit(inDueDate.charAt(5))!=true){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else if(Character.isDigit(inDueDate.charAt(6))!=true){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else if(Character.isDigit(inDueDate.charAt(8))!=true){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else if(Character.isDigit(inDueDate.charAt(9))!=true){
            throw new IllegalArgumentException("WARNING: invalid due date; task not created");
        }else{
            this.dueDate = inDueDate;
        }

        this.completed = inCompleted;
    }
}
