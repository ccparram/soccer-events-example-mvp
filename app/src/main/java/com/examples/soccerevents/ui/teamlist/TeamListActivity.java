package com.examples.soccerevents.ui.teamlist;


import android.content.Intent;
import android.os.Bundle;

import com.examples.soccerevents.R;
import com.examples.soccerevents.data.database.model.Team;
import com.examples.soccerevents.ui.base.BaseActivity;
import com.examples.soccerevents.ui.teamdetail.TeamDetailActivity;
import com.examples.soccerevents.ui.teamdetail.TeamDetailFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamListActivity extends BaseActivity implements TeamListMvpView, TeamListAdapter.OnItemClickListener {

    private final String LEAGUE_NAME = "Spanish_la_liga";

    @Inject
    TeamListMvpPresenter<TeamListMvpView, TeamListMvpInteractor> presenter;

    @BindView(R.id.rcv_team_list)
    RecyclerView rcvTeamList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private TeamListAdapter adapter = new TeamListAdapter(new ArrayList<>(), this);

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        presenter.onAttach(TeamListActivity.this);

        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.team_detail_container) != null) {
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

        presenter.onViewPrepared(LEAGUE_NAME);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onItemClick(Team team) {
        presenter.onClickItemTeam(team);
    }

    @Override
    public void updateTeams(List<Team> teams) {
        adapter.addItems(teams);
    }

    @Override
    public void showTeamDetail(Team team) {

        if (mTwoPane) {
            TeamDetailFragment fragment = TeamDetailFragment.newInstance(team);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.team_detail_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, TeamDetailActivity.class);
            intent.putExtra(TeamDetailFragment.ARG_TEAM, team);
            startActivity(intent);
        }
    }
}