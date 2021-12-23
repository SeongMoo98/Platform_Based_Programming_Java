package com.cafe.order;

import java.util.ArrayList;
import java.util.List;
import com.cafe.order.OrderRepository;

public class Order {
    //OrderItem을 저장하는 List
    private List<OrderItem> items=new ArrayList<OrderItem>();
    //주문수, 주문번호
    private static int orderCounter = 1;
    private int orderNo=0;
    //Pickup
    private Order.PickUp delivery;

    //static interface를 Order class에

    public static interface PickUp{
        public abstract void handle(Order o);
    }

    public Order(){
        delivery=null;
    }

    //주문번호 return
    public int getOrderNo(){
        return this.orderNo;
    }
    public void setOrderNo(int orderNo){
        this.orderNo=orderNo;
    }

    //현재 주문수 return
    public static int getOrderCounter(){
        return orderCounter;
    }
    public void setPickUp(PickUp pick){
        this.delivery=pick;
    }

    //List에 원소추가
    public void addItem(OrderItem OI) {
        items.add(OI);
        orderCounter++;
    }

    public void completed(){
        delivery.handle(this);
        OrderRepository.remove();
        orderCounter--;
    }


    @Override
    public String toString(){
        String msg="[";
        for(int i=0; i<items.size();i++){
            if(i==items.size()-1){
                msg+=items.get(i).toString();
            }
            else{
                msg+=items.get(i).toString()+", ";
            }
        }
        msg += "]";
        return msg;
    }
}
