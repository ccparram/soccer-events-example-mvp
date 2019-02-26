package com.examples.soccerevents.ui.teamlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.examples.soccerevents.R;
import com.examples.soccerevents.data.database.model.Team;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamListHolder> {

    private List<Team> teams;
    private OnItemClickListener listener;

    public TeamListAdapter(List<Team> teams, OnItemClickListener listener) {
        this.teams = teams;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TeamListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new TeamListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamListHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public void addItems(List<Team> teams) {
        this.teams.addAll(teams);
        notifyDataSetChanged();
    }

    class TeamListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item_team_badge)
        ImageView imgBadge;
        @BindView(R.id.txt_item_team_name)
        TextView txtName;
        @BindView(R.id.txt_item_team_stadium)
        TextView txtStadium;

        public TeamListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(int position) {
            final Team team = teams.get(position);

            if (team.getBadgeUrl() != null) {
                Glide.with(itemView.getContext())
                        .asBitmap()
                        .load(team.getBadgeUrl())
                        .centerCrop()
                        .into(imgBadge);
            }

            if (team.getName() != null) {
                txtName.setText(team.getName());
            }

            if (team.getName() != null) {
                txtStadium.setText(team.getStadium());
            }

            itemView.setOnClickListener((view) -> {
                listener.onItemClick(team);
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Team team);
    }
}
