package com.grupa2.cart;

import com.grupa2.AbstractModel;
import com.grupa2.chocolate.ChocolateModel;
import com.grupa2.chocolate.ItemOrder;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

public class CartModel extends AbstractModel<Long> {
//
//    @Column
//    private int id;


    @Column
    private String name;

    @OneToMany
    private List<ChocolateModel> chocolate;

    @OneToMany(mappedBy = "id" , cascade = CascadeType.ALL)
    private List<ItemOrder> itemOrders;
}



