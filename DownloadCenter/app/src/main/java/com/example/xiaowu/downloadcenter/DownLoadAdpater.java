package com.example.xiaowu.downloadcenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xiaowu on 2016-5-16.
 */
public class DownLoadAdpater extends RecyclerView.Adapter<DownLoadAdpater.DownLoadViewHolder> {
    private static final String TAG = "DownLoadAdpater";
    private Context mContext;
    private ArrayList<DownLoadItem> mList;
    private OnItemFocusListener onItemFocusListener;
    private OnKeyEventListener onKeyEventListener;

    public DownLoadAdpater(Context context, ArrayList<DownLoadItem> list)
    {
        mContext=context;
        mList=list;

    }

    public void setOnKeyEventListener(OnKeyEventListener onKeyEventListener) {
        this.onKeyEventListener = onKeyEventListener;
    }

    public void setOnItemFocusListener(OnItemFocusListener onItemFocusListener) {
        this.onItemFocusListener = onItemFocusListener;
    }

    //创建View，被layoutmannager所调用
    @Override
    public DownLoadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.downitem,parent,false);
        DownLoadViewHolder viewHolder=new DownLoadViewHolder(view);
        return viewHolder;
    }
    //将数据与界面进行绑定
    @Override
    public void onBindViewHolder(DownLoadViewHolder holder, int position) {
        DownLoadItem item=new DownLoadItem();
        item=mList.get(position);
        holder.tv_name.setText(item.getName());
        holder.tv_size.setText(item.getSize());
        holder.tv_state.setText(item.getState());

        holder.tv_completed.setText(item.getCompleted()+"");
        holder.tv_speed.setText(item.getSpeed()+"/秒");


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class DownLoadViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_name;
        public TextView tv_size;
        public TextView tv_state;
        public TextView tv_completed;
        public TextView tv_speed;

        public DownLoadViewHolder(final View itemView) {
            super(itemView);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_size= (TextView) itemView.findViewById(R.id.tv_size);
            tv_state= (TextView) itemView.findViewById(R.id.tv_state);
            tv_completed= (TextView) itemView.findViewById(R.id.tv_completed);
            tv_speed= (TextView) itemView.findViewById(R.id.tv_speed);
            itemView.setFocusable(true);
            itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    if (onItemFocusListener!=null)
                        onItemFocusListener.OnItemFocus(view,b,getPosition());

                }
            });
            itemView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keycode, KeyEvent keyEvent) {

                    if (onKeyEventListener != null) {

                           return  onKeyEventListener.OnKeyEvent(view,keycode,keyEvent,getPosition());
                    }
                    return false;
                }
            });
        }
    }

    interface OnItemFocusListener{
        void OnItemFocus(View view, boolean hasFocus, int position);
    }

    interface OnKeyEventListener{
        boolean OnKeyEvent(View view, int keycode, KeyEvent keyEvent, int position);
    }
}
