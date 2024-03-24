package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.doan_mobileapp.R;

import java.util.ArrayList;

import Activity.DangNhapActivity;
import Activity.DanhMucActivity;
import model.Category;
import model.SanPham;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    ArrayList<Category> items;
    Context context;
    public CategoryAdapter(ArrayList<Category> items){
        this.items=items;
    }
    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder holder, int position) {
        holder.txtCate.setText(items.get(position).getTen());
        switch (position){
            case 0:{
                holder.imgCate.setBackgroundResource(R.drawable.cate_0_background);
                break;
            }
            case 1:{
                holder.imgCate.setBackgroundResource(R.drawable.cate_1_background);
                break;
            }
            case 2:{
                holder.imgCate.setBackgroundResource(R.drawable.cate_2_background);
                break;
            }
            case 3:{
                holder.imgCate.setBackgroundResource(R.drawable.cate_3_background);
                break;
            }
            case 4:{
                holder.imgCate.setBackgroundResource(R.drawable.cate_4_background);
                break;
            }
            case 5:{
                holder.imgCate.setBackgroundResource(R.drawable.cate_5_background);
                break;
            }
            case 6:{
                holder.imgCate.setBackgroundResource(R.drawable.cate_6_background);
                break;
            }
            case 7:{
                holder.imgCate.setBackgroundResource(R.drawable.cate_7_background);
                break;
            }
        }
        int drawableResourceId=context.getResources().getIdentifier(items.get(position).getHinh(),
                "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.imgCate);

        holder.categoryitems.setOnClickListener(v -> {
            Intent it = new Intent(context, DanhMucActivity.class);
            it.putExtra("CategoryTen",items.get(position).getTen());
            it.putExtra("CategoryID",items.get(position).getId());
            context.startActivity(it);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView txtCate;
        ImageView imgCate;
        CardView categoryitems;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtCate = itemView.findViewById(R.id.txtCate);
            imgCate = itemView.findViewById(R.id.imgCate);
            categoryitems = itemView.findViewById(R.id.categoryitems);
        }
    }
}
