package com.grupa2.cart;

import com.grupa2.chocolate.ChocolateModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class SimpleCartController {
    private Integer id;
    private CartService cartService;
//    List<ChocolateModel> cartItems = new ArrayList<ChocolateModel>();

    public SimpleCartController(CartService cartService) {
        this.cartService = cartService;
    }

//    public SimpleCartController(Integer id, List<ChocolateModel> cartItems) {
//        this.id = id;
//        this.cartItems = cartItems;
//    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("cartModels", cartService.get());
        return "cart";
    }

    @PostMapping("/add-cart")
    public String addCart(@ModelAttribute("cartModel") CartModel cartModel) {
        cartService.add(cartModel);
        return "redirect:/cart/getAll";
    }


//        public void addChocolateModelToCart(int id) {
//            ChocolateModel chocolateModel = getChocolateModelById(id);
//            addToCart(chocolateModel);
//        }
//        private ChocolateModel getChocolateModelById(int id) {
//            cartService.ge
//            for (ChocolateModel choco: chocolateModels) {
//                if (choco.getid() == id) {
//                    chocolateModel = choco;
//                    break;
//                }
//            }
//            return chocolateModel;
//        }
//        private void addToCart(ChocolateModel chocolateModel) {
//            cartItems.add(chocolateModel);
//        }
//        public void removeChocolateModelByID(int id) {
//            ChocolateModel choco = getChocolateModelByChocolateModelID(id);
//            cartItems.remove(choco);
//        }
//        void printCartItems() {
//            for (ChocolateModel choco: cartItems) {
//                System.out.println(choco.getName());
//            }
//        }
    }

