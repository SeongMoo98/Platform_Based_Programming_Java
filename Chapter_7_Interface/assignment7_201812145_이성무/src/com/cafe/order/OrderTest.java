package com.cafe.order;

import com.cafe.menu.*;

public class OrderTest {
    static PickUpFactory pickUpFactory = new PickUpFactory();
    private int num;
    public static void main(String[] args) {
        //OrderRepository(주문내역)과 add안의 함수에서 Order 생성 후 Beverage추가
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.add(makeOrderForDelivery());
        orderRepository.add(makeOrderForDriveThru());
        orderRepository.add(makeOrderForTakeOut());

        //주문내역이 더 있는지 없는지
        while(orderRepository.hasNext()) {
            //toString으로 주문번호와 주문내역 출력
            System.out.println(orderRepository);
            //Order의 Next를 확인
            Order order = orderRepository.next();
            if (order == null)
                break;
            //pickUp에 따라 배달 드라이으쓰루 출력이 다 다름
            order.completed();
        }
    }


    private static Order makeOrderForTakeOut() {
        Order order = new Order();
        Order.PickUp pickUp = pickUpFactory.makeTakeOut();
        order.setPickUp(pickUp);
        order.addItem(new OrderItem(new Teavana("Chamomile"), 1)) ;
        order.addItem(new OrderItem(new Coffee("Americano"), 1)) ;
        return order;
    }

    private static Order makeOrderForDriveThru() {
        Order order = new Order();
        Order.PickUp pickUp = pickUpFactory.makeDriveThru("001가0000");
        order.setPickUp(pickUp);
        order.addItem(new OrderItem(new Coffee("Americano"), 2)) ;
        return order;
    }

    private static Order makeOrderForDelivery() {
        Order order = new Order();
        Order.PickUp pickUp = pickUpFactory.makeDelivery("Pusan National University");
        order.setPickUp(pickUp);
        order.addItem(new OrderItem(new Blended("MangoBanana"), 1)) ;
        order.addItem(new OrderItem(new Coffee("Americano"), 1)) ;
        return order;
    }
}