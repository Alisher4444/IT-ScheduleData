package temirbekia.ru.it_schedule.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import temirbekia.ru.it_schedule.R;

/**
 * Created by Kas on 20.10.2016.
 */

public class ListViewTeachersAdapter extends BaseAdapter {


    private List<ListViewTeachersModel> listTeacher;
    Context context;


    public ListViewTeachersAdapter (Context context, List<ListViewTeachersModel> listTeacher) {
        this.context=context;
        this.listTeacher = listTeacher;


    }

    @Override
    public int getCount() {
        return listTeacher.size();
    }

    @Override
    public Object getItem(int position) {
        return listTeacher.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listTeacher.get(position).getId();
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = View.inflate(context,R.layout.listview_items_teacher, null);


//        ListViewTeachersModel teacherList = getListViewModelTeacher(position);

        // get Image of the group
     /*   ImageView teacherImage = (ImageView) view.findViewById(R.id.list_image);
        teacherImage.setImageResource(listTeacher.get(position).getTeacherImage());
*/
        TextView teacherName = (TextView) view.findViewById(R.id.list_name);
        teacherName.setText(listTeacher.get(position).getTeacherName());





        // get name of the stream
        TextView subjectName = (TextView) view.findViewById(R.id.list_sub);
        subjectName.setText(listTeacher.get(position).getSubject());

        return view;
    }

    // reurn num of group list
  /*  private ListViewTeachersModel getListViewModelTeacher(int position)
    {
        return (ListViewTeachersModel) getItem(position);
    }
*/
}
