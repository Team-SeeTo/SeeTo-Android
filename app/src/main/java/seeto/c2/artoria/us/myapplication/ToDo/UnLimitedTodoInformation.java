package seeto.c2.artoria.us.myapplication.ToDo;

public class UnLimitedTodoInformation {
    private Category category;
    private Mode mode;
    TodoItem[] TodoItems;

    public Category getCategory() {
        return category;
    }

    public Mode getMode() {
        return mode;
    }

    public TodoItem[] getTodoItems() {
        return TodoItems;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTodoItems(TodoItem[] todoItems) {
        TodoItems = todoItems;
    }
}
