package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    @Test
    public void shouldFindTwo() {
        Ticket ticket1 = new Ticket(11, 11000, "SVO", "LED", 120);
        Ticket ticket2 = new Ticket(222, 9000, "DME", "LED", 130);
        Ticket ticket3 = new Ticket(3, 15000, "SVO", "ROV", 150);
        Ticket ticket4 = new Ticket(44, 18000, "VKO", "AER", 180);
        Ticket ticket5 = new Ticket(555, 12000, "SVO", "LED", 110);

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchBy("SVO", "LED");
        Ticket[] expected = {ticket1, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortCost() {
        Ticket ticket1 = new Ticket(11, 11000, "SVO", "LED", 120);
        Ticket ticket2 = new Ticket(222, 9000, "DME", "LED", 130);
        Ticket ticket3 = new Ticket(3, 15000, "SVO", "ROV", 150);
        Ticket ticket4 = new Ticket(44, 18000, "VKO", "AER", 180);
        Ticket ticket5 = new Ticket(555, 12000, "SVO", "LED", 110);

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {
                ticket2,
                ticket1,
                ticket5,
                ticket3,
                ticket4
        };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByFrom() {
        Ticket ticket1 = new Ticket(11, 11000, "SVO", "LED", 120);
        Ticket ticket2 = new Ticket(222, 9000, "DME", "LED", 130);
        Ticket ticket3 = new Ticket(3, 15000, "SVO", "ROV", 150);
        Ticket ticket4 = new Ticket(44, 18000, "VKO", "AER", 180);
        Ticket ticket5 = new Ticket(555, 12000, "SVO", "LED", 110);

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchByFrom("DME");
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByToSort() {
        Ticket ticket1 = new Ticket(11, 11000, "SVO", "LED", 120);
        Ticket ticket2 = new Ticket(222, 9000, "DME", "LED", 130);
        Ticket ticket3 = new Ticket(3, 15000, "SVO", "ROV", 150);
        Ticket ticket4 = new Ticket(44, 18000, "VKO", "AER", 180);
        Ticket ticket5 = new Ticket(555, 12000, "SVO", "LED", 110);

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchByTo("LED");
        Ticket[] expected = {ticket2, ticket1, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveNotDeparture() {
        Ticket ticket1 = new Ticket(11, 11000, "SVO", "LED", 120);
        Ticket ticket2 = new Ticket(222, 9000, "DME", "LED", 130);
        Ticket ticket3 = new Ticket(3, 15000, "SVO", "ROV", 150);
        Ticket ticket4 = new Ticket(44, 18000, "VKO", "AER", 180);
        Ticket ticket5 = new Ticket(555, 12000, "SVO", "LED", 110);

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeByDeparture("IST");
        });
    }
}
