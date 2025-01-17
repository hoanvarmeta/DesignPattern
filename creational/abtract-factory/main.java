import java.util.ArrayList;

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

class Paypal {
    static int current = 0;
    int id;
    int balance;

    Paypal() {
        this.id = ++this.current;
        this.balance = 0;
    }
}

abstract class CreditCardPayment {
    abstract void deposit(int id, int amount);

    abstract void pay(int id, int amount);
}

abstract class PaypalPayment {
    abstract void deposit(int id, int amount);

    abstract void pay(int id, int amount);
}

class PaypalOnline extends PaypalPayment {

    public void whoiam() {
        System.out.println("Paypal Online");
    }

    public void deposit(int id, int amount) {
        for (Paypal paypal : DB.payPals) {
            if (paypal.id == id) {
                paypal.balance += amount;
                System.out.println("Deposit with paypal Online, id: " + paypal.id + ", amount: " + amount);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void pay(int id, int amount) {
        for (Paypal paypal : DB.payPals) {
            if (paypal.id == id) {
                paypal.balance -= amount;
                System.out.println("Pay with paypal Online,  id: " + paypal.id + ", amount: " + amount);
                return;
            }

        }
        System.out.println("Not found");
    }
}

class PaypalOffline extends PaypalPayment {

    public void whoiam() {
        System.out.println("Paypal Offline");
    }

    public void deposit(int id, int amount) {
        for (Paypal paypal : DB.payPals) {
            if (paypal.id == id) {
                paypal.balance += amount;
                System.out.println("Deposit with paypal Offline, id: " + paypal.id + ", amount: " + amount);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void pay(int id, int amount) {
        for (Paypal paypal : DB.payPals) {
            if (paypal.id == id) {
                paypal.balance -= amount;
                System.out.println("Pay with paypal Offline,  id: " + paypal.id + ", amount: " + amount);
                return;
            }

        }
        System.out.println("Not found");
    }
}

class CreditCardOnline extends CreditCardPayment {

    public void whoiam() {
        System.out.println("CreditCard Online");
    }

    public void deposit(int id, int amount) {
        for (CreditCard creditCard : DB.creditCards) {
            if (creditCard.id == id) {
                creditCard.balance += amount;
                System.out.println("Deposit with credit card Online, id: " + creditCard.id + ", amount: " + amount);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void pay(int id, int amount) {
        for (CreditCard creditCard : DB.creditCards) {
            if (creditCard.id == id) {
                creditCard.balance -= amount;
                System.out.println("Pay with credit card Online,  id: " + creditCard.id + ", amount: " + amount);
                return;
            }

        }
        System.out.println("Not found");
    }
}

class CreditCardOffline extends CreditCardPayment {

    public void whoiam() {
        System.out.println("CreditCard Offline");
    }

    public void deposit(int id, int amount) {
        for (CreditCard creditCard : DB.creditCards) {
            if (creditCard.id == id) {
                creditCard.balance += amount;
                System.out.println("Deposit with credit card Offline, id: " + creditCard.id + ", amount: " + amount);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void pay(int id, int amount) {
        for (CreditCard creditCard : DB.creditCards) {
            if (creditCard.id == id) {
                creditCard.balance -= amount;
                System.out.println("Pay with credit card Offline,  id: " + creditCard.id + ", amount: " + amount);
                return;
            }

        }
        System.out.println("Not found");
    }
}

interface PaymentFactory {
    PaypalPayment choosePaypal();

    CreditCardPayment chooseCreditCard();
}

class PaymentOnlineFactory implements PaymentFactory {
    public PaypalPayment choosePaypal() {
        return new PaypalOnline();
    }

    public CreditCardPayment chooseCreditCard() {
        return new CreditCardOnline();
    }
}

class PaymentOfflineFactory implements PaymentFactory {
    public PaypalPayment choosePaypal() {
        return new PaypalOffline();
    }

    public CreditCardPayment chooseCreditCard() {
        return new CreditCardOffline();
    }
}

public class main {
    public static void main(String[] args) {
        PaymentFactory paymentOfflineFactory = new PaymentOfflineFactory();
        CreditCardPayment creditCard = paymentOfflineFactory.chooseCreditCard();
        DB.creditCards.add(new CreditCard());
        creditCard.deposit(1, 1000);
        creditCard.pay(1, 100);
    }
}
