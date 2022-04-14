package Fragments;
/*
*
* author hamed pouyanfar
* get api with retrofit
*
*
* */

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorialsandroid.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Adapters.UserAdapter;
import Model.User;
import Server.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView listView = view.findViewById(R.id.userList);
        Call<ArrayList<User>> user = RetrofitClient.getInstance().getApi().getUsers();
        user.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {

                User userModel;

                ArrayList<User> users = response.body();

                for(int i = 0 ; i < users.size(); i++){

                    userModel = new User();
                    userModel.setId(users.get(i).getId());
                    userModel.setName(users.get(i).getName());
                    userModel.setUsername(users.get(i).getUsername());
                    userModel.setEmail(users.get(i).getEmail());
                    /*
                    * don't add model to arraylist
                    * users.add(userModel);
                    * */

                }
                UserAdapter adapter = new UserAdapter(getActivity(),users);
                listView.setLayoutManager(new LinearLayoutManager(getActivity()));
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Toast.makeText(view.getContext().getApplicationContext(), "Erorrrr", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
