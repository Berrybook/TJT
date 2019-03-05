package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Invoice;
import com.tjt.entity.POS_Table;

public interface InvoiceDAO extends JpaRepository<Invoice, Long> {
	
	
	@Query("select ig.invoice_Number,ig.user_Details_Table,ig.saledate,ig.total_price from Invoice ig where ig.user_Details_Table IN (SELECT userid from User_Details_Table st WHERE st.pos_table=:postable)")
	public List<Object[]> getInvoice(@Param("postable")POS_Table postable);
	
	
	@Query("SELECT pt.gstNo,pt.gstAddress FROM POS_Table pt WHERE pt.pos=:pos")
	public List<Object[]> getGstNoAndGstAddress(@Param("pos")String pos);
	
	@Query("SELECT t.tyrepattern FROM POS_Item t where t.pos=:pos GROUP BY (t.tyrepattern)")
	public List<String> allTyrePatternByPos(@Param("pos")String pos_table);
	
	
	@Query("SELECT t.tyresize FROM POS_Item t where t.pos=:pos AND t.tyrepattern=:pattern ")
	public List<String> allTyreSizeByPos(@Param("pos")String pos,@Param("pattern")String  pattern );

	@Query("SELECT ts.salePrice FROM POS_Item ts WHERE ts.pos=:pos AND ts.tyrepattern=:pattern AND ts.tyresize=:size")
	public Double getPriceByPatternAndSize(@Param("pattern")String  pattern,@Param("size")String  size,@Param("pos")String pos);
	
}
