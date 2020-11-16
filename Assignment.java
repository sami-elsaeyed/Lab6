public class Assignment{
  public int grade;
  public Assignment next;
  public Assignment(int n){
    grade=n;
  }
  public void displayNode()throws Exception{
    System.out.println(grade);
  }
  
  
}