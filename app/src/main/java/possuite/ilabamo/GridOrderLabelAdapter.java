package possuite.ilabamo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class GridOrderLabelAdapter extends BaseAdapter {
    private Context context;
    private DatabaseHelper myDB;
    private  int layout;
    private ArrayList<OrderLabelItems> orderLabelList;
    private int orderLabelID;
    public  double pGrossTotal;

    public GridOrderLabelAdapter(Context context, int layout, ArrayList<OrderLabelItems> orderLabelList, int orderLabelID) {
        this.context = context;
        this.layout = layout;
        this.orderLabelList = orderLabelList;
        this.orderLabelID = orderLabelID;
    }

    @Override
    public int getCount() {
        return orderLabelList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderLabelList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtLabelId, txtDescription, txtBill, currentLabel;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();
        myDB = new DatabaseHelper(context);

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtDescription = (TextView) row.findViewById(R.id.tvDesc);
            holder.txtBill  = (TextView) row.findViewById(R.id.tvBill);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }
        OrderLabelItems orderLabelItems = orderLabelList.get(position);
        holder.txtDescription.setText(orderLabelItems.getDescription());
        holder.txtBill.setText(String.format(Locale.US,"%,.2f",myDB.getOrderTot(orderLabelItems.getId())));
        holder.txtBill.setBackgroundColor(Color.parseColor("#ff99cc00"));
        //holder.imageView = (ImageView) row.findViewById(R.id.imgLabel);
        //if (currentLabel == orderLabelItems.getDescription()){
        if (orderLabelID == orderLabelList.get(position).getId()){
            holder.txtBill.setBackgroundColor(Color.parseColor("#f5f5f5"));
        }
        myDB.close();
        return row;
    }
}
