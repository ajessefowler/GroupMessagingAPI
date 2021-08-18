package com.groupmessage.api.auth.interfaces;

import com.groupmessage.api.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
