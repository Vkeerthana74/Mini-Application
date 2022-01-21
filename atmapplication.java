import java.util.*;
public class atmapplication{
    static int arr[]={0,0,0,0} ;
    static Scanner s=new Scanner(System.in);
    static int a,b,c,fill,usramt,takeamt,amt2000,amt500,amt200,amt100,tm0,tm1,tm2,tm3,newtotal,depo;
    static String usr,pswrd,pswrdOld,pswraNew,n,usrcheck,passcheck;
    public static void display(int fill){    // This method is used to display Available Amount in ATM
        for(int i=0;i<arr.length;i++){
            if(i==0){
                System.out.println("100 -> "+arr[i]);
            }
            else if(i==1){
                System.out.println("200 -> "+arr[i]);
            }
            else if(i==2){
                System.out.println("500 -> "+arr[i]);
            }
            else if(i==3){
                System.out.println("2000 ->"+arr[i]);
            }           
        }
        tm0=arr[0]*100;
        tm1=arr[1]*200;
        tm2=arr[2]*500;
        tm3=arr[3]*2000;
        System.out.println("Available amount in 100's: "+tm0);
        System.out.println("Available amount in 200's: "+tm1);
        System.out.println("Available amount in 500's: "+tm2);
        System.out.println("Available amount in 2000's: "+tm3);
        fill=(arr[0]*100+arr[1]*200+arr[2]*500+arr[3]*2000)-takeamt;
        System.out.println(fill);
        m1(); 
    }
    public static void m1(){      //This method is to display the Main menu
        System.out.println("\t \t \t-----WELCOME YOU-----\n");
        System.out.println("\t \t \tPlease insert the card\n");
        System.out.println("1.Admin login");
        System.out.println("2.User login");
        System.out.println("3.Cancel");
        System.out.print("Enter your choice: ");
        a=s.nextInt();
        System.out.println("\033[2J");
        System.out.println("\033[H");
        switch(a){
            case 1:
            admin1();
            case 2:
            user();
            case 3:
            end();
        }
    }
    public static void admin1(){          // It is an Admin method which comprises of functionalities like Amount filling in ATM and checking Available amount ATM.
            System.out.println("Username: ");
            usr=s.next();
            System.out.println("Password: ");
            pswrd=s.next();
            if(usr.equals("admin")&&pswrd.equals("1234")){
                System.out.println("\033[2J");
                System.out.println("\033[H");
                System.out.println("\t \t \t-----WELCOME Admin-----\n");
                System.out.println("1.Amount filling");
                System.out.println("2.Available amount");
                System.out.println("3.Cancel");
                System.out.print("Enter your choice: ");
                b=s.nextInt();
                System.out.println("\033[2J");
                System.out.println("\033[H");
                switch(b){
                    case 1:
                    AdmAmtFill();
                    break;
                    case 2:
                    atmCapacity();
                }
                m1();
                admin1();          
            }
            else{
                System.out.println("\033[2J");
                System.out.println("\033[H");
                System.out.println("\t \t \tInvalid username");
                m1();
            }
        }
    public static void AdmAmtFill(){ // This admin method fills the respective notes in Rupee.
        if(b==1){
            System.out.println("Enter the amount needed to be added");
            System.out.print("Enter no of RS:2000 notes: "); 
            arr[0]=s.nextInt();
            System.out.print("Enter no of RS:500 notes: "); 
            arr[1]=s.nextInt();
            System.out.print("Enter no of RS:200 notes: "); 
            arr[2]=s.nextInt();
            System.out.print("Enter no of RS:100 notes: "); 
            arr[3]=s.nextInt();
            System.out.println("Amount added successfully");
            m1();
        }
    }
    public static void atmCapacity(){ // It displays the Amount Available in ATM.
        if(b==2){
            System.out.println("Amount available in Atm is");
            display(fill);   
            clr();
        }         
    }
    public static void end(){   // This Grrets User with a Message
        System.out.println("\t \t \tTransaction ended !!!");
        System.out.println("\t \t \tYou can take your card\n");
        m1();
    }
    public static void user(){    // This User method has User Credentials and User Functionalities
        String passcheck;          
            System.out.println("User ID: ");
            usr=s.next();
            System.out.println("4 digit PIN: ");
            pswrd=s.next();
            usrcheck=("user");
            passcheck="1234";
            if(usr.equals(usrcheck)&& pswrd.equals(passcheck)){
                System.out.println("\t \t \t-----WELCOME User-----\n");
                System.out.println("1.Withdraw");
                System.out.println("2.Available Balance");
                System.out.println("3.Green pin Generation");
                System.out.println("5.Direct Deposit");
                System.out.println("7.Cancel");
                c=s.nextInt();
                System.out.println("\033[2J");
                System.out.println("\033[H");
                switch(c){
                    case 1:
                    withdraw();
                    break;
                    case 2:
                    balance();
                    break;
                    case 3:
                    pin();
                    case 4:
                    //miniState();
                    break;
                    case 5:
                    deposit();
                    break;
                    case 6:
                    //transfer();
                    case 7:
                    end();            
                default:
                m1();
                 }
           }
           else{
            System.out.println("\033[2J");
            System.out.println("\033[H");
            System.out.println("\t \t \tInvalid username");
            m1();
        }
    }
    public static void pin(){    //This method is used for creating a new PIN for the User
        System.out.println("old");
        String old=s.next();
        System.out.println("new");
        String passcheck=s.next();
        System.out.println("new is "+passcheck);
    }
    public static int balance(){  // It helps in finding User's Account Balance
        int totalAmount=13700;
        newtotal=totalAmount-takeamt;
        fill=fill-takeamt;
        if(newtotal==13700){
            System.out.println("Available balance of the user : "+totalAmount);
        }
        else{
            System.out.println("Available balance of the user : "+newtotal);
        }
        return fill; 
    }
    public static void withdraw(){  // The amount that is being withdrawn is executed here!
        int totalAmount=13700;
        System.out.println("Enter amount needed to be withdrawn");
        takeamt=s.nextInt();
        if(fill<takeamt&&totalAmount<takeamt){
            System.out.println("-----Atm has insufficient amount now!-----");
        }
        else{
            System.out.println("Collect your cash");
        }
    }    
    public static void deposit(){  // Amount that is being deposited written in this method.
        int totalAmount=13700;
        System.out.println("Enter the deposit amount: ");
        depo=s.nextInt();
        totalAmount+=depo;
        System.out.println("Amount deposited successfully");
        System.out.println("Total amount: "+totalAmount);
        user();
    }
    public static void clr(){  //  This method clears the screen by using end method!
        System.out.println("\t \t \tPress enter to continue!!!");
        n=s.nextLine();
        if(n==" "){
            end();
        }
    }
    public static void main(String args[]){ // Main method of the program!
            m1();
            admin1();          
    }
}

        

