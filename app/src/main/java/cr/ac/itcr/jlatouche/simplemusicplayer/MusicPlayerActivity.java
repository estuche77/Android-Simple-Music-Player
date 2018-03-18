package cr.ac.itcr.jlatouche.simplemusicplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class MusicPlayerActivity extends AppCompatActivity {

    private static MediaPlayer mediaPlayer = MainActivity.mediaPlayer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        int songNumber = (int) getIntent().getSerializableExtra("SONGNUMBER");
        Song currentSong = MainActivity.songs.get(songNumber);

        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.sunset);
        mediaPlayer.start();

        final TextView songNameText = findViewById(R.id.songTitleName);
        final TextView actualTimeText = findViewById(R.id.actualTimeText);
        final TextView endTimeText = findViewById(R.id.endTimeText);
        final SeekBar songBar = findViewById(R.id.songSeekBar);
        final Button previewButton = findViewById(R.id.previewButton);
        final Button playpauseButton = findViewById(R.id.playpauseButton);
        final Button nextButton = findViewById(R.id.nextButton);

        songNameText.setText(currentSong.getName());

        int mediaPos = mediaPlayer.getCurrentPosition();
        int mediaMax = mediaPlayer.getDuration();

        int minutes = mediaPos / (60 * 1000);
        int seconds = (mediaPos / 1000) % 60;
        String mediaPosStr = String.format("%d:%02d", minutes, seconds);

        actualTimeText.setText(mediaPosStr);

        minutes = mediaMax / (60 * 1000);
        seconds = (mediaMax / 1000) % 60;
        String mediaMaxStr = String.format("%d:%02d", minutes, seconds);

        endTimeText.setText(mediaMaxStr);

        songBar.setMax(mediaMax / 1000);
        songBar.setProgress(mediaPos / 1000);

        songBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mediaPlayer != null && fromUser) {
                    mediaPlayer.seekTo(progress);
                    int mediaPos_new = mediaPlayer.getCurrentPosition();

                    int minutes = mediaPos_new / (60 * 1000);
                    int seconds = (mediaPos_new / 1000) % 60;
                    String mediaPosStr = String.format("%d:%02d", minutes, seconds);
                    actualTimeText.setText(mediaPosStr);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediaPlayer.setVolume(0, 0);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                actualTimeText.setText("0:00");
                songBar.setProgress(0);
            }
        });

        final Runnable moveSeekBarThread = new Runnable() {
            public void run() {
                if(mediaPlayer.isPlaying()){

                    int mediaPos_new = mediaPlayer.getCurrentPosition();
                    int mediaMax_new = mediaPlayer.getDuration();
                    songBar.setMax(mediaMax_new);
                    songBar.setProgress(mediaPos_new);

                    int minutes = mediaPos_new / (60 * 1000);
                    int seconds = (mediaPos_new / 1000) % 60;
                    String mediaPosStr = String.format("%d:%02d", minutes, seconds);

                    actualTimeText.setText(mediaPosStr);

                    songBar.postDelayed(this, 1000);
                }
            }
        };

        handler = new Handler();
        handler.removeCallbacks(moveSeekBarThread);
        handler.postDelayed(moveSeekBarThread, 1000);

        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        playpauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                else {
                    mediaPlayer.start();
                    handler.removeCallbacks(moveSeekBarThread);
                    handler.postDelayed(moveSeekBarThread, 1000);
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
