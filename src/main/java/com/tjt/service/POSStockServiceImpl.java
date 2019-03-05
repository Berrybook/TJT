package com.tjt.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.POSItemDAO;
import com.tjt.dto.POSItemDTO;
import com.tjt.dto.TyreInformationDTO2;
import com.tjt.entity.POS_Item;
import com.tjt.entity.POS_Table;
import com.tjt.entity.Tyre_Information;

@Service
public class POSStockServiceImpl implements POSStockService {

        @Autowired
         private POSItemDAO positemdao;

        //posItem Assignment Service 
        @Override
        public void posItemAssignment(POSItemDTO dto,String allTyre)throws Exception  {
                Long quantity=0L;
                List<Object[]> obj=null;
                POS_Item positem =null;
                Tyre_Information tyre=null;
                POS_Table postable=null;
                Integer count=0;
                
                //Create POS-Item Object 
                positem = new POS_Item();
                
            //Create POSTable Object And set POS Value  
            postable=new POS_Table();
                postable.setPos(dto.getPos());
                
                
                //Assign  All Tyre in Each POS
                
                if(allTyre!=null){
                
                //Fetch  All Tire for assign the Each POS 
                obj=positemdao.listtyreid();
                
                //Iterative The List Of Tyred And Assign to Each POS 
                        for (Object[] objects : obj) {
                                
                                
                                
                                //set All value in POSItem Object And Store 
                                positem.setTyrepattern((String) objects[0]);
                                positem.setTyresize((String) objects[1]);
                                positem.setQuantity(quantity);
                                positem.setPos(dto.getPos());
                                count=positemdao.checkTyre((String) objects[0],(String) objects[1], dto.getPos());
                                if(count==0){
                                //new tyre row created 
                                positemdao.save(positem);
                                }// end if
                                else{
                                   
                                }//end else
                                
                        }//end for loop
                }//end if 
                
                //Assign Multiple Tyre in Each POS 
                else{
                        String[] item=null;
                        item=dto.getTyrepattern();
                        for(int i=0;i<item.length;i++){
                                // Create Tyre_Information Object 
                            tyre= new Tyre_Information();        
                            
                            //Assign Each item in String item
                            String tyreitem=item[i];
                            
                          //split the String to token and get tyrePattren and tyreSize 
                                String[] tyrearray=tyreitem.split("/");
                                String tyrepattern=tyrearray[0];
                                String tyresize=tyrearray[1];
                                
                                //Set TyrePattern and TyreSize Value In Tyre Object 
                                tyre.setTyrepattern(tyrepattern);
                                tyre.setTyresize(tyresize);
                                
                                //set  value in POSITEM object 
                                positem.setPos(dto.getPos());
                                positem.setTyrepattern(tyrepattern);
                                positem.setTyresize(tyresize);
                                positem.setQuantity(quantity);
                                
                                count=positemdao.checkTyre(tyrepattern,tyresize, dto.getPos());
                                if(count==0){
                                //new tyre row created 
                                positemdao.save(positem);
                                }//end if
                                else{
                                       
                                }//end esle 

                        }//end for loop

                }//end else
                
        }//end posItemAssignment
        
