package com.sweeter.repository;

import com.sweeter.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Page<Message> findAll(Pageable pageable);

    Page<Message> findByTag(String tag, Pageable pageable);

}
