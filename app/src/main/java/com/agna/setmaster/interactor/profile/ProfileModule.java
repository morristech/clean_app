/*
 * Copyright 2016 Maxim Tuev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agna.setmaster.interactor.profile;

import com.agna.setmaster.app.dagger.PerApplication;
import com.agna.setmaster.interactor.profile.storage.db.DataBaseHelper;
import com.agna.setmaster.interactor.profile.storage.db.dao.ProfileDao;
import com.agna.setmaster.interactor.profile.storage.db.entity.ProfileObj;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class ProfileModule {

    @Provides
    @PerApplication
    ProfileDao provideProfileDao(DataBaseHelper dataBaseHelper) {
        return dataBaseHelper.safeGetDao(ProfileObj.class);
    }
}
