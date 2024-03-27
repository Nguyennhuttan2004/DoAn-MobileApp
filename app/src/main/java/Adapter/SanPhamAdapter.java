package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.doan_mobileapp.R;

import java.util.ArrayList;

import Activity.ChiTietActivity;
import Activity.EditActivity;
import model.SanPham;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder> {
    ArrayList<SanPham> items;
    Context context;

    public SanPhamAdapter(ArrayList<SanPham> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SanPhamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_bestfood,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamAdapter.ViewHolder holder, int position) {
        holder.txtSPtitle.setText(items.get(position).getTen());
        holder.txtSPgia.setText(items.get(position).getGia() + "đ");
        SanPham sp = items.get(position);
        Glide.with(context)
                .load(items.get(position).getHinh())
                .transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.imgSP);

        holder.itemView.setOnClickListener(v -> {
            Intent it = new Intent(context, EditActivity.class);
            it.putExtra("sp",items.get(position));
            context.startActivity(it);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtSPtitle,txtSPgia;
        ImageView imgSP;
        CardView bestfooditem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSPtitle = itemView.findViewById(R.id.txtSPtitle);
            txtSPgia = itemView.findViewById(R.id.txtSPgia);
            imgSP = itemView.findViewById(R.id.imgSP);
            bestfooditem = itemView.findViewById(R.id.bestfooditem);
        }
    }
}
