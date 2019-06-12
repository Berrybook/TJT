package com.tjt.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Invoice;
import com.tjt.entity.POS_Table;

public interface ReportDAO extends JpaRepository<Invoice, Long> {
	
	
	@Query("select i.saledate,it.tyrepattern,it.tyresize,i.payment_mode,sum(i.total_price),count(*) from Invoice i INNER JOIN Invoice_Items it ON i.invoice_Number=it.invoice_Number WHERE i.saledate BETWEEN :saledate AND :saledateto AND i.userId IN (select p.userid from User_Details_Table p where p.pos_table = :pos_table ) GROUP BY i.saledate,it.tyrepattern,it.tyresize,i.payment_mode")
	public List<Object[]> getSalesDetailsByDate(@Param("saledate") Date saledate,@Param("saledateto") Date saledateto,@Param("pos_table") POS_Table pos_table);
	
	@Query("select pi.pos,pi.tyrepattern,pi.tyresize,pi.quantity from POS_Item pi")
	public List<Object[]> getStockdetails();
    
	@Query("select i.userId,i.saledate,sum(i.total_price),count(*) from Invoice i INNER JOIN Invoice_Items it ON i.invoice_Number=it.invoice_Number WHERE i.saledate BETWEEN :saledate AND :saledateto AND i.userId IN (select p.userid from User_Details_Table p where p.pos_table = :pos_table ) GROUP BY i.userId,i.saledate")
	public List<Object[]> getSalesDetailsByMonth(@Param("saledate") Date saledate,@Param("saledateto") Date saledateto,@Param("pos_table") POS_Table pos_table);
	
	
}
