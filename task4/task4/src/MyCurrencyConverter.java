import java.util.Scanner;
import java.util.HashMap;

class Converter {
    private HashMap<String, Double> rates;

    Converter() {
        rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("INR", 83.0);
        rates.put("EUR", 0.93);
        rates.put("JPY", 157.5);
        rates.put("GBP", 0.79);
    }

    double convert(String from, String to, double amt) {
        if (rates.containsKey(from) && rates.containsKey(to)) {
            double base = amt / rates.get(from);
            return base * rates.get(to);
        }
        return -1;
    }

    boolean isValid(String code) {
        return rates.containsKey(code);
    }

    void showCurrencies() {
        System.out.println("Available: " + rates.keySet());
    }
}

public class MyCurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Converter c = new Converter();

        System.out.println("Currency Converter");
        c.showCurrencies();

        System.out.print("From: ");
        String from = sc.next().toUpperCase();

        System.out.print("To: ");
        String to = sc.next().toUpperCase();

        if (!c.isValid(from) || !c.isValid(to)) {
            System.out.println("Invalid currency.");
            return;
        }

        System.out.print("Amount: ");
        double amt = sc.nextDouble();

        double result = c.convert(from, to, amt);

        if (result >= 0)
            System.out.printf("%.2f %s = %.2f %s\n", amt, from, result, to);
        else
            System.out.println("Conversion failed.");
    }
}
