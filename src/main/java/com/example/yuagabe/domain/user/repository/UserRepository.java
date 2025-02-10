package com.example.yuagabe.domain.user.repository;

import com.example.yuagabe.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByAccountId(String accountId);

}