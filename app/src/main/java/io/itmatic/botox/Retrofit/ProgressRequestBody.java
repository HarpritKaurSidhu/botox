package io.itmatic.botox.Retrofit;

import android.os.Handler;
import android.os.Looper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.itmatic.botox.Provider.UploadDocumentFirstActivity;
import io.itmatic.botox.Provider.UploadDocumentSecondActivity;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class ProgressRequestBody extends RequestBody {
    private File mFile;
    private String mPath;
    private UploadCallbacks mListener;

    private int requestCodeId;
    private static final int DEFAULT_BUFFER_SIZE = 2048;

    public interface UploadCallbacks {
        void onProgressUpdate(int percentage,int requestCode);
        void onError();
        void onFinish();
    }

    public ProgressRequestBody(final File file, final UploadDocumentFirstActivity listener, int requestCode) {
        mFile = file;
        mListener = listener;
        requestCodeId = requestCode;
    }
    public ProgressRequestBody(final File file, final UploadDocumentSecondActivity listener, int requestCode) {
        mFile = file;
        mListener = listener;
        requestCodeId = requestCode;
    }

    public int getRequestCodeId() {
        return requestCodeId;
    }

    public void setRequestCodeId(int requestCodeId) {
        this.requestCodeId = requestCodeId;
    }

    @Override
    public MediaType contentType() {
        // i want to upload only images
        return MediaType.parse("image/*");
    }

    @Override
    public long contentLength() throws IOException {
      return mFile.length();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        long fileLength = mFile.length();
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        FileInputStream in = new FileInputStream(mFile);
        long uploaded = 0;

        try {
            int read;
            Handler handler = new Handler(Looper.getMainLooper());
            while ((read = in.read(buffer)) != -1) {

                // update progress on UI thread
                handler.post(new ProgressUpdater(uploaded, fileLength));

                uploaded += read;
                sink.write(buffer, 0, read);
            }
        } finally {
            in.close();
        }
    }

    private class ProgressUpdater implements Runnable {
        private long mUploaded;
        private long mTotal;
        public ProgressUpdater(long uploaded, long total) {
            mUploaded = uploaded;
            mTotal = total;
        }

        @Override
        public void run() {
            mListener.onProgressUpdate((int)(100 * mUploaded / mTotal),getRequestCodeId());
        }
    }
}