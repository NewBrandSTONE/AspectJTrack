package me.young.autotrack.aspectj.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import me.young.autotrack.aspectj.R;

/**
 * <一句话简述功能>
 * <功能详细描述>
 *
 * @author O.z Young
 * @version 2020-05-20
 */
public class LcopHorTabView extends LinearLayout {

    private Context mContext;
    private RadioGroup mRadioGroup;
    private List<RadioButton> mRadioButtons = new ArrayList<>();

    public LcopHorTabView(Context context) {
        super(context);
        init(context, null);
    }

    public LcopHorTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LcopHorTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attr) {
        this.mContext = context;
        View rootView = LayoutInflater.from(context).inflate(R.layout.layout_lcop_hor_tab, this, true);
        mRadioGroup = rootView.findViewById(R.id.radio_group);
    }

    public void setTitles(List<String> titles) {
        // 创建LcopRadioButton
        createRadioButton(titles);
        // 添加RadioButton->RadioGroup中
        addRadioGroup();
    }

    private void addRadioGroup() {
        RadioGroup.LayoutParams groupLayoutParams = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        for (RadioButton radioButton : mRadioButtons) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMarginStart(50);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setBackgroundColor(Color.YELLOW);
            mRadioGroup.addView(radioButton, groupLayoutParams);
        }
    }

    private void createRadioButton(List<String> titles) {
        for (String title : titles) {
            RadioButton radioButton = new RadioButton(mContext);
            radioButton.setId(View.generateViewId());
            radioButton.setText(title);
            radioButton.setTextSize(50);
            radioButton.setTextColor(Color.BLACK);
            radioButton.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
            mRadioButtons.add(radioButton);
        }
    }

}
