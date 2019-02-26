package com.examples.soccerevents.ui.teamdetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.examples.soccerevents.R;
import com.examples.soccerevents.data.database.model.Team;
import com.examples.soccerevents.data.database.model.TeamEvent;
import com.examples.soccerevents.di.component.ActivityComponent;
import com.examples.soccerevents.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamDetailFragment extends BaseFragment implements TeamDetailMvpView {

    public static final String TAG = "TeamDetailFragment";
    public static final String ARG_TEAM = "1";

    @BindView(R.id.img_team_detail_badge)
    ImageView imgDetailTeamBadge;

    @BindView(R.id.txt_team_detail_name)
    TextView txtName;

    @BindView(R.id.txt_team_detail_year)
    TextView txtYear;

    @BindView(R.id.txt_team_detail_description)
    TextView txtDescription;

    @BindView(R.id.img_team_detail_jersey)
    ImageView imgJersey;

    @BindView(R.id.rcv_team_detail_events)
    RecyclerView rcvTeamDetail;

    @BindView(R.id.img_team_detail_facebook)
    ImageView imgFacebook;

    @BindView(R.id.img_team_detail_twitter)
    ImageView imgTwitter;

    @BindView(R.id.img_team_detail_instagram)
    ImageView imgInstagram;

    @BindView(R.id.txt_team_detail_next_events_label)
    TextView txtNextEventsLabel;

    @BindView(R.id.txt_team_detail_website)
    TextView txtWebsite;

    private Team team;
    private TeamEventAdapter adapter = new TeamEventAdapter(new ArrayList<>());

    @Inject
    TeamDetailMvpPresenter<TeamDetailMvpView, TeamDetailMvpInteractor> presenter;

    public static TeamDetailFragment newInstance(Team team) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_TEAM, team);
        TeamDetailFragment fragment = new TeamDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_TEAM)) {
            team = getArguments().getParcelable(ARG_TEAM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_detail, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            presenter.onAttach(this);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        presenter.onDetach();
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        rcvTeamDetail.setLayoutManager(layoutManager);
        rcvTeamDetail.setHasFixedSize(true);
        rcvTeamDetail.setAdapter(adapter);

        presenter.onViewPrepared(team.getId());
    }


    @Override
    public void showTeamDetail(List<TeamEvent> events) {

        Glide.with(getContext())
                .asBitmap()
                .load(team.getBadgeUrl())
                .centerCrop()
                .into(imgDetailTeamBadge);

        Glide.with(getContext())
                .asBitmap()
                .load(team.getJersey())
                .centerCrop()
                .into(imgJersey);

        txtName.setText(team.getName());
        txtYear.setText(team.getFoundationYear());
        txtDescription.setText(team.getDescription());
        txtNextEventsLabel.setVisibility(View.VISIBLE);

        showSocialNewtworkIconsAndWebsiteLink();
        adapter.addItems(events);
    }

    private void showSocialNewtworkIconsAndWebsiteLink() {
        if (!team.getFacebook().isEmpty()) imgFacebook.setVisibility(View.VISIBLE);
        if (!team.getTwitter().isEmpty()) imgTwitter.setVisibility(View.VISIBLE);
        if (!team.getInstagram().isEmpty()) imgInstagram.setVisibility(View.VISIBLE);
        if (!team.getWebsite().isEmpty()) txtWebsite.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.img_team_detail_facebook, R.id.img_team_detail_twitter, R.id.img_team_detail_instagram, R.id.txt_team_detail_website})
    public void onViewClicked(View view) {

        String url = "";
        switch (view.getId()) {
            case R.id.img_team_detail_facebook:
                url = team.getFacebook();
                break;
            case R.id.img_team_detail_twitter:
                url = team.getTwitter();
                break;
            case R.id.img_team_detail_instagram:
                url = team.getInstagram();
                break;
            case R.id.txt_team_detail_website:
                url = team.getWebsite();
                break;
        }
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}
