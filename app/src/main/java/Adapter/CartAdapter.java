package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.doan_mobileapp.R;

import java.util.ArrayList;

import Helper.ChangeNumberItemsListener;
import Helper.ManagmentGiohang;
import model.SanPham;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewholder> {
    ArrayList<SanPham> list;
    private ManagmentGiohang managmentGiohang;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdapter(ArrayList<SanPham> list, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.list = list;
        managmentGiohang=new ManagmentGiohang(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);

        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.viewholder holder, int position) {
        holder.txtTitle.setText(list.get(position).getTen());
        holder.txtTotalPrice.setText(list.get(position).getGia() + "đ");
        holder.txtPrice.setText(list.get(position).getNumInCart()+ " * " +(
                list.get(position).getNumInCart()*list.get(position).getGia()));
        holder.txtNumberItem.setText(list.get(position).getNumInCart()+"");
        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getHinh())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);

        holder.btnPlusCart.setOnClickListener(v -> {
            managmentGiohang.plusNumberItem(list, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            });
        });
        holder.btnMinusCart.setOnClickListener(v -> {
            managmentGiohang.minusNumberItem(list, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            });
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtTotalPrice,btnPlusCart,btnMinusCart;
        ImageView pic;
        TextView txtPrice,txtNumberItem;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtTotalPrice=itemView.findViewById(R.id.txtTotalPrice);
            btnPlusCart=itemView.findViewById(R.id.btnPlusCart);
            btnMinusCart=itemView.findViewById(R.id.btnMinusCart);
            pic=itemView.findViewById(R.id.pic);
            txtPrice=itemView.findViewById(R.id.txtPrice);
            txtNumberItem=itemView.findViewById(R.id.txtNumberItem);
        }
    }
}
