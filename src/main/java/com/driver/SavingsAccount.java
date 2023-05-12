package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    private int nWithdrwas;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
        this.nWithdrwas = 0;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public int getnWithdrwas() {
        return nWithdrwas;
    }

    public void setnWithdrwas(int nWithdrwas) {
        this.nWithdrwas = nWithdrwas;
    }

    public void withdraw(double amount) throws Exception {
        if(nWithdrwas > maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }

        if(amount > super.getBalance()){
            throw new Exception("Insufficient Balance");
        }

        super.setBalance(super.getBalance() - amount);
        nWithdrwas++;
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

    }

    public double getSimpleInterest(int years){
        return super.getBalance() + rate * years * super.getBalance();
        // Return the final amount considering that bank gives simple interest on current amount

    }

    public double getCompoundInterest(int times, int years){

        return super.getBalance() * Math.pow(1+(rate/times), times*years);
        // Return the final amount considering that bank gives compound interest on current amount given times per year

    }

}
