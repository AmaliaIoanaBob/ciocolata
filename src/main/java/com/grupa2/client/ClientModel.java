package com.grupa2.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grupa2.AbstractModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity
@Getter
@Setter

public class ClientModel extends AbstractModel<Long> {


    @Column
    private String name;

    @Column
    @JsonIgnore
    private String email;


    @Transient
    @JsonIgnore
    private String phoneNr;

//   private ClientModel client;
}
