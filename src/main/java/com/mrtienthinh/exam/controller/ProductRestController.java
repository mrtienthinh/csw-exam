package com.mrtienthinh.exam.controller;

import com.mrtienthinh.exam.dto.SellRequest;
import com.mrtienthinh.exam.entity.ProductEntity;
import com.mrtienthinh.exam.model.BaseResponse;
import com.mrtienthinh.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    ProductService productService;


    @GetMapping("/page")
    public Page<ProductEntity> viewIndexPage(@RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<ProductEntity> productEntities = productService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        return productEntities;
    }

    @GetMapping
    public List<ProductEntity> getAll() {
        List<ProductEntity> productEntities = productService.getAllProduct();
        return productEntities;
    }

    @GetMapping("/{id}")
    public ProductEntity getById(Model model, @PathVariable int id) {
        return productService.getProductByID(id);
    }

    @PostMapping
    public String addProduct(@RequestBody ProductEntity product) {
        if (product.getId() > 0) {
            productService.updateProduct(product);
        } else {
            productService.addProduct(product);
        }
        return "redirect:/product";
    }

    @PostMapping("/sell")
    public ResponseEntity sellProduct(@RequestBody SellRequest product) {
        productService.sellProduct(product);
        BaseResponse res = new BaseResponse();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
}

