package com.examples.soccerevents;

import android.app.Application;

import com.examples.soccerevents.di.component.ApplicationComponent;
import com.examples.soccerevents.di.component.DaggerApplicationComponent;
import com.examples.soccerevents.di.module.ApplicationModule;
import com.examples.soccerevents.di.module.NetworkModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class SoccerEventsApp extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(BuildConfig.BASE_URL))
                .build();

        applicationComponent.inject(this);

        setupLogger();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    private void setupLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
}
