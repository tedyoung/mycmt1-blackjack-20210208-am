package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {
  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void newWalletAddMoneyIsNotEmpty() throws Exception {
    //given a new wallet
    Wallet wallet = new Wallet();

    //when we add money
    wallet.addMoney(10);

    //then we expect it to not be empty
    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void newWalletThenBalanceIsZero() throws Exception {
    Wallet wallet = new Wallet();

    // THEN balance is ZERO
    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void newWalletAdd15ThenBalanceIs15() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(15);

    assertThat(wallet.balance())
        .isEqualTo(15);
  }

  @Test
  public void newWalletAdd17AndAdd18ThenBalanceIs35() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(17);

    wallet.addMoney(18);

    assertThat(wallet.balance())
        .isEqualTo(17 + 18);
  }

  @Test
  public void addMoneyLessThanZeroThrowsException() throws Exception {
    Wallet wallet = new Wallet();

    assertThatThrownBy(() -> {
      wallet.addMoney(-1);
    })
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void addMoneyOfZeroThrowsException() throws Exception {
    Wallet wallet = new Wallet();

    assertThatThrownBy(() -> {
      wallet.addMoney(0);
    })
        .isInstanceOf(IllegalArgumentException.class);
  }

}
