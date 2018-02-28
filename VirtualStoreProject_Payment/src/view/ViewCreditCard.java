package view;

import data.Item;
import main.Order;
import payment.PaymentStrategyCreditCard;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class ViewCreditCard implements ViewPaymentStrategy {

    private final PrintInformations printInformations = new PrintInformations();
    Scanner read = new Scanner(System.in);

    private String creditCardNumber;
    private int installmentsTimes;

    @Override
    public void executeView(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
        PaymentStrategyCreditCard credit = new PaymentStrategyCreditCard();

        System.out.print("Enter with your Credit Card number: ");
        creditCardNumber = read.next();
        System.out.print("How many installments? ");
        installmentsTimes = read.nextByte();
        System.out.println("\nHyperClass Shopping");
        System.out.println("Av. Cassiano Ricardo, 601 - Jd Aquarius");
        System.out.println("________________________________________");
        System.out.println(formatter.format(order.getOrderDate()));
        System.out.println("CREDIT CARD");
        for (Item product : order.getItens()) {
            System.out.println("Product: " + product.getProductItem());
            System.out.println("Quantity: " + product.getQuantityItem());
            System.out.printf("Subtotal: R$%.2f\n", product.getSubtotal());
        }
        System.out.println("--");
        System.out.printf("Total:  RS%.2f", order.getTotal());
        System.out.println("\nInstallments: " + getInstallmentsTimes());
        System.out.printf("Total each installments: RS%.2f", credit.getInstallmentsValue(order.getTotal(), getInstallmentsTimes()));
        System.out.println("\n________________________________________");
    }

    private String getCreditCardNumber() {
        return creditCardNumber;
    }

    private int getInstallmentsTimes() {
        return installmentsTimes;
    }

}
