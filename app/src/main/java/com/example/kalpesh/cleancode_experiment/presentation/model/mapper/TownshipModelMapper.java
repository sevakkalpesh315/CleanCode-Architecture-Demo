package com.example.kalpesh.cleancode_experiment.presentation.model.mapper;

import com.example.entity.Township;
import com.example.kalpesh.cleancode_experiment.presentation.di.PerActivity;
import com.example.kalpesh.cleancode_experiment.presentation.model.TownshipModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by kalpesh on 06/09/2017.
 */
@PerActivity
public class TownshipModelMapper {
    
    @Inject
    public TownshipModelMapper() {
    }


    /**
     * Get entity from Domain(parameter) to transform to presentation(return object)
     * @param township
     * @return
     */
    public TownshipModel transform(Township township){
        TownshipModel townshipModel = null;
if(township!=null){
    townshipModel= new TownshipModel(township.getId(), township.getName(), township.getImageUrl());
}
return townshipModel;


        /**
         * Converts to list
         */
    }
    public List<TownshipModel> transformList(List<Township> townships){

        List<TownshipModel> townshipModelList= new ArrayList<>();

        for(Township township: townships){
            if(townships!=null)
            townshipModelList.add(transform(township));
        }
        return townshipModelList;
    }
}
