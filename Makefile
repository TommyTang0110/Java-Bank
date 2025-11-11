JAVAC = javac
JFLAGS = -g

all: testCustomer

HasMenu.class: HasMenu.java
	$(JAVAC) $(JFLAGS) HasMenu.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	$(JAVAC) $(JFLAGS) CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.class
	$(JAVAC) $(JFLAGS) SavingsAccount.java

User.class: User.java HasMenu.class
	$(JAVAC) $(JFLAGS) User.java

Customer.class: Customer.java User.class CheckingAccount.class SavingsAccount.class
	$(JAVAC) $(JFLAGS) Customer.java

testChecking: CheckingAccount.class
	java CheckingAccount

testSavings: SavingsAccount.class
	java SavingsAccount

testCustomer: Customer.class
	java Customer

clean:
	rm -f *.class
