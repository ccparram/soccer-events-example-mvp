package com.examples.soccerevents;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class SoccerEventsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupLogger();
    }

    private void setupLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
}
