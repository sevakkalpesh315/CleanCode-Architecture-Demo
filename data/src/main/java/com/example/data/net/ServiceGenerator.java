package com.example.data.net;

/**
 * Created by kalpesh on 05/09/2017.
 */


public class ServiceGenerator {
    private static TownshipService townshipService;
    public static TownshipService getTownshipService(){
        if(townshipService==null){
            townshipService = RetrofitHelper.getRetrofit().create(TownshipService.class);
        }
        return townshipService;
    }
}
