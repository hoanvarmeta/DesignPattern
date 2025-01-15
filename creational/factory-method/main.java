
interface Payment {
    int limit = 1000;

    void pay(int amount);
}

class CreditCard implements Payment {
    String id;
    int balance;

    CreditCard(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public void pay(int amount) {
        if (this.balance < amount) {
            System.out.println("Balance not enough");
        }
        this.balance -= amount;
        System.out.println("Pay with credit card,  id: " + this.id + ", amount: " + amount);
    }
}

class Paypal implements Payment {
    String id;
    int balance;

    Paypal(String id, int balance) {
        this.balance = balance;
        this.id = id;
    }

    public void pay(int amount) {
        if (this.balance < amount) {
            System.out.println("Balance not enough");
        }
        this.balance -= amount;
        System.out.println("Pay with paypal, id: " + this.id + ", amount: " + amount);
    }
}

abstract class PaymentCreator {

    public abstract Payment choosePayment(String paymentType, String id, int balance);
}

class PaymentOnlineCreator extends PaymentCreator {
    public Payment choosePayment(String paymentType, String id, int balance) {
        if (paymentType == "CreditCard") {
            return new CreditCard(id, balance);
        } else if (paymentType == "Paypal") {
            return new Paypal(id, balance);
        }
        return null;
    }
}

public class main {
    public static void main(String[] args) {
        PaymentCreator paymentOnlineCreator = new PaymentOnlineCreator();
        Payment paymentOn = paymentOnlineCreator.choosePayment("CreditCard", "123", 1000);
        paymentOn.pay(200);
    }
}
