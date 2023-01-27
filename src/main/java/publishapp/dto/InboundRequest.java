package publishapp.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
 

public class InboundRequest {
	 
	private List<Request> request = new ArrayList<Request>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public List<Request> getRequest() {
		return request;
	}
	public void setRequest(List<Request> request) {
		this.request = request;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	@Override
	public String toString() {
		return "InboundRequest [request=" + request + ", additionalProperties=" + additionalProperties + "]";
	}
	
	
}
