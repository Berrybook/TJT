package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tjt.entity.Request_Order;
import com.tjt.entity.Role_Table;

@Repository
public interface Request_Order_DAO extends JpaRepository<Request_Order,Long>{
	
	@Query("select i.order_id,i.raised_By from Request_Order i where i.raised_By in(select warehouse_Id from Warehouse_User_Mapping where parent_Id in(select warehouse_Id from Warehouse_User_Mapping where userid=:userId and role=:role and module_id=:module_Id ))")
	public List<Object[]> allRequestOrderByModule_IdAndRoleAndUserId(@Param("module_Id")String module_Id,@Param("role") String role,@Param("userId") String userId);
	
	@Query("select i.pattern,i.size,i.quantity from Order_Item i where i.order_Id=:orderid")
	public List<Object[]> order_ItemByOrderId(@Param("orderid")Long orderId);

	@Query("select i.order_id,i.raised_By,i.requisation_Date,i.priority,i.dealer_id,i.status,i.approver from Request_Order i where i.raised_By=:reasiedBy")
	public List<Object[]> orderByReasedBy(@Param("reasiedBy")String  reasiedBy);
	
	//ViewOrder By Dealer
	@Query("select i.order_id,i.raised_By,i.requisation_Date,i.priority,i.dealer_id,i.status,i.approver from Request_Order i where i.dealer_id=:dealerId and i.status in (:approved,:accept,:reject)")
	public List<Object[]> orderViewByDealer(@Param("dealerId")String  dealerId,@Param("approved")String  approved,@Param("accept")String  accept,@Param("reject")String  reject);
	
	@Query("select u.userid from User_Details_Table u where u.role=:admin")
	public String userByAdmin(@Param("admin")Role_Table admin);
	
	@Modifying
	@Query(value="Update Request_Order set status=:status where order_id=:order_id",nativeQuery=true)
	public void updateRequest_OrderStatus(@Param("order_id")Long order_id,@Param("status")String status);

}
