package com.groupmessage.api.controllers.interfaces;

import com.groupmessage.api.controllers.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
