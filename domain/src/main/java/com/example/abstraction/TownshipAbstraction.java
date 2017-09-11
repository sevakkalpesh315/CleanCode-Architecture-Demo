package com.example.abstraction;


import com.example.entity.Township;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 05/09/2017.
 */

public interface TownshipAbstraction {

    Observable<List<Township>> townships();
}
