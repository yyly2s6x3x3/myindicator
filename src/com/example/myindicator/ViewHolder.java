package com.example.myindicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressLint("NewApi")
public class ViewHolder {
	
	private SparseArray<View> views;
	private int mPosition;
	private View mConvertView;

	public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
		this.mPosition=position;
		this.views=new SparseArray<View>();
		mConvertView=LayoutInflater.from(context).inflate(layoutId, parent,false);
		mConvertView.setTag(this);
	}

	public static ViewHolder get(Context context, View convertView,ViewGroup parent, int layoutId, int position) {
		if(convertView==null){
			return new ViewHolder(context, parent, layoutId, position);
		}else{
			ViewHolder holder=(ViewHolder) convertView.getTag();
			holder.mPosition=position;
			return holder;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T extends View> T getView(int viewId){
		View view=views.get(viewId);
		if(view==null){
			view=mConvertView.findViewById(viewId);
			views.put(viewId, view);
		}
		return (T) view;
	}
	
	public View getConvertView(){
		return mConvertView;
	}
	
	public int getPosition(){
		return mPosition;
	}
	
	public ViewHolder setVisible(int viewId,int visible){
		getView(viewId).setVisibility(visible);
		return this;
	}
	
	public ViewHolder setParams(int viewId,LayoutParams params){
		getView(viewId).setLayoutParams(params);
		return this;
	}
	
	public ViewHolder setText(int viewId,String text,String colorString){
		TextView textView=getView(viewId);
		textView.setText(text);
		if(colorString!=null&&colorString.length()>0){
			try {
				textView.setTextColor(Color.parseColor(colorString));
			} catch (Exception e) {
			}
		}
		return this;
	}
	
	public ViewHolder setImageResource(int viewId,int resId){
		ImageView imageView=getView(viewId);
		imageView.setImageResource(resId);
		return this;
	}
	
	public ViewHolder setImageBitmap(int viewId,Bitmap bitmap){
		ImageView imageView=getView(viewId);
		imageView.setImageBitmap(bitmap);
		return this;
	}
	
	public ViewHolder setImageUrl(int viewId,String url){
		ImageView imageView=getView(viewId);
		//ImageLoader.getInstance().displayImage(url,imageView);
		return this;
	}
	
	public ViewHolder setButtonText(int viewId,String text){
		Button button=getView(viewId);
		button.setText(text);
		return this;
	}
	
	public ViewHolder setCheckBox(int viewId,boolean checked){
		CheckBox checkBox=getView(viewId);
		checkBox.setChecked(checked);
		return this;
	}
	
	public ViewHolder setImageButtonResource(int viewId,int resId){
		ImageButton button=getView(viewId);
		button.setImageResource(resId);
		return this;
	}
	
	public ViewHolder setmageButtonBitmap(int viewId,Bitmap bitmap){
		ImageButton button=getView(viewId);
		button.setImageBitmap(bitmap);
		return this;
	}
	
	public ViewHolder setmageButtonDrawable(int viewId,Drawable drawable){
		ImageButton button=getView(viewId);
		button.setImageDrawable(drawable);
		return this;
	}
	
	public ViewHolder setRadioButtonChecked(int viewId,boolean checked){
		RadioButton button=getView(viewId);
		button.setChecked(checked);
		return this;
	}
	
	public ViewHolder setSpinner(int viewId,int progress){
		ProgressBar progressBar=getView(viewId);
		progressBar.setProgress(progress);
		return this;
	}
}
