import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptGenerator {

    private static int billNo = 1001;

    public static String generateAndReturn(Cart cart) {

        StringBuilder sb = new StringBuilder();

        double subtotal = cart.getTotal();
        double gst = cart.getGST();
        double cgst = cart.getCGST();
        double grandTotal = cart.getGrandTotal();

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        sb.append("========================================\n");
        sb.append("          NIZAM'S DUM BIRYANI\n");
        sb.append("========================================\n");
        sb.append("Bill No : ").append(billNo++).append("\n");
        sb.append("Date    : ").append(sdf.format(new Date())).append("\n");
        sb.append("----------------------------------------\n");

        sb.append(
                String.format(
                        "%-20s %-5s %-10s\n",
                        "ITEM",
                        "QTY",
                        "AMOUNT"
                )
        );

        sb.append("----------------------------------------\n");

        for (CartItem item : cart.items) {

            sb.append(
                    String.format(
                            "%-20s %-5d %-10.2f\n",
                            item.product.name,
                            item.quantity,
                            item.getTotal()
                    )
            );
        }

        sb.append("----------------------------------------\n");

        sb.append(
                String.format(
                        "%-25s %.2f\n",
                        "Subtotal",
                        subtotal
                )
        );

        sb.append(
                String.format(
                        "%-25s %.2f\n",
                        "GST (2.5%)",
                        gst
                )
        );

        sb.append(
                String.format(
                        "%-25s %.2f\n",
                        "CGST (2.5%)",
                        cgst
                )
        );

        sb.append("----------------------------------------\n");

        sb.append(
                String.format(
                        "%-25s %.2f\n",
                        "GRAND TOTAL",
                        grandTotal
                )
        );

        sb.append("========================================\n");
        sb.append("         THANK YOU VISIT AGAIN\n");
        sb.append("========================================\n");

        return sb.toString();
    }
}