package com.grupa2.chocolate;


import com.grupa2.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChocolateService extends AbstractService<Long,ChocolateModel,ChocolateRepository> {

    private ChocolateRepository chocolateRepository;

    public ChocolateService(ChocolateRepository chocolateRepository) {
        super(chocolateRepository);
    }

    public boolean verifyIfNameExists(String chocolateName) {
        List<ChocolateModel> chocolateModelList = chocolateRepository.findAll();
        for (ChocolateModel chocolateModel : chocolateModelList) {
            if (chocolateModel.getName().equalsIgnoreCase(chocolateName)) {
                return true;
            }
        }
        return false;
    }



}

