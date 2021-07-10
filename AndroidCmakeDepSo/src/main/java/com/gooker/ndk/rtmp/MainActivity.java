package com.gooker.ndk.rtmp;

import android.Manifest;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.widget.TextView;

import com.gooker.cts.activity.AbsActivity;
import com.gooker.cts.tools.LogUtils;
import com.gooker.ndk.rtmp.databinding.ActivityMainBinding;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AbsActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
//        System.loadLibrary("rtmp-ndk");
//        System.loadLibrary("x264");
        System.loadLibrary("native-lib");
    }

    private ActivityMainBinding binding;
    private AtomicBoolean mAudioRecordQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        binding.audioRecordStartBtn.setOnClickListener(v -> {
            mAudioRecordQuit = new AtomicBoolean(false);
            binding.audioRecordStartBtn.setEnabled(false);

            new Thread(this::createAudioRecord).start();

        });

        binding.audioRecordStopBtn.setOnClickListener(v -> {
            binding.audioRecordStartBtn.setEnabled(true);
            mAudioRecordQuit.set(true);
        });

        requestPermission(new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA}, strings -> {
            LogUtils.e("");
            return null;
        }, strings -> {
            LogUtils.e("");
            return null;
        });
    }

    private void createAudioRecord() {

        int encoding = AudioFormat.ENCODING_PCM_16BIT;
        int SAMPLE_RATE = 48_000;
        int channelInStereo = AudioFormat.CHANNEL_IN_STEREO;
        int minBufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, channelInStereo, encoding);

        LogUtils.e("minBufferSize:" + minBufferSize);
        AudioRecord audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, SAMPLE_RATE, channelInStereo, encoding, minBufferSize);

        audioRecord.startRecording();
//        int readLen = minBufferSize;
        int readLen = minBufferSize / 2;
//            byte[] data = new byte[minBufferSize];
        short[] data = new short[readLen];

        while (!mAudioRecordQuit.get()) {
            int readStatus = audioRecord.read(data, 0, readLen);
            LogUtils.e("readStatus:" + readStatus);
//            LogUtils.e(data.length);
        }
        audioRecord.stop();
        audioRecord.release();
        audioRecord = null;


    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}