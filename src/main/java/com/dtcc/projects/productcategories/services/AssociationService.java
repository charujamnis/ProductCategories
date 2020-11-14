package com.dtcc.projects.productcategories.services;

import com.dtcc.projects.productcategories.models.Association;
import com.dtcc.projects.productcategories.repositories.AssociationRepository;
import com.dtcc.projects.productcategories.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationService {

    private AssociationRepository associationRepository;

    @Autowired
    public AssociationService(AssociationRepository associationRepository){
        this.associationRepository=associationRepository;
    }

    public Association save(Association association){
        return (Association) associationRepository.save(association);
    }
}
