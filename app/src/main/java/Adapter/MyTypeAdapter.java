package Adapter;

import android.content.Context;
import android.widget.TextView;

import com.wdcloud.recycleviewoftype.R;

import java.util.List;

import RecycleViewutil.BaseMultiItemQuickAdapter;
import RecycleViewutil.BaseViewHolder;
import bean.SectionMultipleItem;

/**
 * Created by Umbrella on 2019/2/26.
 */

public class MyTypeAdapter extends BaseMultiItemQuickAdapter<SectionMultipleItem, BaseViewHolder> {
    private Context context;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyTypeAdapter(Context context,List<SectionMultipleItem> data) {
        super(data);
        addItemType(0, R.layout.in_layout);
        addItemType(1, R.layout.out_layout);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param
     */
//    public MyTypeAdapter(int sectionHeadResId,List<User> data) {
//        super(sectionHeadResId,data);
//        addItemType(0, R.layout.in_layout);
//        addItemType(1, R.layout.out_layout);
//    }
    @Override
    protected void convert(BaseViewHolder helper, SectionMultipleItem item) {
        helper.addOnClickListener(R.id.in_img);
        helper.addOnClickListener(R.id.out_img);
        helper.addOnClickListener(R.id.in_text);
        helper.addOnClickListener(R.id.out_text);
        switch (helper.getItemViewType()) {
            case 0:
                TextView intext = helper.getView(R.id.in_text);
                intext.setText(item.getUser().getName());
                break;
            case 1:
                TextView outtext = helper.getView(R.id.out_text);
                outtext.setText(item.getUser().getName());
                break;
        }
    }
}
