package seeto.c2.artoria.us.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import seeto.c2.artoria.us.myapplication.UI.Mirror.ChildInfo;
import seeto.c2.artoria.us.myapplication.UI.Mirror.ParentInfo;
import seeto.c2.artoria.us.myapplication.R;

public class MirrorAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<ParentInfo> deptList;

    public MirrorAdapter(Context context,ArrayList<ParentInfo> deptList)
    {
        this.context = context;
        this.deptList = deptList;
    }

    @Override
    public int getGroupCount() {
        return deptList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<ChildInfo> increaseList  = deptList.get(groupPosition).getList();
        return increaseList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return deptList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<ChildInfo> increaseList = deptList.get(groupPosition).getList();
        return increaseList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ParentInfo headerInfo = (ParentInfo)getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mirror_parent,null);
        }
        TextView heading = (TextView)convertView.findViewById(R.id.heading);
        heading.setText(headerInfo.getTitle().trim());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildInfo DetailInfo = (ChildInfo)getChild(groupPosition,childPosition);
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mirror_child,null);
        }

        TextView sequence = (TextView)convertView.findViewById(R.id.childText1);
        sequence.setText(DetailInfo.getSequence().trim());

        TextView childitem = (TextView)convertView.findViewById(R.id.childText2);
        childitem.setText(DetailInfo.getTitle().trim());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}