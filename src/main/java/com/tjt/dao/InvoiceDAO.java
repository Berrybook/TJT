package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Invoice;
import com.tjt.entity.POS_Table;

public interface InvoiceDAO extends JpaRepository<Invoice, Long> {
	
	@Query("SELECT t.tyrepattern FROM Tyre_Information t GROUP BY (t.tyrepattern)")
	public List<Object[]> allTyrePattern();
	@Query("SELECT ts.tyresize FROM Tyre_Information ts WHERE ts.tyrepattern=:tyrepattern ")
	public List<Object[]> allTyreSize(@Param("tyrepattern")String tyrepattern);
	@Query("SELECT ts.price FROM Tyre_Information ts WHERE ts.tyrepattern=:tyrepattern  AND ts.tyresize=:tyresize")
	public Double getTyrePrice(@Param("tyrepattern")String tyrePattern,@Param("tyresize")String tyresize);
	
	
	@Query("select ig.invoice_Number,ig.user_Details_Table,ig.saledate,ig.total_price from Invoice ig where ig.user_Details_Table IN (SELECT userid from User_Details_Table st WHERE st.pos_table=:postable)")
	public List<Object[]> getInvoice(@Param("postable")POS_Table postable);
	
	
	@Query("SELECT pt.gstNo,pt.gstAddress FROM POS_Table pt WHERE pt.pos=:pos")
	public List<Object[]> getGstNoAndGstAddress(@Param("pos")String pos);

}
