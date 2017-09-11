package com.example.data.repoistory;


import com.example.abstraction.TownshipAbstraction;
import com.example.data.entity.TownshipEntity;
import com.example.data.entity.mappers.TownshipMappers;
import com.example.data.repoistory.datasource.TownshipDataStoreFactory;
import com.example.entity.Township;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by kalpesh on 05/09/2017.
 */
@Singleton
public class TownShipDataRepository implements TownshipAbstraction {

    private final TownshipDataStoreFactory townshipDataStoreFactory;
    private final TownshipMappers townshipMapper;

    @Inject
    public TownShipDataRepository(TownshipDataStoreFactory townshipDataStoreFactory, TownshipMappers townshipMapper) {
        this.townshipDataStoreFactory = townshipDataStoreFactory;
        this.townshipMapper = townshipMapper;
    }

    @Override
    public Observable<List<Township>> townships() {
        return townshipDataStoreFactory.create().townships().map(new Function<List<TownshipEntity>, List<Township>>() {
            @Override
            public List<Township> apply(List<TownshipEntity> townshipEntities) throws Exception {
                return townshipMapper.transformList(townshipEntities);
            }
        });
    }
}
