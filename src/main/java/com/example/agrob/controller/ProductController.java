package com.example.agrob.controller;

import com.example.agrob.model.MainUser;
import com.example.agrob.model.Product;
import com.example.agrob.service.MainUserService;
import com.example.agrob.service.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")


public class ProductController {
    private final ProductService productService;
    private final MainUserService userService;

    public ProductController(ProductService productService, MainUserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public String allProductsPage(Model model) {
        List<Product> products = this.productService.findAll();
        model.addAttribute("products", products);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MainUser currentUser = (MainUser) auth.getPrincipal();
//        MainUser currentUser =
//            this.userService.findUserByName(principal.getName()).orElseThrow(() -> new RuntimeException());
        System.out.println("USER INFO: " + currentUser.getId());
        model.addAttribute("user", currentUser);

        model.addAttribute("bodyContent","product-page");
        return "master-page";
    }

    @GetMapping("/farmer")
    public String allFarmerProducts(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MainUser currentUser = (MainUser) auth.getPrincipal();

        List<Product> products = this.productService.findAllByOwnerId(currentUser.getId());
        model.addAttribute("products", products);
//        MainUser currentUser =
//            this.userService.findUserByName(principal.getName()).orElseThrow(() -> new RuntimeException());
        System.out.println("USER INFO: " + currentUser.getId());
        model.addAttribute("user", currentUser);

        model.addAttribute("bodyContent","farmer-product-page");
        return "master-page";
    }

    @GetMapping("/product/{id}")
    public String productView (Model model,@PathVariable Long id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MainUser currentUser = (MainUser) auth.getPrincipal();
        Product p=productService.findById(id).orElse(null);

        MainUser owner=userService.findById(p.getOwnerId()).orElse(null);

        model.addAttribute("owner",owner);
        model.addAttribute("user",currentUser);
        model.addAttribute("product",p);

        model.addAttribute("bodyContent","view-product");
        return "master-page";

    }




    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String addProduct(@PathVariable Long id, Model model) {
        MainUser currentUser = (MainUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", currentUser);
        Product product = this.productService.findById(id).get();
        model.addAttribute("product", product);
        return "add-product-page";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        MainUser currentUser = (MainUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", currentUser);
        if (this.productService.findById(id).isPresent()) {
            Product product = this.productService.findById(id).get();
            model.addAttribute("product", product);
            model.addAttribute("bodyContent","add-page");
            return "master-page";


        }
        model.addAttribute("bodyContent","error-page");
        return "master-page";

    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        MainUser currentUser = (MainUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", currentUser);
        model.addAttribute("bodyContent", "add-product");
        model.addAttribute("bodyContent","add-page");
        return "master-page";
    }

    @PostMapping("/add")
    public String saveProduct(@RequestParam(required = false) Long id, @RequestParam String name,
                              @RequestParam Double price, @RequestParam Integer quantity,@RequestParam String img,
                              @RequestParam String description) {
        MainUser user = (MainUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (id != null) {
            Product p= new Product();
            p.setId(id);
            p.setName(name);
            p.setPrice(price);
            p.setQuantity(quantity);
            p.setImg(img);
            p.setDescription(description);
            p.setOwnerId(user.getId());
            this.productService.edit(p);
        } else {
            Product p= new Product();
            p.setName(name);
            p.setPrice(price);
            p.setQuantity(quantity);
            p.setImg(img);
            p.setDescription(description);
            p.setOwnerId(user.getId());
            this.productService.add(p);
        }
        return "redirect:/products";
    }

}
