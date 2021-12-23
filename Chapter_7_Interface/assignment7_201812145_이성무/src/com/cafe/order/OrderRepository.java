package com.cafe.order;

import java.util.ArrayList;
import java.util.List;

interface Iterator<T>{
    public boolean hasNext();
    public T next();
}
//Generic Interface를 <Order>로 특정지어서 했군
public class OrderRepository implements Iterator<Order>{

    private static List<Order> orders= new ArrayList<Order>();

    private static int iter=-1;
    private static int count=0;
    public void add(Order order){
        count++;
        order.setOrderNo(count);
        orders.add(order);
    }
    public boolean hasNext(){
        int index=iter+1;
        if(index>orders.size()-1)
            return false;
        else
            return true;
    }
    public Order next() {
        if(hasNext()){
            int retIndex=iter+1;
            iter++;
            return orders.get(retIndex);
        }
        else
            return null;
    }
    public List<Order> getOrders(){
        return orders;
    }
    public static void remove(){
        orders.remove(iter);
        iter--;
    }

    @Override
    public String toString(){
        String msg="--- 주문 관리자 화면 ---\n"+"현재 주문수는 총 "+orders.size()+" 입니다.\n\n\n"+"< 주문 내역 >\n\n";
        for(int i=0; i<orders.size(); i++){
            msg+="주문번호 : "+ orders.get(i).getOrderNo()+" - "+orders.get(i).toString()+"\n";
        }
        return msg;
    }
}
