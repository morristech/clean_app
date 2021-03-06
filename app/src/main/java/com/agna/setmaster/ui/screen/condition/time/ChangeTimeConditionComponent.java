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
package com.agna.setmaster.ui.screen.condition.time;

import com.agna.setmaster.app.dagger.AppComponent;
import com.agna.setmaster.ui.base.PerScreen;
import com.agna.setmaster.ui.base.activity.ActivityModule;
import com.agna.setmaster.ui.base.dialog.module.ActivityDialogModule;

import dagger.Component;

/**
 *
 */
@Component(dependencies = AppComponent.class, modules = {
        ActivityModule.class,
        ActivityDialogModule.class,
        TimeConditionModule.class})
@PerScreen
public interface ChangeTimeConditionComponent {
    void inject(ChangeTimeConditionActivity activity);
}
