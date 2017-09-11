package com.example.kalpesh.cleancode_experiment.presentation.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.kalpesh.cleancode_experiment.CleanCode_DemoApp;
import com.example.kalpesh.cleancode_experiment.presentation.di.components.ApplicationComponent;
import com.example.kalpesh.cleancode_experiment.presentation.di.modules.ActivityModule;

import butterknife.ButterKnife;

/**
 * Created by kalpesh on 06/09/2017.
 */

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        this.getApplicationComponent().inject(this);
        initComponents();

    }




    public abstract int getContentLayout();

    public abstract void initComponents();

    /**
     * Get the Main Application component for dependency injection.
     *
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((CleanCode_DemoApp) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}

