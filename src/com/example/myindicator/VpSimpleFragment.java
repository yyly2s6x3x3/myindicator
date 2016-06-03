package com.example.myindicator;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class VpSimpleFragment extends Fragment
{
	public static final String BUNDLE_TITLE = "title";
	public static final String BUNDLE_POSITION = "position";
	private String mTitle = "DefaultValue";
	private int position=0;
	private List<String> datas;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		Bundle arguments = getArguments();
		if (arguments != null)
		{
			mTitle = arguments.getString(BUNDLE_TITLE);
		}

		this.position=arguments.getInt(BUNDLE_POSITION, 0);
		View view=inflater.inflate(R.layout.fragment, container,false);
		ListView listView=(ListView) view.findViewById(R.id.listview);
		datas=new ArrayList<String>();
		for(int i=0;i<96;i++){
			datas.add("fragment:"+position+",position:"+i);
		}
		listView.setAdapter(new MyAdapter(getActivity(), datas, R.layout.item));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Toast.makeText(getActivity(), datas.get(position), Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}

	public static VpSimpleFragment newInstance(String title,int position)
	{
		Bundle bundle = new Bundle();
		bundle.putString(BUNDLE_TITLE, title);
		bundle.putInt(BUNDLE_POSITION, position);
		VpSimpleFragment fragment = new VpSimpleFragment();
		fragment.setArguments(bundle);
		return fragment;
	}
}
