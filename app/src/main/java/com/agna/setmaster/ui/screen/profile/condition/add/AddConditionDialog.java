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
package com.agna.setmaster.ui.screen.profile.condition.add;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.agna.setmaster.R;
import com.agna.setmaster.domain.condition.Condition;
import com.agna.setmaster.ui.base.dialog.BaseBottomSheetDialog;

import java.util.ArrayList;

/**
 *
 */
public class AddConditionDialog extends BaseBottomSheetDialog {

    public static final String EXTRA_CONDITIONS = "EXTRA_CONDITIONS";
    private BottomSheetBehavior<View> mBottomSheetBehavior;
    private ArrayList<Class<? extends Condition>> conditions;
    private AddConditionListAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void onConditionChosen(Class<? extends Condition> conditionType) {
        getListener(AddConditionDialogListener.class).onAddCondition(conditionType);
        dismiss();
    }

    private void initViews(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.condition_list);
        adapter = new AddConditionListAdapter(recyclerView, this::onConditionChosen);
        adapter.showConditions(conditions);
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        conditions = (ArrayList<Class<? extends Condition>>) getArguments().getSerializable(EXTRA_CONDITIONS);
        View contentView = View.inflate(getContext(), R.layout.add_condition_dialog, null);
        dialog.setContentView(contentView);
        mBottomSheetBehavior = BottomSheetBehavior.from(((View) contentView.getParent()));
        new Handler().postDelayed(() -> mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED), 200);
        initViews(contentView);
    }

    public static AddConditionDialog newInstance(ArrayList<Class<? extends Condition>> supportedConditions) {
        AddConditionDialog dialog = new AddConditionDialog();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CONDITIONS, supportedConditions);
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public String getName() {
        return "AddConditionDialog";
    }

    public interface AddConditionDialogListener {
        void onAddCondition(Class<? extends Condition> conditionType);
    }
}
