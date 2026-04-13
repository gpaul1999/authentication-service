package com.example.authservice.controller;

import com.example.authservice.dto.ProductResponse;
import com.example.authservice.dto.ProductTypeResponse;
import com.example.authservice.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final DataService dataService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model) {
        List<ProductTypeResponse> productTypes = dataService.getAllProductTypes();
        Map<Long, List<ProductResponse>> productsByType = new LinkedHashMap<>();
        for (ProductTypeResponse pt : productTypes) {
            productsByType.put(pt.getId(), dataService.getProductsByType(pt.getId()));
        }
        model.addAttribute("productTypes", productTypes);
        model.addAttribute("productsByType", productsByType);
        return "services";
    }

    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        DataService.ProductPageData data = dataService.getProductPageData(id);
        model.addAttribute("product", data.product());
        model.addAttribute("detail", data.detail());
        return "product-detail";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
}
