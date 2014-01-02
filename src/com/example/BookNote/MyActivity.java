package com.example.BookNote;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyActivity extends Activity {
    ListView list;
    String[] web = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    } ;
    Integer[] imageId = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
        CustomList adapter = new
                CustomList(MyActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MyActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public static Bitmap createLightweightScaledBitmapFromStream(InputStream is, int minShrunkWidth, int minShrunkHeight, Bitmap.Config config) {
//
//        BufferedInputStream bis = new BufferedInputStream(is, 32 * 1024);
//        try {
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            if (config != null) {
//                options.inPreferredConfig = config;
//            }
//
//            final BitmapFactory.Options decodeBoundsOptions = new BitmapFactory.Options();
//            decodeBoundsOptions.inJustDecodeBounds = true;
//            bis.mark(Integer.MAX_VALUE);
//            BitmapFactory.decodeStream(bis, null, decodeBoundsOptions);
//            bis.reset();
//
//            final int width = decodeBoundsOptions.outWidth;
//            final int height = decodeBoundsOptions.outHeight;
//            Log.v("Original bitmap dimensions: %d x %d", width, height);
//            int sampleRatio = Math.max(width / minShrunkWidth, height / minShrunkHeight);
//            if (sampleRatio >= 2) {
//                options.inSampleSize = sampleRatio;
//            }
//            Log.v("Bitmap sample size = %d", options.inSampleSize);
//
//            Bitmap ret = BitmapFactory.decodeStream(bis, null, options);
//            Log.d("Sampled bitmap size = %d X %d", options.outWidth, options.outHeight);

//            return ret;
//        } catch (IOException e) {
//            Log.e("Error resizing bitmap from InputStream.", e);
//        } finally {
//            Util.ensureClosed(bis);
//        }
//        return null;
//    }
//
//
//    public static Bitmap createScaledBitmapFromStream(InputStream is, int maxWidth, int maxHeight, Bitmap.Config config) {
//
//        // Start by grabbing the bitmap from file, sampling down a little first if the image is huge.
//        Bitmap tempBitmap = createLightweightScaledBitmapFromStream(is, maxWidth, maxHeight, config);
//
//        Bitmap outBitmap = tempBitmap;
//        int width = tempBitmap.getWidth();
//        int height = tempBitmap.getHeight();
//
//        // Find the greatest ration difference, as this is what we will shrink both sides to.
//        float ratio = calculateBitmapScaleFactor(width, height, maxWidth, maxHeight);
//        if (ratio < 1.0f) { // Don't blow up small images, only shrink bigger ones.
//            int newWidth = (int) (ratio * width);
//            int newHeight = (int) (ratio * height);
//            Log.v("Scaling image further down to %d x %d", newWidth, newHeight);
//            outBitmap = Bitmap.createScaledBitmap(tempBitmap, newWidth, newHeight, true);
//            Log.d("Final bitmap dimensions: %d x %d", outBitmap.getWidth(), outBitmap.getHeight());
//            tempBitmap.recycle();
//        }
//        return outBitmap;
//    }
}