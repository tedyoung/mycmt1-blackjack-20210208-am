package com.jitterted.ebp.blackjack;

public class Wallet {

  private int balance;

  public Wallet() {
    balance = 0;
  }

  public boolean isEmpty() {
    return balance == 0;
  }

  public void addMoney(int amount) {
    ensureAmountIsValid(amount);
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int amount) {
    ensureBetAmountIsValid(amount);
    ensureSufficientBalanceOf(amount);
    balance -= amount;
  }

  private void ensureBetAmountIsValid(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
  }

  private void ensureAmountIsValid(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException();
    }
  }

  private void ensureSufficientBalanceOf(int amount) {
    if (amount > balance) {
      throw new IllegalStateException();
    }
  }
}
