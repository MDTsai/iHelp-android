package edu.stu.ihelp.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

public class CameraWrapper extends Activity {
    public static int REQ_CODE_CAMERA = 0x100;
    public static int REQ_CODE_VIDEO = 0x200;
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.camera);
        
        int reqCode = -1; 
        try {
            reqCode = this.getIntent().getExtras().getInt("REQ_CODE");
        } catch (Exception e) {
            
        }
        
        if (reqCode == REQ_CODE_CAMERA) {
            Intent takePictureIntent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, REQ_CODE_CAMERA);    
        } else if (reqCode == REQ_CODE_VIDEO) {
            Intent takeVideoIntent = new Intent (MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(takeVideoIntent, REQ_CODE_VIDEO);
        } else {
            finish();
        }
    }
    
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Intent intent = new Intent (this, General.class);
            startActivity(intent);
        }
        
        this.finish();
    }
}
