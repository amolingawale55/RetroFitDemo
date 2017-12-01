package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.retrofitdemo.R;

import java.util.List;

import Models.Item;
import Models.SOAnswersResponse;

/**
 * Created by admin on 12/1/2017.
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {

    Item item=new Item();
    private Context context;
    private List<Item> items;
    public static String TAG="DemoAdapter";
    public DemoAdapter(Context context, List<Item> itemsarraylist) {
        this.context=context;
        this.items=itemsarraylist;
    }

    @Override
    public DemoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_itom,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DemoAdapter.ViewHolder holder, int position) {


        Item itemmodels=new Item();

        itemmodels=items.get(position);
        String name=itemmodels.getOwner().getDisplayName();

        Log.d(TAG,"name="+name);
        holder.txtname.setText(name);


//        SOAnswersResponse soAnswersResponse=new SOAnswersResponse();
//        String qoutamax=soAnswersResponse.getQuotaMax().toString();
//
//        holder.txtid.setText(""+qoutamax);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtname,txtid;
        public ViewHolder(View itemView) {
            super(itemView);

            txtname=itemView.findViewById(R.id.txtname);
            txtid=itemView.findViewById(R.id.txtid);


        }
    }
}
