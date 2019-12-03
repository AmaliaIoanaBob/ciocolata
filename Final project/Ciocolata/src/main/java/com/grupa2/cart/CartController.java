package com.grupa2.cart;

import com.grupa2.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")

public class CartController extends AbstractController<Long,CartModel,CartRepository,CartService> {



        public CartController(CartService service) {
            super(service);
        }
    }


