# Bank Project 1 - Algorithms

## CheckingAccount.start()

1. Loop:
   1. Print account menu.
   2. Read user choice.
   3. If 0: exit loop.
   4. If 1: call `checkBalance()`.
   5. If 2: call `makeDeposit(scanner)`.
   6. If 3: call `makeWithdrawal(scanner)`.
   7. Otherwise: print "Invalid choice".

## CheckingAccount.makeDeposit(scanner)

1. Print "Making a deposit..."
2. Call `getDouble(scanner, prompt)` to read an amount.
3. If amount <= 0: print error, return.
4. Add amount to `balance`.
5. Print new balance.

## CheckingAccount.makeWithdrawal(scanner)

1. Print "Making a withdrawal..."
2. Call `getDouble(scanner, prompt)` to read an amount.
3. If amount <= 0: print error, return.
4. If amount > balance: print "Insufficient funds", return.
5. Subtract amount from `balance`.
6. Print new balance.

## Customer.start()

1. Ask for user name and PIN.
2. Use `login()` from `User`.
3. If login fails: print error and exit.
4. Loop:
   1. Show customer menu.
   2. If checking selected: call `checking.start()`.
   3. If savings selected: call `savings.start()`.
   4. If change PIN: update PIN.
   5. If exit: break.# Java-Bank
