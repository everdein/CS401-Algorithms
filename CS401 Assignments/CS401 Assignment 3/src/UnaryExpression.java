//              :   General Layout:
//              :   Query (interface) -> And, Or, Not, UnaryExpression
//              :       -execute, getField
//              :   UnaryExpression (abstract) -> Equal, GT, GTE, LT, LTE, NotEqual
//              :       -execute, field, value, getField

public abstract class UnaryExpression<T extends Comparable<T>> implements Query<T> {

    protected String field;
    protected T value;

    public UnaryExpression(String field, T value){
        this.field = field;
        this.value = value;
    }
}
