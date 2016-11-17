package temirbekia.ru.it_schedule.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import temirbekia.ru.it_schedule.adapters.ListViewTeachersModel;

/**
 * Created by Alisher on 21.10.2016.
 */

public class ConnectDB extends SQLiteOpenHelper {
    public static final String DBNAME="new.sqlite";
    public static final String DBLOCATION = "/data/data/temirbekia.ru.it_schedule/databases/";
    private Context context;
    private SQLiteDatabase database;

    public ConnectDB(Context context){
        super(context,DBNAME,null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDatabase(){

        String dbPath = context.getDatabasePath(DBNAME).getPath();
        if(database!=null && database.isOpen()){
            return;
        }
        database=SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);


    }

    public void closeDatabase(){
        if (database!=null){
            database.close();
        }
    }


    public List<ListViewTeachersModel> getList(){
        ListViewTeachersModel model = null;
        List<ListViewTeachersModel> modelList= new ArrayList<>();
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT *FROM TEACHER",null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){

            model = new ListViewTeachersModel(cursor.getInt(0),
                    cursor.getString(1),cursor.getString(2),cursor.getString(3));
            modelList.add(model);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return modelList;
    }

}
