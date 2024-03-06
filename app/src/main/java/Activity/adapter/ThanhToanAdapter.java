package Activity.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doan_mobileapp.R;
import Activity.interfaceTT.IClickItemTT;
import Activity.model.ThanhToan;

import java.util.ArrayList;

public class ThanhToanAdapter extends RecyclerView.Adapter<ThanhToanAdapter.ViewHolder>{
    Activity context;
    IClickItemTT onClickItemTT;
    ArrayList<ThanhToan> arrThanhtoan;
    public ThanhToanAdapter(Activity context, ArrayList<ThanhToan> arrThanhtoan,IClickItemTT onClickItemTT){
        this.context = context;
        this.arrThanhtoan = arrThanhtoan;
        this.onClickItemTT=onClickItemTT;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewThanhtoan=layoutInflater.inflate(R.layout.lv_item,parent,false);
        ViewHolder viewHolderTT=new ViewHolder(viewThanhtoan);
        return viewHolderTT;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThanhToan tt=arrThanhtoan.get(position);
        holder.itemImg.setImageResource(tt.getHinh());
        holder.itemTitle.setText(tt.getPhuongthuc());

        holder.layoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemTT.onClickItemTT(tt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrThanhtoan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImg;
        TextView itemTitle;
        CardView layoutitem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutitem=itemView.findViewById(R.id.layoutitem);
            itemImg = itemView.findViewById(R.id.itemImg);
            itemTitle = itemView.findViewById(R.id.itemTitle);
        }
    }
}
