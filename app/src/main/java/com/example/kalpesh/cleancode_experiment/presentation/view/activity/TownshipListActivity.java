package com.example.kalpesh.cleancode_experiment.presentation.view.activity;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kalpesh.cleancode_experiment.R;
import com.example.kalpesh.cleancode_experiment.presentation.di.HasComponent;
import com.example.kalpesh.cleancode_experiment.presentation.di.components.DaggerUserComponent;
import com.example.kalpesh.cleancode_experiment.presentation.di.components.UserComponent;
import com.example.kalpesh.cleancode_experiment.presentation.model.TownshipModel;
import com.example.kalpesh.cleancode_experiment.presentation.presenter.TownshipListPresenter;
import com.example.kalpesh.cleancode_experiment.presentation.view.TownshipListView;
import com.example.kalpesh.cleancode_experiment.presentation.view.adapter.TownshipAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by kalpesh on 06/09/2017.
 */

public class TownshipListActivity extends BaseActivity implements TownshipListView, HasComponent<UserComponent> {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.activity_township_list)
    RelativeLayout activityTownshipList;
    @BindView(R.id.error)
    TextView error;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private TownshipAdapter townshipAdapter;

    //TODO: Dagger Implementation
    private UserComponent userComponent;

    @Inject TownshipListPresenter townshipListPresenter;

    //from presentation
//    private TownshipListPresenter townshipListPresenter;
//    private TownshipModelMapper townshipModelMapper;
//
//    //from domain
//    private GetTownshipList getTownshipList;
//
//
//    //from data
//    private TownShipDataRepository townshipDataRepository;
//    private TownshipMappers townshipMapper;
//    private TownshipDataStoreFactory townshipDataStoreFactory;
//    private TownshipCache townshipCache;

    private void initializeInjector() {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }
    @Override public UserComponent getComponent() {
        return userComponent;
    }

    @Override
    public void showLoading() {
        recycler.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        recycler.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        recycler.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        error.setVisibility(View.VISIBLE);
        error.setText(errorMessage);
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void renderTownshipList(List<TownshipModel> townshipModels) {
        townshipAdapter.setTownships(townshipModels);

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_township_list;
    }

    @Override
    public void initComponents() {
        this.initializeInjector();
        this.getComponent().inject(this);

        townshipAdapter = new TownshipAdapter();
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        recycler.setAdapter(townshipAdapter);

        //TODO: Dagger Implementation
//        townshipModelMapper = new TownshipModelMapper();
//        townshipMapper = new TownshipMappers();
//
//        townshipCache = new TownshipCacheImpl();
//        townshipDataStoreFactory = new TownshipDataStoreFactory(townshipCache);
//        townshipDataRepository = new TownShipDataRepository(townshipDataStoreFactory,townshipMapper);
//        getTownshipList = new GetTownshipList(townshipDataRepository,);
//        townshipListPresenter = new TownshipListPresenter(getTownshipList,townshipModelMapper);

        townshipListPresenter.setTownshipListView(this);
        townshipListPresenter.initialize();

    }
}
