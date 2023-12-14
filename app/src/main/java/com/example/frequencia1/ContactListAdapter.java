package com.example.frequencia1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> {

    private List<Contact> contactList;

    public ContactListAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.contactImageView.setImageResource(contact.getImageResource());
        holder.contactNameText.setText(contact.getName());
        holder.contactNumberText.setText(contact.getNumber());
        holder.contactEmailText.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView contactImageView;
        TextView contactNameText;
        TextView contactNumberText;
        TextView contactEmailText;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            contactImageView = itemView.findViewById(R.id.contactImageView);
            contactNameText = itemView.findViewById(R.id.contactNameText);
            contactNumberText = itemView.findViewById(R.id.contactNumberText);
            contactEmailText = itemView.findViewById(R.id.contactEmailText);
        }
    }
}
