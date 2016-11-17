package temirbekia.ru.it_schedule.structure;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import temirbekia.ru.it_schedule.R;
import temirbekia.ru.it_schedule.adapters.ListViewTeachersAdapter;
import temirbekia.ru.it_schedule.adapters.ListViewTeachersModel;
import temirbekia.ru.it_schedule.database.ConnectDB;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * Created by Kas on 18.10.2016.
 */



public class Teachers extends AppCompatActivity {


    ListView teachers;
    private List<ListViewTeachersModel> modelList;
    private ConnectDB db;
    private ListViewTeachersAdapter lvAdapterTeach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        teachers = (ListView) findViewById(R.id.teacher_list);

        db=new ConnectDB(this);
        File database=getApplicationContext().getDatabasePath(ConnectDB.DBNAME);
        if(false==database.exists()){
            db.getReadableDatabase();
            if(copyDatabase(this)){
                Toast.makeText(this,"Copy database success",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Copy database wrong",Toast.LENGTH_SHORT).show();
                return;
            }
        }

        modelList = db.getList();

        lvAdapterTeach = new ListViewTeachersAdapter(this,modelList);
        teachers.setAdapter(lvAdapterTeach);

        teachers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(Teachers.this, Schedule.class);
                String message = "ПЖ получись";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }



    private boolean copyDatabase(Context context){

        try{
            InputStream inputStream = context.getAssets().open(ConnectDB.DBNAME);
            String outFileName= ConnectDB.DBLOCATION+ConnectDB.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int len=0;
            while ((len=inputStream.read(buff))>0){
                outputStream.write(buff,0,len);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("Teachers","Db copied");
            return  true;


        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}
