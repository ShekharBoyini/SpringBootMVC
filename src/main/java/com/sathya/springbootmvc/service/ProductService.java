package com.sathya.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.ProductModel;
import com.sathya.springbootmvc.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public void saveproductDetails(ProductModel productModel)
	{
		double stockValue;
		stockValue=productModel.getPrice()*productModel.getQuantity();
		
		double discountprice;
		discountprice=productModel.getPrice()*productModel.getDiscountRate()/100;
		
		double offerprice;
		offerprice=productModel.getPrice()- discountprice;
		
		double taxprice;
		taxprice=productModel.getDiscountRate()*18/100;
		
		double finalprice;
		finalprice=offerprice+taxprice;
		
		ProductEntity productEntity=new ProductEntity();
		
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadeIn(productModel.getMadeIn());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountRate(productModel.getDiscountRate());
		productEntity.setDicountPrice(discountprice);
		productEntity.setTaxprice(taxprice);
		productEntity.setOfferPrice(offerprice);
		productEntity.setFinalPrice(finalprice);
		productEntity.setStockValue(stockValue);
		
		productRepository.save(productEntity);
		
}
	public List<ProductEntity> getAllProducts()  {
		
		List<ProductEntity>products=productRepository.findAll();
		return products;
	}
	
	
	public ProductEntity searchById(Long id) {
		Optional<ProductEntity>optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else
		{
			return null;
		}
		
	}
	
	public void deletetById(Long id) {
		
		productRepository.deleteById(id);
		
	}
	
	
	
}
