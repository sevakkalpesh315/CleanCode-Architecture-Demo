package com.example.interactor;


import com.example.abstraction.TownshipAbstraction;
import com.example.entity.Township;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 05/09/2017.
 */

public class GetTownshipList extends UseCase<List<Township>, Void>{

private final TownshipAbstraction townshipAbstraction;

    @Inject
    public GetTownshipList(TownshipAbstraction townshipAbstraction, ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.townshipAbstraction = townshipAbstraction;
    }
    @Override
    Observable<List<Township>> buildUseCaseObservable(Void aVoid) {
        return townshipAbstraction.townships();
    }
}
