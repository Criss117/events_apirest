/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.events.services;

import co.edu.unicauca.events.dao.EventRepository;
import co.edu.unicauca.events.domain.Event;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author FABIAN G
 */
@Component
public class EventService implements IEventService {
  @Autowired
  EventRepository eventDao;

  @Override
  @Transactional
  public List<Event> findAll() {
    return (List<Event>) eventDao.findAll();
  }

  @Override
  @Transactional
  public Event findById(Long id) {
    Event e = eventDao.findById(id).orElse(null);
    return e;
  }

  @Override
  @Transactional
  public Event create(Event event) {
    return eventDao.save(event);
  }

  @Override
  @Transactional
  public Event update(Long id, Event event) {
    Event e = findById(id);
    e.setName(event.getName());
    return eventDao.save(e);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    eventDao.deleteById(id);
  }
}
