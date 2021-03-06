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
package com.agna.setmaster.interactor.condition.simple;

import com.agna.setmaster.domain.condition.Condition;

import rx.Observable;

/**
 * Responsible for checking condition
 */
public interface SimpleConditionChecker<C extends Condition> {

    void unregister(ConditionWrapper<C> condition);

    void register(ConditionWrapper<C> condition);

    Observable<ConditionStateChangedEvent> observeConditionStateChanged();
}
