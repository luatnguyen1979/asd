/**
 * 
 */
package asd.framework.booking.domain;

import java.io.Serializable;

import asd.booking.utils.CardType;

/**
 * @author luatnguyen
 *
 */
public class Payment  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7398548737104741301L;
	private CardType cartType;
	private String holderName;
	private String cardNumber;
	private String expiredMonth;
	private String expiredYear;
	private String ccv;
	private Address billingAddress;

	/**
	 * @param cartType
	 * @param holderName
	 * @param cardNumber
	 * @param expiredMonth
	 * @param expiredYear
	 * @param ccv
	 *
	 */
	public Payment(CardType cartType, String holderName, String cardNumber, String expiredMonth, String expiredYear,
			String ccv) {
		this.cartType = cartType;
		this.holderName = holderName;
		this.cardNumber = cardNumber;
		this.expiredMonth = expiredMonth;
		this.expiredYear = expiredYear;
		this.ccv = ccv;
	}

	/**
	 * @return the cartType
	 */
	public CardType getCartType() {
		return cartType;
	}

	/**
	 * @param cartType
	 *            the cartType to set
	 */
	public void setCartType(CardType cartType) {
		this.cartType = cartType;
	}

	/**
	 * @return the holderName
	 */
	public String getHolderName() {
		return holderName;
	}

	/**
	 * @param holderName
	 *            the holderName to set
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the expiredMonth
	 */
	public String getExpiredMonth() {
		return expiredMonth;
	}

	/**
	 * @param expiredMonth
	 *            the expiredMonth to set
	 */
	public void setExpiredMonth(String expiredMonth) {
		this.expiredMonth = expiredMonth;
	}

	/**
	 * @return the expiredYear
	 */
	public String getExpiredYear() {
		return expiredYear;
	}

	/**
	 * @param expiredYear
	 *            the expiredYear to set
	 */
	public void setExpiredYear(String expiredYear) {
		this.expiredYear = expiredYear;
	}

	/**
	 * @return the ccv
	 */
	public String getCcv() {
		return ccv;
	}

	/**
	 * @param ccv
	 *            the ccv to set
	 */
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	/**
	 * @return the billingAddress
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress
	 *            the billingAddress to set
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
}
