package com.example.codekreiger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    public SliderAdapter(Context context){

        this.mContext=context;
    }
    //Arrays
    public int[] slide_images={
            R.drawable.paanda,
            R.drawable.pandaa,
            R.drawable.pandaaa
    };

    public String[] slide_descs={
            " The questions are in the form of code snippets of C language." +
                    "  Each code snippet will give you instructions that will help you in" +
                    " traversing the path that leads you from one checkpoint to another.",
            " When you reach the checkpoint[HOPEFULLY:)]" +
                    " you will see a QR CODE ," +
                    " click on the submit button at the end of question" +
                    " that will take you to a screen where you have to scan the QR CODE.",
            "If the checkpoint is correct the QR CODE will be scanned successfully" +
                    "        and you will next see a dialog box  where you have to answer the question asked at the end of code."
    };
    @Override
    public int getCount(){
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(View view,Object o){
        return view==(RelativeLayout)o;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){
        mLayoutInflater=(LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view=mLayoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=(ImageView)view.findViewById(R.id.slideImage);

        TextView slideDescription=(TextView)view.findViewById(R.id.slide_descs);

        slideImageView.setImageResource(slide_images[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
     container.removeView((RelativeLayout)object);

    }
}
