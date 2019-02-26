package com.examples.soccerevents.ui.teamdetail;


import com.examples.soccerevents.data.database.model.TeamEvent;
import com.examples.soccerevents.ui.base.MvpView;

import java.util.List;

public interface TeamDetailMvpView extends MvpView {

    void showTeamDetail(List<TeamEvent> events);

}