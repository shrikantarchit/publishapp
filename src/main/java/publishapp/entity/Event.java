package publishapp.entity;

import java.io.Serializable;

public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String issueId;

	private String crtDate;

	private String url;

	public Event(Integer id, String issueId, String crtDate, String url) {
		super();
		this.id = id;
		this.issueId = issueId;
		this.crtDate = crtDate;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}

	public Event(String issueId, String crtDate, String url) {
		super();
		this.issueId = issueId;
		this.crtDate = crtDate;
		this.url = url;
	}

	@Override
	public String toString() {
		return "RequestUrl [id=" + id + ", issueId=" + issueId + ", crtDate=" + crtDate + ", url=" + url + "]";
	}

}
