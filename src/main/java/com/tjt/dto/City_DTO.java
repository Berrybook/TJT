package com.tjt.dto;

import java.io.Serializable;



public class City_DTO implements Serializable{
	
	  /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
		private String cityname;
		private String gstno;
		private String gstaddres;
		private String descrption;
		private String state;
		public String getCityname() {
			return cityname;
		}
		public void setCityname(String cityname) {
			this.cityname = cityname;
		}
		public String getGstno() {
			return gstno;
		}
		public void setGstno(String gstno) {
			this.gstno = gstno;
		}
		public String getGstaddres() {
			return gstaddres;
		}
		public void setGstaddres(String gstaddres) {
			this.gstaddres = gstaddres;
		}
		public String getDescrption() {
			return descrption;
		}
		public void setDescrption(String descrption) {
			this.descrption = descrption;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}

}
