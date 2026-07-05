import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PosBillingSystem extends JFrame {

    Cart cart = new Cart();

    JTextArea cartArea;
    JLabel totalLabel;

    JPanel productPanel;
    JPanel categoryPanel;

    boolean darkMode = false;

    String selectedCategory = "Chicken Dum Biryani";

    ArrayList<Product> products = new ArrayList<>();

    public PosBillingSystem() {

        loadProducts();

        setTitle("Nizam's Dum Biryani");
        setSize(1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel heading =
                new JLabel(
                        "Nizam's Dum Biryani",
                        SwingConstants.CENTER);

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28));

        JButton settingsBtn =
                new JButton("⚙ Settings");

        settingsBtn.addActionListener(
                e -> showSettings()
        );

        topPanel.add(
                heading,
                BorderLayout.CENTER);

        topPanel.add(
                settingsBtn,
                BorderLayout.EAST);

        add(
                topPanel,
                BorderLayout.NORTH);




        categoryPanel = new JPanel();
        categoryPanel.setLayout(
                new GridLayout(0,1));

        addCategories();

        JScrollPane categoryScroll =
                new JScrollPane(
                        categoryPanel);

        categoryScroll.setPreferredSize(
                new Dimension(
                        250,
                        0));

        add(
                categoryScroll,
                BorderLayout.WEST);




        productPanel = new JPanel();

        productPanel.setLayout(
                new GridLayout(
                        0,
                        3,
                        15,
                        15));

        JScrollPane productScroll =
                new JScrollPane(
                        productPanel);

        add(
                productScroll,
                BorderLayout.CENTER);




        cartArea = new JTextArea();

        cartArea.setEditable(false);

        cartArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14));

        JScrollPane cartScroll =
                new JScrollPane(
                        cartArea);

        cartScroll.setPreferredSize(
                new Dimension(
                        350,
                        0));

        add(
                cartScroll,
                BorderLayout.EAST);




        JPanel bottomPanel =
                new JPanel();

        totalLabel =
                new JLabel(
                        "Grand Total : ₹0");

        totalLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18));

        JButton billBtn =
                new JButton(
                        "Generate Bill");

        JButton resetBtn =
                new JButton(
                        "Reset");

        billBtn.addActionListener(
                e -> {

                    String bill =
                            ReceiptGenerator
                                    .generateAndReturn(
                                            cart);

                    JOptionPane.showMessageDialog(
                            this,
                            bill,
                            "Receipt",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    cart.clear();
                    refreshCart();
                });

        resetBtn.addActionListener(
                e -> {

                    cart.clear();
                    refreshCart();
                });

        bottomPanel.add(
                totalLabel);

        bottomPanel.add(
                billBtn);

        bottomPanel.add(
                resetBtn);

        add(
                bottomPanel,
                BorderLayout.SOUTH);




        loadCategoryProducts(
                selectedCategory);

        refreshCart();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showSettings() {

        String[] options = {
                "Light Theme",
                "Dark Theme"
        };

        int choice =
                JOptionPane.showOptionDialog(
                        this,
                        "Choose Theme",
                        "Settings",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

        if(choice == 0){

            darkMode = false;
            applyTheme();

        } else if(choice == 1){

            darkMode = true;
            applyTheme();
        }
    }

    private void applyTheme() {

        Color bg =
                darkMode
                        ? new Color(35,35,35)
                        : Color.WHITE;

        Color fg =
                darkMode
                        ? Color.WHITE
                        : Color.BLACK;

        getContentPane().setBackground(bg);

        categoryPanel.setBackground(bg);
        productPanel.setBackground(bg);

        cartArea.setBackground(bg);
        cartArea.setForeground(fg);

        repaint();
    }

    private void addCategories() {

        String[] categories = {

                "Chicken Dum Biryani",
                "Mutton Dum Biryani",
                "Special Combos",
                "Mutton Royal Gravies",
                "Nizami Special Mutton Gravies",
                "Mutton Starters",
                "Soups",
                "Rotis",
                "Beverages",
                "Desserts",
                "Haleem"
        };

        for(String category : categories){

            JButton btn =
                    new JButton(category);

            btn.addActionListener(
                    e -> {

                        selectedCategory =
                                category;

                        loadCategoryProducts(
                                category);
                    });

            categoryPanel.add(btn);
        }
    }
        private void loadProducts() {

        products.add(new Product(1,
                "Mini Chicken Biryani",
                "Chicken Dum Biryani",
                139));

        products.add(new Product(2,
                "Full Chicken Biryani",
                "Chicken Dum Biryani",
                279));

        products.add(new Product(3,
                "Family Chicken Biryani",
                "Chicken Dum Biryani",
                559));

        products.add(new Product(4,
                "Jumbo Chicken Biryani",
                "Chicken Dum Biryani",
                839));

        products.add(new Product(7,
                "Mini Mutton Biryani",
                "Mutton Dum Biryani",
                199));

        products.add(new Product(8,
                "Full Mutton Biryani",
                "Mutton Dum Biryani",
                349));

        products.add(new Product(9,
                "Family Mutton Biryani",
                "Mutton Dum Biryani",
                699));

        products.add(new Product(12,
                "Single Chicken Combo",
                "Special Combos",
                499));

        products.add(new Product(13,
                "Classic Chicken Combo",
                "Special Combos",
                699));

        products.add(new Product(14,
                "Single Mutton Combo",
                "Special Combos",
                599));

        products.add(new Product(15,
                "Classic Mutton Combo",
                "Special Combos",
                799));



        products.add(new Product(16,
                "Mutton Masala",
                "Mutton Royal Gravies",
                249));

        products.add(new Product(17,
                "Mutton Kadai",
                "Mutton Royal Gravies",
                269));



        products.add(new Product(18,
                "Nizami Mutton Curry",
                "Nizami Special Mutton Gravies",
                279));



        products.add(new Product(19,
                "Mutton Fry",
                "Mutton Starters",
                249));

        products.add(new Product(20,
                "Mutton Pepper Fry",
                "Mutton Starters",
                279));



        products.add(new Product(21,
                "Mutton Soup",
                "Soups",
                99));



        products.add(new Product(22,
                "Rumali Roti",
                "Rotis",
                15));

        products.add(new Product(23,
                "Tandoori Roti",
                "Rotis",
                20));

        products.add(new Product(24,
                "Plain Naan",
                "Rotis",
                25));

        products.add(new Product(25,
                "Butter Naan",
                "Rotis",
                30));

        products.add(new Product(26,
                "Garlic Naan",
                "Rotis",
                30));



        products.add(new Product(27,
                "Water Bottle",
                "Beverages",
                20));

        products.add(new Product(28,
                "Cool Drink",
                "Beverages",
                40));



        products.add(new Product(29,
                "Double Ka Meetha",
                "Desserts",
                79));

        products.add(new Product(30,
                "Qubani Ka Meetha",
                "Desserts",
                99));



        products.add(new Product(31,
                "Special Haleem",
                "Haleem",
                249));
    }



    private void loadCategoryProducts(
            String category) {

        productPanel.removeAll();

        for(Product p : products) {

            if(p.category.equals(category)) {

                productPanel.add(
                        createProductCard(p));
            }
        }

        productPanel.revalidate();
        productPanel.repaint();
    }



    private JPanel createProductCard(
            Product p) {

        JPanel card = new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS));

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                Color.GRAY),
                        BorderFactory.createEmptyBorder(
                                10,10,10,10)));

        JLabel name =
                new JLabel(p.name);

        name.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        JLabel price =
                new JLabel(
                        "₹" + p.price);

        price.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        JLabel qtyLabel =
                new JLabel("0");

        JButton plus =
                new JButton("+");

        JButton minus =
                new JButton("-");

        JPanel qtyPanel =
                new JPanel();

        qtyPanel.add(minus);
        qtyPanel.add(qtyLabel);
        qtyPanel.add(plus);

        plus.addActionListener(e -> {

            cart.addItem(p);

            int qty =
                    Integer.parseInt(
                            qtyLabel.getText());

            qtyLabel.setText(
                    String.valueOf(
                            qty + 1));

            refreshCart();
        });

        minus.addActionListener(e -> {

            int qty =
                    Integer.parseInt(
                            qtyLabel.getText());

            if(qty > 0){

                cart.decreaseItem(p);

                qtyLabel.setText(
                        String.valueOf(
                                qty - 1));

                refreshCart();
            }
        });

        card.add(name);
        card.add(Box.createVerticalStrut(10));
        card.add(price);
        card.add(Box.createVerticalStrut(10));
        card.add(qtyPanel);

        return card;
    }



    private void refreshCart() {

        StringBuilder sb =
                new StringBuilder();

        sb.append(
                "ITEM\tQTY\tTOTAL\n");

        sb.append(
                "---------------------------------\n");

        for(CartItem item : cart.items){

            sb.append(
                    String.format(
                            "%s\t%d\t%.2f\n",
                            item.product.name,
                            item.quantity,
                            item.getTotal()
                    ));
        }

        sb.append(
                "\n---------------------------------\n");

        sb.append(
                String.format(
                        "Subtotal : %.2f\n",
                        cart.getTotal()));

        sb.append(
                String.format(
                        "GST (2.5%%) : %.2f\n",
                        cart.getGST()));

        sb.append(
                String.format(
                        "CGST (2.5%%) : %.2f\n",
                        cart.getCGST()));

        sb.append(
                "---------------------------------\n");

        sb.append(
                String.format(
                        "Grand Total : %.2f\n",
                        cart.getGrandTotal()));

        cartArea.setText(
                sb.toString());

        totalLabel.setText(
                "Grand Total : ₹" +
                        String.format(
                                "%.2f",
                                cart.getGrandTotal()));
    }
}