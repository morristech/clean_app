package com.two_man.setmaster.app;

import android.content.Context;

import com.two_man.setmaster.entity.condition.Condition;
import com.two_man.setmaster.entity.setting.Setting;
import com.two_man.setmaster.interactor.InitializeAppInteractor;
import com.two_man.setmaster.module.condition.ComplexConditionChecker;
import com.two_man.setmaster.module.condition.simple.SimpleConditionChecker;
import com.two_man.setmaster.module.condition.simple.time.TimeBroadcastReceiver;
import com.two_man.setmaster.module.condition.simple.time.TimeConditionChecker;
import com.two_man.setmaster.module.condition.simple.wifi.WifiConditionChecker;
import com.two_man.setmaster.module.condition.simple.wifi.WifiStatusBroadcastReceiver;
import com.two_man.setmaster.module.profile.ProfileService;
import com.two_man.setmaster.module.setting.SettingManager;
import com.two_man.setmaster.module.setting.applyer.MediaVolumeSettingApplier;
import com.two_man.setmaster.module.setting.applyer.RingSettingApplier;
import com.two_man.setmaster.module.setting.applyer.SettingApplier;

import java.util.ArrayList;
import java.util.Map;

import dagger.Component;

@Component(modules = AppModule.class)
@PerApplication
public interface AppComponent {
    void inject(TimeBroadcastReceiver obj);
    void inject(WifiStatusBroadcastReceiver obj);

    ComplexConditionChecker conditionChecker();
    Map<Class<? extends Condition>, SimpleConditionChecker<?>> simpleConditionCheckers();
    TimeConditionChecker timeConditionChecker();
    WifiConditionChecker wifiConditionChecker();
    ArrayList<Class<? extends Condition>> conditionsTypes();

    Map<Class<? extends Setting>, SettingApplier> settingAppliers();
    RingSettingApplier ringSettingApplier();
    MediaVolumeSettingApplier mediaVolumeSettingApplier();
    ArrayList<Class<? extends Setting>> settingsTypes();
    SettingManager settingManager();

    ProfileService profileService();
    InitializeAppInteractor initializeAppInteractor();
    Context appContext();
}