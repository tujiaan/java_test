public class Father {
    static{
        System.out.println("father static method");
    }
    Father() {
        System.out.println("father's construct method");
    }
    Father(String name){
        System.out.println("father's paratems construct"+name);
    }
      protected void play(){
        System.out.println("this is father's play method");
     }
}
