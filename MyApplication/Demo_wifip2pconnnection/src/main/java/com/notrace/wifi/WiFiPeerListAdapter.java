package com.notrace.wifi;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by notrace on 2015/12/22.
 */
public class WiFiPeerListAdapter extends BaseAdapter {
    private List<WifiP2pDevice>list;
    private Context context;
    public WiFiPeerListAdapter(Context context,List<WifiP2pDevice>list)
    {
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    public void setData(List<WifiP2pDevice>list){
        this.list=list;
        notifyDataSetChanged();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=new ViewHolder();

        convertView= LayoutInflater.from(context).inflate(R.layout.item,null);
        holder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
        holder.tv_address= (TextView) convertView.findViewById(R.id.tv_address);
        holder.tv_primarytype= (TextView) convertView.findViewById(R.id.tv_primarytype);
        holder.tv_secondtype= (TextView) convertView.findViewById(R.id.tv_secondtype);


        holder.tv_name.setText(list.get(position).deviceName);
        holder.tv_address.setText(list.get(position).deviceAddress);
        holder.tv_primarytype.setText(list.get(position).primaryDeviceType);
        holder.tv_secondtype.setText(list.get(position).secondaryDeviceType+"");

        return convertView;
    }

    public class ViewHolder{
        private TextView tv_name,tv_address,tv_primarytype,tv_secondtype;
    }
}
