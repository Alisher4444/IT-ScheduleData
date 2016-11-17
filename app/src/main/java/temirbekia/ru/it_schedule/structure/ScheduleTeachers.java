package temirbekia.ru.it_schedule.structure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import temirbekia.ru.it_schedule.R;
import temirbekia.ru.it_schedule.adapters.ListViewScheduleModel;
import temirbekia.ru.it_schedule.adapters.ListViewScheduleModelTeacher;
import temirbekia.ru.it_schedule.adapters.ScheduleAdapter;
import temirbekia.ru.it_schedule.adapters.ScheduleAdapterTeacher;

/**
 * Created by Kas on 20.10.2016.
 */

public class ScheduleTeachers extends AppCompatActivity {

    ListView teachers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_teachers);

        teachers = (ListView) findViewById(R.id.teacher_list);

        ScheduleAdapterTeacher schedule = new ScheduleAdapterTeacher(getApplicationContext(), initData2());
        teachers.setAdapter(schedule);

        teachers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ScheduleTeachers.this,TableTeachers.class);
                startActivity(intent);
            }
        });


    }


    private List<ListViewScheduleModelTeacher> initData2()
    {

        List<ListViewScheduleModelTeacher> days = new ArrayList<ListViewScheduleModelTeacher>();

        days.add(new ListViewScheduleModelTeacher(1, R.drawable.mt, "Monday"));
        days.add(new ListViewScheduleModelTeacher(1, R.drawable.tt, "Tuesday"));
        days.add(new ListViewScheduleModelTeacher(1, R.drawable.wt, "Wednesday"));
        days.add(new ListViewScheduleModelTeacher(1, R.drawable.tt, "Thursday"));
        days.add(new ListViewScheduleModelTeacher(1, R.drawable.ft, "Friday"));

        return days;
    }





}
