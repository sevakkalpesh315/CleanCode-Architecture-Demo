package com.example.data.net;


import com.example.data.entity.TownshipEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by kalpesh on 05/09/2017.
 */


public interface TownshipService {
    @GET("bins/yy0wl")
    Observable<List<TownshipEntity>> getTownships();
}
