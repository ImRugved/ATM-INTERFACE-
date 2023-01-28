// Rugved Belkundkar

import javax.swing.plaf.synth.*;
import java.sql.SQLOutput;
import java.util.*;
class bankaccount {
    static  void register() {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n--------------------------------------------------\n");
        System.out.print("Enter Your Name : ");
        ATM.name=sc.nextLine();
        System.out.print("Enter Username : ");
        String user=sc.nextLine();
        System.out.print("Enter Your Pin : ");
        String pass=sc.nextLine();
        System.out.print("Enter Your Account Number : ");
        ATM.accnumber=sc.nextLine();
        System.out.println("\nREGISTRATION SUCCESSFULLY!");
        System.out.println("\n--------------------------------------------------\n");
        ATM.prompt();
        while(true) {
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1) {
                login(user,pass);
                break;
            } else {
                if(choice==2) {
                    System.exit(0);
                } else {
                    System.out.println("Wrong Value! Enter Again");
                }
            }
        }
    }
    static void display(String name) {}
    static void login(String user,String pass) {}
}
class transaction {
    static void withdraw() {
        Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------------------------------\n");
        System.out.print("Enter Amount to Withdraw : ");
        int wcash=sc.nextInt();
        if(wcash<=ATM.balance) {
            ATM.balance=ATM.balance-wcash;
            ATM.history.add(Integer.toString(wcash));
            ATM.history.add("Withdraw");
            System.out.println("Amount of Rupees "+wcash+" Withdraw Successfully\n Collect Your Money\n");
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("You Have Insufficient Balance to Withdraw The Cash");
            System.out.println("--------------------------------------------------");
        }
        ATM.prompt();
    }
    static void deposit() {
        Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.print("Enter Amount to Deposit : ");
        int dcash=sc.nextInt();
        ATM.updatebalance(dcash);
        ATM.history.add(Integer.toString(dcash));
        ATM.history.add("Deposited");
        System.out.println("Amount Rs"+dcash+" Deposit Successful!");
        System.out.println("--------------------------------------------------");
        ATM.prompt();
    }
    static void transfer() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter The Name of Receiver : ");
        String s=sc.nextLine();
        System.out.print("Enter The Account Number of The Receiver : ");
        int num=sc.nextInt();
        System.out.print("Enter The Amount To Be Transferred : ");
        int tcash=sc.nextInt();
        if(tcash<=ATM.balance) {
            ATM.balance=ATM.balance-tcash;
            ATM.history.add(Integer.toString(tcash));
            ATM.history.add("Amount Transferred To "+s);
            System.out.println("\nAmount Rs."+tcash+"/- Transferred Successfully");
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("Insufficient Balance To Transfer The Cash");
            System.out.println("--------------------------------------------------");
        }
    }
}
class check {
    static void checkbalance() {
        System.out.println("--------------------------------------------------");
        System.out.println("Available Balance In The Bank Account :");
        ATM.showbalance();
        System.out.println("--------------------------------------------------\n");
        ATM.prompt();
    }
}
class his {
    static void transactionhistory() {
        System.out.println("--------------------------------------------------\n");
        System.out.println("Transaction History : ");
        int k=0;
        if(ATM.balance>0) {
            for(int i=0; i<(ATM.history.size()/2); i++) {
                for(int j=0; j<2; j++) {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
                System.out.println(".\n");
            }
        } else {
            System.out.println("Your Account Is Empty");
        }
        ATM.prompt();
    }
}
public class ATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash) {
        balance=balance+dcash;
    }
    static void showbalance() {
        System.out.println(balance);
    }
    public static void homepage() {
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME INTO RUGVED'S ATM INTERFACE");
        System.out.println("--------------------------------------------------");
        System.out.println("\nSelect Option : ");
        System.out.println("1 : Register");
        System.out.println("2 : Exit");
        System.out.print("\nEnter Choice : ");
        int choice =sc.nextInt();
        if (choice==1) {
            bankaccount.register();
        } else {
            if(choice==2) {
                System.exit(0);
            } else {
                homepage();
            }
        }
    }
    static void prompt() {
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM SYSTEM");
        System.out.println("--------------------------------------------------");
        System.out.println("Select Option Below : ");
        System.out.println("1 : Withdraw Money");
        System.out.println("2 : Deposit Money");
        System.out.println("3 : Transfer Money ");
        System.out.println("4 : Check Your Balance");
        System.out.println("5 : Transaction History");
        System.out.println("6 : Exit");
        System.out.print("\nEnter Your Choice : ");
        int choice=sc.nextInt();
        switch (choice) {
        case 1:
            transaction.withdraw();
        case 2:
            transaction.deposit();
        case 3:
            transaction.transfer();
        case 4:
            check.checkbalance();
        case 5:
            his.transactionhistory();
        case 6:
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        homepage();
    }
}