/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.kalpesh.cleancode_experiment.presentation.di.components;


import com.example.kalpesh.cleancode_experiment.presentation.di.PerActivity;
import com.example.kalpesh.cleancode_experiment.presentation.di.modules.ActivityModule;
import com.example.kalpesh.cleancode_experiment.presentation.di.modules.UserModule;
import com.example.kalpesh.cleancode_experiment.presentation.view.activity.TownshipListActivity;

import dagger.Component;

/**
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
//  void inject(UserListFragment userListFragment);
//  void inject(UserDetailsFragment userDetailsFragment);

  void inject(TownshipListActivity townshipListActivity);
}
