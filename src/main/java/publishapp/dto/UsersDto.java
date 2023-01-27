package publishapp.dto;

import javax.persistence.Column;

public class UsersDto {
	private int id;

	private int userId;

	private String title;

	private String completed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "UsersDto [id=" + id + ", userId=" + userId + ", title=" + title + ", completed=" + completed + "]";
	}

	public UsersDto(int id, int userId, String title, String completed) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.completed = completed;
	}

	public UsersDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
