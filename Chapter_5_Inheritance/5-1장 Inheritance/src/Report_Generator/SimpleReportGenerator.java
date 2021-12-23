package Report_Generator;

import java.util.List;

public class SimpleReportGenerator extends AbstractReportGenerator {
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
        String msg="고객의 수 : "+customers.size()+" 명\n";
        return msg;
    }
    @Override
    public String getReportForCustomer(Customer customer) {
        String msg=customer.getName()+" : "+customer.getPoint()+"\n";
        return msg;
    }

    @Override
    public String getReportFooter(List<Customer> customers) {
        return null;
    }
}
