import java.util.List;

public class Controller {

	/* Member variables */
	
    Timesheet timesheet;
    ConsoleUtils consoleUtils;
    
    /* Constructor */
    
    public Controller(){
        this.timesheet = new Timesheet();
        this.consoleUtils = new ConsoleUtils();
    }
    
    /* Methods */

	/*
	 * Runs the program
	 */
    public void start() {

        consoleUtils.printHelp(); // Print the action menu

        boolean quit = false;
        while(!quit) {

			// Prompt the user for input, collect input, parse into parts
            String input = consoleUtils.promptString("> ");
            String[] actionParts = input.split(" ");
            String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
            if (action.equals("add")) {

                processAddAction();

            } else if (action.equals("delete")) {

                processDeleteAction(actionParts);

            } else if (action.equals("stop")) {

                processStopAction(actionParts);

            } else if (action.equals("list")) {

                processListAction(actionParts);

            } else if (action.equals("quit")) {

                quit = true;

            } else if (action.equals("help")) {

            	consoleUtils.printHelp();

            } else if(action.length() ==0 ){
            
                // do nothing.
                
            } else {
                // Your code here
            	consoleUtils.info("Invalid Input. Type help if you would like to see options.");
            }
        }
        System.exit(0);
    }

	/*
	 * The user requested that a given TimesheetEntry be stopped (marked as complete)
	 * This method conveys that request to the Timesheet
	 */
    public void processStopAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to stop command");
            return;
        }
        
        if(actionParts.length == 1){
            consoleUtils.error("Too few inputs to stop command");
            return;
        }

        int id = Integer.parseInt(actionParts[1]);
        try {
			timesheet.stop(timesheet.get(id));
		} catch (TimeSetException e) {
			consoleUtils.error("This entry has already been stopped");
			return;
		}
        consoleUtils.info("Entry stopped");
    }

	/*
	 * The user requested that a given TimesheetEntry be deleted
	 * This method conveys that request to the Timesheet
	 */
    public void processDeleteAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to delete command");
            return;
        }

        int id = Integer.parseInt(actionParts[1]);
		timesheet.delete(timesheet.get(id));
		consoleUtils.info("Entry deleted");
    }

	/*
	 * The user wants to view a list of timesheet entries
	 * This method conveys that request to the Timesheet,
	 * along with any special options (active-only, filter by project name)
	 */
    public void processListAction(String[] actionParts){
    	boolean active = false;
    	String project = null;
    	
        if(actionParts.length > 3){
            consoleUtils.error("Too many inputs to list command");
            return;
        }

		// Your code here
        if(actionParts.length>1) {
        	for (String s : actionParts) {
	        	if (s.equals("-a")) {
	        		active = true;
	        	}
	        	else {
	        		project = s;
	        	}
	        }
        }
        
       
        consoleUtils.printList(timesheet.list(project, active));
    }

	/*
	 * The user wants to add a new entry to the Timesheet
	 * This method conveys that request to the Timesheet, along with
	 * the specified project name and task description 
	 */
    public void processAddAction(){
    
        String project = consoleUtils.promptString("Project Name (one word only):");
        String description = consoleUtils.promptString("Task:");
        try{
        	timesheet.add(project, description);
        }catch(Exception e) {
        	consoleUtils.error("Project Name is more than one word");
        	return;
        }
        consoleUtils.info("Entry added");
        
    }
}