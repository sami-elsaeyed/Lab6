/*Grade Calculator for students in CISC 3130
 * Semester has 8 homeworks each worth 6 points. 6 Labs each worth 2 points.
 * Two midterms that equal 10 points and a 20 point final 
 * Program shows score letter grade and how much is required in the remaining assignents to 
 * achieve each letter grade above the students total so far.
 */
import java.util.*;
public class Student{
  //each student has three singley linked lists one for each type of assignment
 public Assignment hw;
 public Assignment lab;
 public Assignment exam;
 //boolean for keeping track who has taken the final
 public Boolean taken=false;
 public int finalg;
 //constructor
 public Student(){
   hw=null;
   lab=null;
   exam=null;
 }
   public boolean isEmpty(Assignment head){
    return(head==null);  
  }//insert first mehtod for each linkedlist
  public void insertHW(Assignment s){
    if(isEmpty(hw))
      hw=s;
    s.next=hw;
    hw=s;
  }//insert first method for each linked list
  public void insertLab(Assignment s){
    if(isEmpty(lab))
      lab=s;
    s.next=lab;
    lab=s;
  }// insert first method for each linked list
  public void insertExam(Assignment s){
    if(isEmpty(exam))
      exam=s;
    s.next=exam;
    exam=s;
  }//method grade figures out grade and how much is left for each letter grade above the total so far
  public void grade(int h,int l,int e,int f){ 
    int total=0;
    //three single for loops to ad up data from each linked list;
    for(int i=0;i<h;i++){
      total+=hw.grade;
      hw=hw.next;
    }
    for(int i=0;i<l;i++){
      total+=lab.grade;
      lab=lab.next;
    }
    for(int i=0;i<e;i++){
      total+=exam.grade;
      exam=exam.next;
    }//the projection is done only for thos ewho havent taken the final those who took the final are given a final grade and letter grade.
    if(taken==true){
      total+=f;
      if(total>=90){
        System.out.println("Your grade is "+total+" or an A");
      return;}
      if(total>=80){
        System.out.println("Your grade is "+total+" or a B");
       return;}
      if(total>=70){
      System.out.println("Your grade is "+total+" or a C");
      return;}
      if(total>=60){
      System.out.println("Your grade is "+total+" or a D");
      return;}
        System.out.println("Your grade is "+total+" or a F");
      
    }
      
      else{
        //projection for all students using the program before finals are taken
      if(total<60)
        System.out.println("You need at least "+(60-total)+" points in your next "+(17-(h+l+e))+" assignments and final exam to get a D or better.");
      if(total<=69)
        System.out.println("You need at least "+(70-total)+" points in your next "+(17-(h+l+e))+" assignments and final exam to get a C or better.");
      if(total<=79)
        System.out.println("You need at least "+(80-total)+" points in your next "+(17-(h+l+e))+" assignments and final exam to get a B or better.");
      if(total<=89)
        System.out.println("You need at least "+(90-total)+" points in your next "+(17-(h+l+e))+" assignments and final exam to get a A ."); 
    }
    return;                                                                 
  }      

  public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    Student model=new Student();
    int x;
    int h=0;
    System.out.println("Please enter Homework grade");
    x=scan.nextInt();
    //three while loops that take in input from user. filling up the three linkedlist. -1 is used to indicate end of entry for that assignment type
    while(x!=-1&&h<8){
      if(x<=6&&x>=0){
        Assignment s=new Assignment(x);
        model.insertHW(s);
        h++;}
      else
        System.out.println("Enter a valid Homework grade");
      if(h==8){
        System.out.println("Thats all your homework assignemnts!");
        break;
      }
      System.out.println("Please enter Homework grade");
      x=scan.nextInt();
    }
    int y;
    int l=0;
    System.out.println("Please enter Lab grade");
    y=scan.nextInt();
    while(y!=-1&&l<6){
      if(y<=2&&y>=0){
        Assignment s=new Assignment(y);
        model.insertLab(s);
        l++;}
      else
        System.out.println("Enter a valid Lab grade");
      if(l==6){
        System.out.println("Thats all your Labs!");
        break;
      }
      System.out.println("Please enter Lab grade");
      y=scan.nextInt();
    }
    int z;
    int e=0;
    System.out.println("Please enter Exam grade");
    z=scan.nextInt();
    while(z!=-1&&e<2){
      if(z<=10&&z>=0){
        Assignment s=new Assignment(z);
        model.insertExam(s);
        e++;}
      else
        System.out.println("Enter a valid Exam grade");
      if(e==2){
        System.out.println("Thats all your Exams!");
        break;
      }
      System.out.println("Please enter Exam grade");
      z=scan.nextInt();
    }
    //input final grade if final is taken change boolean.
    System.out.println("If you ave taken the final enter your grade if not enter '-1'");
    int f = scan.nextInt();
    if(f!=-1)
      model.taken=true;
    model.grade(h,l,e,f);   
  }
  
 
}