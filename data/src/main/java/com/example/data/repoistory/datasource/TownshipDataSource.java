package com.example.data.repoistory.datasource;


import com.example.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 05/09/2017.
 */

/**
 *  * Data layer- Step 3
 *
 *  Create a datastore interface similar to domain level usecase which is to be used with
 */
public interface TownshipDataSource {
    Observable<List<TownshipEntity>> townships();
}
