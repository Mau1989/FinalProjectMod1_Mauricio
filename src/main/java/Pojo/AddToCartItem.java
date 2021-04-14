package Pojo;

public class AddToCartItem {
    private String item;

    public AddToCartItem(String _item){
        setItem(_item);
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
