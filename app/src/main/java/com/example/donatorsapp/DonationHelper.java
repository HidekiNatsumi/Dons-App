package com.example.donatorsapp;

public class DonationHelper {
    String amount ,donations;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDonations() {
        return donations;
    }

    public void setDonations(String donations) {
        this.donations = donations;
    }

    public DonationHelper(String amount, String donations) {
        this.amount = amount;
        this.donations = donations;
    }

    public DonationHelper() {
    }
}
