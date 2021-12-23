package Lambda_Expression.Function_T_R;

@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}
