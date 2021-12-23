package com.cafe.order;

import com.cafe.menu.*;
import java.util.Scanner;
enum Command{ ADD,COST,SIZE,PRINT,QUIT,INVALID };

public class OrderTest {
    private static Order order = new Order();
    public static void main(String[] args){
        final Scanner scanner=new Scanner(System.in);
        while(true){
            final Command cmd = getCommand(scanner);
            if(cmd == Command.QUIT){
                System.out.println("Bye");
                break;
            }
            if(cmd==Command.INVALID){
                System.out.println("Invalid Operation!");
                continue;
            }

            switch(cmd){
                case ADD: {
                    final OrderItem item = createOrderItem(scanner);
                    System.out.println(item);
                    order.add(item);
                    break;
                }
                case COST:
                    System.out.printf("%,d%n",order.cost());
                    break;
                case SIZE: {
                    final String name=scanner.next();
                    final String size=scanner.next();
                    if(!order.setSize(name,size)) {
                        System.out.println("The size does not supported!");
                    }
                    break;
                }
                case PRINT:
                    order.print(); break;
                default: break;
            }
        }
        scanner.close();
    }

    private static Command getCommand(Scanner scanner) {
        System.out.print("Enter Command String!");
        final String operation = scanner.next();
        Command kind;
        try {
            kind=Command.valueOf(operation.toUpperCase());
        }
        catch(IllegalArgumentException e){
            kind=Command.INVALID;
        }
        return kind;
    }

    private static OrderItem createOrderItem(final Scanner scanner){
        final String type = scanner.next();
        final String name = scanner.next();
        final int quantity = scanner.nextInt();

        Beverage beverage=null;
        if("Coffee".equals(type)){
            beverage=new Coffee(name);
        }
        else if("Blended".equals(type)){
            beverage=new Blended(name);
        }
        else if("Teavana".equals(type)){
            beverage=new Teavana(name);
        }
        return new OrderItem(beverage,quantity);
    }
}


