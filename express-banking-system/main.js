const Bank = require("./Bank");

const bank = new Bank();

bank.addAccount(101, 1000);
bank.addAccount(102, 2000);

console.log("\nInitial Balances:");
bank.checkBalance(101);
bank.checkBalance(102);

console.log("\nTransferring 500 from Account 101 to 102:");
bank.transfer(102, 101, 450);

console.log("\nFinal Balance  is : ");
bank.checkBalance(101);
bank.checkBalance(102);
