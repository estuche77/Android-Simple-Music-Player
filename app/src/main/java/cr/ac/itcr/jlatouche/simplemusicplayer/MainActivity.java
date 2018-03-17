package cr.ac.itcr.jlatouche.simplemusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView songsListView = findViewById(R.id.songsListView);


    }

    public class SongsAdapter extends BaseAdapter {

        private ArrayList<Song> songs;

        public SongsAdapter(ArrayList<Song> songs) {
            this.songs = songs;
        }

        @Override
        public int getCount() {
            return songs.size();
        }

        @Override
        public Object getItem(int i) {
            return songs.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = getLayoutInflater();
            if (view == null) {
                view = inflater.inflate(R.layout.song_row, null);
            }

            TextView songName = view.findViewById(R.id.songName);
            TextView songAuthor = view.findViewById(R.id.songAuthor);
            TextView songTime = view.findViewById(R.id.songTotalTime);

            songName.setText(String.valueOf(songs.get(i).getName()));
            songAuthor.setText(String.valueOf(songs.get(i).getAuthor()));
            songTime.setText(String.valueOf(songs.get(i).getTime()));

            return null;
        }
    }
}
