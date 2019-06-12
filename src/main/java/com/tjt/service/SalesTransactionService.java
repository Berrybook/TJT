package com.tjt.service;


import java.util.List;

import com.tjt.dto.SalesTransactionDTO;
import com.tjt.dto.UserDTO;

public interface SalesTransactionService {
public String Salestransaction(SalesTransactionDTO sales) throws  Exception;
public List<SalesTransactionDTO> getallSales()throws Exception;
public List<UserDTO> allSalesManId(String pos)throws Exception;
}
