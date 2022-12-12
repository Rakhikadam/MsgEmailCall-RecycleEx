package com.example.msgemail_callactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewExample extends AppCompatActivity {
    RecyclerView contactlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_example);
        contactlist = findViewById(R.id.contactlist);
        List<Contact> list = new ArrayList<Contact>();
        list.add(new Contact("pankaj","999999","pankaj@gmail.com"));
        list.add(new Contact("rakhi","96669999","rakhi@gmail.com"));
        list.add(new Contact("pruthvi","888888","pruthvi@gmail.com"));
        ContactListAdapter adapter = new ContactListAdapter(list);
        contactlist.setLayoutManager(new LinearLayoutManager(RecycleViewExample.this));
        contactlist.setAdapter(adapter);

    }
    class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.MyCustomViewHolder> {
        List<Contact> list;

        public ContactListAdapter(List<Contact> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ContactListAdapter.MyCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(RecycleViewExample.this).inflate(R.layout.contact_row,parent,false);
           MyCustomViewHolder holder = new MyCustomViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ContactListAdapter.MyCustomViewHolder holder, int position) {
            holder.name.setText(list.get(position).getName());
            holder.number.setText(list.get(position).getNumber());
            holder.email.setText(list.get(position).getEmail());
            holder.number.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent callintent = new Intent(Intent.ACTION_CALL);
                    callintent.setData(Uri.parse("tel:"+list.get(position).getNumber()));
                    startActivity(callintent);
                }
            });

            holder.email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mailintent = new Intent(Intent.ACTION_VIEW);
                    mailintent.setData(Uri.parse("mailto:"+list.get(position).getEmail()));
                    startActivity(mailintent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class MyCustomViewHolder extends RecyclerView.ViewHolder {
            TextView name, number , email;
            public MyCustomViewHolder(@NonNull View itemView) {
                super(itemView);
               name = itemView.findViewById(R.id.name);
               number = itemView.findViewById(R.id.number);
               email= itemView.findViewById(R.id.email);
            }
        }
    }
}