package com.grupa2.events;

import com.grupa2.AbstractModel;

import javax.persistence.Column;

public class EventModel extends AbstractModel <Long> {

    @Column
    private String name;
}
