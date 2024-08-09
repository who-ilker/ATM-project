import java.util.Scanner;
// Username, password | Kullanıcı 3'den fazla yanlış girerse bloke | Deposit, withdraw, check balance, quit
public class Main {
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);

        int password, sysPassword = 123, right = 3, option;
        String username, sysUsername = "ilk";
        int userMoney = 1400;
        boolean loggedIn = false;

        while (right > 0){
            if(!loggedIn){                          // The area that we write user login or not
                System.out.print("Username: ");
                username = inp.nextLine();
                if(username.equals(sysUsername)){
                    System.out.print("Password: ");
                    password = inp.nextInt();
                    inp.nextLine(); // Buffer temizleme
                    if(password == sysPassword){
                        loggedIn = true;
                    }
                    else {
                        right--;
                        System.out.println("You entered your password wrong. Remaining password entry rights: "+right);
                        if(right == 0){
                            System.out.println("Your bank account has been blocked. Please be contact with your bank.");
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Your username was not found.");
                }
            }
            if(loggedIn){
                System.out.println("Deposit (1) | Withdraw (2) | Check Balance (3) | Quit (4) |");
                System.out.print("Which option (1) (2) (3) (4): ");
                option =inp.nextInt();
                int money;
                switch (option){
                    case 1:
                        System.out.print("The amount you want to deposit: ");
                        money = inp.nextInt();
                        userMoney += money;
                        break;
                    case 2:
                        System.out.print("The amount you want to withdraw: ");
                        money = inp.nextInt();
                        if (userMoney < money){
                            System.out.println("Your balance is insufficient.");
                        }
                        else {
                            userMoney -= money;
                            System.out.println("Your current balance: "+userMoney);
                        }
                        break;
                    case 3:
                        System.out.println("Your current balance: "+userMoney);
                        break;
                    case 4:
                        System.out.println("Exit has been made.");
                        right = 0;
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            }
        }


    }
}