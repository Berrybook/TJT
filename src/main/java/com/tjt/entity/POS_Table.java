package com.tjt.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="pos_table")
public class POS_Table {
		
		
		@Id
		@Column(name="pos" )
		@OnDelete(action = OnDeleteAction.CASCADE)
		private String pos;
		@Column(name="password" )
		private String password;
		
		@Column(name="address1" )
		private String  address1;
		
		@Column(name="address2" )
		private String  address2;
		
		@Column(name="pincode" )
		private String  pincode;
		
		@ManyToOne
		@JoinColumn(name="cityname" ,nullable=false)
		@OnDelete(action = OnDeleteAction.CASCADE)
		private City_Table city_table;
		@Column(name="gst_No" ,nullable=false)
		private String gstNo;
		@Column(name="gst_Address" ,nullable=false)
		private String gstAddress;
		
		
		
		
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		
		
		public String getPos() {
			return pos;
		}
		public void setPos(String pos) {
			this.pos = pos;
		}
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public City_Table getCity_table() {
			return city_table;
		}
		public void setCity_table(City_Table city_table) {
			this.city_table = city_table;
		}
		public String getGstNo() {
			return gstNo;
		}
		public void setGstNo(String gstNo) {
			this.gstNo = gstNo;
		}
		public String getGstAddress() {
			return gstAddress;
		}
		public void setGstAddress(String gstAddress) {
			this.gstAddress = gstAddress;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		
}
