package com.grupa2;


import com.grupa2.chocolate.ChocolateModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@MappedSuperclass
@Getter
@Setter

    public abstract class AbstractModel<ID_TYPE> {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private ID_TYPE id;

        @Column(nullable=false, updatable = false,
                insertable = false,
                columnDefinition =
                        "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private Timestamp created;
}


