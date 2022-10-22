package com.example.luu_giu_hom_thu_dientu.service;

import com.example.luu_giu_hom_thu_dientu.model.DeclarationMedical;

public class DeclarationMedicalService implements IDeclarationMedicalService{
    private static DeclarationMedical declarationMedical;

    static {
        declarationMedical=new DeclarationMedical();
    }

    @Override
    public void save(DeclarationMedical declarationMedical) {

    }
}
