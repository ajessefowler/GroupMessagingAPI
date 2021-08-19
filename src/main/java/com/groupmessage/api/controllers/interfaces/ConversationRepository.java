package com.groupmessage.api.controllers.interfaces;

import com.groupmessage.api.controllers.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
}
