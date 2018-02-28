package payment;

import view.ViewBillet;
import view.ViewCreditCard;
import view.ViewPaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class Payment {

    private Map<Integer, ViewPaymentStrategy> map = new HashMap<>();
    private PaymentType p;

    public Payment(){
        map.put(p.BILLET.getOptionPayment(), new ViewBillet());
        map.put(p.CREDITCARD.getOptionPayment(), new ViewCreditCard());
    }

    public ViewPaymentStrategy paymentExecute(int paymentOption){
        return map.get(paymentOption);
    }
}

