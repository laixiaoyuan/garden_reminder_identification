package edu.xlaiscu.gardenreminding;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

/**
 * Created by Lexie on 5/22/16.
 */
public class IdentifyOutcomeAdaptor extends CursorAdapter{

    public IdentifyOutcomeAdaptor(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }
//update
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.outcome_namecard_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String plantName = cursor.getString(cursor.getColumnIndex("plantName"));
        String photoPath = cursor.getString(cursor.getColumnIndex("photoPath"));

        ((TextView) view.findViewById(R.id.txtNote)).setText(plantName);

//        URL newurl = new URL(photoPath);
//        Bitmap myIcaon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream());
        ((ImageView) view.findViewById(R.id.icon)).setImageURI(Uri.parse(photoPath));
    }
}
