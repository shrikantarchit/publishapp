package publishapp.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import publishapp.dao.EventMapper;
import publishapp.dto.DeliveredStatusResponse;
import publishapp.entity.Event;
@Service
public class EventService {}
