package nielsen.lesson5_homework;

/**
 * Created by lnielsen on 9/19/16.
 */
public class ToDo {

    private String textToDo;
    private boolean isCompleted;

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getTextToDo() {
        return textToDo;
    }

    public void setTextToDo(String textToDo) {
        this.textToDo = textToDo;
    }


    public ToDo(String textToDo) {
        this.textToDo = textToDo;
        this.isCompleted = false;
    }
}