package Report_Generator;

import java.util.List;

public class ComplexReportGenerator extends AbstractReportGenerator{

    @Override
    public boolean customerReportCondition(Customer customer) {
        if(customer.getName()==null){
            return false;
        }
        else{
            return true;
        }
    }
    @Override
    public String getReportHeader(List<Customer> customers) {
        for(int i=0; i<customers.size();i++){
            if(customers.get(i).getPoint()<100){
                customers.remove(i);
            }
        }
        String msg="고객의 수 : "+customers.size()+" 명 입니다\n";
        return msg;
    }
    @Override
    public String getReportForCustomer(Customer customer) {
        String msg=customer.getName()+" : "+customer.getPoint()+"\n";
        return msg;
    }
    @Override
    public String getReportFooter(List<Customer> customers){
        int Points=0;
        for(Customer p : customers){
            Points+=p.getPoint();
        }
        String msg="점수 합계 : "+Points+"\n";
        return msg;
    }

}
