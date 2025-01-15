
interface Payment {
    int limit = 1000;

    void pay();
}

class CreditCard implements Payment {
    String ccv;

    CreditCard(String ccv) {
        this.ccv = ccv;
    }

    public void pay() {
        System.out.println("Pay with credit card,  ccv: " + this.ccv);
    }
}

class Paypal implements Payment {
    String username;

    Paypal(String username) {
        this.username = username;
    }

    public void pay() {
        System.out.println("Pay with paypal, id: " + this.username);
    }
}

abstract class PaymentCreator {
    public void getPayment(String paymentType) {
        Payment payment = this.choosePayment(paymentType);
        System.out.println("limit: " + payment.limit);
    }

    public abstract Payment choosePayment(String paymentType);
}

class PaymentOnlineCreator extends PaymentCreator {
    public Payment choosePayment(String paymentType) {
        if (paymentType == "CreditCard") {
            return new CreditCard("123");
        } else if (paymentType == "Paypal") {
            return new Paypal("234");
        }
        return null;
    }
}

public class main {
    public static void main(String[] args) {
        PaymentCreator paymentOnlineCreator = new PaymentOnlineCreator();
        Payment paymentOn = paymentOnlineCreator.choosePayment("CreditCard");
        paymentOnlineCreator.getPayment("CreditCard");
        paymentOn.pay();
    }
}
