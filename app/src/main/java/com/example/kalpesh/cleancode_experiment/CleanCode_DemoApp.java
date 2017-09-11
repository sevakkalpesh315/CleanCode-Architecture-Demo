package com.example.kalpesh.cleancode_experiment;

import android.app.Application;

import com.example.kalpesh.cleancode_experiment.presentation.di.components.ApplicationComponent;
import com.example.kalpesh.cleancode_experiment.presentation.di.components.DaggerApplicationComponent;
import com.example.kalpesh.cleancode_experiment.presentation.di.modules.ApplicationModule;

import io.realm.Realm;

public class CleanCode_DemoApp extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        Realm.init(this);

    }
    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
