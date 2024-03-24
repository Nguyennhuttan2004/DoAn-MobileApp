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
import model.SanPham;


public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.viewholder> {
    ArrayList<SanPham> items;
    Context context;
    public DanhMucAdapter(ArrayList<SanPham> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public DanhMucAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_danhmuc,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhMucAdapter.viewholder holder, int position) {
        holder.txtDMtitle.setText(items.get(position).getTen());
        holder.txtDMgia.setText("$"+items.get(position).getGia());
        //holder.txtDMstar.setText(""+items.get(position).getStar());

        Glide.with(context)
                .load(items.get(position).getHinh())
                .transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.imgDM);

        holder.itemView.setOnClickListener(v -> {
            Intent it = new Intent(context, ChiTietActivity.class);
            it.putExtra("sp",items.get(position));
            context.startActivity(it);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView txtDMtitle,txtDMgia;
        ImageView imgDM;
        //CardView danhmucitem;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtDMtitle = itemView.findViewById(R.id.txtDMtitle);
            txtDMgia = itemView.findViewById(R.id.txtDMgia);
            imgDM = itemView.findViewById(R.id.imgDM);
            //danhmucitem = itemView.findViewById(R.id.danhmucitem);
        }

    }
}
