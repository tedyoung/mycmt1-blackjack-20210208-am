package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WalletBettingTest {

  @Test
  public void walletWith12Bet8BalanceIs4() throws Exception {
    // GIVEN
    Wallet wallet = createWalletWithInitialBalanceOf(12);

    wallet.bet(8);

    assertThat(wallet.balance())
        .isEqualTo(12 - 8); // EVIDENT DATA
  }

  @Test
  public void walletWith27Bet7AndBet9BalanceIs11() throws Exception {
    Wallet wallet = createWalletWithInitialBalanceOf(27);

    wallet.bet(7);
    wallet.bet(9);

    assertThat(wallet.balance())
        .isEqualTo(27 - 7 - 9);
  }

  @Test
  public void walletWhenBetFullBalanceThenIsEmpty() throws Exception {
    Wallet wallet = createWalletWithInitialBalanceOf(33);

    wallet.bet(33);

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void betNegativeAmountThrowsException() throws Exception {
    Wallet wallet = new Wallet();

    assertThatThrownBy(() -> {
      wallet.bet(-1);
    })
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void betZeroLeavesBalanceTheSame() throws Exception {
    Wallet wallet =createWalletWithInitialBalanceOf(18);

    // Why? Betting of Zero is allowed
    wallet.bet(0);

    assertThat(wallet.balance())
        .isEqualTo(18);
  }

  @Test
  public void betMoreThanBalanceThrowsException() throws Exception {
    Wallet wallet = createWalletWithInitialBalanceOf(10);

    assertThatThrownBy(() -> {
      wallet.bet(11);
    })
      .isInstanceOf(IllegalStateException.class);
  }

  private Wallet createWalletWithInitialBalanceOf(int amount) {
    Wallet wallet = new Wallet();
    wallet.addMoney(amount);
    return wallet;
  }

}