package BonusTask;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class App  extends JFrame {
    private final DefaultListModel<BankingAccount> accountListModel = new DefaultListModel<>();
    private final JList<BankingAccount> accountList = new JList<>(accountListModel);
    private final Map<String, BankingAccount> accounts = new LinkedHashMap<>();

    public App() {
        super("My Bank Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        accountList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(accountList), BorderLayout.CENTER);

        JPanel controls = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton btnCreate = new JButton("Create");
        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnTransfer = new JButton("Transfer");

        controls.add(btnCreate);
        controls.add(btnDeposit);
        controls.add(btnWithdraw);
        controls.add(btnTransfer);
        panel.add(controls, BorderLayout.SOUTH);
        add(panel);

        btnCreate.addActionListener(e -> createAccount());
        btnDeposit.addActionListener(e -> depositToAccount());
        btnWithdraw.addActionListener(e -> withdrawFromAccount());
        btnTransfer.addActionListener(e -> transferBetweenAccounts());
    }

    private void createAccount() {
        String name = JOptionPane.showInputDialog(this, "Enter account name:");
        if (name != null && !name.trim().isEmpty()) {
            if (accounts.containsKey(name)) {
                JOptionPane.showMessageDialog(this, "Account already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                BankingAccount acct = new BankingAccount(name);
                accounts.put(name, acct);
                accountListModel.addElement(acct);
            }
        }
    }

    private void depositToAccount() {
        BankingAccount acct = accountList.getSelectedValue();
        if (acct == null) {
            JOptionPane.showMessageDialog(this, "Select an account first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String amtStr = JOptionPane.showInputDialog(this, "Enter deposit amount:");
        try {
            double amt = Double.parseDouble(amtStr);
            acct.deposit(amt);
            accountList.repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void withdrawFromAccount() {
        BankingAccount acct = accountList.getSelectedValue();
        if (acct == null) {
            JOptionPane.showMessageDialog(this, "Select an account first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String amtStr = JOptionPane.showInputDialog(this, "Enter withdrawal amount:");
        try {
            double amt = Double.parseDouble(amtStr);
            if (!acct.withdraw(amt)) {
                JOptionPane.showMessageDialog(this, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            accountList.repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void transferBetweenAccounts() {
        BankingAccount source = accountList.getSelectedValue();
        if (source == null || accounts.size() < 2) {
            JOptionPane.showMessageDialog(this, "Ensure at least 2 accounts exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String targetName = (String) JOptionPane.showInputDialog(
                this, "Select target account:", "Transfer",
                JOptionPane.PLAIN_MESSAGE, null,
                accounts.keySet().stream().filter(n -> !n.equals(source.getName())).toArray(),
                null
        );
        if (targetName == null) return;
        BankingAccount target = accounts.get(targetName);
        String amtStr = JOptionPane.showInputDialog(this, "Enter transfer amount:");
        try {
            double amt = Double.parseDouble(amtStr);
            if (!source.transfer(target, amt)) {
                JOptionPane.showMessageDialog(this, "Transfer failed (check funds).", "Error", JOptionPane.ERROR_MESSAGE);
            }
            accountList.repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
