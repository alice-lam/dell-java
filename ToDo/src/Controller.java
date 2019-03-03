import java.util.Scanner;

public class Controller {

	private Scanner _scanner = new Scanner(System.in);;
	private DAO database = new DAO();

	public void start() {
		printHelp();
		boolean continueAction = true;
		while (continueAction) {
			String input = promptMessageAndGetInput("Please select an option:");
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
			if (action.equals("add")) {

				processAddAction();

			} else if (action.equals("delete")) {

				processDeleteAction();

			} else if (action.equals("mark")) {

				processMarkDoneAction();

			} else if (action.equals("list")) {

				processListAction(actionParts);

			} else if (action.equals("quit")) {

				continueAction = false;

			} else if (action.equals("help")) {

				printHelp();

			} else if (action.length() == 0) {

				// do nothing.

			} else {
				promptMessage("[Error: Invalid action]");
			}
		}

	}

	private void processListAction(String[] actionParts) {
		if (actionParts[1].equals("all")) {
			database.list("all");
			System.out.println();
		} else if (actionParts[1].equals("done")) {
			database.list("done");
			System.out.println();
		} else if (actionParts[1].equals("pending")) {
			database.list("pending");
			System.out.println();
		} else {
			promptMessage("[Error: Invalid list action]");
		}
	}

	private void processDeleteAction() {
		int itemId = Integer.parseInt(promptMessageAndGetInput("Enter a projectID id to delete:"));
		database.delete(itemId);
		promptMessage("[Entry deleted]");
		System.out.println();
	}

	private void processMarkDoneAction() {
		int itemId = Integer.parseInt(promptMessageAndGetInput("Enter a projectID id to complete:"));
		database.markDone(itemId);
	}

	private String promptMessageAndGetInput(String message) {
		System.out.println(message);
		return _scanner.nextLine();
	}

	private void promptMessage(String message) {
		System.out.println(message);
	}

	private void processAddAction() {
		String description = promptMessageAndGetInput("Item Description: ");
		database.add(description);
		promptMessage("[Entry added]");
		System.out.println();
	}

	private void printHelp() {
		System.out.println("Available functions: ");
		System.out.println("  add: 			to add an item");
		System.out.println("  delete: 		to delete an item");
		System.out.println("  mark done: 	the item to mark as done");
		System.out.println("  list pending: to list the pending items");
		System.out.println("  list done: 	to list the done items");
		System.out.println("  list all: 	to list all items");
		System.out.println("  help: 		display available functions");
		System.out.println("  quit: 		to quit");
		System.out.println();
	}
}