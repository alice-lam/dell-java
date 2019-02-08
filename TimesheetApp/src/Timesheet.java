import java.util.ArrayList;
import java.util.List;

public class Timesheet {
	private List<TimesheetEntry> database;
	
	public Timesheet() {
		database = new ArrayList();
	}
	
	public void add(String project, String task) {
		TimesheetEntry newEntry = new TimesheetEntry(project, task);
		database.add(newEntry);
	}
	public List<TimesheetEntry> list() {
		return database;
	}
}
