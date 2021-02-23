package generictypes;

//public class MyStringBox {
//   private String s;
//
//   public void add(String s) {
//      this.s = s;
//   }
//
//   public S get() {
//      return s;
//   }
//}


//My generic box class - weeeheyyyyyy
public class Box<T> {
   private T t;

   public void add(T t) {
      this.t = t;
   }

   public T get() {
      return t;
   }
}