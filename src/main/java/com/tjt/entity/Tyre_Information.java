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

		

}
