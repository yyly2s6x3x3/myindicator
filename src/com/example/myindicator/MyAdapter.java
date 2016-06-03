package com.example.myindicator;

import java.util.List;

import android.content.Context;

public class MyAdapter extends CommonAdapter<String>{

	public MyAdapter(Context context, List<String> datas, int layoutId) {
		super(context, datas, layoutId);
	}

	@Override
	public void convert(ViewHolder holder, String t) {
		holder.setText(R.id.textView1, t, "");
	}

}
