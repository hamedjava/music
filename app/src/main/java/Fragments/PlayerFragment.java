package Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.fragment.app.Fragment;

import com.example.tutorialsandroid.R;

import java.io.IOException;

public class PlayerFragment extends Fragment {
    public int isPlaying = 0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MediaPlayer media = MediaPlayer.create(getActivity(),R.raw.mohsen);
        ImageView img_player_artistName;

        AppCompatImageButton btn_player_playMusic,
                             btn_player_forwardMusic,
                             btn_player_backwardMusic,
                             btn_player_repeatMusic,
                             btn_player_shareMusic;

        AppCompatSeekBar seekbar = getActivity().findViewById(R.id.seekbar_player);
        img_player_artistName = getActivity().findViewById(R.id.img_player_artistImage);
        btn_player_playMusic = getActivity().findViewById(R.id.btn_player_playMusic);
        btn_player_repeatMusic = getActivity().findViewById(R.id.btn_player_repeatMusic);
        btn_player_shareMusic = getActivity().findViewById(R.id.btn_player_shareMusic);
        btn_player_forwardMusic = getActivity().findViewById(R.id.btn_player_forward);
        btn_player_backwardMusic = getActivity().findViewById(R.id.btn_player_backward);

        btn_player_playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPlaying == 0){
                    media.start();
                    btn_player_playMusic.setImageDrawable(getContext().getDrawable(R.drawable.ic_baseline_stop_circle_24));
                    isPlaying = 1;
                }else{
                    media.stop();
                    media.reset();
                    btn_player_playMusic.setImageDrawable(getContext().getDrawable(R.drawable.ic_baseline_play_circle_filled_24));
                    isPlaying = 0;
                }
            }
        });

    }

}
