abstract class Paypal {
    int limit;
    int balance;

    public abstract void whoiam();

    public void print() {
        System.out.println("balance: " + this.balance);
    }
}

abstract class CreditCard {
    int limit;
    int invoice;

    public abstract void whoiam();

    public void print() {
        System.out.println("invoice: " + this.invoice);
    }
}

class PaypalOnline extends Paypal {
    public void whoiam() {
        System.out.println("Paypal Online");
    }
}

class PaypalOffline extends Paypal {
    public void whoiam() {
        System.out.println("Paypal Offline");
    }
}

class CreditCardOnline extends CreditCard {
    public void whoiam() {
        System.out.println("CreditCard Online");
    }
}

class CreditCardOffline extends CreditCard {
    public void whoiam() {
        System.out.println("CreditCard Offline");
    }
}

interface PaymentFactory {
    Paypal choosePaypal();

    CreditCard chooseCreditCard();
}

class PaymentOnlineFactory implements PaymentFactory {
    public Paypal choosePaypal() {
        return new PaypalOnline();
    }

    public CreditCard chooseCreditCard() {
        return new CreditCardOnline();
    }
}

class PaymentOfflineFactory implements PaymentFactory {
    public Paypal choosePaypal() {
        return new PaypalOffline();
    }

    public CreditCard chooseCreditCard() {
        return new CreditCardOffline();
    }
}

public class main {
    public static void main(String[] args) {
        PaymentFactory paymentOfflineFactory = new PaymentOfflineFactory();
        CreditCard creditCard = paymentOfflineFactory.chooseCreditCard();
        creditCard.whoiam();
    }
}
