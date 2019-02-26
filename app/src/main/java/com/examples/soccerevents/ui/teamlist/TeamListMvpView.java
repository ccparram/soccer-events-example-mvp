package com.examples.soccerevents.ui.teamlist;


import com.examples.soccerevents.data.database.model.Team;
import com.examples.soccerevents.ui.base.MvpView;

import java.util.List;

public interface TeamListMvpView extends MvpView {

    void updateTeams(List<Team>teams);

    void showTeamDetail(Team team);

}
