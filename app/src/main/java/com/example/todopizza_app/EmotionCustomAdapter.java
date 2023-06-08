package com.example.todopizza_app;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class EmotionCustomAdapter extends ArrayAdapter<String> {
    int[] spinnerImages;
    Context mcontext;
    public EmotionCustomAdapter(@NonNull Context context, int[] spinnerImages){
        super(context, R.layout.todo_target);
        this.spinnerImages = spinnerImages;
        this.mcontext = context;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return spinnerImages.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView == null){
            LayoutInflater mInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.imgspin,parent, false);

            mViewHolder.mImage = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mImage.setImageResource(spinnerImages[position]);
        return convertView;
    }
    private static class ViewHolder{
        ImageView mImage;
    }
}
