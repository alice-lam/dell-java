public class ToDoItem {

	int id;
	String description;
	boolean isCompleted;

	public ToDoItem(int id,  String description, boolean isCompleted) {
		this.id = id;
		this.description = description;
		this.isCompleted = isCompleted;
	}
	
	public int getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public boolean isCompletedFlag() {
		return this.isCompleted;
	}

}