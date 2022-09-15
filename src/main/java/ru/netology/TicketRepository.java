package ru.netology;

import java.util.Arrays;

public class TicketRepository {

    protected Ticket[] tickets = new Ticket[0];

    public Ticket findByDeparture(String from) {
        for (Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from)) {
                return ticket;
            }
        }
        return null;
    }

    public void removeByDeparture(String from) {
        if (findByDeparture(from) == null) {
            throw new NotFoundException("Нет такого аэропорта вылета:" + from);
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getFrom() != from) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket findByArrival(String to) {
        for (Ticket ticket : tickets) {
            if (ticket.getTo().equals(to)) {
                return ticket;
            }
        }
        return null;
    }

    public void removeByArrival(String to) {
        if (findByArrival(to) == null) {
            throw new NotFoundException("Нет такого аэропорта прилета:" + to);
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getFrom() != to) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }


    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        Arrays.sort(tickets);
        return tickets;
    }


}
