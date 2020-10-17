package com.edgar.beltreviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.beltreviewer.models.Event;
import com.edgar.beltreviewer.models.User;
import com.edgar.beltreviewer.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eRepo;
	
	//find all Events
	public List<Event> findAllEvents() {
		List<Event> allEvents = this.eRepo.findAll();
		return allEvents;
	}
	
	//find 1 Event
	public Event findOneEvent(Long id) {
		Event event = this.eRepo.findById(id).orElse(null);
		return event;
	}
	
	//Save Event
	public Event saveEvent(Event updatedEvent) {
		return this.eRepo.save(updatedEvent);
	}
	
	//find Event by State
	public List<Event> findEventsByState(String state) {
		List<Event> inState = this.eRepo.findByStateContaining(state);
		return inState;
	}
	
	//find Event not in State
	public List<Event> findEventsByNotState(String state) {
		List<Event> notInState = this.eRepo.findByStateNot(state);
		return notInState;
	}
	
	//find Host Id
	public Long findHostId(Long eventId) {
		Event thisEvent = this.eRepo.findById(eventId).orElse(null);
		User thisHost = thisEvent.getHost();
		return thisHost.getId();
	}
	
}
