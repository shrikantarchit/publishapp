package publishapp.dto;

 
 
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveredStatusResponse {

	@JsonProperty("responseUniqueId")
	private String responseUniqueId;

	@JsonProperty("responseUniqueMessage")
	private String responseUniqueMessage;

	 
	public String getResponseUniqueId() {
		return responseUniqueId;
	}

	public void setResponseUniqueId(String responseUniqueId) {
		this.responseUniqueId = responseUniqueId;
	}

	/**
	 * @return the responseUniqueMessage
	 */
	public String getResponseUniqueMessage() {
		return responseUniqueMessage;
	}

	/**
	 * @param responseUniqueMessage the responseUniqueMessage to set
	 */
	public void setResponseUniqueMessage(String responseUniqueMessage) {
		this.responseUniqueMessage = responseUniqueMessage;
	}
}
