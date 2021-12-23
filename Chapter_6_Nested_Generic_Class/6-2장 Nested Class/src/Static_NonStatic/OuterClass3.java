package Static_NonStatic;


public class OuterClass3 {
    String outerField = "Outer field";
    static String staticOuterField = "Static Outer Field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        //parameter로 OuterClass를 준다 - static 때문에
        void accessMembers(OuterClass3 outer) {
            //Compile error - static에서 nonstatic을 참조할수없다
            //객체내의 nonstatic 참조
            //System.out.println(outerField);
            System.out.println(outer.outerField);
            //static멤버는 바로 참조가능
            System.out.println(staticOuterField);
        }
    }
    public static void main(String[] args) {
        //Non-Static InnerClass
        //OuterClass에서 객체 생성후 접근해야한다
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass3 outerObject = new OuterClass3();
        OuterClass3.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);

        System.out.println("\nTop-level class:");
        System.out.println("--------------------");

        TopLevelClass topLevelObject = new TopLevelClass();
        topLevelObject.accessMembers(outerObject);
    }

}
class TopLevelClass {
    void accessMembers(OuterClass3 outer) {
        // Compiler error: Cannot make a static reference to the non-static
        // field OuterClass.outerField
        // System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        System.out.println(OuterClass3.staticOuterField);
    }
}



