package com.example.msgemail_callactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import list_of_user.user;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.listnumber);
        List<user>userList = new ArrayList<>();
        user user1 = new user("Rakhi","823455","rakhika11@gmail.com");
        userList.add(user1);
        ContactAdpter adpter = new ContactAdpter(userList);
        list.setAdapter(adpter);

    }

    class ContactAdpter extends BaseAdapter{List<user>list;

        public ContactAdpter(List<user> userList) {this.list=userList;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View ABC = LayoutInflater.from(MainActivity.this).inflate(R.layout.listperson,viewGroup,false);
            TextView textView = ABC.findViewById(R.id.name);
            textView.setText(list.get(i).getName());

            TextView textView1 = ABC.findViewById(R.id.mail);
            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mailintent =new Intent(Intent.ACTION_VIEW);
                    mailintent.setData(Uri.parse("mailto:"+list.get(i).getEmail_id()));
                    startActivity(mailintent);
                }
            });
            ImageView call = ABC.findViewById(R.id.call);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent callintent = new Intent(Intent.ACTION_CALL);
                    callintent.setData(Uri.parse("tel:"+list.get(i).getContact_number()));
                    startActivity(callintent);
                }
            });

            ImageView msg = ABC.findViewById(R.id.msg);
            msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent msgIntent = new Intent(Intent.ACTION_VIEW);
                    msgIntent.setData(Uri.parse("sms:"+list.get(i).getContact_number()));
                    startActivity(msgIntent);
                }
            });

            msg.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Dialog dialog =new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.dialog);
                    EditText text = findViewById(R.id.message);
                    Button button = findViewById(R.id.send);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent msgintent = new Intent(Intent.ACTION_VIEW);
                            msgintent.setData(Uri.parse("sms:"+list.get(i).getContact_number()));
                            startActivity(msgintent);

                        }
                    });





                    return false;
                }
            });

            return ABC;
        }
    }


}