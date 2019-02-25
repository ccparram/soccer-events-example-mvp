package com.examples.soccerevents.ui.base;

import com.examples.soccerevents.data.network.ApiHelper;

import javax.inject.Inject;

public class BaseInteractor implements MvpInteractor {

    private final ApiHelper mApiHelper;

    @Inject
    public BaseInteractor(ApiHelper apiHelper) {
        mApiHelper = apiHelper;;
    }

    @Override
    public ApiHelper getApiHelper() {
        return mApiHelper;
    }

}
