package Query;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QueryString {
    private StringBuilder query = new StringBuilder();
    public QueryString(){}

    public synchronized void add(String name, String value){
        query.append('&');
        encode(name,value);
    }
    //Encoding
    //한글, 기호등등은 아스키 코드 값이 없으므로 Encoding된 값이 필요하다
    //URL class는 자동으로 Encoding하지 않기 때문에 Encoding을 따로 해주어야 한다(URLEncoder)
    //%와 16진수 값 사용
    public synchronized void encode(String name, String value){
        try{
            query.append(URLEncoder.encode(name,"UTF-8"));
            query.append('=');
            query.append(URLEncoder.encode(value,"UTF-8"));
        }
        catch(UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
    }

    public synchronized String getQuery(){
        return query.toString();
    }

    @Override
    public String toString(){
        return getQuery();
    }
}
