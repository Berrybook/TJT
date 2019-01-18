package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity @IdClass(TyreCompositeKey.class)
@Table
public class Tyre_Information {
		
	
		@Id
		@Column(name="tyrepattern")
		@OnDelete(action = OnDeleteAction.CASCADE)
		private String tyrepattern;
		
		@Id
		@Column(name="tyresize")
		@OnDelete(action = OnDeleteAction.CASCADE)
		private String tyresize;
		
		@Column(name="price", nullable = false)
		private Double price;
		@Column(name="CGST", nullable = false)
		private String CGST;
		@Column(name="SGST", nullable = false)
		private String SGST;
		@Column(name="IGST", nullable = false)
		private String IGST;


		public String getTyrepattern() {
			return tyrepattern;
		}

		public void setTyrepattern(String tyrepattern) {
			this.tyrepattern = tyrepattern;
		}

		public String getTyresize() {
			return tyresize;
		}

		public void setTyresize(String tyresize) {
			this.tyresize = tyresize;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getCGST() {
			return CGST;
		}

		public void setCGST(String cGST) {
			CGST = cGST;
		}

		public String getSGST() {
			return SGST;
		}

		public void setSGST(String sGST) {
			SGST = sGST;
		}

		public String getIGST() {
			return IGST;
		}

		public void setIGST(String iGST) {
			IGST = iGST;
		}
}
