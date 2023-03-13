package org.vlopezn.visitednationalpark.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.vlopezn.visitednationalpark.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    public Optional<User> findUserByEmail(String email);


    @Query(value = "SELECT user_id, first_name, last_name, email, password FROM user WHERE user_id = :id", nativeQuery = true)
    public User findUserById(@Param("id") Long id);

}
