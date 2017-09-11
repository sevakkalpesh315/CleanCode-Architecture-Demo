package com.example.data.repoistory.datasource;


import com.example.data.cache.TownshipCache;
import com.example.data.entity.TownshipEntity;
import com.example.data.net.ServiceGenerator;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by kalpesh on 05/09/2017.
 */


/**
 * Gets the data from Retrofit (API) request and stores in Realm database
 */
public class TownshipCloudDataStore implements TownshipDataSource {
TownshipCache townshipCache;

    public TownshipCloudDataStore(TownshipCache townshipCache) {
        this.townshipCache = townshipCache;
    }

    @Override
    public Observable<List<TownshipEntity>> townships() {
        return ServiceGenerator.getTownshipService().getTownships().doOnNext(new Consumer<List<TownshipEntity>>() {
            @Override
            public void accept(List<TownshipEntity> townshipEntities) throws Exception {
                townshipCache.put(townshipEntities);
            }
        });
    }
}
