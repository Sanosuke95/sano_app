package fr.sanosuke.sano_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.sanosuke.sano_app.R;
import fr.sanosuke.sano_app.model.GridModel;

public class GridAdapter extends ArrayAdapter<GridModel> {
    View listItemView;
    TextView textCard;
    ImageView imageCard;

    public GridAdapter(@NonNull Context context, List<GridModel> gridModelArrayList) {
        super(context, 0, gridModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        GridModel gridModel = getItem(position);
        textCard = listItemView.findViewById(R.id.card_title);
        imageCard = listItemView.findViewById(R.id.card_image);

        assert gridModel != null;
        textCard.setText(gridModel.getText());
        imageCard.setImageResource(gridModel.getImage());
        return listItemView;
    }
}
