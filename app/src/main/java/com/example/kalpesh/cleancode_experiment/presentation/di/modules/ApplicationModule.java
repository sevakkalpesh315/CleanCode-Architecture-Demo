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
package com.example.kalpesh.cleancode_experiment.presentation.di.modules;

import android.content.Context;

import com.example.abstraction.TownshipAbstraction;
import com.example.data.cache.TownshipCache;
import com.example.data.cache.TownshipCacheImpl;
import com.example.data.executor.JobExecutor;
import com.example.data.repoistory.TownShipDataRepository;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.kalpesh.cleancode_experiment.CleanCode_DemoApp;
import com.example.kalpesh.cleancode_experiment.presentation.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final CleanCode_DemoApp application;

  public ApplicationModule(CleanCode_DemoApp application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
    return this.application;
  }

  @Provides
  @Singleton
  ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides
  @Singleton
  PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton
  TownshipCache provideUserCache(TownshipCacheImpl userCache) {
    return userCache;
  }

  @Provides
  @Singleton
  TownshipAbstraction provideUserRepository(TownShipDataRepository userDataRepository) {
    return userDataRepository;
  }
}
