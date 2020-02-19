package com.example.twiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudAppendBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    static String connStr = "DefaultEndpointsProtocol=https;AccountName=sungho0218;AccountKey=VAHrGlgHEGgbpqmSjLNGFqbNIMwEFMVIdQQFQWVLGZ+faZ8+UY/M9VO4USbUx8zVkDGw0g3tV2EoxDseCLtjdQ==;EndpointSuffix=core.windows.net";
    int[] imgArr = {R.drawable.t1_nayeon, R.drawable.t2_dahyeon, R.drawable.t3_jeongyeon, R.drawable.t4_sana,
            R.drawable.t5_momo, R.drawable.t6_chaeyoung,
            R.drawable.t7_mina, R.drawable.t8_jihyo, R.drawable.t9_zuwi,R.drawable.busan};
    String[] nameArr = {"t1_nayeon", "t2_dahyeon", "t3_jeongyeon",
            "t4_sana", "t5_momo", "t6_chaeyoung",
            "t7_mina", "t8_jihyo", "t9_zuwi","busan"};

    static CloudBlobContainer container;
    int indexA = -1;
    ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imgV = findViewById(R.id.imgV);
        this.imgV.setImageResource(R.drawable.t1_nayeon);
    }

    public void getContainer(View v) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    CloudStorageAccount storageAccount = CloudStorageAccount.parse(connStr);
                    //storage account 생성
                    CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
                    //blob client 생성
                    container = blobClient.getContainerReference("images");
                    //생성했던 컨테이너의 이름을 넣음.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
    }

    public void showNextimage(View v) {
        //bitmap으로 불러오기
        indexA++;
        if (indexA > 9) indexA = 0;
        Resources res = getResources();
        final Bitmap bitmap = BitmapFactory.decodeResource(res, imgArr[indexA]);
        imgV.setImageBitmap(bitmap);
    }
    //클라우드 사용하여 업로드 진행
    public void uploadImage(View v) {
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream ips = getResources().openRawResource(imgArr[indexA]);
                    final int imgLength = ips.available();
                    container.createIfNotExists();
                    String imgName = nameArr[indexA] + ".jpg";
                    CloudBlockBlob imgBlob = container.getBlockBlobReference(imgName);
                    imgBlob.upload(ips,imgLength);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }); threadB.start();
    }

    //클라우드 사용하여 다운로드 진행
    public void downloadImage(View v){
        Log.d("Test","down");
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    CloudBlockBlob blob = container.getBlockBlobReference("iu.jpg");
                    //다운로드 할 항목
                    if(blob.exists()){
                        //iu.jpg가 존재한다면 실행
                        blob.downloadAttributes();
                        final ByteArrayOutputStream imgStream = new ByteArrayOutputStream();
                        blob.download(imgStream);
                        byte[] buffer = imgStream.toByteArray();
                        final Bitmap bitmap = BitmapFactory.decodeByteArray(buffer,0,buffer.length);

                        runOnUiThread(new Runnable() {
                            //UI 쓰레드는 메인 쓰레드에서 작동하라
                            @Override
                            public void run() {
                                imgV.setImageBitmap(bitmap);
                            }
                        });
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        threadC.start();
    }
}
