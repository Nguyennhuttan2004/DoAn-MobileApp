package Helper;
import android.content.Context;
import android.widget.Toast;
import java.util.ArrayList;

import model.SanPham;


public class ManagmentGiohang {
    private Context context;
    private TinyDB tinyDB;

    public ManagmentGiohang(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertFood(SanPham item) {
        ArrayList<SanPham> listpop = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listpop.size(); i++) {
            if (listpop.get(i).getTen().equals(item.getTen())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if(existAlready){
            listpop.get(n).setNumInCart(item.getNumInCart());
        }else{
            listpop.add(item);
        }
        tinyDB.putListObject("CartList",listpop);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<SanPham> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public Double getTotalFee(){
        ArrayList<SanPham> listItem=getListCart();
        double fee=0;
        for (int i = 0; i < listItem.size(); i++) {
            fee=fee+(listItem.get(i).getGia()*listItem.get(i).getNumInCart());
        }
        return fee;
    }
    public void minusNumberItem(ArrayList<SanPham> listItem,int position,ChangeNumberItemsListener changeNumberItemsListener){
        if(listItem.get(position).getNumInCart()==1){
            listItem.remove(position);
        }else{
            listItem.get(position).setNumInCart(listItem.get(position).getNumInCart()-1);
        }
        tinyDB.putListObject("CartList",listItem);
        changeNumberItemsListener.change();
    }
    public  void plusNumberItem(ArrayList<SanPham> listItem,int position,ChangeNumberItemsListener changeNumberItemsListener){
        listItem.get(position).setNumInCart(listItem.get(position).getNumInCart()+1);
        tinyDB.putListObject("CartList",listItem);
        changeNumberItemsListener.change();
    }
}
