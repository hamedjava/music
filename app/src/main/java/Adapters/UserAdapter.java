package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorialsandroid.R;

import java.util.ArrayList;
import java.util.List;

import Model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    ArrayList<User> users;
    Context context;

    public UserAdapter(Context context , ArrayList<User> users){
        this.context = context;
        this.users = users;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.user_items,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.tv_user_name.setText(user.getName());
        holder.tv_user_username.setText(user.getUsername());
        holder.tv_user_username.setText(user.getEmail());
        holder.tv_user_username.setText(user.getId());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tv_user_id,
                tv_user_name,
                tv_user_email,
                tv_user_username;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_user_id = itemView.findViewById(R.id.tv_user_id);
            tv_user_name = itemView.findViewById(R.id.tv_user_name);
            tv_user_username = itemView.findViewById(R.id.tv_user_username);
            tv_user_email = itemView.findViewById(R.id.tv_user_email);
        }
    }
}
