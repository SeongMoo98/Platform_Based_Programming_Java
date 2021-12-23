package Decision;

public class If_5 {
    public static void main(String [] args){
        final String message="Java 8 !";
        for(final char aChar :message.toCharArray()){
            final StringBuilder sb= new StringBuilder();
            sb.append(aChar+" : ");
            if(Character.isDigit(aChar)){
                sb.append("digit.");
            }
            else if(Character.isLowerCase(aChar)){
                sb.append("lowercase.");
            }
            else if(Character.isUpperCase(aChar)){
                sb.append("uppercase.");
            }
            else if(Character.isWhitespace(aChar)){
                sb.append("whitespace.");
            }
            else{
                sb.append("neither alphanumeric nor whitespace.");
            }
            System.out.println(sb.toString());
        }
    }
}
