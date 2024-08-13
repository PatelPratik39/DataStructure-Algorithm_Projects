const Bank = require("./Bank");

const bank = new Bank();

bank.addAccount(101, 1000);
bank.addAccount(102, 2000);
bank.addAccount(103, 3000);
bank.addAccount(104, 4000);
bank.addAccount(105, 5000);

console.log("\nInitial Balances:");
bank.checkBalance(101);
bank.checkBalance(102);

console.log("\nTransferring 500 from Account 101 to 102:");
bank.transfer(102, 101, 450);
bank.transfer(105,103, 1000)

console.log("\nFinal Balance  is : ");
bank.checkBalance(101);
bank.checkBalance(102);
bank.checkBalance(103);
bank.checkBalance(105);

