package artisque.m1811;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by iMac on 5/23/17.
 */

public class ImageTableAdaptercopy2 extends BaseAdapter {
    private DatabaseHelper myDB;
    private Context context;
    private  int layout;
    private  int orderTable;
    private String [] web;

    public Context getContext() {
        return context;
    }

    public int getLayout() {
        return layout;
    }

    public int getOrderTable() {
        return orderTable;
    }

    public String[] getWeb() {
        return web;
    }

    public ImageTableAdaptercopy2(Context context, int layout, String[] web, int orderTable) {
        this.context = context;
        this.layout = layout;
        this.web = web;
        this.orderTable = orderTable;

    }


    private class ViewHolderService{
        TextView txtItemsLabel, txtItemBill;
    }

    @Override
    public int getCount() {
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolderService holder = new ViewHolderService();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtItemsLabel = (TextView) row.findViewById(R.id.grid_item_label);
            holder.txtItemBill = (TextView) row.findViewById(R.id.tvBill);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolderService) row.getTag();
        }

        //Service service = serviceList.get(position);
        holder.txtItemsLabel.setText(web[position]);

        holder.txtItemBill.setBackgroundColor(Color.parseColor("#ff99cc00"));
        if (orderTable == Integer.valueOf(web[position].toString())){
            holder.txtItemBill.setBackgroundColor(Color.parseColor("#f5f5f5"));
        }

        holder.txtItemBill.setText("Bill: "+myDB.getOrderTot(Integer.valueOf(web[position])));


        return row;
    }

}
