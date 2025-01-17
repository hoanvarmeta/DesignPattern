import java.util.ArrayList;

interface Payment {
    void deposit(int id, int amount);

    void pay(int id, int amount);
}

class DB {
    public static ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
    public static ArrayList<Paypal> payPals = new ArrayList<Paypal>();

}

class CreditCard {
    static int current = 0;
    int id;
    int balance;

    CreditCard() {
        this.id = ++this.current;
        this.balance = 0;
    }
}

class CreditCardPayment implements Payment {

    public void deposit(int id, int amount) {
        for (CreditCard creditCard : DB.creditCards) {
            if (creditCard.id == id) {
                creditCard.balance += amount;
                System.out.println("Deposit with credit card, id: " + creditCard.id + ", amount: " + amount);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void pay(int id, int amount) {
        for (CreditCard creditCard : DB.creditCards) {
            if (creditCard.id == id) {
                creditCard.balance -= amount;
                System.out.println("Pay with credit card,  id: " + creditCard.id + ", amount: " + amount);
                return;
            }

        }
        System.out.println("Not found");
    }
}

class Paypal {
    static int current = 0;
    int id;
    int balance;

    Paypal() {
        this.id = ++this.current;
        this.balance = 0;
    }
}

class PaypalPayment implements Payment {

    public void deposit(int id, int amount) {
        for (Paypal paypal : DB.payPals) {
            if (paypal.id == id) {
                paypal.balance += amount;
                System.out.println("Deposit with paypal, id: " + paypal.id + ", amount: " + amount);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void pay(int id, int amount) {
        for (Paypal paypal : DB.payPals) {
            if (paypal.id == id) {
                paypal.balance -= amount;
                System.out.println("Pay with paypal,  id: " + paypal.id + ", amount: " + amount);
                return;
            }

        }
        System.out.println("Not found");
    }
}

abstract class PaymentCreator {
    public abstract Payment choosePayment(String paymentType);
}

class PaymentOnlineCreator extends PaymentCreator {
    public Payment choosePayment(String paymentType) {
        if (paymentType == "CreditCard") {
            return new CreditCardPayment();
        } else if (paymentType == "Paypal") {
            return new PaypalPayment();
        }
        return null;
    }
}

public class main {
    public static void main(String[] args) {
        DB.payPals.add(new Paypal());
        DB.creditCards.add(new CreditCard());
        PaymentCreator paymentOnlineCreator = new PaymentOnlineCreator();
        Payment paymentOn = paymentOnlineCreator.choosePayment("CreditCard");
        paymentOn.deposit(1, 200);
        paymentOn.pay(1, 200);
    }
}
