package com.mrtienthinh.exam.service;

import com.mrtienthinh.exam.dto.SellRequest;
import com.mrtienthinh.exam.entity.ProductEntity;
import com.mrtienthinh.exam.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public ProductEntity addProduct(ProductEntity product) {
        ProductEntity productEntity = productRepo.save(product);
        return productEntity;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        ProductEntity productEntity = getProductByID(id);
        productRepo.delete(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity getProductByID(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<ProductEntity> getProductByName(String name) {
        return productRepo.findNameCustom(name);
    }

    @Override
    public Page<ProductEntity> findPaginated(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public void sellProduct(SellRequest request) {
        ProductEntity product = getProductByID(request.getProductId());
        product.sell(request.getQuantity());
        productRepo.save(product);
    }

}

