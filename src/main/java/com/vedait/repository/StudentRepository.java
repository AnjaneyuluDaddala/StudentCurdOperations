
package com.vedait.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.vedait.entity.StudentRegister;

@EnableJpaRepositories
@Repository
public interface StudentRepository extends JpaRepository<StudentRegister, Long>{
	
	StudentRegister findByEmail(String email);
	
	
	Optional<StudentRegister> findOneByEmailAndPassword(String email, String password);
//	
//	 @Query("SELECT s FROM StudentRegister s WHERE s.email = :email AND s.password = :password")
//	Optional<StudentRegister> findByEmailPassword(@Param("email") String email, @Param("password")String password);

}
