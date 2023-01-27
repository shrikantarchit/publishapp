package publishapp.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import publishapp.dao.EmployeeMapper;
import publishapp.dao.EventMapper;
import publishapp.dto.DeliveredStatusResponse;
import publishapp.dto.IssueRequest;
import publishapp.entity.Employee;
import publishapp.entity.Event;
import publishapp.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	private final static Logger LOGGER = Logger.getLogger(EventController.class.getName());
	@Autowired
	EventMapper eventMapper;
	ObjectMapper mapper = new ObjectMapper();
	// @Inject
	// RestTemplate restTemplate ;

	Event event;

	@RequestMapping(value = "/saveProcess/{eventId1}/{eventId2}", method = RequestMethod.POST)
	public String saveEmployee(@RequestBody Event event, @PathVariable String eventId1, @PathVariable String eventId2) {
		String eventId = eventId1 + "/" + eventId2;
		LOGGER.info("eventId:" + eventId);
		String value = "https://cfapidev.acm.org/rest/eRightsAptaraPacmPapersDump/eRightsAptaraPacmPapersDump/"
				+ eventId;
		// Event eventt=new Event(eventId,new SimpleDateFormat("dd-MM-yyyy").format(new
		// Date()),value);
		//event.setIssueId(eventId);
		//event.setCrtDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		//event.setUrl(value);
		String s = "";
		DeliveredStatusResponse deliveredStatusResponse = new DeliveredStatusResponse();
		deliveredStatusResponse.setResponseUniqueId(EventController.formatDate(new Date(), "yyyy/MM/dd hh:mm:ss"));
		deliveredStatusResponse.setResponseUniqueMessage("Issue ID recieved successfully");

		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		// String requestJson = restTemplate.exchange(value, HttpMethod.GET, entity,
		// String.class).getBody();

		// LOGGER.info("Service metadata:" + requestJson);
		try {

			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			TypeReference<List<IssueRequest>> typeRef = new TypeReference<List<IssueRequest>>() {
			};
			// List<IssueRequest> inboundRequest = mapper.readValue(requestJson, typeRef);
			// LOGGER.info("INBOUND REQUEST : " + inboundRequest);

		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			s = mapper.writeValueAsString(deliveredStatusResponse);
			eventMapper.saveEvent(event);
			LOGGER.info("event:" + event);

		} catch (Exception exception) {

			LOGGER.info("Exception Details" + exception.getMessage());

		}
		LOGGER.info("s:" + s);
		return s;

	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String convertedDate = simpleDateFormat.format(date);
		return convertedDate;
	}
}
