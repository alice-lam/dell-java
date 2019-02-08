import java.time.LocalDateTime;

public class TimesheetEntry {
	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private static int NEXTID = 1;

	public TimesheetEntry(String myProject, String myTask) {
		this.projectName = myProject;
		this.task = myTask;
		startTime = LocalDateTime.now();
		id = NEXTID;
		NEXTID++;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getTask() {
		return task;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}
	
	public void updateEndTime() {
		if (endTime==null) {
			endTime = LocalDateTime.now();
		}
	}
	
}
