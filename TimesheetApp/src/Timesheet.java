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
	
	public void delete(TimesheetEntry entry) {
		database.remove(entry);
	}
	
	public List<TimesheetEntry> list() {
		return database;
	}
	
	public TimesheetEntry get(int id) {
		for(TimesheetEntry i : database) {
			if (i.getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public void stop(TimesheetEntry entry) {
		entry.updateEndTime();
	}
}
