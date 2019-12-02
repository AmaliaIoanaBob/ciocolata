package com.grupa2.chocolate;

import com.grupa2.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chocolate")
public class ChocolateController extends AbstractController<Long,ChocolateModel,ChocolateRepository,ChocolateService> {

    @Autowired
    public ChocolateController(ChocolateService chocolateService) {
            super(chocolateService);
    }



}

