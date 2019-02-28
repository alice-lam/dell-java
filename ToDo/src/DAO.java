import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private List<ToDoItem> _list;
	Statement statement = null;
	private int _id = 0;

	public DAO() {
		_list = new ArrayList<>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:projectList.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 second.
			createTable();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createTable() {

		try {
			statement.executeUpdate("drop table if exists projectList");
			statement.executeUpdate(
					"create table projectList(id integer, description string, isCompleted boolean)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void markDone(int itemId) {
		try {
			String queryString = "UPDATE projectList SET isCompleted = true WHERE id = " + itemId;
			statement.executeUpdate(queryString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(String description) {
		try {
			_id++;
			String queryString = "insert into projectList values('" + _id + "', '" + description + "', '" + false + "');";
			statement.executeUpdate(queryString);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int itemId) {
		try {
			ToDoItem item = getItem(itemId);
			statement.executeUpdate("DELETE FROM projectList WHERE id = " + Integer.toString(itemId));
			System.out.println("id:        :" + item.id);
			System.out.println("description:" + item.description);
			System.out.println("status     :" + item.isCompleted);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ToDoItem getItem(int itemId) {
		ToDoItem foundItem = null;
		
		try {
			ResultSet rs = statement.executeQuery("select * from projectList where id = " + Integer.toString(itemId));
			int id = -1;
			String name = "";
			String description = "";
			boolean isCompleted = false;
			
			while (rs.next()) {
				// read the result set
				id = rs.getInt("id");
				description = rs.getString("description");
				isCompleted = Boolean.parseBoolean(rs.getString("isCompleted"));
				foundItem = new ToDoItem(id, description, isCompleted);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foundItem;
	}
	
	public void list(String status) {
		String completed;
		ArrayList<ToDoItem> tempList = new ArrayList<ToDoItem>();
		
		try {
			String query = "select * from projectList ";
			
			if(status.equals("done")) {
				query = query + "WHERE isCompleted = 'true'";
			}else if(status.equals("pending")) {
				query = query + "WHERE isCompleted = 'false'";
			}
			
			ResultSet rs = statement.executeQuery(query);
			int id = -1;
			String description = "";
			boolean isCompleted = false;

			while (rs.next()) {
				// read the result set
				id = rs.getInt("id");
				description = rs.getString("description");
				isCompleted = Boolean.parseBoolean(rs.getString("isCompleted"));
				tempList.add(new ToDoItem(id, description, isCompleted));
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (tempList.size()==0) {
			System.out.println("No Projects Found.");
			return;
		}
		
		for(int i = 0; i<tempList.size(); i++) {
			if(tempList.get(i).isCompleted == true) {
				completed = "Completed";
			}
			else {
				completed = "Pending";
			}
			System.out.println("Project ID: " + tempList.get(i).getId() + " | Project Description: " + tempList.get(i).getDescription() +" | Status: " + completed);
		}
		return;
	}

}