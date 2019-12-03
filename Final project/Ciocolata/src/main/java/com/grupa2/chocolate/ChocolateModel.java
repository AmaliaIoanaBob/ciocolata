package com.grupa2.chocolate;

import com.grupa2.AbstractModel;
import com.grupa2.cart.CartModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.util.List;

@Entity
@Getter
@Setter
public class ChocolateModel extends AbstractModel<Long> {

//        @Column
//        private int id;
//
        @Column
        private String name;

        @Column
        private Double price;

        @ManyToOne
        private CartModel cartModel;

        @OneToOne
        private ItemOrder itemOrder;

}



