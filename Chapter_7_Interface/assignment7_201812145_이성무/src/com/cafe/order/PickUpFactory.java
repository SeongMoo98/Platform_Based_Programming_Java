package com.cafe.order;

public class PickUpFactory {

    //TakeOut Inner Classs
    class TakeOut implements Order.PickUp {
        public TakeOut(){

        }
        @Override
        public void handle(Order o) {
            System.out.println("---테이크 아웃 화면---");
            System.out.println("주문번호: "+o.getOrderNo());
            System.out.println("주문하신 음료가 준비 되었습니다!");
            System.out.println();
        }
    }
    //Order.PickUp은 Interface
    //return type을 Interface로 하고 TakeOut객체 반화
    public Order.PickUp makeTakeOut (){
        return new TakeOut();
    }

    //Delivery Inner Classs
    class Delivery implements Order.PickUp {
        private String address;
        // your code here
        Delivery(String address){
            this.address=address;
        }

        @Override
        public void handle(Order o) {
            System.out.println("---배달 관리 화면---");
            System.out.println("배달통으로 주문을 전달합니다!");
            System.out.println("배송주소: "+address);
            System.out.println();
        }
    }
    public Order.PickUp makeDelivery (String address){
        return new Delivery(address);
    }

    //DriveThru Inner Classs
    class DriveThru implements Order.PickUp {
        private String vehicleNumber;
        // your code here
        DriveThru(String vehicleNumber){

            this.vehicleNumber=vehicleNumber;
        }

        @Override
        public void handle(Order o) {
            System.out.println("---드라이브 쓰루 화면---");
            System.out.println("차량번호: "+vehicleNumber);
            System.out.println("주문하신 음료가 준비 되었습니다!");
            System.out.println();
        }
    }
    public Order.PickUp makeDriveThru (String vehicleNumber){
        return new DriveThru(vehicleNumber);
    }
}