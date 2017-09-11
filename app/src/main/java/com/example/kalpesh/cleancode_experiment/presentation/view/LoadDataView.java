package com.example.kalpesh.cleancode_experiment.presentation.view;

import android.content.Context;

/**
 * Created by kalpesh on 05/09/2017.
 */


public interface LoadDataView {
    void showLoading();
    void hideLoading();
    void showError(String errorMessage);
    Context context();
}
