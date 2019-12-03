package com.grupa2.chocolate;

import com.grupa2.AbstractController;
import com.grupa2.AbstractService;
import com.grupa2.cart.CartModel;
import com.grupa2.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/chocolate")
public class SimpleChocolateController {

    private ChocolateService chocolateService;
    @Autowired
    private CartService cartService;

    public SimpleChocolateController(ChocolateService chocolateService) {
        this.chocolateService = chocolateService;
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("chocolateModels", chocolateService.get());
        return "chocolate";
    }

    @PostMapping("/add-chocolate")
    public String addChocolate(@ModelAttribute("chocolateModel") ChocolateModel chocolateModel) {
        chocolateService.add(chocolateModel);
        return "redirect:/chocolate/getAll";
    }
    @RequestMapping("/add-chocolate")
    public String goToAddChocolate(Model model){
        model.addAttribute("chocolateModel", new ChocolateModel());
        return"add-chocolate";

    }

    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id) {
// fiecare user are acces la un singur cos, noi am hard codat cart-ul la care are acces "user-ul" nostru
        long userCart = 1L;
        Optional<CartModel> cartModel = cartService.get(userCart);
        cartService.addToCart(userCart, chocolateService.get(id).get());
        return "redirect:/chocolate/getAll";
    }

    @RequestMapping("/goToCart")
    public String goToCart(Model model) {
        model.addAttribute("itemOrders",cartService.get(1L).get().getItemOrders());
        return "cart-view";

    }



    @RequestMapping(value ="/delete/{id}")
    public String ChocolateService(@PathVariable Long id) {
          chocolateService.delete(id);
        return "redirect:/chocolate/getAll";
    }
    @PostMapping("/update/{id}")
    public String updateChocolate(@ModelAttribute("chocolateModel") ChocolateModel chocolateModel) {
        chocolateService.update(chocolateModel);
        return "redirect:/chocolate/getAll";
    }

    @RequestMapping(value ="/update/{id}")
    public String  updateChoco (Model model, @PathVariable Long id) {
// TODO:       1. gaseste in baza de date obiectul dupa id
//        chocolateService.update(chocolateModel);
       ChocolateModel chocolateModel = chocolateService.get(id).get();
       model.addAttribute("chocolateModel", chocolateModel);

//        return "redirect:/chocolate/getAll";
        return "edit-chocolate";
    }


}
