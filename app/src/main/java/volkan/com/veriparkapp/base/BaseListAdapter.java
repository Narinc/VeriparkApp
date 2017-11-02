package volkan.com.veriparkapp.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volkan on 31.10.2017 22:39.
 */

public abstract class BaseListAdapter<T> extends BaseAdapter {
    protected LayoutInflater inflater;
    protected Context context;
    protected List<T> objectsList;

    public BaseListAdapter(Context context) {
        this(context, new ArrayList<T>());
    }

    public BaseListAdapter(Context context, List<T> objectsList) {
        this.context = context;
        this.objectsList = objectsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objectsList.size();
    }

    @Override
    public T getItem(int position) {
        return objectsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateList(List<T> newData) {
        objectsList = newData;
        notifyDataSetChanged();
    }

    public void add(T item) {
        objectsList.add(item);
        notifyDataSetChanged();
    }

    public void setItem(int index, T item) {
        objectsList.set(index, item);
    }

    public int getIndex(T item) {
        return objectsList.indexOf(item);
    }

    public void addList(List<T> items) {
        objectsList.addAll(0, items);
        notifyDataSetChanged();
    }

    public List<T> getList() {
        return objectsList;
    }

    public void remove(T item) {
        objectsList.remove(item);
        notifyDataSetChanged();
    }

    public void removeAll() {
        objectsList.clear();
        notifyDataSetChanged();
    }
}
