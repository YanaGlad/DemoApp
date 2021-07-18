package com.example.gladandroidenginelib2.media;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

//Класс для подключения музыки в игру
//Пример использования (BitmapLoader) : Media.Music stayInsideMusic = mainRunActivity.getMedia().setMusic("stayInside.mp3");
public class Media {
    private AssetManager assetManager;

    public Media(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        assetManager = activity.getAssets();
    }

    Music setMusic(String fileName) throws IOException {
        return new Music(assetManager.openFd(fileName));

    }

    public class Music implements MediaPlayer.OnCompletionListener {
        MediaPlayer mediaPlayer;
        boolean isPrepared, running;

        Music(AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaPlayer = new MediaPlayer();

            mediaPlayer.setDataSource
                    (assetFileDescriptor.getFileDescriptor(),
                            assetFileDescriptor.getStartOffset(),
                            assetFileDescriptor.getLength());
            mediaPlayer.prepare();
            isPrepared = true;
            mediaPlayer.setOnCompletionListener(this);
        }

        public void run() throws IOException {
            if (mediaPlayer.isPlaying()) return;
            synchronized (this) {
                if (!isPrepared) mediaPlayer.prepare();
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(3f, 3f);
                mediaPlayer.start();
                running = true;
            }
        }

        public void stop() {
            mediaPlayer.stop();
            synchronized (this) {
                running = false;
                isPrepared = false;
            }
        }

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

        }

        public boolean isRunning() {
            return running;
        }
    }
}