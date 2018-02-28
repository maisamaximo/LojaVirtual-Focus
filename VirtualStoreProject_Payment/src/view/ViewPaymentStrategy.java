package view;

import main.Order;

public interface ViewPaymentStrategy {

    //could be client?
    void executeView(Order order);
}
