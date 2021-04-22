package com.aziz.contactreader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aziz.contactreader.R;
import com.aziz.contactreader.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> implements Filterable {

    private List<Contact> contactList;
    private List<Contact> filteredContactList;
    private Context context;

    public ContactsAdapter(Context context, List<Contact> contacts){
        this.context = context;
        this.contactList = contacts;
        this.filteredContactList = contacts;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public TextView name, number;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.phone);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact contact = filteredContactList.get(position);
        holder.image.setImageURI(contact.getPhotoURI());
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getMobileNumber());
    }

    @Override
    public int getItemCount() {
        return filteredContactList.size();
    }

    @Override
    public Filter getFilter()  {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String text = constraint.toString().toLowerCase().trim();
                if(text.isEmpty()){
                    filteredContactList.addAll(contactList);
                }else{
                    List<Contact> filteredList = new ArrayList<>();
                    for(Contact row: contactList){
                        if(row.getName().toLowerCase().contains(text) || row.getMobileNumber().contains(text)){
                            filteredList.add(row);
                        }
                    }
                    filteredContactList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredContactList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredContactList = (List<Contact>) results.values;
                notifyDataSetChanged();
            }
        };
    }

}
