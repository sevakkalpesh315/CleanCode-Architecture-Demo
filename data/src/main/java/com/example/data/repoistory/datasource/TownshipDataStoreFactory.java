package com.example.data.repoistory.datasource;


import com.example.data.cache.TownshipCache;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by kalpesh on 05/09/2017.
 */


/**
 * Main condition factory which decided where to load the data from
 *
 */
@Singleton
public class TownshipDataStoreFactory {
    private final TownshipCache townshipCache;

    @Inject
    public TownshipDataStoreFactory(TownshipCache townshipCache) {
        this.townshipCache = townshipCache;
    }

    public TownshipDataSource create(){

        if(!townshipCache.isExpired() && townshipCache.isCached()) {
            return new TownshipLocalDataStore(townshipCache);
        }
            else{
                return new TownshipCloudDataStore(townshipCache);
            }
        }
}
