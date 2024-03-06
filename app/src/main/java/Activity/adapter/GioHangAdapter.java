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

import java.util.ArrayList;

import Activity.model.GioHang;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.ViewHolder>{
    Activity context;
    ArrayList<GioHang>arr_giohang;
    CardView layoutgiohang;
    public GioHangAdapter(Activity context,ArrayList<GioHang>arr_giohang){
        this.context=context;
        this.arr_giohang=arr_giohang;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View viewgiohang=layoutInflater.inflate(R.layout.giohang_item,parent,false);
        ViewHolder viewHolderGH=new ViewHolder(viewgiohang);
        return viewHolderGH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GioHang gh=arr_giohang.get(position);
        holder.itemgiohang_image.setImageResource(gh.getHinhsp());
        holder.itemgiohang_tensp.setText(gh.getTensp());
        holder.itemgiohang_soluong.setText(gh.getSoluongsp());
        holder.itemgiohang_giatien.setText(gh.getGiasp());
    }

    @Override
    public int getItemCount() {
        return arr_giohang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemgiohang_tensp,itemgiohang_giatien,itemgiohang_soluong;
        ImageView itemgiohang_image;
        CardView layoutgiohang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                layoutgiohang = itemView.findViewById(R.id.layoutgiohang);
                itemgiohang_image=itemView.findViewById(R.id.itemgiohang_image);
                itemgiohang_giatien=itemView.findViewById(R.id.itemgiohang_giatien);
                itemgiohang_soluong=itemView.findViewById(R.id.itemgiohang_soluong);
                itemgiohang_tensp=itemView.findViewById(R.id.itemgiohang_tensp);
        }
    }


}



