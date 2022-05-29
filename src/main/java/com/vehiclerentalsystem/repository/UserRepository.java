package com.vehiclerentalsystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vehiclerentalsystem.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("select c from User c where c.email=:useremail and c.password=:password")
	User login(@Param("useremail")String loguserName,@Param("password")String password);

	

}
