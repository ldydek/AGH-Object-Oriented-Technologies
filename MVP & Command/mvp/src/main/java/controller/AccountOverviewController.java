package controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Account;
import model.Category;
import model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountOverviewController {

    private Account data;

    private AccountAppController appController;

    @FXML
    private TableView<Transaction> transactionsTable;

    @FXML
    private TableColumn<Transaction, LocalDate> dateColumn;

    @FXML
    private TableColumn<Transaction, String> payeeColumn;

    @FXML
    private TableColumn<Transaction, Category> categoryColumn;

    @FXML
    private TableColumn<Transaction, BigDecimal> inflowColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button addButton;

    @FXML
    private void initialize() {
        transactionsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        dateColumn.setCellValueFactory(dataValue -> dataValue.getValue().getDateProperty());
        payeeColumn.setCellValueFactory(dataValue -> dataValue.getValue().getPayeeProperty());
        categoryColumn.setCellValueFactory(dataValue -> dataValue.getValue().getCategoryProperty());
        inflowColumn.setCellValueFactory(dataValue -> dataValue.getValue().getInflowProperty());

        deleteButton.disableProperty().bind(Bindings.isEmpty(transactionsTable.getSelectionModel().getSelectedItems()));
        editButton.disableProperty().bind(Bindings.isEmpty(transactionsTable.getSelectionModel().getSelectedItems()));
    }

    @FXML
    private void handleDeleteAction() {
        data.getTransactions().removeAll(transactionsTable.getSelectionModel().getSelectedItems());
    }

    @FXML
    private void handleEditAction() {
        Transaction transaction = transactionsTable.getSelectionModel().getSelectedItem();
        if (transaction != null) {
            appController.showTransactionEditDialog(transaction);
        }
    }

    @FXML
    private void handleAddAction() {
        Transaction transaction = Transaction.newTransaction();
        if (appController.showTransactionEditDialog(transaction)) {
            data.addTransaction(transaction);
        }
    }

    public void setData(Account account) {
        this.data = account;
        transactionsTable.setItems(data.getTransactions());
    }

    public void setAppController(AccountAppController appController) {
        this.appController = appController;
    }
}
