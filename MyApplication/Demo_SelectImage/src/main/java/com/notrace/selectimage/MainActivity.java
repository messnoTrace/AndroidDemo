package com.notrace.selectimage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.sw926.imagefileselector.ImageCropper;
import com.sw926.imagefileselector.ImageFileSelector;

import java.io.File;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btn_takepic,btn_choose;
    private ImageView imageView;
    ImageFileSelector mImageFileSelector;
    ImageCropper mImageCropper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageview);
        btn_choose= (Button) findViewById(R.id.btn_choose);
        btn_takepic= (Button) findViewById(R.id.btn_takepic);

        btn_choose.setOnClickListener(this);
        btn_takepic.setOnClickListener(this);




        //选择图片
         mImageFileSelector = new ImageFileSelector(this);
        mImageFileSelector.setCallback(new ImageFileSelector.Callback() {
            @Override
            public void onSuccess(final String file) {
                // 选取图片成功
                mImageCropper.cropImage(new File(file));
            }

            @Override
            public void onError() {
                // 选取图片失败
                Toast.makeText(MainActivity.this,"选择失败",Toast.LENGTH_SHORT).show();
            }
        });
        // 设置输出文件的尺寸
        mImageFileSelector.setOutPutImageSize(800, 600);
        // 设置保存图片的质量 0到100
        mImageFileSelector.setQuality(80);


        //裁剪图片
         mImageCropper = new ImageCropper(this);
        mImageCropper.setCallback(new ImageCropper.ImageCropperCallback() {
            @Override
            public void onCropperCallback(ImageCropper.CropperResult result, File srcFile, File outFile) {
                if (result == ImageCropper.CropperResult.success) {
                    // 成功
                    loadImage(outFile.getPath());
                } else if (result == ImageCropper.CropperResult.error_illegal_input_file) {
                    // 输入的文件失败
                } else if (result == ImageCropper.CropperResult.error_illegal_out_file) {
                    // 输出文件失败
                }
            }
        });

        // 设置输出文件的宽高比
        mImageCropper.setOutPutAspect(1, 1);
         // 设置输出文件的尺寸
        mImageCropper.setOutPut(800, 800);
        // 设置是否缩放到指定的尺寸
        mImageCropper.setScale(true);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mImageFileSelector.onActivityResult(requestCode, resultCode, data);
        mImageCropper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mImageFileSelector.onSaveInstanceState(outState);
        mImageCropper.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mImageFileSelector.onRestoreInstanceState(savedInstanceState);
        mImageCropper.onRestoreInstanceState(savedInstanceState);
    }

    // Android 6.0的动态权限
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mImageFileSelector.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_takepic:

                mImageFileSelector.takePhoto(MainActivity.this);
                break;
            case R.id.btn_choose:
                mImageFileSelector.selectImage(MainActivity.this);
                break;
        }
    }


    private void loadImage(final String file) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = BitmapFactory.decodeFile(file);
                File imageFile = new File(file);
                final StringBuilder builder = new StringBuilder();
                builder.append("path: ");
                builder.append(file);
                builder.append("\n\n");
                builder.append("length: ");
                builder.append((int) (imageFile.length() / 1024d));
                builder.append("KB");
                builder.append("\n\n");
                builder.append("image size: (");
                builder.append(bitmap.getWidth());
                builder.append(", ");
                builder.append(bitmap.getHeight());
                builder.append(")");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }
}
