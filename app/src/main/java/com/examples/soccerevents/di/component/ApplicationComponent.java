package com.examples.soccerevents.di.component;

import android.app.Application;
import android.content.Context;

import com.examples.soccerevents.SoccerEventsApp;
import com.examples.soccerevents.data.network.ApiHelper;
import com.examples.soccerevents.di.ApplicationContext;
import com.examples.soccerevents.di.module.ApplicationModule;
import com.examples.soccerevents.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(SoccerEventsApp app);

    @ApplicationContext
    Context context();

    Application application();

    ApiHelper apiHelper();
}