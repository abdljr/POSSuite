package artisque.m1811;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ImageTableAdaptercopy extends BaseAdapter
{
    private DatabaseHelper myDB;
    private Context mContext;
    private int orderTable;
    private String[] web;
    public  double pGrossTotal;

    public ImageTableAdaptercopy(Context c, String[] web, int orderTable )
    {
        mContext = c;
        this.web=web;
        this.orderTable=orderTable;
    }

    @Override
    public int getCount()
    {
        return web.length;
    }
    @Override
    public Object getItem(int position)
    {
        return position;
    }
    @Override
    public long getItemId(int position)
    {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent)
    {
        myDB = new DatabaseHelper(mContext);


        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null)
        {
            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.gridtables, null);
            // set value into textview
            TextView textView = (TextView)
                    gridView.findViewById(R.id.grid_item_label);
            //textView.setText(web[position]);
            textView.setText(web[position].toString());
            // set image based on selected text
            //ImageView imageView = (ImageView)
            //        gridView.findViewById(R.id.grid_item_image);
            //imageView.setImageResource(Imageid[position]);

            //imageView.setImageResource(R.drawable.background);

            TextView textView1 = (TextView)
                    gridView.findViewById(R.id.tvBill);
            textView1.setBackgroundColor(Color.parseColor("#ff99cc00"));
            if (orderTable == Integer.valueOf(web[position].toString())){
            //if (orderTable == position){
                textView1.setBackgroundColor(Color.parseColor("#f5f5f5"));
            }

            textView1.setText("Bill: "+myDB.getOrderTot(Integer.valueOf(web[position])));

        }
        else
        {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
