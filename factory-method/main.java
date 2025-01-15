
interface Payment {
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
    String id_paypal;

    Paypal(String id_paypal) {
        this.id_paypal = id_paypal;
    }

    public void pay() {
        System.out.println("Pay with paypal, id: " + this.id_paypal);
    }
}

abstract class PaymentCreator {
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
        Payment paymentOn = new PaymentOnlineCreator().choosePayment("CreditCard");
        paymentOn.pay();
    }
}
