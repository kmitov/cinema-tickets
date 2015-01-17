package com.cinema.tickets.dto;

/**
 * Created by kmitov on 1/14/15.
 */
public class TheatreSeatDto {
    private Long number;
    private Long rowNumber;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Long rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
