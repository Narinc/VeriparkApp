package volkan.com.veriparkapp.ui.indexlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import volkan.com.veriparkapp.R;
import volkan.com.veriparkapp.base.BaseListAdapter;
import volkan.com.veriparkapp.data.model.stock_indexes_info.response.StockandIndex;
import volkan.com.veriparkapp.ui.ActivityEvents;

/**
 * Created by volkan on 02.11.2017 02:04.
 */

public class IndexListAdapter extends BaseListAdapter<StockandIndex> {

    private final IndexListScreen.View indexView;

    public IndexListAdapter(Context context, IndexListScreen.View indexView, List<StockandIndex> objectsList) {
        super(context, objectsList);
        this.indexView = indexView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        final StockandIndex item = getItem(i);

        if (view == null) {
            view = inflater.inflate(R.layout.item_index, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (item.getDifference() > 0) {
            holder.ivStatus.setImageResource(R.drawable.arrow_up);
        } else holder.ivStatus.setImageResource(R.drawable.sort_down);

        holder.tvSymbol.setText(item.getSymbol());
        holder.tvPrice.setText(String.valueOf(item.getPrice()).concat(" TL"));
        holder.tvDifference.setText(String.valueOf(item.getDifference()).concat(" %"));
        holder.tvVolume.setText(String.valueOf(item.getVolume()));
        holder.tvBuying.setText(String.valueOf(item.getBuying()));
        holder.tvSelling.setText(String.valueOf(item.getSelling()));

        Date date = new Date(item.getHour());
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateFormatted = formatter.format(date);
        holder.tvHour.setText(dateFormatted);

        holder.tvPrice.setText(String.valueOf(item.getDayPeakPrice()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityEvents activityEvents = (ActivityEvents) indexView.getActivity();
                activityEvents.showDetail(item);
            }
        });

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.iv_status)
        ImageView ivStatus;
        @BindView(R.id.tv_symbol)
        TextView tvSymbol;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_difference)
        TextView tvDifference;
        @BindView(R.id.tv_volume)
        TextView tvVolume;
        @BindView(R.id.tv_buying)
        TextView tvBuying;
        @BindView(R.id.tv_selling)
        TextView tvSelling;
        @BindView(R.id.tv_hour)
        TextView tvHour;
        @BindView(R.id.tv_peak_price)
        TextView tvPeakPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
