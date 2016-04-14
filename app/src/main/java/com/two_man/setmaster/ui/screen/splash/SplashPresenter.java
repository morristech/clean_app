package com.two_man.setmaster.ui.screen.splash;

import com.two_man.setmaster.interactor.InitializeAppInteractor;
import com.two_man.setmaster.ui.base.BasePresenter;
import com.two_man.setmaster.ui.base.activity.PerActivity;
import com.two_man.setmaster.ui.navigation.Navigator;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;

/**
 * presenter экрана сплеша
 */
@PerActivity
public class SplashPresenter extends BasePresenter<SplashActivity> {

    private InitializeAppInteractor initializeAppInteractor;
    private Navigator navigator;

    @Inject
    public SplashPresenter(InitializeAppInteractor initializeAppInteractor, Navigator navigator) {
        this.initializeAppInteractor = initializeAppInteractor;
        this.navigator = navigator;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        Observable.zip(
                initializeAppInteractor.initialize(),
                Observable.timer(500, TimeUnit.MILLISECONDS),
                (o1, o2)->null)
                .subscribe(this::onInitialized);
    }

    private void onInitialized(Object o) {
        navigator.openMain();
    }
}