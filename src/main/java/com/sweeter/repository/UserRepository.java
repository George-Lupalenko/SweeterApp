package com.sweeter.repository;

import com.sweeter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    User findByUsername(String useranme);

    User findByActivationCode(String code);

}