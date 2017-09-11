package com.example.kalpesh.cleancode_experiment.presentation.view;


import com.example.kalpesh.cleancode_experiment.presentation.model.TownshipModel;

import java.util.List;

/**
 * Created by kalpesh on 05/09/2017.
 */



public interface TownshipListView extends LoadDataView {
    void renderTownshipList(List<TownshipModel> townshipModels);
}
