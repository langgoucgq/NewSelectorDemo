package com.example.caikaiyang.newselectordemo.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.caikaiyang.newselectordemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caikaiyang on 2017/8/5.
 */

public class NewSelecterView extends LinearLayout {


    private Context context;
    private List<String> list;
    private int text_color;
    private int text_color_selecter;
    private int text_padding_left;
    private int text_padding_right;
    private int text_padding_top;
    private int text_padding_bottom;
    private int text_size;
    private List<TextView> textViews;

    public NewSelecterView(Context context) {
        super(context);
    }

    public NewSelecterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.NewSelecterView);
        if(array!=null){
            for(int i=0;i<array.length();i++){
                int attr = array.getIndex(i);
                switch (attr){
                    case R.styleable.NewSelecterView_text_color:
                        text_color=array.getColor(R.styleable.NewSelecterView_text_color, Color.BLACK);
                        break;
                    case R.styleable.NewSelecterView_text_color_select:
                        text_color_selecter=array.getColor(R.styleable.NewSelecterView_text_color_select,Color.BLACK);
                        break;
                    case R.styleable.NewSelecterView_text_padding_bottom:
                        text_padding_bottom= (int) array.getDimension(R.styleable.NewSelecterView_text_padding_bottom,0);
                        break;
                    case R.styleable.NewSelecterView_text_padding_left:
                        text_padding_left= (int) array.getDimension(R.styleable.NewSelecterView_text_padding_left,0);
                        break;
                    case R.styleable.NewSelecterView_text_padding_right:
                        text_padding_right= (int) array.getDimension(R.styleable.NewSelecterView_text_padding_right,0);
                        break;
                    case R.styleable.NewSelecterView_text_padding_top:
                        text_padding_top= (int) array.getDimension(R.styleable.NewSelecterView_text_padding_top,0);
                        break;
                    case R.styleable.NewSelecterView_text_size:
                        text_size= (int) array.getDimension(R.styleable.NewSelecterView_text_size,14f);
                        break;

                }


            }
            array.recycle();


        }



    }

    public NewSelecterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init(){
        list=new ArrayList<>();
        textViews=new ArrayList<>();
    }


    public void setTopic(List<String> list){
        this.list=list;
        for(int i=0;i<list.size();i++){
            TextView textView=new TextView(context);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,text_size);
            textView.setText(list.get(i));
            textView.setTextColor(text_color);
            textView.setPadding(text_padding_left,text_padding_top,text_padding_right,text_padding_bottom);
            addView(textView);
            final int finalI = i;
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedChange(finalI);
                    
                }
            });
            textViews.add(textView);
        }
        selectedChange(0);

    }


    public void selectedChange(int position){
        for(TextView textView:textViews){
            textView.setTextColor(text_color);
        }
        textViews.get(position).setTextColor(text_color_selecter);
    }

}
