package com.examples.soccerevents.ui.teamdetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.examples.soccerevents.R;
import com.examples.soccerevents.data.database.model.TeamEvent;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamEventAdapter extends RecyclerView.Adapter<TeamEventAdapter.TeamListHolder> {

    private List<TeamEvent> events;

    public TeamEventAdapter(List<TeamEvent> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public TeamListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_team_detail_event, parent, false);
        return new TeamListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamListHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void addItems(List<TeamEvent> events) {
        this.events.addAll(events);
        notifyDataSetChanged();
    }

    class TeamListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_card_team_detail_name)
        TextView txtName;
        @BindView(R.id.txt_card_team_detail_date)
        TextView txtDate;

        public TeamListHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(int position) {
            final TeamEvent event = events.get(position);

            if (event.getName() != null) {
                txtName.setText(event.getName());
            }

            if (event.getDate() != null) {
                txtDate.setText(event.getDate());
            }

        }
    }
}
