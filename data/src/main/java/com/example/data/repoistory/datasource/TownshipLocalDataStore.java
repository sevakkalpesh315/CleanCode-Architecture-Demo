package com.example.data.repoistory.datasource;


import com.example.data.cache.TownshipCache;
import com.example.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 05/09/2017.
 */

/**
 * Get the data from Realm(Cache- expiry 10min from last updated time)
 */
public class TownshipLocalDataStore implements TownshipDataSource {

private final TownshipCache townshipCache;

    public TownshipLocalDataStore(TownshipCache townshipCache) {
        this.townshipCache = townshipCache;
    }

    @Override
    public Observable<List<TownshipEntity>> townships() {
        return townshipCache.get();
    }
}
