/* package data.repositories;

import data.models.Ticket;
import exceptions.TicketsNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketsTest {
    TicketRepository tickets;

    @BeforeEach
    void setUp() {
        tickets = new Tickets();
    }
    @Test
        void testThatTicketsCanBeSaved(){
            Ticket ticket = new Ticket();
            tickets.save(ticket);
            assertEquals(1, tickets.count());
    }
    @Test
        void testThatTicketsCanBeFoundById(){
        Ticket ticket = new Ticket();
        ticket.setId(1);
        Ticket checkTicket = tickets.save(ticket);
        Ticket foundTicket = tickets.findById(1);
        assertEquals(checkTicket, foundTicket);
    }
    @Test
        void testThatTicketCanBeDeleted(){
        Ticket ticket = new Ticket();
        ticket.setId(1);
        tickets.save(ticket);
        tickets.delete(ticket);
        assertThrows(TicketsNotFoundException.class, () -> tickets.findById(1));
    }
    @Test
        void testThatTicketCanFindAll(){
        Ticket ticket = new Ticket();
        tickets.save(ticket);
        Ticket ticket1 = new Ticket();
        tickets.save(ticket1);
        Ticket ticket2 = new Ticket();
        tickets.save(ticket2);
        assertEquals(3, tickets.count());
    }
    @Test
        void testThatTicketCanBeDeletedById(){
        Ticket ticket = new Ticket();
        ticket.setId(1);
        tickets.save(ticket);
        Ticket ticket1 = new Ticket();
        ticket.setId(2);
        tickets.save(ticket1);
        tickets.deleteById(1);
        assertThrows(TicketsNotFoundException.class, () -> tickets.findById(1));
        }
    @Test
        void testThatTicketsCanBeUpdated(){
        Ticket ticket = new Ticket();
        ticket.setId(1);
        tickets.save(ticket);
        Ticket ticket1 = new Ticket();
        ticket1.setId(2);
        tickets.save(ticket1);
        Ticket ticket2 = new Ticket();
        ticket2.setId(2);
        Ticket checkTicket = tickets.save(ticket2);
        assertEquals(checkTicket, tickets.findById(2));
        }
} */