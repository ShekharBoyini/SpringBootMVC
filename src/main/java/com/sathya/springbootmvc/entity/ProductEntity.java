package com.sathya.springbootmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="Product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private int quantity;
	private double discountRate;
	private double taxprice;
	private double dicountPrice;
	private double offerPrice;
	private double finalPrice;
	private double stockValue;
	
	
	
}
