package dao;

public class Task {
	private String Title;
	private String Statut;
	private String Deadline;
	private String Category;
	private String Description;
	
	
	
	public Task(String Title, String Statut, String Deadline, String Category,String Description ) {
		super();
//		Title = title;
//		Statut = statut;
//		Deadline = deadline;
//		Category = category;
	
		
	}



	public String getTitle() {
		return Title;
	}



	public void setTitle(String title) {
		Title = title;
	}



	public String getStatut() {
		return Statut;
	}



	public void setStatut(String statut) {
		Statut = statut;
	}



	public String getDeadline() {
		return Deadline;
	}



	public void setDeadline(String deadline) {
		Deadline = deadline;
	}



	public String getCategory() {
		return Category;
	}



	public void setCategory(String category) {
		Category = category;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}
	
	

}
