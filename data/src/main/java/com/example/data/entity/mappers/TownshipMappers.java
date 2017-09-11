package com.example.data.entity.mappers;

/**
 * Created by kalpesh on 05/09/2017.
 */


import com.example.data.entity.TownshipEntity;
import com.example.entity.Township;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Data layer- Step 2
 *
 * This will transform the data entity to domain entity
 * 2.1 Create a function to return class-name entity defined in domain layer (parameters from data layer entity classname)
 */
@Singleton
public class TownshipMappers {
    @Inject
    public TownshipMappers() {}

    /**
     * Gives data to domain layer guys which will give data to presentation layer dudes
     * @param townshipEntity: Data layer
     * @return
     */

    /**
     * Get entity from Data(parameter) to transform to Domain(return object)
     * @param townshipEntity
     * @return
     */
    public Township transform(TownshipEntity townshipEntity){
        Township township=null;
        if(townshipEntity!=null) {
            township = new Township(townshipEntity.getId(), townshipEntity.getName(), townshipEntity.getImageUrl());
        }
        return township;
    }

    /**
     * Creates list
     * @param townshipEntities
     * @return
     */
    public List<Township> transformList(List<TownshipEntity> townshipEntities){

        List<Township> townships= new ArrayList<>();
        for(TownshipEntity townshipEntity: townshipEntities){
            if(townshipEntity!=null){
                townships.add(transform(townshipEntity));
            }
        }
        return townships;
    }

}
