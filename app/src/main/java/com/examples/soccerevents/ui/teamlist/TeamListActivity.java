package com.examples.soccerevents.ui.teamlist;


import android.os.Bundle;

import com.examples.soccerevents.R;
import com.examples.soccerevents.data.database.model.Team;
import com.examples.soccerevents.ui.base.BaseActivity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamListActivity extends BaseActivity implements TeamListMvpView, TeamListAdapter.OnItemClickListener {

    @Inject
    TeamListMvpPresenter<TeamListMvpView, TeamListMvpInteractor> presenter;

    @BindView(R.id.rcv_team_list)
    RecyclerView rcvTeamList;

    private TeamListAdapter adapter = new TeamListAdapter(new ArrayList<>(), this);

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        presenter.onAttach(TeamListActivity.this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.item_detail_container) != null) {
            mTwoPane = true;
        }
        setUp();
    }

    @Override
    protected void setUp() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rcvTeamList.setLayoutManager(layoutManager);
        rcvTeamList.setHasFixedSize(true);
        rcvTeamList.setAdapter(adapter);

        presenter.onViewPrepared("Spanish_la_liga");
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onItemClick(String teamId) {
        Logger.e("teamId: " + teamId);
    }

    @Override
    public void updateTeams(List<Team> teams) {
        adapter.addItems(teams);
    }
}