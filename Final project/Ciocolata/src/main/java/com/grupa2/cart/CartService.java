package com.grupa2.cart;

import com.grupa2.AbstractService;
import com.grupa2.chocolate.ChocolateModel;
import com.grupa2.chocolate.ChocolateRepository;
import com.grupa2.chocolate.ItemOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService extends AbstractService <Long, CartModel,CartRepository>{

    @Autowired
    CartRepository cartRepository;

    public CartService(CartRepository repository) {
        super(repository);
    }

    public void save(CartModel cartModel) {
        cartRepository.saveAndFlush(cartModel);

    }

    public void addToCart(Long id, ChocolateModel chocolateModel) {
        CartModel cartModel = cartRepository.getOne(id);
        List<ItemOrder> itemOrders = cartModel.getItemOrders();

//        itereaza peste ItemOrders si vezi daca exista un ItemORder care contine ciocolata din parametrul functiei
//        daca exista, atunci mareste cantitatea
//        daca nu exista, mareste cantitatea si adauga in lista
        boolean itemOrderExists = false;
        for (ItemOrder itemOrder : itemOrders) {
            if (itemOrder.getChocolateModel().getName().equalsIgnoreCase(chocolateModel.getName())) {
                itemOrder.setQuantity(itemOrder.getQuantity() + 1);
                itemOrderExists = true;
                break;
            }
        }
        if (!itemOrderExists) {
            ItemOrder itemOrder = new ItemOrder();
            itemOrder.setChocolateModel(chocolateModel);
            chocolateModel.setItemOrder(itemOrder);
            itemOrder.setQuantity(1);
            itemOrder.setCartModel(cartModel);
            itemOrders.add(itemOrder);
        }
        cartRepository.saveAndFlush(cartModel);

    }
}
