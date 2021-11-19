package com.alex.ppmtool.repositories;

import com.alex.ppmtool.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User getById(Long id);

    //what is Optional? could use this instead of getById
    //Optional<User> findById(Long id);

}
