package com.examples.soccerevents.di.component;


import android.content.Context;

import com.examples.soccerevents.di.ApplicationContext;
import com.examples.soccerevents.di.PerActivity;
import com.examples.soccerevents.di.module.ActivityModule;
import com.examples.soccerevents.ui.teamdetail.TeamDetailFragment;
import com.examples.soccerevents.ui.teamlist.TeamListActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ApplicationContext
    Context context();

    void inject(TeamListActivity activity);

    void inject(TeamDetailFragment fragment);
}
