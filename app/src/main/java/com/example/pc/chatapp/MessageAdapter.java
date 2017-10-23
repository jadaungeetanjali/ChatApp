package com.example.pc.chatapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by PC on 10/23/2017.
 */

public class MessageAdapter extends ArrayAdapter<messagesModel> {

    public MessageAdapter(Context context, int resource, List<messagesModel> objects){
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View rootView, ViewGroup parent){
        if (rootView == null){
            rootView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }
        ImageView photoImageView = (ImageView) rootView.findViewById(R.id.photoImageView);
        TextView messageTextView = (TextView) rootView.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) rootView.findViewById(R.id.nameTextView);

        messagesModel message = getItem(position);

        if (message.getPhotoUrl() != null){
            Picasso.with(photoImageView.getContext()).load(message.getPhotoUrl()).into(photoImageView);
        }else{
            messageTextView.setText(message.getText());
        }
        authorTextView.setText(message.getName());

      return rootView;
    }
}
