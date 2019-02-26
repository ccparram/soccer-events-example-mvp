package com.examples.soccerevents.ui.teamdetail;

import android.os.Bundle;

import com.examples.soccerevents.R;
import com.examples.soccerevents.data.database.model.Team;
import com.examples.soccerevents.ui.base.BaseActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;


public class TeamDetailActivity extends BaseActivity {

    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            Team team = getIntent().getParcelableExtra(TeamDetailFragment.ARG_TEAM);

            TeamDetailFragment fragment = TeamDetailFragment.newInstance(team);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.team_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    protected void setUp() {

    }

}