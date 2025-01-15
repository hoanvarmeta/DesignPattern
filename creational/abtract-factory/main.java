abstract class Paypal {
    int id;
    int balance;

    public abstract void whoiam();

    public abstract void pay(int amount);

    public void print() {
        System.out.println("balance: " + this.balance);
    }
}

abstract class CreditCard {
    int id;
    int balance;

    public abstract void whoiam();

    public abstract void pay(int amount);

    public void print() {
        System.out.println("balance: " + this.balance);
    }
}

class PaypalOnline extends Paypal {
    static int current = 0;

    public void whoiam() {
        System.out.println("Paypal Online");
    }

    PaypalOnline(int balance) {
        this.id = ++current;
        this.balance = balance;
    }

    public void pay(int amount) {
        if (this.balance < amount) {
            System.out.println("Balance not enough");
        } else {
            this.balance -= amount;
            System.out.println("Pay with Paypal Online with amount: " + amount);
        }
    }
}

class PaypalOffline extends Paypal {
    static int current = 0;

    public void whoiam() {
        System.out.println("Paypal Offline");
    }

    PaypalOffline(int balance) {
        this.id = ++current;
        this.balance = balance;
    }

    public void pay(int amount) {
        if (this.balance < amount) {
            System.out.println("Balance not enough");
        } else {
            this.balance -= amount;
            System.out.println("Pay with Paypal Offline with amount: " + amount);
        }

    }
}

class CreditCardOnline extends CreditCard {
    static int current = 0;

    CreditCardOnline(int balance) {
        this.id = ++current;
        this.balance = balance;
    }

    public void whoiam() {
        System.out.println("CreditCard Online");
    }

    public void pay(int amount) {
        if (this.balance < amount) {
            System.out.println("Balance not enough");
        } else {
            this.balance -= amount;
            System.out.println("Pay with CreditCard Offline with amount: " + amount);
        }

    }
}

class CreditCardOffline extends CreditCard {
    static int current = 0;

    CreditCardOffline(int balance) {
        this.id = ++current;
        this.balance = balance;
    }

    public void whoiam() {
        System.out.println("CreditCard Offline");
    }

    public void pay(int amount) {
        if (this.balance < amount) {
            System.out.println("Balance not enough");
        } else {
            this.balance -= amount;
            System.out.println("Pay with CreditCard Offline with amount: " + amount);
        }
    }
}

interface PaymentFactory {
    Paypal choosePaypal(int balance);

    CreditCard chooseCreditCard(int balance);
}

class PaymentOnlineFactory implements PaymentFactory {
    public Paypal choosePaypal(int balance) {
        return new PaypalOnline(balance);
    }

    public CreditCard chooseCreditCard(int balance) {
        return new CreditCardOnline(balance);
    }
}

class PaymentOfflineFactory implements PaymentFactory {
    public Paypal choosePaypal(int balance) {
        return new PaypalOffline(balance);
    }

    public CreditCard chooseCreditCard(int balance) {
        return new CreditCardOffline(balance);
    }
}

public class main {
    public static void main(String[] args) {
        PaymentFactory paymentOfflineFactory = new PaymentOfflineFactory();
        CreditCard creditCard = paymentOfflineFactory.chooseCreditCard(2000);
        creditCard.pay(1100);
    }
}
