package com.grupa2.cart;

import com.grupa2.chocolate.ChocolateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartModel,Long> {

    }
