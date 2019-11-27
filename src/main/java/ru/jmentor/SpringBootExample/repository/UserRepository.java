package ru.jmentor.SpringBootExample.repository;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.Query;import org.springframework.data.repository.query.Param;import org.springframework.stereotype.Repository;import org.springframework.transaction.annotation.Transactional;import ru.jmentor.SpringBootExample.model.User;import java.util.List;@Repository@Transactionalpublic interface UserRepository extends JpaRepository<User, Long> {    @Query("SELECT user FROM User as user JOIN FETCH user.role WHERE user.userName=:userName")    User findByUserName(@Param("userName") String userName);    @Query("SELECT user FROM User as user JOIN FETCH user.role WHERE user.id=:id")    User getById(@Param("id") Long id);    @Query("FROM User as user LEFT JOIN FETCH user.role ORDER BY user.id")    List<User> findAll();    @Query("FROM User WHERE userName=:userName")    User isExistByName(@Param("userName") String userName);}