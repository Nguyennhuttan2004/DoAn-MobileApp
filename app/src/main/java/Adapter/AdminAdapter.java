package Adapter;

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

import java.util.ArrayList;

import Activity.interfaceTT.IClickItemAM;
import model.Admin;
import model.ThanhToan;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.ViewHolder> {
    Activity context;
    ArrayList<Admin> arrAdmin;
    IClickItemAM onClickItemDM;

    public AdminAdapter(Activity context, ArrayList<Admin> arrAdmin, IClickItemAM onClickItemDM) {
        this.context = context;
        this.arrAdmin = arrAdmin;
        this.onClickItemDM = onClickItemDM;
    }

    @NonNull
    @Override
    public AdminAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewAdmin=layoutInflater.inflate(R.layout.lv_item,parent,false);
        ViewHolder viewHolderAM=new AdminAdapter.ViewHolder(viewAdmin);
        return viewHolderAM;
    }

    @Override
    public void onBindViewHolder(@NonNull AdminAdapter.ViewHolder holder, int position) {
        Admin am=arrAdmin.get(position);
        holder.itemImg.setImageResource(am.getHinh());
        holder.itemTitle.setText(am.getTenql());
        holder.layoutitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemDM.onClickItemAM(am);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrAdmin.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
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
