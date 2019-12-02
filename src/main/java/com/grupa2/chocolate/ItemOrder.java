package com.grupa2.chocolate;

import com.grupa2.AbstractModel;
import com.grupa2.cart.CartModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ItemOrder extends AbstractModel<Long> {

    @Column
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    private ChocolateModel chocolateModel;

    @ManyToOne(cascade = CascadeType.ALL)
    private CartModel cartModel;
}
