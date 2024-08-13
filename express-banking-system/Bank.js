const LinkedList = require("./LinkedList");

class Bank {
  constructor() {
    this.accounts = new LinkedList();
  }

  addAccount(accountNumber, balance) {
    const newAccount = {
      accountNumber,
      balance
    };
    this.accounts.append(newAccount);
    console.log(`Account ${accountNumber} added with balance ${balance}`);
  }
  findAccount(accountNumber) {
    return this.accounts.find(
      (account) => account.accountNumber === accountNumber
    );
  }

  transfer(fromAccountNumber, toAccountNumber, amount) {
    const fromAccount = this.findAccount(fromAccountNumber);
    const toAccount = this.findAccount(toAccountNumber);
    if (!fromAccount || !toAccount) {
      console.log("Account Not found");
      return;
    }

    if (fromAccount.balance < amount) {
      console.log("Insufficient balance");
      return;
    }

    fromAccount.balance -= amount;
    toAccount.balance += amount;
    console.log(
      `Transferred ${amount} from ${fromAccountNumber} to ${toAccountNumber}`
    );
  }

  checkBalance(accountNumber) {
    const account = this.findAccount(accountNumber);
    if (account) {
      console.log(`Account ${accountNumber} has balance ${account.balance}`);
    } else {
      console.log("Account not found");
    }
  }
}

module.exports = Bank;
