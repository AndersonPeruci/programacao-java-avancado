package view;

import helper.Utils;
import model.AccountBank;
import model.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private static String name = "Bank of Java";
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<AccountBank> accountBanks;

    public static void main(String[] args) {
        Bank.accountBanks = new ArrayList<>();
        Bank.menu();
    }

    private static void menu() {
        int option = 0;
        System.out.println("================================");
        System.out.println("============= ATM ===============");
        System.out.println("========== " + Bank.name + "==========");
        System.out.println("================================");

        System.out.println("Select an option in the menu: ");
        System.out.println(
                "1 - Create an account\n" +
                "2 - Withdraw\n" +
                "3 - Deposit\n" +
                "4 - Transfer\n" +
                "5 - List accounts\n" +
                "6 - Exit\n");

        try {
            option = Integer.parseInt(Bank.scanner.nextLine());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Invalid option");
            Utils.stop(2);
            Bank.menu();
        }
        switch (option) {
            case 1 -> Bank.createAccount();
            case 2 -> Bank.withdrawAccount();
            case 3 -> Bank.depositAccount();
            case 4 -> Bank.transferAccount();
            case 5 -> Bank.listAccount();
            case 6 -> {
                System.out.println("Thank you for use our application! See you later");
                Utils.stop(2);
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid option");
                Utils.stop(2);
                Bank.menu();
            }
        }
    }

    private static void createAccount() {
        System.out.println("Client data");
        System.out.println("__________________________");

        System.out.print("Enter client name: ");
        String name = Bank.scanner.nextLine();

        System.out.print("Enter client email: ");
        String email = Bank.scanner.nextLine();

        System.out.print("Enter client CPF: ");
        String cpf = Bank.scanner.nextLine();

        System.out.print("Enter client birthday date: ");
        String birthdayDate = Bank.scanner.nextLine();

        Bank.accountBanks.add(new AccountBank(new Client(name, email, cpf, Utils.stringToDate(birthdayDate))));

        System.out.println("Bank account completed successfully");
        Utils.stop(2);
        Bank.menu();
    }

    private static void withdrawAccount() {
        System.out.println("Withdraw");
        System.out.println("__________________________");

        System.out.print("Enter account number: ");
        int accNumb = Bank.scanner.nextInt();

        AccountBank accountBank = Bank.findByAccountNumber(accNumb);

        if (accountBank != null) {
            System.out.print("Enter amount to withdraw: ");
            Double withdrawAmount = Bank.scanner.nextDouble();

            accountBank.withdraw(withdrawAmount);
        } else {
            System.out.print("Account " + accNumb + "not exist");
        }

        Utils.stop(2);
        Bank.menu();
    }

    private static AccountBank findByAccountNumber(int accNumb) {
        for (AccountBank accountBank: Bank.accountBanks) {
            if (accountBank.getNumber() == accNumb)
                return accountBank;
        }
        return null;
    }

    private static void depositAccount() {
        System.out.println("Deposit");
        System.out.println("__________________________");

        System.out.print("Enter account number: ");
        int accNumb = Bank.scanner.nextInt();

        AccountBank accountBank = Bank.findByAccountNumber(accNumb);

        if (accountBank != null) {
            System.out.print("Enter amount to deposit: ");
            Double withdrawAmount = Bank.scanner.nextDouble();

            accountBank.deposit(withdrawAmount);
        } else {
            System.out.print("Account " + accNumb + " not exist");
        }

        Utils.stop(2);
        Bank.menu();
    }

    private static void transferAccount() {
        System.out.println("Deposit");
        System.out.println("__________________________");

        System.out.print("Enter account number: ");
        int accNumb = Bank.scanner.nextInt();

        AccountBank accountBank = Bank.findByAccountNumber(accNumb);
        if (accountBank == null) {
            System.out.print("Account " + accNumb + " not exist");
            Utils.stop(2);
            Bank.menu();
        }

        System.out.print("Enter destination account number: ");
        int destAccNumb = Bank.scanner.nextInt();

        AccountBank destAccountBank = Bank.findByAccountNumber(destAccNumb);
        if (destAccountBank == null) {
            System.out.print("Destination Account " + destAccNumb + " not exist");
            Utils.stop(2);
            Bank.menu();
        }

        System.out.print("Enter amount to transfer: ");
        Double transferAmount = Bank.scanner.nextDouble();

        accountBank.transfer(destAccountBank, transferAmount);

        Utils.stop(2);
        Bank.menu();
    }

    private static void listAccount() {
        if (Bank.accountBanks.size() == 0) {
            System.out.print("There is no bank account");
            return;
        }
        for (AccountBank accountBank: Bank.accountBanks) {
            System.out.println(accountBank);
            System.out.println("___________________________");
        }
        Utils.stop(3);
        Bank.menu();
    }
}
