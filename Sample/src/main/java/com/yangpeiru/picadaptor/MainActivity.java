package com.yangpeiru.picadaptor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.yangpeiru.picadaptorlibrary.PicAdaptorLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity
{

    int[] icon = new int[]{R.mipmap.recommend_40,
                           R.mipmap.recommend_41,
                           R.mipmap.recommend_42,
                           R.mipmap.recommend_43,
                           R.mipmap.recommend_44,
                           R.mipmap.recommend_45,
                           R.mipmap.recommend_46,
                           R.mipmap.recommend_47,
                           R.mipmap.recommend_48,
                           R.mipmap.recommend_49,
                           R.mipmap.recommend_50,};
    private ImageView     mIvPic;
    private List<Integer> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < icon.length; i++) {
            mDatas.add(icon[i]);
        }
        Log.d("Log", "" + mDatas);

        //动态的添加view
        ListView     mListView = new ListView(MainActivity.this);
        PicAdaptorLayout.LayoutParams layoutParams = new PicAdaptorLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                                                                       LinearLayout.LayoutParams.MATCH_PARENT);
        addContentView(mListView, layoutParams);
        ImageAdapter adapter   = new ImageAdapter();
        mListView.setAdapter(adapter);
        Log.d("Log", "开始加载...");
    }

    public class ImageAdapter
            extends BaseAdapter
    {
        @Override
        public int getCount() {
            if (mDatas != null) {
                return mDatas.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mDatas != null) {
                return mDatas.get(position);
            }
            return 0;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            Log.d("Log", "1");
            if (convertView == null) {
                convertView = View.inflate(MainActivity.this, R.layout.activity_main, null);
                holder = new ViewHolder();
                convertView.setTag(holder);
                holder.mIv = (ImageView) convertView.findViewById(R.id.main_iv_pic);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Integer id = mDatas.get(position);
            Log.d("Log", "id:" + id);
            holder.mIv.setImageResource(id);

            return convertView;
        }
    }

    private class ViewHolder {
        ImageView mIv;
    }
}
