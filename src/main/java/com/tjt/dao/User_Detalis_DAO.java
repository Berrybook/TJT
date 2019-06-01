package com.tjt.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.City_Table;
import com.tjt.entity.POS_Table;
import com.tjt.entity.Role_Table;
import com.tjt.entity.User_Details_Table;

public interface User_Detalis_DAO extends JpaRepository<User_Details_Table, String> {
	@Query("select p.role from User_Details_Table p where p.userid=:userid and p.password=:password")
	public List<Role_Table>  login(@Param("userid") String userid, 
			  @Param("password") String password);
	
	@Query("SELECT s.userid,s.userName  from User_Details_Table s where s.pos_table=:pos_table AND s.userid NOT IN (:admin) ")
	public List<Object[]> allSalesmanid(@Param("pos_table") POS_Table pos_table,@Param("admin")String  admin);
	
	@Query("SELECT udt.mailid from User_Details_Table udt where udt.userid=:userid")
	public String userMailById(@Param("userid") String userid);
	
	@Query("select count(*) from User_Details_Table udt where udt.userid=:userid")
	public Integer checkUser(@Param("userid")String pos);

	@Query("select pt.userid,pt.password,pt.mobilenumber,pt.address,pt.mailid,pt.role,pt.userName,pt.pos_table from User_Details_Table pt where pt.role NOT in (:role)")
	public List<Object[]> allUserList(@Param("role")Role_Table role);
	
	
	@Query("select count(*) from User_Details_Table p where p.userid=:userid and p.password=:password")
	public Integer  userLoginAuthentication(@Param("userid") String userid, 
			  @Param("password") String password);
	
	@Query("select count(*) from User_Role_Mapping p where p.userid=:userid and p.role=:role")
	public Integer  userRoleauthentication(@Param("userid") String userid, 
			  @Param("role") String role);
	
	@Query("select userid from User_Details_Table where role NOT IN (:admin)")
	public List<String> userIdExceptAdmin(@Param("admin")Role_Table admin);
	
	@Query("select userid from User_Details_Table where role=:role")
	public List<String> findUserByRole(@Param("role") Role_Table role);
	

	@Query("select u.userid,u.userName,u.pos_table from User_Details_Table u where u.role='SALESMAN' and u.pos_table IN(select p.pos from POS_Table p  where p.city_table=:cityname)")
	public List<Object[]> allSalesmanByCity(@Param("cityname") City_Table cityname);		
	
	
    @Query("select a.adhocPos,a.startDate,a.endDate from Adhoc_Assignment a inner join User_Details_Table u on u.userid=a.userid")
	public List<Object[]> allSalesmanByCity2();

	@Query("select u.userid,u.userName,u.pos_table from User_Details_Table u where u.userid=:id")
	public List<Object[]> allSalesmanById(@Param("id") String id);
}
