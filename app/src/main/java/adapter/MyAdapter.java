package adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import barcode.com.practice.R;
import myinterface.RecyclerViewClickListener;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    List<String> nameList;
    Context context;
    RecyclerViewClickListener recyclerViewClickListener;

    public MyAdapter(List<String > nameList, Context context, RecyclerViewClickListener recyclerViewClickListener){
        this.nameList = nameList;
        this.context = context;
        this.recyclerViewClickListener = recyclerViewClickListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_name,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final String name = nameList.get(position);
        holder.tvName.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewClickListener.onClickListener(name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName;

        public ViewHolder(View itemView){
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_adapter_text);
        }

    }

}
