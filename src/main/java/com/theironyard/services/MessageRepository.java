package com.theironyard.services;

import com.theironyard.entities.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ryankielty on 1/21/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