        //posItem Quantity Assignment Service 
        @Override
        public void posItemQuantityAssign(POSItemDTO posItemDTO)throws Exception  {
                POS_Table postable=null;
                POS_Item positem = null;
                String[] pattern=null;
                String[] size=null;
                Long[] quantitylist=null;
                
                Integer count=0;
                Long existingquantity=0l;
                //create pos_table object 
                postable=new POS_Table();
                
                //set POS value in pos_tbale object 
                postable.setPos(posItemDTO.getPos());
                pattern=posItemDTO.getTyrepattern();
                
                
                size=posItemDTO.getTyresize();
                quantitylist=posItemDTO.getQuantity();
                for(int i=0;i<pattern.length;i++){
                	
                				positem = new POS_Item();
                				
                                //check tyre information in database
                                count=positemdao.checkTyre(pattern[i],size[i],posItemDTO.getPos());
                                if(count==0){
                                        //set  value in POSITEM object 
                                       
                                        positem.setPos(posItemDTO.getPos());
                                        positem.setTyrepattern(pattern[i]);
                                        positem.setTyresize(size[i]);
                                        positem.setQuantity(quantitylist[i]);
                                        //new tyre row created 
                                        positemdao.save(positem);
                                       
                                }
                                else{
                                
                                        existingquantity=positemdao.featchQuantity(pattern[i],size[i],posItemDTO.getPos());
        
                                        //adding quantity in existing quantity 
                                        existingquantity=existingquantity+quantitylist[i];
                                     
                
                                        //set  value in POSITEM object 
                                        positem.setPos(posItemDTO.getPos());
                                        positem.setTyrepattern(pattern[i]);
                                        positem.setTyresize(size[i]);
                                        positem.setQuantity(existingquantity);
                                        //update quantity in PosItem
                                            //new tyre row created 
                                            positemdao.save(positem);
                                        	
                              
                        }
                }
        }
        @Override
        public List<TyreInformationDTO2> listtyreid()throws Exception  {
                List<TyreInformationDTO2> listtyreid=null;
                List<Object[]> listtyre=null;
                listtyreid=new ArrayList<TyreInformationDTO2>();
                try {
                listtyre=positemdao.listtyreid();
                for (Object[] objects : listtyre) {
                        TyreInformationDTO2 tyre=new TyreInformationDTO2();
                        tyre.setTyrepattern((String) objects[0]);
                        tyre.setTyresize((String) objects[1]);
                        listtyreid.add(tyre);
                }
                }
                catch(Exception e) {
                        e.printStackTrace();
                }

                return listtyreid;
                
        }
        
        
        
        
        @Override
        public List<String> listpos()throws Exception  {
                List<String> listposid=null;
                
                
                listposid=positemdao.listpos();
        
                return listposid;
        }



        
        /*
        @Override
        public List<TyreInformationDTO2>  listpostyreid() throws Exception {
                
                //find list tyre_id and pattern and size 
                List<TyreInformationDTO2> listtyredto=null;
                List<Object[]> listtyre=null;
                listtyredto=new ArrayList<TyreInformationDTO2>();
                try {
                listtyre=positemdao.listpositem();
                for (Object[] objects : listtyre) {
                        POS_Item positem=new POS_Item();
                        positem.setTyre_id((Tyre_Information) objects[0]);
                        positem.setTyrepattern((String) objects[1]);
                        positem.setTyresize((String) objects[2]);
        
                        Tyre_Information tyre=new Tyre_Information();
                        tyre=positem.getTyre_id();
                        
                        TyreInformationDTO2 tyreitem=new TyreInformationDTO2();
                        tyreitem.setTyreid(tyre.getTyreid());
                        tyreitem.setTyrepattern(positem.getTyrepattern());
                        tyreitem.setTyresize(positem.getTyresize());
                        listtyredto.add(tyreitem);
                
                }
                }
                catch(Exception e) {
                        e.printStackTrace();
                }

                return listtyredto;
        }
        */
        
        /*@Override
        public List<String> listposname(Long tyreid) throws Exception {
                List<String> listposid=null;
                List<POS_Table> listpos=null;
                Tyre_Information tyreinfo=new Tyre_Information();
                tyreinfo.setTyreid(tyreid);
                listposid=new ArrayList<String>();
                
                        listpos=positemdao.listposname(tyreinfo);
                        for (POS_Table postable : listpos) {
                                String pos=null;
                                pos=postable.getPos();
                                listposid.add(pos);
                        }
                
                
                return listposid;
        
        }
        
        
        //UPDATE POS_ITEM QUANTITY
        
        @Override
        public void posUpdate(POSItemDTO dto) throws Exception {
                
                POS_Item positem=null;
                POS_Table postable=null;
                Tyre_Information tyre=null;
                long quantity=0l;
                
                positem=new POS_Item();
                tyre= new Tyre_Information();
                postable=new POS_Table();
                
                //set POSItemDTO pos value in POS_Table 
                postable.setPos(dto.getPos());
                tyre.setTyreid(dto.getTyre_id());
                        quantity =positemdao.featchQuantity(tyre, postable);
                   quantity=quantity+dto.getQuantity();
                   
                Long tyreid = dto.getTyre_id();
                List<Object[]> obj=null;

                        obj=positemdao.fetchTyrePatternSize(tyreid);
                        for (Object[] objects : obj) {
                                tyre.setTyrepattern((String) objects[0]);
                                tyre.setTyresize((String) objects[1]);
        
                
                
                positem.setTyrepattern(tyre.getTyrepattern());
                positem.setTyresize(tyre.getTyresize());
                tyre.setTyreid(dto.getTyre_id());
                positem.setPos_table(postable);
                positem.setTyre_id(tyre);
                positem.setQuantity(quantity);
                
                positemdao.save(positem);
                
        }
                        
                
        }
*/
        
        @Override
        public void posUpdate(POSItemDTO dto) throws Exception {
                // TODO Auto-generated method stub
                
        }


        @Override
        public List<TyreInformationDTO2> listpostyreid() throws Exception {
                // TODO Auto-generated method stub
                return null;
        }


        @Override
        public List<String> listposname(Long tyreid) throws Exception {
                // TODO Auto-generated method stub
                return null;
        }

      
        
        
}
