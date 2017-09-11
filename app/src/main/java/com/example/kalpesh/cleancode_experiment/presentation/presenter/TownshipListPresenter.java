package com.example.kalpesh.cleancode_experiment.presentation.presenter;

import com.example.entity.Township;
import com.example.interactor.DefaultObserver;
import com.example.interactor.GetTownshipList;
import com.example.kalpesh.cleancode_experiment.presentation.di.PerActivity;
import com.example.kalpesh.cleancode_experiment.presentation.model.TownshipModel;
import com.example.kalpesh.cleancode_experiment.presentation.model.mapper.TownshipModelMapper;
import com.example.kalpesh.cleancode_experiment.presentation.view.TownshipListView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by kalpesh on 06/09/2017.
 */


/**
 * Get the data from Domain layer using the Default Observer
 * Transform the data received from above step above (mapper transformList function)
 */
@PerActivity
public class TownshipListPresenter implements Presenter {

    private TownshipListView townshipListView;

    /**
     * From domain
     */
    private final GetTownshipList getTownshipList;
    private final TownshipModelMapper townshipModelMapper;

    @Inject
    public TownshipListPresenter(GetTownshipList getTownshipList,
                                 TownshipModelMapper townshipModelMapper) {
        this.getTownshipList = getTownshipList;
        this.townshipModelMapper = townshipModelMapper;
    }

    public void setTownshipListView(TownshipListView townshipListView){
        this.townshipListView = townshipListView;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getTownshipList.dispose();
        this.townshipListView=null;
    }

    /**
     * Tasks view should perform
     */
    public void initialize(){
        this.loadTownshipList();
    }

    private void loadTownshipList() {
        this.showViewLoading();
        this.getTownshipList();
    }

    private void showViewLoading() {
        this.townshipListView.showLoading();
    }

    private void hideViewLoading() {
        this.townshipListView.hideLoading();
    }

    private void showErrorMessage(String errorMessage) {
        this.townshipListView.showError(errorMessage);
    }



    /**
     * Other dudes to perform job
     */
//Job 1
    private final class TownshipListObserver extends DefaultObserver<List<Township>>{

        @Override
        public void onNext(List<Township> value) {
            TownshipListPresenter.this.showTownshipListInView(value);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
            TownshipListPresenter.this.hideViewLoading();
            TownshipListPresenter.this.showErrorMessage(e.getLocalizedMessage());
        }

        @Override
        public void onComplete() {
            TownshipListPresenter.this.hideViewLoading();
        }
    }

    private void getTownshipList() {
        this.getTownshipList.execute(new TownshipListObserver(),null);
    }


    //Job2
    /**
     * This is the magical thing to display items after transform function is called
     * @param townships
     */
    private void showTownshipListInView(List<Township> townships) {
        // First transformList
        final List<TownshipModel> townshipModelList =
                this.townshipModelMapper.transformList(townships);

        // Second display the list
        this.townshipListView.renderTownshipList(townshipModelList);
    }

}
