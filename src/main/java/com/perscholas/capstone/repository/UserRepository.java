package com.perscholas.capstone.repository;
import com.perscholas.capstone.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query( value = "SELECT user_id, first_name, last_name, email, password " +
            " FROM user WHERE email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);


    @Query(value = "SELECT user_id, first_name, last_name, email, password FROM user WHERE user_id = :id", nativeQuery = true)
    User findUserById(@Param("id") Long id);


    //public User findUserByUserName(String name);
}
