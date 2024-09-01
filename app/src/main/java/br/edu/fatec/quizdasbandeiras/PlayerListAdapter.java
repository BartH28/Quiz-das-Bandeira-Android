package br.edu.fatec.quizdasbandeiras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;



public class PlayerListAdapter extends ArrayAdapter<Player> {
    private Context mContext;

    int mResource;

    public PlayerListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Player> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        int score = getItem(position).getScore();

        Player player = new Player(name, score);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvScore = (TextView) convertView.findViewById(R.id.textView3);

        tvName.setText(name);
        tvScore.setText(Integer.toString(score));

        return convertView;
    }
}
