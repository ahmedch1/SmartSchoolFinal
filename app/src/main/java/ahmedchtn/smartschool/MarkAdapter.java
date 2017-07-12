package ahmedchtn.smartschool;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ahmed Chouihi on 30-06-2017.
 */

public class MarkAdapter extends ArrayAdapter<MarkItem> {
    public MarkAdapter(Context context, int resource, List<MarkItem> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_mark, parent, false);
        }
        TextView subjectTextView = (TextView) convertView.findViewById(R.id.subjectTextView);
        TextView valueTextView = (TextView) convertView.findViewById(R.id.valueTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);

        MarkItem markItem = getItem(position);

        subjectTextView.setVisibility(View.VISIBLE);
        valueTextView.setVisibility(View.VISIBLE);
        subjectTextView.setText(markItem.getSubject());
        valueTextView.setText(markItem.getValue());
        authorTextView.setText(markItem.getName());
        return convertView;
    }


}


