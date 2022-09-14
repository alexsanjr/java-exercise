package model.entities;

import model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if(!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }


    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        return Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        LocalDate date = LocalDate.now();
        if (checkIn.isBefore(date) || checkOut.isBefore(date)) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if(!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber
                + ", check-in: " + dtf.format(checkIn)
                + ", check-out: " + dtf.format(checkOut)
                + ", " + duration() + " nights";
    }
}
